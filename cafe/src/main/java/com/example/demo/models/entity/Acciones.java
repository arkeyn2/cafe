package com.example.demo.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "acciones")
public class Acciones implements Serializable {




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;


	private String fecha_dia;
	
	private Date fecha_trago;

	private int total_ganado;

	private String tipo_accion;

	private String estado_de_pago;

	private String estado;

	private int adelanto;

	private int comisiones;

	private String pendiente;

	private String dia_activo;

	private int caja;

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

	public int getTotal_ganado() {
		return total_ganado;
	}

	public void setTotal_ganado(int total_ganado) {
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

	public int getAdelanto() {
		return adelanto;
	}

	public void setAdelanto(int adelanto) {
		this.adelanto = adelanto;
	}

	public int getComisiones() {
		return comisiones;
	}

	public void setComisiones(int comisiones) {
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

	private static final long serialVersionUID = 1L;
}
