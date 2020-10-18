package com.filipmoszczynski.module.books.service;

import com.filipmoszczynski.module.books.entity.BooksEntity;
import com.filipmoszczynski.module.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    public BookService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    private BooksRepository booksRepository;

    public BooksEntity getOne(Long id) {
        return booksRepository.getOne(id);
    }

    public List<BooksEntity> getAll() {
        return booksRepository.findAll();
    }

    public BooksEntity create(BooksEntity entity) {
        return booksRepository.saveAndFlush(entity);
    }

    public BooksEntity update(BooksEntity entity, Long id) {
        return booksRepository.saveAndFlush(entity.setId(id));
    }

    public void delete(Long id) {
        booksRepository.deleteById(id);
    }

}
