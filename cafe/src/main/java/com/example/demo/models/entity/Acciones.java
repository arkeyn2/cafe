package com.example.demo.models.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "acciones")
public class Acciones implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	private String fecha_dia;

	@Column(nullable = false)
	private String total_ganado;
	
	@Column(nullable = false)
	private String tipo_accion;

	@Column(nullable = false)
	private String estado_de_pago;
	
	@Column(nullable = false)
	private String estado;
	
	private String adelanto;
	
	private String comisiones;
	
	private String pendiente;

	private String dia_activo;
	
	private String caja;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Servicios servicio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Tragos tragos;


	

	public String getDia_activo() {
		return dia_activo;
	}



	public void setDia_activo(String dia_activo) {
		this.dia_activo = dia_activo;
	}

	public long getId() {
		return id;
	}






	public void setId(long id) {
		this.id = id;
	}






	public String getFecha_dia() {
		return fecha_dia;
	}






	public void setFecha_dia(String fecha_dia) {
		this.fecha_dia = fecha_dia;
	}






	public String getTotal_ganado() {
		return total_ganado;
	}






	public void setTotal_ganado(String total_ganado) {
		this.total_ganado = total_ganado;
	}






	public String getTipo_accion() {
		return tipo_accion;
	}






	public void setTipo_accion(String tipo_accion) {
		this.tipo_accion = tipo_accion;
	}






	public String getEstado_de_pago() {
		return estado_de_pago;
	}






	public void setEstado_de_pago(String estado_de_pago) {
		this.estado_de_pago = estado_de_pago;
	}






	public String getEstado() {
		return estado;
	}






	public void setEstado(String estado) {
		this.estado = estado;
	}






	public String getAdelanto() {
		return adelanto;
	}






	public void setAdelanto(String adelanto) {
		this.adelanto = adelanto;
	}






	public String getComisiones() {
		return comisiones;
	}






	public void setComisiones(String comisiones) {
		this.comisiones = comisiones;
	}






	public String getPendiente() {
		return pendiente;
	}






	public void setPendiente(String pendiente) {
		this.pendiente = pendiente;
	}






	public Servicios getServicio() {
		return servicio;
	}






	public void setServicio(Servicios servicio) {
		this.servicio = servicio;
	}






	public Usuario getUsuario() {
		return usuario;
	}






	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}






	public Tragos getTragos() {
		return tragos;
	}






	public void setTragos(Tragos tragos) {
		this.tragos = tragos;
	}






	public static long getSerialversionuid() {
		return serialVersionUID;
	}






	private static final long serialVersionUID = 1L;

}
