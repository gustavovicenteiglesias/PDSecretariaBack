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
	private String legajo;

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
	
	@Column(name = "antiguedad" )
	private Integer antiguedad;
	
	@Column(name = "titulo_habilitante")
	private String titulo_habilitante;
	
	@Column(name = "dni")
	private Integer dni;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "localidad")
	private String localidad;
	
	@Column(name = "codigopostal")
	private Integer codigopostal;
	
	
	
	

	@JoinTable(
			name = "rel_escuelas_profesores",
			joinColumns = @JoinColumn(name = "FK_ESCUELAS"),
			inverseJoinColumns = @JoinColumn(name = "FK_PROFESORES")
			)
	 
	 @JsonManagedReference
	 @JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Escuela> escuelas = new ArrayList<>();

	

	public Profesor(Integer id, String legajo, String nombre, String apellido, String especialidad, Date fechaIngreso,
			Date fecha_nacimiento, Integer antiguedad, String titulo_habilitante, Integer dni, String calle,
			Integer numero, String localidad, Integer codigopostal, List<Escuela> escuelas) {
		super();
		this.id = id;
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.fechaIngreso = fechaIngreso;
		this.fecha_nacimiento = fecha_nacimiento;
		this.antiguedad = antiguedad;
		this.titulo_habilitante = titulo_habilitante;
		this.dni = dni;
		this.calle = calle;
		this.numero = numero;
		this.localidad = localidad;
		this.codigopostal = codigopostal;
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

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
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

	public Integer getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(Integer antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getTitulo_habilitante() {
		return titulo_habilitante;
	}

	public void setTitulo_habilitante(String titulo_habilitante) {
		this.titulo_habilitante = titulo_habilitante;
	}
	
	

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Integer getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(Integer codigopostal) {
		this.codigopostal = codigopostal;
	}

	@Override
	public String toString() {
		return "Profesor [id=" + id + ", legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", especialidad=" + especialidad + ", fechaIngreso=" + fechaIngreso + ", fecha_nacimiento="
				+ fecha_nacimiento + ", antiguedad=" + antiguedad + ", titulo_habilitante=" + titulo_habilitante
				+ ", dni=" + dni + ", calle=" + calle + ", numero=" + numero + ", localidad=" + localidad
				+ ", codigopostal=" + codigopostal + ", escuelas=" + escuelas + "]";
	}

	

	
	
	

}

	

	