package br.com.doandersonferreira.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.doandersonferreira.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);

}
