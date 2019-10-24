package br.com.cubo.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cubo.evento.model.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer >{

}
