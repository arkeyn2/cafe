package com.example.demo.models.services;

import java.util.Date;
import java.util.List;

import com.example.demo.models.entity.Acciones;

public interface IAccionesService {
	
	public List<Acciones> findAll();
	
	public Acciones findById(Long id);
	
	public Acciones save(Acciones accion);
	
	public void delete(Long id);
	
	public List<Acciones> chicaportrago(long id); 
	
	public List<Acciones> chicaporfecha(long id,String fecha); 
	
	public List<Acciones> fechainformes(Date fecha1,Date fecha2); 


}
