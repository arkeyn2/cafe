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

import com.example.demo.models.entity.Tragos;
import com.example.demo.models.services.TragosService;

@CrossOrigin(origins ={"http://loalhost:4200","*"})
@RestController
@RequestMapping("/api")
public class TragosRestContoller {
	
	@Autowired
	private TragosService tragosService;
	
	@GetMapping("/tragos")
	public List<Tragos>index(){
		return tragosService.findAll();
	}
	
	@GetMapping("/tragos{id}")
	public ResponseEntity<?> show(@PathVariable Long id){
		
		Tragos trago = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			trago = tragosService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta a la base de datos");
			response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		if (trago == null) {
			response.put("mensaje", "El tipo id:".concat(id.toString().concat(" no existe en la base de datos!")));
		}
		return new ResponseEntity<Tragos>(trago, HttpStatus.OK);
	}

}
