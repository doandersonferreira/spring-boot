package br.com.doandersonferreira.forum.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.doandersonferreira.forum.controller.dto.TopicoDto;
import br.com.doandersonferreira.forum.model.Topico;
import br.com.doandersonferreira.forum.repository.TopicoRepository;

@RestController
public class TopicosController {

	// Injeção de dependêcia
	@Autowired
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")
	public List<TopicoDto> lista(String nomeCurso){		

		if(nomeCurso == null) {
			// Obtem lista de tópico do banco de dados
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);	
		}else {
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
		
	}
	
}
