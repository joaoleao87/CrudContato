package br.ifpe.web2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.service.GrupoService;

@Controller
public class GrupoController {

	@Autowired
	GrupoService grupoService;
	
	@GetMapping("/cadastrarGrupos")
	public String exibirForm(Grupo grupo) {
		return "grupos";
	}
		
	@PostMapping("salvarGrupo")
	public String salvarGrupo(Grupo grupo) {
		grupoService.criarGrupo(grupo);
		return "redirect:/exibirContato";
	}
	
	@GetMapping("/listarGrupos")
	public String listarGrupos(Model model) {
		model.addAttribute("listaGrupos", grupoService.listarGrupos());
		return "grupo-list";
	}
	
	@GetMapping("/removerGrupo")
	public String removerGrupo(Integer id) {
		grupoService.deletarGrupo(id);	
		return "redirect:/listarGrupos";
	}
	
	@GetMapping("/editarGrupo")
	public String editarContato(Integer id, Model model) {
		model.addAttribute("grupo", grupoService.buscarGrupo(id));
		return "grupos";
	}
}
