package com.testyantra.mongodb.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.mongodb.request.CricketersRequest;
import com.testyantra.mongodb.response.CricketersResponse;
import com.testyantra.mongodb.service.CricketersServiceImpl;
/**
 * @author sameer
 *
 */
@RestController
@RequestMapping("/api/cricketer")
public class CricketersController {
	
	@Autowired
	CricketersServiceImpl cricketersServiceImpl;

	
	@PostMapping("/add")
	public ResponseEntity<?> addCricketer(@RequestBody CricketersRequest cricketersRequest) {
		CricketersResponse addCricketer = cricketersServiceImpl.addCricketer(cricketersRequest);
		if(addCricketer!=null) {
			return new ResponseEntity<>(addCricketer,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteCricketer(@RequestParam int cricketerId) {
		CricketersResponse deleteCricketer = cricketersServiceImpl.deleteeCricketer(cricketerId);
		if(deleteCricketer!=null) {
			return new ResponseEntity<>(deleteCricketer,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/get")
	public ResponseEntity<?> getCricketerById(@RequestParam int cricketerId) {
		CricketersResponse addCricketer = cricketersServiceImpl.getCricketerById(cricketerId);
		if(addCricketer!=null) {
			return new ResponseEntity<>(addCricketer,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllCricketer() {
		CricketersResponse allCricketerList = cricketersServiceImpl.getAllCricketer();
		if(allCricketerList!=null) {
			return new ResponseEntity<>(allCricketerList,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateData(@RequestBody CricketersRequest cricketersRequest) {
		CricketersResponse updatedData = cricketersServiceImpl.update(cricketersRequest);
		if(updatedData!=null) {
			return new ResponseEntity<>(updatedData,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
