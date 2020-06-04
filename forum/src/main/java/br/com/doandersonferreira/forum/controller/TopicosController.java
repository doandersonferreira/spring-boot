package br.com.doandersonferreira.forum.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.doandersonferreira.forum.controller.dto.DetalhesDoTopicoDto;
import br.com.doandersonferreira.forum.controller.dto.TopicoDto;
import br.com.doandersonferreira.forum.controller.form.AtualizacaoTopicoForm;
import br.com.doandersonferreira.forum.controller.form.TopicoForm;
import br.com.doandersonferreira.forum.model.Topico;
import br.com.doandersonferreira.forum.repository.CursoRepository;
import br.com.doandersonferreira.forum.repository.TopicoRepository;

@RestController // Indica que a classe é um controller Spring e retorna os objetos como JSON
@RequestMapping("/topicos") // Indica o contexto mapeado pelo controller
public class TopicosController {

	// Injeção de dependêcia
	@Autowired
	private TopicoRepository topicoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	
	@GetMapping // Mapeado o método GET para o path '/'
	public List<TopicoDto> lista(String nomeCurso){	// Parametros sem anotacao, por padrao, sao traduzidos como Request Params	

		if(nomeCurso == null) {
			// Obtem lista de tópico do banco de dados
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);	
		}else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
		
	}
	
	@PostMapping // Mapeado o método POST para o path '/'
	@Transactional // Metodos de escrita (write, update, delete) devem ser anotados para indicar ao Spring que commite ao final da transacao
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {

		Topico topico = form.converter(cursoRepository);
		topicoRepository.save(topico);
		
		// Implementando o retorno do código HTTP (201 - Created) e o recurso
		// no corpo
		URI uri = uriBuilder.path("topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}
	
	@GetMapping("/{id}") // Mapeado o método POST para o path '/{id}'
	public DetalhesDoTopicoDto detalhar(@PathVariable Long id) {
		Topico topico = topicoRepository.getOne(id);
		
		return new DetalhesDoTopicoDto(topico);
	}
	
	@PutMapping("/{id}") // Mapeado o método PUT para o path '/{id}'
	@Transactional
	public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
		Topico topico = form.atualizar(id, topicoRepository);
		
		return ResponseEntity.ok(new TopicoDto(topico));

	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id){
		
		topicoRepository.deleteById(id);
		return ResponseEntity.ok().build();
		
	}
	
}
