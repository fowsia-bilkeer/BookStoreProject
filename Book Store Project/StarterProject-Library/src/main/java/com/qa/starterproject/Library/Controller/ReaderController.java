package com.qa.starterproject.Library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.starterproject.Library.DAO.Reader;
import com.qa.starterproject.Library.DTO.ReaderDTO;
import com.qa.starterproject.Library.Service.ReaderService;

@RestController()
@RequestMapping("/reader")
@CrossOrigin
public class ReaderController {
	private ReaderService service;
	
	
	@Autowired
	public ReaderController(ReaderService service) {
		this.service = service;
	}
	@PostMapping("/create")
	public ResponseEntity<ReaderDTO> create(@RequestBody Reader reader) {
		return new ResponseEntity<>(this.service.create(reader), HttpStatus.CREATED);
	}
	@PostMapping("/createMany") 
	public ResponseEntity<List<ReaderDTO>> createMany(@RequestBody List<Reader> reader) {
		return new ResponseEntity<>(this.service.createMany(reader), HttpStatus.CREATED);
	}
	@GetMapping("/readAll")
	public ResponseEntity<List<ReaderDTO>> readAll() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<ReaderDTO> update(@RequestBody Reader newReader) {
		return new ResponseEntity<>(this.service.update(newReader), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable float id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	@GetMapping("/readBy/id:{id}")
	public ResponseEntity<List<ReaderDTO>> readId(@PathVariable int id) {
		List<ReaderDTO> readers = this.service.readId(id);
		return new ResponseEntity<>(readers, HttpStatus.OK);
	}
	
	@GetMapping("/readBy/first-name:{firstName}")
	public ResponseEntity<List<ReaderDTO>> readName(@PathVariable String firstName) {
		List<ReaderDTO> readers = this.service.readFirstName(firstName);
		return new ResponseEntity<>(readers, HttpStatus.OK);
	}
	
	@GetMapping("/readBy/last-name:{lastName}")
	public ResponseEntity<List<ReaderDTO>> readGenre(@PathVariable String lastName) {
		List<ReaderDTO> readers = this.service.readLastName(lastName);
		return new ResponseEntity<>(readers, HttpStatus.OK);
	}

}
