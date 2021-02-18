package com.mitocode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Persona;
import com.mitocode.repo.IPersonaRepo;

@Service
public class IPersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaRepo repo;
	
	@Override
	public Persona registrar(Persona p) throws Exception {	
		return repo.save(p);
	}

	@Override
	public Persona modificar(Persona p) throws Exception {		
		return repo.save(p);
	}

	@Override
	public List<Persona> listar() throws Exception {
		return repo.findAll();
	}

	@Override
	public Persona listarPorId(Integer id) throws Exception {
		Optional<Persona> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Persona();
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		repo.deleteById(id);
	}
}
