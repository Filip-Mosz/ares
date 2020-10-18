package com.filipmoszczynski.module.books.mapper;

import com.filipmoszczynski.module.books.dto.BookForm;
import com.filipmoszczynski.module.books.entity.BooksDetailsEntity;
import com.filipmoszczynski.module.books.entity.BooksEntity;

public class BookFormMapper {

    public static BooksEntity map(BookForm form) {
        return new BooksEntity()
                .setAuthor(form.getAuthor())
                .setTitle(form.getTitle())
                .setDetails(getDetails(form));
    }

    private static BooksDetailsEntity getDetails(BookForm form) {
        return new BooksDetailsEntity()
                .setIsbn(form.getIsbn())
                .setLang(form.getLang());

    }
}
