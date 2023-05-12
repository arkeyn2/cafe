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
	
	public List<Acciones> chicaporfecha(String nombre,Date fecha); 
	
	public List<Acciones> fechainformes(String fecha1,String fecha2); 
	
	public List<Object> findia(String fecha); 
	
	public List<Object> cierrecaja(String fecha1,String fecha2); 
}
