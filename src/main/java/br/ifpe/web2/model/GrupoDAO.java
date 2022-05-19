package br.ifpe.web2.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoDAO extends JpaRepository<Grupo, Integer>{
	public List<Grupo> findByDataExpiracaoAfter(LocalDate DataExpiracao);
}
