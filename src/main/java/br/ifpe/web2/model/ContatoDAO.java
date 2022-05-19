package br.ifpe.web2.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoDAO extends JpaRepository<Contato,Integer> {
	
	
}
