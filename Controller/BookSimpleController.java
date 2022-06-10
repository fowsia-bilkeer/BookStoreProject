package com.qa.starterproject.Library.Controller;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.starterproject.Library.DAO.BookSimple;

import com.qa.starterproject.Library.Service.BookServiceSimple;

//@RestController()
//@RequestMapping("/CarSimple")
public class BookSimpleController {
	
	
	private BookServiceSimple service;
	


		@Autowired
		public BookSimpleController(BookServiceSimple service) {
			this.service = service;
		}

		@PostMapping("/create")
		public ResponseEntity<BookSimple> create(@RequestBody BookSimple bookSimple) {
			return new ResponseEntity<>(this.service.create(bookSimple), HttpStatus.CREATED);
		}

		@GetMapping("/readAll")
		public ResponseEntity<Object> readAll() {
			return new ResponseEntity<Object>(this.service.readAll(), HttpStatus.OK);
		}

		
		@GetMapping("/readID/{id}")
		public ResponseEntity<BookSimple> readId(@PathVariable float id) {
			Optional<BookSimple> BookSimple = this.service.readId(id);
			return BookSimple.isPresent() ? new ResponseEntity<BookSimple>(BookSimple.get(), HttpStatus.OK)
					           : new ResponseEntity<>(HttpStatus.NOT_FOUND);
		

		}

		@PutMapping("/update/{id}")
		public ResponseEntity<BookSimple> update(@PathVariable float id, @RequestBody BookSimple newBookSimple) throws Exception {
			Optional<BookSimple> BookSimple = this.service.update(id, newBookSimple);
			return BookSimple.isPresent() ? new ResponseEntity<>(BookSimple.get(), HttpStatus.ACCEPTED)
					: new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		@DeleteMapping("/delete/{id}")
		public ResponseEntity<BookSimple> delete(@PathVariable float id) throws Exception {
			return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
					: new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}


