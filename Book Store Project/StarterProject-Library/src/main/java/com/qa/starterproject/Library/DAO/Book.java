package com.qa.starterproject.Library.DAO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
//import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {
	
	public static Object getPages;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	float id;
	
	int pages;
	
//	@NotNull;
	String genre;
	
	@Column(name = "cover size", length = 10 )
	String bookSize;
	
	@ManyToOne(targetEntity = Reader.class)
	@JsonBackReference
	private Reader store;
	
	{
		pages = 322;
	}




public boolean isPresent() {
	// TODO Auto-generated method stub
	return false;
}

public Book get() {
	// TODO Auto-generated method stub
	return null;
}


public Object getName() {
	// TODO Auto-generated method stub
	return null;
}

public void setName(Object name) {
	// TODO Auto-generated method stub
	
}





//public MultiValueMap<String, String> get1() {
//	// TODO Auto-generated method stub
//	return null;
//}


	


		

}

	


