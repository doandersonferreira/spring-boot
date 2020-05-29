package br.com.doandersonferreira.forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.doandersonferreira.forum.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	List<Topico> findByCursoNome(String nomeCurso);

}
