package br.com.luismatos.mapa24.interfaces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.luismatos.mapa24.application.ports.in.RegistroInputPort;
import br.com.luismatos.mapa24.interfaces.dto.RegistroDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/registro")
public class RegitroController {

	public static final String PAGINA_REDIRECT_HOME = "redirect:/home";

	@Autowired
	private RegistroInputPort registroInputPort;

	@PostMapping("/novo")
	public String novo(@Valid RegistroDTO registroDTO, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			return PAGINA_REDIRECT_HOME;
		}

		log.info("Iniciando o cadastro de registro");

		registroInputPort.salvaNovoRegistro(registroDTO);

		return PAGINA_REDIRECT_HOME;
	}

}
