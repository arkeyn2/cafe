package com.example.demo.models.services;

import java.util.List;

import com.example.demo.models.entity.Tragos;

public interface TragosService {
	
	public List<Tragos> findAll();
	
	public Tragos findById(Long id);
	
	public Tragos save(Tragos tragos);
	
	public void delete(Long id);

}
