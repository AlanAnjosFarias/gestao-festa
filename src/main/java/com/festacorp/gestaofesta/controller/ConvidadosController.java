package com.festacorp.gestaofesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.festacorp.gestaofesta.model.Convidado;
import com.festacorp.gestaofesta.repository.Convidados;

@Controller
//@RequestMapping("/convidados") //com essa anotation podemos remover ("/convidados") dos metodos da classe
public class ConvidadosController {

	@Autowired
	private Convidados convidados;

	@GetMapping("/convidados")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados"); // "ListaConvidados"nome da view/arquivo html
		modelAndView.addObject("convidados", convidados.findAll()); // "convidados" metodo GET do browser
		modelAndView.addObject(new Convidado());
		return modelAndView;
	}

	@PostMapping("/convidados")
	public String salvar(Convidado convidado) {
		this.convidados.save(convidado);
		return "redirect:/convidados";

	}
}
