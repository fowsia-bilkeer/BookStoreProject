package com.qa.starterproject.Library.Repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.qa.starterproject.Library.DAO.Book;
import com.qa.starterproject.Library.DAO.BookSimple;

public interface BookRepo  extends JpaRepository<Book, Float> {
	
	@Query("SELECT book FROM Book book WHERE book.name = ?1")
	public List<Book> readName(String name);
	
	@Query("SELECT book FROM Book book WHERE book.genre = ?1")
	public List<Book> readGenre(String genre);	
	
	@Query("SELECT book FROM Book book WHERE book.id = ?1")
	public List<Book> readId(float id);
	
	@Modifying
	@Query("Delete FROM Book book WHERE book.id IN ?1")
	public void delete(List<Float> ids);
	
	@Query("SELECT book FROM Book book WHERE book.id in ?1")
	public List<Book> exists(List<Float> ids);

   public BookSimple saveAndFlush(BookSimple booksimple);
	public BookSimple saveAllAndFlush(Book updateFromRepo);

	public Book save(List<BookSimple> booksimple);

	public Book findById(float id);

	
	
}
