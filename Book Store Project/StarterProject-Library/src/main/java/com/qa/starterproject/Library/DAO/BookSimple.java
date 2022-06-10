package com.qa.starterproject.Library.DAO;
//import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;



//@Entity
public class BookSimple {


		
		
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private double id;
		private String name;
		private String genre;
		private int pages;
//		private String author;
		
		public BookSimple() {
			super();
			System.out.println("Book created");
			
		}
		
		
		
		public BookSimple(double id, String name, String genre, int pages) {
			super();
			this.id = id;
			this.name = name;
			this.genre = genre;
			this.pages = pages;
//			this.author = author;
		}
		


		public double getId() {
			return id;
		}
		public void setId(double id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public int getPages() {
			return pages;
		}
		public void setPages(int pages) {
			this.pages = pages;
		}



		public Object getStore() {
			// TODO Auto-generated method stub
			return null;
		}


		public void getStore(Reader store) {
			// TODO Auto-generated method stub
			
		}


		public String getBookSize(String bookSize) {
			return bookSize;
			// TODO Auto-generated method stub
			
		}


		public int getCover(Object cover) {
			return pages;
			// TODO Auto-generated method stub
			
		}



		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}



		public static BookSimple get() {
			// TODO Auto-generated method stub
			return null;
		}


		
		


			
		}	






