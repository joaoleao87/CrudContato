package br.ifpe.web2.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.ifpe.web2.model.Contato;
import br.ifpe.web2.service.ContatoService;
import br.ifpe.web2.service.GrupoService;

@Controller
public class ContatoController {
	
	@Autowired
	ContatoService contatoService;
	
	@Autowired 
	GrupoService grupoService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/exibirContato";
	}

	@GetMapping("/exibirContato")
	public String exibirForm(Contato contato, Model model) {
		model.addAttribute("gruposModel", grupoService.listarGrupoVigente());
		return "contatos-form";
	}
	
	@PostMapping("/salvarContato")
	public String salvarContato(Contato contato) {
		contatoService.criarContato(contato);
		System.out.println(contato);
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/listarContatos")
	public String listarContatos(Model model) {
		model.addAttribute("lista", contatoService.listarContato());
		return "contatos-list";
	}
	
	@GetMapping("/removerContato")
	public String removerContato(Integer id) {
		contatoService.deletarContatoById(id);
		return "redirect:/listarContatos";
	}
	
	@GetMapping("/editarContato")
	public String editarContato(Integer id, Model model) {
		Contato contato = contatoService.buscarContato(id);
		model.addAttribute("gruposModel", grupoService.listarGrupos());
		model.addAttribute("contato", contato);
		return "contatos-form";
	}
}
