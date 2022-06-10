package com.qa.starterproject.Library.DAO;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Reader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy = "reader")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonManagedReference
	private List<Book> books = new ArrayList<>();

	public void setLastName(@NotNull String location2) {
		// TODO Auto-generated method stub
		
	}


}
