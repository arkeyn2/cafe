package com.example.demo.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trago")
public class Tragos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nombre_trago;

	private String tipo_trago;

	@Column(nullable = false)
	private String estado_trago;

	@Column(nullable = false)
	private String valor_trago;
	
	private String iva;
	
	private String metodo_pago;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre_trago() {
		return nombre_trago;
	}

	public void setNombre_trago(String nombre_trago) {
		this.nombre_trago = nombre_trago;
	}

	public String getTipo_trago() {
		return tipo_trago;
	}

	public void setTipo_trago(String tipo_trago) {
		this.tipo_trago = tipo_trago;
	}

	public String getEstado_trago() {
		return estado_trago;
	}

	public void setEstado_trago(String estado_trago) {
		this.estado_trago = estado_trago;
	}

	public String getValor_trago() {
		return valor_trago;
	}

	public void setValor_trago(String valor_trago) {
		this.valor_trago = valor_trago;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}



	private static final long serialVersionUID = 1L;

}
