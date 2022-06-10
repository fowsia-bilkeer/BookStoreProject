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
import com.qa.starterproject.Library.DAO.Book;
import com.qa.starterproject.Library.DTO.BookDTO;
import com.qa.starterproject.Library.Service.BookService;


@RestController
@RequestMapping("/books")
@CrossOrigin
public class BooksController {
	
	private BookService service;
//	public static List<BookSimple> booksimple = Arrays.asList(new BookSimple(1.F, "Homegoing","Historial fiction", 322));
	
	@Autowired
	public BooksController(BookService service) {
		this.service = service;
	}
		
//	@PostMapping("/create")
//	public ResponseEntity<BookDTO> create(@RequestBody Book book)  {
//		return new ResponseEntity<>(this.service.create(book), HttpStatus.CREATED);
//	}
	
	@PostMapping("/creatMany")
	public ResponseEntity<List<BookDTO>> createMany(@RequestBody List<Book> book) {
		return new ResponseEntity<>(this.service.createMany(book), HttpStatus.CREATED);
	}
		
	
	@GetMapping("/readAll")
	public ResponseEntity<List<BookDTO>> readAll() {
		return new ResponseEntity<>(this.service.readAll(), HttpStatus.OK);
					
	}
	
	@PutMapping("/update")
	public ResponseEntity<BookDTO> update(@RequestBody Book newBook)  {
		return new ResponseEntity<>(this.service.update(newBook), HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable float id) {
		return this.service.delete(id) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/readBy/id:{id}")
	public ResponseEntity<List<BookDTO>> readId(@PathVariable float id) {
		List<BookDTO> book = this.service.readId(id);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	
}

	
	



