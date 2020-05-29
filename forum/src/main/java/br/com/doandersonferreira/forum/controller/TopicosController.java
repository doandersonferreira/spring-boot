package br.com.doandersonferreira.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.doandersonferreira.forum.controller.dto.TopicoDto;
import br.com.doandersonferreira.forum.model.Curso;
import br.com.doandersonferreira.forum.model.Topico;

@RestController
public class TopicosController {

	@RequestMapping("/topicos")
	public List<TopicoDto> lista(){		
		Topico topico = new Topico("Dúvida", "Dúvida de Spring!", new Curso("Spring","Programação"));
		
		return TopicoDto.converter(Arrays.asList(topico, topico, topico));
	}
	
}
