package com.qa.starterproject.Library.DTO;

import java.util.ArrayList;
import java.util.List;

import com.qa.starterproject.Library.DAO.Book;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReaderDTO {
	
	
	Long id;
	
	
	String firstName;
	
	
	String lastName;
	
	private List<Book> book = new ArrayList<>();
	

}
