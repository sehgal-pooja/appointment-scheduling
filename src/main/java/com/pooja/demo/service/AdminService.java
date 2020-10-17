package com.pooja.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//import com.pooja.demo.model.Patients;
import com.pooja.demo.model.Staff;
//import com.pooja.demo.repoistory.PatientRepo;
import com.pooja.demo.repoistory.StaffRepo;

@Service 
public class AdminService {
	
//	@Autowired
//	PatientRepo prepo;
	@Autowired
	StaffRepo srepo;

	
	
	
	//STAFF Functions
	
	public Staff addStaff(Staff staff) throws Exception {
		
		try{
			staff.setSid(StaffSeqGeneratorService.generateSequence(staff.SEQUENCE_NAME));
			return srepo.save(staff);
		}catch(Exception e) {
			throw new Exception("Couldn't add details.");
		}
	}
	
	public List<Staff> getAllStaff() throws Exception
	{	
		try{
			return srepo.findAll();
		}
		catch(Exception e) {
			throw new Exception("Couldn't get staff.");
		}
	}
	
	public Optional<Staff> getStaff(@RequestParam int sid) throws Exception
	{
		try{
			return srepo.findById(sid);
		}
		catch(Exception e) {
			throw new Exception("Couldn't find record.");
		}
	}
	
	public Staff updateStaff(Staff staff) throws Exception
	{
		try{
			//staff.setSid(StaffSeqGeneratorService.generateSequence(staff.SEQUENCE_NAME));
			srepo.save(staff);
			return staff;
		}
		
		catch(Exception e) {
			throw new Exception("Couldn't update details.");
		}
	}
	
	public Staff updateById(final int sid, final Staff staff) throws Exception {
		  try{
			  //staff.setSid(StaffSeqGeneratorService.generateSequence(staff.SEQUENCE_NAME));
			  return srepo.save(staff);
		  }
		  catch(Exception e) {
				throw new Exception("Couldn't update.");
			}
		 }
	
	public int deleteStaff(@PathVariable int sid) throws Exception
	{
		try{
			srepo.deleteById(sid);
			return sid;
		}
		
		catch(Exception e) {
			throw new Exception("Couldn't find record.");
		}
	}
	
	public String deleteAllStaff() throws Exception {
		try{
			srepo.deleteAll();
			return "deleted";
		}
		
		catch(Exception e) {
			throw new Exception("Couldn't delete.");
		}
	}




}
