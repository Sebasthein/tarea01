package com.mitocode.service;

import java.util.List;


import com.mitocode.model.Producto;

public interface IProductoService {
	Producto registrar(Producto p) throws Exception;

	Producto modificar(Producto p) throws Exception;

	List<Producto> listar() throws Exception;

	Producto listarPorId(Integer id) throws Exception;

	void eliminar(Integer id) throws Exception;
}
