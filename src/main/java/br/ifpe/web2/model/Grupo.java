package br.ifpe.web2.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Grupo {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeGrupo;
	@Enumerated(EnumType.STRING)
	private Visivel visibilidade;
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate dataExpiracao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeGrupo() {
		return nomeGrupo;
	}
	public void setNomeGrupo(String nomeGrupo) {
		this.nomeGrupo = nomeGrupo;
	}
	public Visivel getVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(Visivel visibilidade) {
		this.visibilidade = visibilidade;
	}
	public LocalDate getDataExpiracao() {
		return dataExpiracao;
	}
	public void setDataExpiracao(LocalDate dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}
	
	
}
