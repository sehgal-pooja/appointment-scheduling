package com.pooja.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooja.demo.model.Patients;
import com.pooja.demo.service.StaffService;



@RestController
@RequestMapping("/")
public class StaffController {
	
	@Autowired StaffService service;
	

	@PostMapping("addP")
	public Patients addPatient(@Valid @RequestBody Patients patients) throws Exception {
		
		return service.addPatients(patients);
	}

	@GetMapping("allP")
	public List<Patients> getAll() throws Exception
	{
		return service.getAllPatients();
	}
	
	
	//
	@GetMapping("patient/{pid}")
	public Optional<Patients> getPatientById(@PathVariable("pid") int pid ) throws Exception
	{
		System.out.println("xyz");
		return service.getPatient(pid);
	}
	//
	
	@PutMapping("updateP")
	public Patients saveOrUpdatePatient(@RequestBody Patients patients) throws Exception
	{
		return service.updatePatient(patients);
	}
	

	@PutMapping("updateP/{pid}")
	public Patients updateById(@PathVariable("pid") final int pid, @RequestBody final Patients patient) throws Exception {
	return service.updateById(pid, patient);
	}
	
	
	@DeleteMapping("deleteP/{pid}")
	public int deletePatients(@PathVariable int pid) throws Exception
	{
		return service.deletePatient(pid);
	}
	
	@DeleteMapping("deleteallP")
	public String deleteAll() throws Exception {
		return service.deleteAll();
	}
}
