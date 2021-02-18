package com.mitocode.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Producto;
import com.mitocode.repo.IProductoRepo;

@Service
public class IProductoServiceImpl implements IProductoService {

		
		@Autowired
		private IProductoRepo repo;
		
		@Override
		public Producto registrar(Producto p) throws Exception {	
			return repo.save(p);
		}

		@Override
		public Producto modificar(Producto p) throws Exception {		
			return repo.save(p);
		}

		@Override
		public List<Producto> listar() throws Exception {
			return repo.findAll();
		}

		@Override
		public Producto listarPorId(Integer id) throws Exception {
			Optional<Producto> op = repo.findById(id);
			return op.isPresent() ? op.get() : new Producto();
		}

		@Override
		public void eliminar(Integer id) throws Exception {
			repo.deleteById(id);
		}
	
}
