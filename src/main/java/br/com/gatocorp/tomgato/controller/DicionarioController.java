package br.com.gatocorp.tomgato.controller;

import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.gatocorp.tomgato.service.DicionarioService;

@RestController
public class DicionarioController {
	
	private DicionarioService dicionarioService = new DicionarioService();
	
	
	@GetMapping("/")
    public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
        return mv;
    }
	
	@PostMapping(value = "/buscar-palavra",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView findByIndice(String palavra, ModelMap  model ) {
		String palavraResult = dicionarioService.findDicionario(palavra);
		model.addAttribute("palavraResult", palavraResult);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
        return mv;
	}

}
