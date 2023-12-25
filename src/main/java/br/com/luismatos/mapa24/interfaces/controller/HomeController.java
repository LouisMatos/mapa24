package br.com.luismatos.mapa24.interfaces.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.luismatos.mapa24.application.ports.in.HomeInputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/home")
public class HomeController {

	public static final String PAGINA_REDIRECT_HOME = "home";

	@Autowired
	private HomeInputPort homeInputPort;

	@GetMapping
	public String home(Model model, Principal principal) {

		log.info("Iniciando busca de registro no banco de dados!");

		model.addAttribute("mapa24", homeInputPort.buscarTodosRegistros());

		return PAGINA_REDIRECT_HOME;

	}

}
