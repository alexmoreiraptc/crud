package com.alexmoreira.crud.controle;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alexmoreira.crud.dao.DisciplinaDAO;
import com.alexmoreira.crud.dominio.Disciplina;

@Controller
public class DisciplinaControle {

	@RequestMapping("/listar-disciplinas")
	public String disciplinasTabela(Model modelo) {
		DisciplinaDAO dao = new DisciplinaDAO();
		List<Disciplina> lista = dao.todos();
		modelo.addAttribute("lista", lista);
		return "listar-disciplinas";
		
	}
	@RequestMapping("/cad-disciplina")
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("disciplina", new Disciplina());
		return "form-disciplina";
		
	}
	@PostMapping("/cad-disciplina")
	public String processaFormulario(Disciplina disciplina) throws SQLException {
		DisciplinaDAO dao = new DisciplinaDAO();
		dao.inserir(disciplina);
		return "redirect:/listar-disciplinas";
		
	}
	@RequestMapping("/")
	public String home(){
		return "home";
		
	}
}
