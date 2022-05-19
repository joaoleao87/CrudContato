package br.ifpe.web2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.model.Contato;
import br.ifpe.web2.model.ContatoDAO;

@Service
public class ContatoService {
	
	@Autowired
	ContatoDAO contatoDAO;
	
	public void criarContato(Contato contato) {
		contatoDAO.save(contato);
	}
	
	public void excluirContato(Contato contato) {
		contatoDAO.delete(contato);
	}
	public void editarContato(Contato contato) {
		contatoDAO.save(contato);
	}
	public List<Contato> listarContato() {
		return contatoDAO.findAll();
	}
	
	public void deletarContatoById(Integer id) {
		contatoDAO.deleteById(id);
	}
	
	public Contato buscarContato(Integer id) {
		return contatoDAO.findById(id).get();
	}
}
