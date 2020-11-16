package com.unsada.app.service;




import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.unsada.app.modelo.Escuela;


public interface EscuelaServiceApi extends CrudRepository<Escuela, Integer> {

	
	Optional<Escuela> findByNombre(String nombre);
	List<Escuela> findByNombreLike(String nombre);
	@Query(value="select p.*, e.* from profesor p\r\n" + 
			"inner join rel_escuelas_profesores r\r\n" + 
			"ON r.fk_profesores=p.id AND r.fk_escuelas=:id\r\n" + 
			"inner join escuela e on e.id_escuela=r.fk_escuelas",nativeQuery = true)
	 Iterable<Escuela> proofesporescuela(@Param("id") int id);

}
