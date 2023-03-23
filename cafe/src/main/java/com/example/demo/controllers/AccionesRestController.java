package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Acciones;
import com.example.demo.models.services.IAccionesService;



@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/api")
public class AccionesRestController {
	
	@Autowired
	private IAccionesService accionesService;

	@GetMapping("/acciones")
	public List<Acciones> index() {
		return accionesService.findAll();
	}
	
	@GetMapping("/acciones/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Acciones acciones = null;
		Map<String, Object> response = new HashMap<>();

		try {
			acciones = accionesService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (acciones == null) {
			response.put("mensaje", "La accione Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Acciones>(acciones, HttpStatus.OK);

	}
	
	@PostMapping("/acciones")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Acciones acciones) {

		Acciones accionesnew = null;
		Map<String, Object> response = new HashMap<>();

		try {
			accionesnew = accionesService.save(acciones);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "La accione ha sido creado con exito!");
		response.put("acciones", accionesnew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/tipos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody Acciones acciones, @PathVariable Long id) {

		Acciones accionesActual = accionesService.findById(id);

		Acciones accionesUpdate = null;

		Map<String, Object> response = new HashMap<>();

		if (acciones == null) {
			response.put("mensaje", "La accione Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {

			accionesActual.setFecha_dia(acciones.getFecha_dia());
			accionesActual.setTotal_ganado(acciones.getTotal_ganado());
			accionesActual.setServicio(acciones.getServicio());
			accionesActual.setTragos(acciones.getTragos());
			accionesActual.setUsario(acciones.getUsario());
			accionesActual.setTipo_accion(acciones.getTipo_accion());
			accionesActual.setPendiente(acciones.getPendiente());
			accionesActual.setEstado(acciones.getEstado());
			
			accionesUpdate = accionesService.save(accionesActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualizado en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "la accion ha sido actualizado con exito!");
		response.put("acciones", accionesUpdate);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/acciones/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			accionesService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La accion eliminada con exito!");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@GetMapping("/acciones/tragos/{id}")
	public ResponseEntity<?> chicaportrago(@PathVariable Long id) {

		List<Acciones> accion = null;
		Map<String, Object> response = new HashMap<>();

		try {
			accion = accionesService.chicaportrago(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		if (accion == null) {
			response.put("mensaje", "La reserva Id:".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Acciones>>(accion, HttpStatus.OK);
	}
}
