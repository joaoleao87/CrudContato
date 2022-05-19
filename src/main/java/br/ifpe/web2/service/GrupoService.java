package br.ifpe.web2.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web2.model.Grupo;
import br.ifpe.web2.model.GrupoDAO;

@Service
public class GrupoService {
	
	@Autowired
	GrupoDAO grupoDAO;
	
	public void criarGrupo(Grupo grupo) {
		grupoDAO.save(grupo);
	}
	
	public void deletarGrupo(Integer id) {
		grupoDAO.deleteById(id);
	}
	
	public void editarGrupo(Grupo grupo) {
		grupoDAO.save(grupo);
	}
	
	public List<Grupo> listarGrupos(){
		return grupoDAO.findAll();
	}
	
	public List<Grupo> listarGrupoVigente(){
		return grupoDAO.findByDataExpiracaoAfter(LocalDate.now());
	}
	
	public Grupo buscarGrupo(Integer id) {
		return grupoDAO.findById(id).get();
	}
}
