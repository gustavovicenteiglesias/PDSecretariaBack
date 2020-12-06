package com.unsada.app.modelo;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "escuela")



public class Escuela implements Serializable{
	
	 private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Basic(optional = false)
	    @Column(name = "id_escuela")
	    private Integer idEscuela;
	   
	    @Column(name = "nombre")
	    private String nombre;
	    
	    @Column(name="diegep")
	    private String diegep;
	    
	    @Column(name="suvencion")
	    private String suvencion;
	    
	    @Column(name = "calle")
		private String calle;
		
		@Column(name = "numero")
		private Integer numero;
		
		@Column(name = "localidad")
		private String localidad;
		
		@Column(name = "codigopostal")
		private Integer codigopostal;
	    
	   
	    @JsonBackReference
	    @ManyToMany(fetch = FetchType.EAGER ,mappedBy =  "escuelas")
	    private List<Profesor> profesores = new ArrayList<>();


		public Integer getIdEscuela() {
			return idEscuela;
		}


		public void setIdEscuela(Integer idEscuela) {
			this.idEscuela = idEscuela;
		}


		public String getNombre() {
			return nombre;
		}


		public void setNombre(String nombre) {
			this.nombre = nombre;
		}


		public String getDiegep() {
			return diegep;
		}


		public void setDiegep(String diegep) {
			this.diegep = diegep;
		}


		public String getSuvencion() {
			return suvencion;
		}


		public void setSuvencion(String suvencion) {
			this.suvencion = suvencion;
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


		


		public Escuela(Integer idEscuela, String nombre, String diegep, String suvencion, String calle, Integer numero,
				String localidad, Integer codigopostal) {
			super();
			this.idEscuela = idEscuela;
			this.nombre = nombre;
			this.diegep = diegep;
			this.suvencion = suvencion;
			this.calle = calle;
			this.numero = numero;
			this.localidad = localidad;
			this.codigopostal = codigopostal;
		}


		public Escuela() {
			super();
		}


		@Override
		public String toString() {
			return "Escuela [idEscuela=" + idEscuela + ", nombre=" + nombre + ", diegep=" + diegep + ", suvencion="
					+ suvencion + ", calle=" + calle + ", numero=" + numero + ", localidad=" + localidad
					+ ", codigopostal=" + codigopostal + "]";
		}


		


	

	    
}