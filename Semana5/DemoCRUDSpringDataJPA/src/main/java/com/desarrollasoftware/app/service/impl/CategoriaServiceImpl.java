package com.desarrollasoftware.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desarrollasoftware.app.entity.Categoria;
import com.desarrollasoftware.app.repository.CategoriaRepository;
import com.desarrollasoftware.app.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	
	@Autowired
	private CategoriaRepository repository;

	@Override
	public List<Categoria> listarTodos() {
		List<Categoria> lista = (List<Categoria>) repository.findAll();
		return lista;
	}

	@Override
	public List<Map<String, ?>> listarCategorias() {
		List<Categoria> lista = (List<Categoria>) repository.findAll();
		List<Map<String, ?>> lista2 = new ArrayList<>();
		for(Categoria r: lista) {
			Map<String,Object> o = new HashMap<>();
			o.put("ID", r.getId());
			o.put("NOMBRE", r.getNombre());
			lista2.add(o);
		}
		return lista2;
	}

}
