package br.com.doandersonferreira.forum.controller.form;

import br.com.doandersonferreira.forum.model.Curso;
import br.com.doandersonferreira.forum.model.Topico;
import br.com.doandersonferreira.forum.repository.CursoRepository;
import br.com.doandersonferreira.forum.repository.TopicoRepository;

public class TopicoForm {

	private String titulo;
	private String mensagem;
	private String nomeCurso;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Topico converter(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(this.nomeCurso);
		return new Topico(titulo,mensagem,curso);
	}

}
