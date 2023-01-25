package com.example.demo.models.services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.ITragoDao;
import com.example.demo.models.entity.Tragos;

public class TraglsServiceImpl implements ITragosService  {
	
	@Autowired
	private ITragoDao tragoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Tragos> findAll() {
		return (List<Tragos>) tragoDao.findAll();
	}

	@Override
	public Tragos findById(Long id) {
		return tragoDao.findById(id).orElse(null);
	}

	@Override
	public Tragos save(Tragos tragos) {
		return tragoDao.save(tragos);
	}

	@Override
	public void delete(Long id) {
		tragoDao.deleteById(id);
	}

}
