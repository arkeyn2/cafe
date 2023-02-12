package com.example.demo.models.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.dao.IHorarioDao;
import com.example.demo.models.entity.Horarios;

@Service
public class HorarioServiceImpl implements IHorarioService {

	private IHorarioDao horarioDao;

	@Override
	@Transactional(readOnly = true)
	public List<Horarios> findAll() {
		return (List<Horarios>) horarioDao.findAll();
	}

	@Override
	public Horarios findById(Long id) {
		return horarioDao.findById(id).orElse(null);
	}

	@Override
	public Horarios save(Horarios horario) {
		return horarioDao.save(horario);
	}

	@Override
	public void delete(Long id) {
		horarioDao.deleteById(id);

	}

}
