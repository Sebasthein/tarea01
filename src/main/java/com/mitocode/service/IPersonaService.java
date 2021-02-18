package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Persona;


public interface IPersonaService {
	Persona registrar(Persona p) throws Exception;

	Persona modificar(Persona p) throws Exception;

	List<Persona> listar() throws Exception;

	Persona listarPorId(Integer id) throws Exception;

	void eliminar(Integer id) throws Exception;
}
 