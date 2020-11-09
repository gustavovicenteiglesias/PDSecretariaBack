package com.unsada.app.modelo;

import java.io.Serializable;
import java.sql.Date;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "profesor")

public class Profesor implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;

	@Column(name = "legajo")
	private Integer legajo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "especialidad")
	private String especialidad;

	@Column(name = "fecha_ingreso")
	private Date fechaIngreso;

	@Column(name = "fecha_nacimiento")
	private Date fecha_nacimiento;

	@JoinTable(
			name = "rel_escuelas_profesores",
			joinColumns = @JoinColumn(name = "FK_ESCUELAS"),
			inverseJoinColumns = @JoinColumn(name = "FK_PROFESORES")
			)
	 
	 @JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Escuela> escuelas = new ArrayList<>();

	public Profesor(Integer id, Integer legajo, String nombre, String apellido, String especialidad, Date fechaIngreso,
			Date fecha_nacimiento, List<Escuela> escuelas) {
		super();
		this.id = id;
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.fechaIngreso = fechaIngreso;
		this.fecha_nacimiento = fecha_nacimiento;
		this.escuelas = escuelas;
	}

	public Profesor() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLegajo() {
		return legajo;
	}

	public void setLegajo(Integer legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public List<Escuela> getEscuelas() {
		return escuelas;
	}

	public void setEscuelas(List<Escuela> escuelas) {
		this.escuelas = escuelas;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", especialidad=" + especialidad + ", fechaIngreso=" + fechaIngreso + ", fecha_nacimiento="
				+ fecha_nacimiento + ", escuelas=" + escuelas + "]";
	}
	
	

}

	

	