package com.mitocode.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Producto;
import com.mitocode.service.IProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	@GetMapping
	public ResponseEntity<List<Producto>> listar() throws Exception {
		List<Producto> lista = service.listar();
		return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Producto p = service.listarPorId(id);
		if(p.getIdProducto()==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO"+ id);
		}
		//String mensaje = "hola perro";
		//return new ResponseEntity<String>(mensaje, HttpStatus.OK);
		return new ResponseEntity<Producto>(p, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<Producto> registrar(@RequestBody Producto p) throws Exception{
		Producto obj = service.registrar(p);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProducto()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Producto> modificar(@RequestBody Producto p) throws Exception{
		Producto obj = service.modificar(p);
		return new ResponseEntity<Producto>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Producto p = service.listarPorId(id);
		if(p.getIdProducto()==null) {
			throw new ModeloNotFoundException(null);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
}
