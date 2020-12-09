package com.alexmoreira.crud.controle;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexmoreira.crud.dao.DisciplinaDAO;
import com.alexmoreira.crud.dominio.Disciplina;

@Controller
public class DisciplinaControle {

	@RequestMapping("/")
	public String disciplinasTabela(Model modelo) {
		DisciplinaDAO dao = new DisciplinaDAO();
		List<Disciplina> lista = dao.todos();
		modelo.addAttribute("lista", lista);
		return "index";
		
	}
}
