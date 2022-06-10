package com.qa.starterproject.Library.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.starterproject.Library.DAO.Reader;

@Repository
public interface ReaderRepo extends JpaRepository<Reader, Long> {
	
	@Query("SELECT reader FROM Reader reader WHERE reader.firstName = ?1")
	public List<Reader> readFirstName(String Name);
	
	@Query(value = "SELECT * FROM Reader WHERE lastName = ?1", nativeQuery = true)
	public List<Reader> readLastName(String Genre);
	
	
	@Query(value = "SELECT * FROM Reader WHERE id = ?1", nativeQuery = true)
	public List<Reader> readId(float id);

	public Reader findById(Class<? extends Long> class1);

	public Reader findAllById(Class<? extends Long> class1);

}
