package com.filipmoszczynski.module.books;

import com.filipmoszczynski.module.books.dto.BookDto;
import com.filipmoszczynski.module.books.dto.BookForm;
import com.filipmoszczynski.module.books.entity.BooksEntity;
import com.filipmoszczynski.module.books.mapper.BookFormMapper;
import com.filipmoszczynski.module.books.mapper.BookMapper;
import com.filipmoszczynski.module.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BooksController {

	@Autowired
	public BooksController(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}

	private final BooksRepository booksRepository;

	@GetMapping(value = "/api/books/{id}")
	public BookDto getBook(@PathVariable Long id) {
		return BookMapper.map(booksRepository.findById(id).get());
	}

	@GetMapping("/api/books")
	public List<BookDto> getBooks() {
		return (BookMapper.map(booksRepository.findAll()));
	}

	@PostMapping("/api/books")
	public BookDto newBooks(@Valid @RequestBody BookForm form) {
		BooksEntity booksEntity = BookFormMapper.map(form);
		return BookMapper.map(booksRepository.saveAndFlush(booksEntity));
	}

	@PutMapping("/api/books/{id}")
	public BookDto updateBooks(@PathVariable Long id,
	                               @RequestBody BooksEntity booksEntity) {
		return BookMapper.map(booksRepository.saveAndFlush(booksEntity.setId(id)));
	}

	@DeleteMapping("/api/books/{id}")
	public void deleteBooks(@PathVariable Long id) {
		booksRepository.deleteById(id);
	}
}
