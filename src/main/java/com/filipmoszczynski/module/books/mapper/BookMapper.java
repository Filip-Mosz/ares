package com.filipmoszczynski.module.books.mapper;

import com.filipmoszczynski.module.books.dto.BookDto;
import com.filipmoszczynski.module.books.entity.BooksEntity;

import java.util.List;
import java.util.stream.Collectors;

public class BookMapper {

    public static BookDto map(BooksEntity entity) {
        return new BookDto()
                .setId(entity.getId())
                .setAuthor(entity.getAuthor())
                .setTitle(entity.getTitle())
                .setDetails(BookDetailsMapper.map(entity.getDetails()))
                .setTags(BooksTagsMapper.map(entity.getTags()));
    }

    public static List<BookDto> map(List<BooksEntity> entities) {
        return entities
                .stream()
                .map(entity -> map(entity))
                .collect(Collectors.toList());
    }
}

//todo należałoby napisać na to testy
