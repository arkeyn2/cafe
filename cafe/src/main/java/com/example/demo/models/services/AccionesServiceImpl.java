package com.example.demo.models.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IAccionesDao;
import com.example.demo.models.entity.Acciones;

@Service
public class AccionesServiceImpl implements IAccionesService {
	
	@Autowired
	private IAccionesDao accionDao;

	@Override
	@Transactional(readOnly = true)
	public List<Acciones> findAll() {
		return (List<Acciones>) accionDao.findAll();
	}

	@Override
	public Acciones findById(Long id) {
		return accionDao.findById(id).orElse(null);
	}

	@Override
	public Acciones save(Acciones accion) {
		return accionDao.save(accion);
	}

	@Override
	public void delete(Long id) {
		accionDao.deleteById(id);
	}
	
	@Override
	public List<Acciones> chicaportrago(long id) {
		return accionDao.chicaportrago(id);
		
		
}
	@Override
	public List<Acciones> chicaporfecha(String nombre , String fecha) {
		return accionDao.chicaporfecha(nombre,fecha);
	}
	
	@Override
	public List<Acciones> fechainformes(Date fecha1 , Date fecha2) {
		return accionDao.fechainformes(fecha1,fecha2);
	}
}
