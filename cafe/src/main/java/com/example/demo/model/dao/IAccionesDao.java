package com.example.demo.model.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Acciones;


public interface IAccionesDao extends CrudRepository<Acciones, Long>{

	@Query("select ac from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id where ac.usuario.id=?1")
	public List<Acciones> chicaportrago(Long id);
	
	@Query("select ac from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id inner join Servicios se on se.id=ac.servicio.id where ac.usuario.id=?1 and ac.fecha_dia=?2")
	public List<Acciones> chicaporfecha(Long id,String fecha);
	
	@Query("select ac from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id inner join Servicios se on se.id=ac.servicio.id inner join Usuario us on us.id=ac.usuario.id where us.nombreUsuario=?1 and ac.fecha_dia=?2")
	public List<Acciones> chicaporfecha(String nombre_user,Date fecha);
	
	//secambio
	@Query("select ac from Acciones ac where ac.dia_activo Between ?1 and ?2 and ac.estado='pagado'")
	public List<Acciones> fechainformes(String fecha1 ,String fecha2);
	
	@Query("SELECT sum(comisiones) FROM Acciones where usuario.id=?1 and fecha_dia=?2")
	public List<Acciones> totoalcomicionId(Long id,String fecha);
	
	@Modifying
	@Query(value=  "select cast(findia(?1)as text)",nativeQuery = true  )
	public List<Object> findia(String fd);
	
	@Modifying
	@Query("select sum(ac.caja) as caja,sum(ac.comisiones) as comisiones,sum(ac.total_ganado) as total_ganado,sum(tra.iva) as iva_trago,sum(tra.valor_trago) as valor_trago,sum(se.iva) as iva_servicio,sum(se.valor) as valor_servicio,sum(ac.adelanto)as adelanto from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id inner join Servicios se on se.id=ac.servicio.id where ac.dia_activo Between ?1 and ?2 and ac.estado='pagado'")
	public List<Object> cierrecaja(String fecha1 ,String fecha2);
	
	@Modifying
	@Query("select sum(ac.caja) as caja,sum(ac.comisiones) as comisiones,sum(ac.total_ganado) as total_ganado,sum(tra.iva) as iva_trago,sum(tra.valor_trago) as valor_trago,sum(se.iva) as iva_servicio,sum(se.valor) as valor_servicio,sum(ac.adelanto)as adelanto from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id inner join Servicios se on se.id=ac.servicio.id inner join Usuario u on usuario_id=ac.usuario.id where ac.dia_activo Between ?1 and ?2 and ac.estado='pagado' and u.id =?3")
	public List<Object> cierrecajaid(String fecha1 ,String fecha2,Long idu);
	
	@Query("select ac from Acciones ac inner join Usuario u on usuario_id=ac.usuario.id where ac.dia_activo Between ?1 and ?2 and ac.estado='pagado' and u.id =?3")
	public List<Acciones> fechainformesid(String fecha1 ,String fecha2,Long id);
	
	/*
	select sum(ac.caja) as caja,sum(ac.comisiones) as comisiones,sum(total_ganado) as total_ganado,sum(tra.iva) as iva_trago,sum(tra.valor_trago) as valor_trago,sum(se.iva) as iva_servicio,sum(se.valor) as valor_servicio from Acciones ac inner join Tragos tra on ac.tragos.id=tra.id inner join Servicios se on se.id=ac.servicio.id where ac.fecha_dia Between ?1 and ?2
	select sum(ac.caja)as caja,sum(ac.comisiones) as gcomisiones,
	sum(total_ganado) as total_ganado,sum(tra.iva) as iva_trago,sum(tra.valor_trago) as valor_trago,
	sum(se.iva) as iva_servicio,sum(se.valor) as valor_servicio from acciones ac 
	inner join trago tra on ac.tragos_id=tra.id 
	inner join servicios se on se.id=ac.servicio_id 
	where ac.fecha_dia between '2023-01-01' and '2023-05-01'
	*/
}

