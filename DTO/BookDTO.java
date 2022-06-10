package com.qa.starterproject.Library.DTO;

import com.qa.starterproject.Library.DAO.Reader;

import lombok.Data;

@Data
public class BookDTO {
	
	
	double id;
	
	
	int pages;
	
	
	String bookSize;
	
	
	Reader store;


	public static Object getCover() {
		// TODO Auto-generated method stub
		return null;
	}



	

}
