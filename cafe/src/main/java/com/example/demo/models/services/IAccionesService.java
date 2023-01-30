package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Acciones;

public interface IAccionesService {
	
	public List<Acciones> findAll();
	
	public Acciones findById(Long id);
	
	public Acciones save(Acciones accion);
	
	public void delete(Long id);

}