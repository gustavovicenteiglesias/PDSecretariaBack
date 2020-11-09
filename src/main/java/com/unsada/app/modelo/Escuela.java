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






		public List<Profesor> getProfesores() {
			return profesores;
		}


		public void setProfesores(List<Profesor> profesores) {
			this.profesores = profesores;
		}


		public Escuela(Integer idEscuela, String nombre, List<Profesor> profesores) {
			super();
			this.idEscuela = idEscuela;
			this.nombre = nombre;
			this.profesores = profesores;
		}


		public Escuela() {
			super();
		}


		@Override
		public String toString() {
			return "Escuela [idEscuela=" + idEscuela + ", nombre=" + nombre + ", profesores=" + profesores + "]";
		}


		
		
		
		
		

		
}