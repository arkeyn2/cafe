package com.example.demo.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Acciones;


public interface IAccionesDao extends CrudRepository<Acciones, Long>{

	@Query("select ac from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id where ac.usuario.id=?1")
	public List<Acciones> chicaportrago(Long id);
	
	@Query("select ac from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id where ac.usuario.id=?1 and ac.fecha_dia=?2")
	public List<Acciones> chicaporfecha(Long id,String fecha);
	
}
