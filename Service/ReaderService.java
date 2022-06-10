package com.qa.starterproject.Library.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.qa.starterproject.Library.DAO.Reader;
import com.qa.starterproject.Library.DTO.ReaderDTO;
import com.qa.starterproject.Library.Repo.ReaderRepo;

//import com.qa.starterproject.Library.DAO.Store;
@Service 
public class ReaderService {
	
	
	private ModelMapper mapper;
	
	ReaderRepo repo;
	
	
	public ReaderService(ReaderRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private ReaderDTO mapToDTO(Reader reader) {
		return this.mapper.map(reader, ReaderDTO.class);
	}
	public ReaderDTO create(Reader reader) {
		return this.mapToDTO(this.repo.save(reader));
	}
	public List<ReaderDTO> createMany(List<Reader> reader) {
		return this.repo.saveAll(reader).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	public List<ReaderDTO> readAll() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	public ReaderDTO update(Reader newReader) {
		Reader reader = this.repo.findAllById(newReader.getId().getClass());
		reader.setFirstName(newReader.getFirstName());
		reader.setLastName(newReader.getLastName());
		return this.mapToDTO(this.repo.save(reader));
		
	}
	public Boolean delete(float id) {
		this.repo.deleteById((long) id);
		return !this.repo.existsById((long) id);
	}
	public List<ReaderDTO> readId(float id) {
		return this.repo.readId(id).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	public List<ReaderDTO> readFirstName(String Name) {
		return this.repo.readFirstName(Name).stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	public List<ReaderDTO> readLocation(String Genre) {
		return this.repo.readLastName(Genre).stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public List<ReaderDTO> readLastName(String lastName) {
		return null;
	}
	


}
