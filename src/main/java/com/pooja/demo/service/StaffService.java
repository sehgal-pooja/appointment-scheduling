package com.pooja.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.pooja.demo.model.Patients;
import com.pooja.demo.repoistory.PatientRepo;

@Service
public class StaffService {

	@Autowired
	PatientRepo prepo;

	
	public Patients addPatients(Patients patient) throws Exception
	{
		try {
				patient.setPid(PatientSeqGeneratorService.generateSequence(patient.SEQUENCE_NAME));
				return prepo.save(patient);
			}
			
		catch (Exception e){
			throw new Exception("Couldn't save Patient details");
		}
	}
	
	
	public List<Patients> getAllPatients() throws Exception
	{	try {
			return prepo.findAll();
		}
		catch(Exception e)
		{
			throw new Exception("Somthing went wrong!!");
		}
	}
	
	public Optional<Patients> getPatient(@RequestParam int pid) throws Exception
	{
		try {
			return prepo.findById(pid);
		}catch(Exception e)
		{
			throw new Exception("No records found with the entered id!!");
		}
		
	}
	
	public Patients updatePatient(Patients patients) throws Exception
	{
		try {
			prepo.save(patients);
			return patients;
		}catch(Exception e)
		{
			throw new Exception("Couldn't update records!!");
		}
		
	}
	
	public Patients updateById(final int pid, final Patients patient) throws Exception
	{
		  try{
			  return prepo.save(patient);
		  }catch(Exception e)
			{
				throw new Exception("Somthing went wrong!!");
			}
	}
	
	
	public int deletePatient(@PathVariable int pid) throws Exception
	{
		try{
			prepo.deleteById(pid);
			return pid;
		}
		
		catch(Exception e)
		{
			throw new Exception("Somthing went wrong!!");
		}
	}
	
	public String deleteAll() throws Exception {
		try{
			prepo.deleteAll();
			return "deleted";
		}catch(Exception e)
		{
			throw new Exception("Somthing went wrong!!");
		}
	}



}
