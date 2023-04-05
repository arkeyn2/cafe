package com.example.demo.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Acciones;


public interface IAccionesDao extends CrudRepository<Acciones, Long>{

	@Query("select ac from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id where ac.usuario.id=?1")
	public List<Acciones> chicaportrago(Long id);
	
	@Query("select ac from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id inner join Servicios se on se.id=ac.servicio.id where ac.usuario.id=?1 and ac.fecha_dia=?2")
	public List<Acciones> chicaporfecha(Long id,String fecha);
	
	@Query("select ac from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id inner join Servicios se on se.id=ac.servicio.id inner join Usuario us on us.id=ac.usuario.id where us.nombreUsuario=?1 and ac.fecha_dia=?2")
	public List<Acciones> chicaporfecha(String nombre_user,String fecha);
	
	@Query("select ac from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id inner join Servicios se on se.id=ac.servicio.id where ac.fecha_dia Between ?1 and ?2")
	public List<Acciones> fechainformes(Date fecha1 ,Date fecha2);
	
	@Query("SELECT sum(comisiones) FROM Acciones where usuario.id=?1 and fecha_dia=?2")
	public List<Acciones> totoalcomicionId(Long id,String fecha);
	
}

