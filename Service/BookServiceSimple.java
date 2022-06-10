package com.qa.starterproject.Library.Service;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


import com.qa.starterproject.Library.DAO.BookSimple;

@Service
public class BookServiceSimple {
	List<BookSimple> BookSimple = new ArrayList<>(Arrays.asList(new BookSimple(2D, "Homegoing",  "Historical Fiction", 322), new BookSimple(3L, "Harry Potter And The Goblet Of Fire", "Fantasy", 636)));
	double currentId = getCurrentId();

	public double getCurrentId() {
		double highest = 0l;
		for (BookSimple b : BookSimple) {
			if (b.getId() > highest) {
				highest = b.getId();
			}
		}
		return highest + 1;
	}

	// create
	public BookSimple create(BookSimple BookSimple) {
		BookSimple.setId(currentId);
		currentId++;
		this.BookSimple.add(BookSimple);
		return this.BookSimple.get(this.BookSimple.size() - 1);

	}

	// read
	public List<BookSimple> readAll() {
		return BookSimple;
	}

	// read id
	public Optional<BookSimple> readId(float id) {
		for (BookSimple BookSimple : BookSimple) {
			if (BookSimple.getId() == id) {
				return Optional.of(BookSimple);
			}
		}
		return Optional.empty();
	}

	// update
	public Optional<BookSimple> update(float id, BookSimple newBookSimple) throws RuntimeException {
		for (BookSimple BookSimple : this.BookSimple) {
			if (BookSimple.getId() == id) {
				this.BookSimple.remove(BookSimple);
				this.BookSimple.add(newBookSimple);
				return Optional.of(this.BookSimple.get(this.BookSimple.size() - 1));
			}
		}
		return Optional.empty();
	}

	// delete
	public Boolean delete(float id) {
		for (BookSimple BookSimple : this.BookSimple) {
			if (BookSimple.getId() == id) {
				return this.BookSimple.remove(BookSimple);
			}
		}
		return false;
	}
}
	


