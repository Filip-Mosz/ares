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
                .setTitle(entity.getTitle());
    }

    public static List<BookDto> map(List<BooksEntity> entities) {
        return entities
                .stream()
                .map(BookMapper::map)
                .collect(Collectors.toList());
    }
}
