package br.ifpe.web2.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Contato {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	@ElementCollection
	@OrderColumn
	private String[] apps;
	@ManyToOne
	private Grupo grupo;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dataNascimento;
	@Enumerated(EnumType.STRING)
	private Estado estado;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String[] getApps() {
		return apps;
	}
	public void setApps(String[] apps) {
		this.apps = apps;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", apps="
				+ Arrays.toString(apps) + ", grupo=" + grupo + ", dataNascimento=" + dataNascimento + ", estado="
				+ estado + "]";
	}

	
	
	
}
