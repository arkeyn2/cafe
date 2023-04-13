package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Horarios;
import com.example.demo.models.entity.Total_dia;
import com.example.demo.models.services.ITotal_diaServiceImpl;

@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/api")
public class Total_diaRestController {
	
	@Autowired
	private ITotal_diaServiceImpl totaldiaser;
	
	@GetMapping("/totaldia")
	public List<Total_dia> index(){
		return totaldiaser.findAll();
	}

	@GetMapping("totaldia/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Total_dia totaldia = null;
		Map<String, Object> response = new HashMap<>();

		try {
			totaldia = totaldiaser.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (totaldia == null) {
			response.put("mensaje", "El horario Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Total_dia>(totaldia, HttpStatus.OK);

	}
}
