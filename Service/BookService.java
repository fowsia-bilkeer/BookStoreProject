package com.qa.starterproject.Library.Service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qa.starterproject.Library.DAO.Book;
import com.qa.starterproject.Library.DAO.BookSimple;
import com.qa.starterproject.Library.DTO.BookDTO;
import com.qa.starterproject.Library.Repo.BookRepo;


@Service 
public class BookService {
	
	
	private ModelMapper mapper;

	BookRepo repo;

	public BookService(BookRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

	private BookDTO mapToDto(Book book) {
		return this.mapper.map(book, BookDTO.class);
	}

	public BookDTO create(List<BookSimple> booksimple) {
		return this.mapToDto(this.save(booksimple));
	}

	private Book save(List<BookSimple> booksimple) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BookDTO> createMany(List<Book> books) {
		return this.repo.saveAll(books).stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public List<BookDTO> readAll() {
		return this.repo.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public BookDTO update(Book newBook) {
		Book book = this.repo.findById(newBook.getId()).get();
//		book.setName(newBook.getName());
		book.setGenre(newBook.getGenre());
		book.setPages(newBook.getPages());
		return this.mapToDto(this.repo.save(book));
	}
	
	@Transactional
	public Boolean delete(List<Float> ids) {
		this.repo.delete(ids);
		return this.repo.exists(ids).size() == 0 ? true : false;
	}

	public List<BookDTO> readId(float id) {
		return this.repo.readId(id).stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public List<BookDTO> readName(String name) {
		return this.repo.readName(name).stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public List<BookDTO> readGenre(String genre) {
		return this.repo.readGenre(genre).stream().map(this::mapToDto).collect(Collectors.toList());
	}

	public boolean delete(float id) {
		// TODO Auto-generated method stub
		return false;
	}

	public Book update(float id, BookSimple newBookSimple) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object create() {
		// TODO Auto-generated method stub
		return null;
	}

	public static Object create(Book book) {
		// TODO Auto-generated method stub
		return null;
	}
}



