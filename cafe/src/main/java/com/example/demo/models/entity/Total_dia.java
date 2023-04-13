package com.example.demo.models.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "total_dia")
public class Total_dia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date fecha_dia;

	private String total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha_dia() {
		return fecha_dia;
	}

	public void setFecha_dia(Date fecha_dia) {
		this.fecha_dia = fecha_dia;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	private static final long serialVersionUID = 1L;

}
