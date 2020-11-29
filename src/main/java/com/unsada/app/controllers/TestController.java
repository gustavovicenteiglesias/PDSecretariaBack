package com.unsada.app.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.unsada.app.modelo.Escuela;
import com.unsada.app.service.EscuelaServiceApi;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	@Autowired
	private EscuelaServiceApi  escuelaServiceApi ; 
	@Autowired
	DataSource datasource;
	@GetMapping("/all")
	//public ModelAndView allAccess() {
		//return new ModelAndView("inicio");
	public String allAccess() {
		return "Bienvenidos.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Map<String, Object> list(){
		
		HashMap<String,Object> response = new HashMap<String,Object>();
		
		try { 
			List<Escuela> empresaList; 
			empresaList = (List<Escuela>) escuelaServiceApi.findAll();
			response.put("message","Successful load");
			response.put("list",empresaList);
			response.put("success",true);
			return response;
			
		} catch (Exception e) {  
			response.put("message",e.getMessage()); 
			response.put("success ",false);
			return response;
		}
		
	}
	
	//public String userAccess() {
		//return "User Content.";
	
	


	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public String moderatorAccess() {
		return "Moderator Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
}
