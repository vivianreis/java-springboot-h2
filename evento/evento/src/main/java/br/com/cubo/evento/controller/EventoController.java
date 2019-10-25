package br.com.cubo.evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cubo.evento.model.Evento;
import br.com.cubo.evento.repository.EventoRepository;

@RestController
@RequestMapping(path = "/eventos")
public class EventoController {

    @Autowired
    private EventoRepository repository;

    @GetMapping
    public Iterable<Evento> list() {
        return repository.findAll();
    }

    @PostMapping
    public Evento save(@RequestBody Evento evento) {
    	return repository.save(evento);
    }
    
    @PutMapping(path = "{id}")
    Evento replaceEvento(@RequestBody Evento newEvento, @PathVariable Integer id) {
    	return repository.findById(id)
    	.map(evento -> {
    		evento.setNome(newEvento.getNome());
    		evento.setLocal(newEvento.getLocal()); 
    		return repository.save(evento);
    	})
    	.orElseGet(() -> {
    		newEvento.setId(id);
    		return repository.save(newEvento);
    	});
    }   
    
    @DeleteMapping(path = "{id}")
    void deleteEvento(@PathVariable Integer id) {
    	repository.deleteById(id);
    }   
          
    
}