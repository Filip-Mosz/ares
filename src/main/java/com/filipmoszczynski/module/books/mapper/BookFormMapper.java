package com.filipmoszczynski.module.books.mapper;

import com.filipmoszczynski.module.books.dto.BookForm;
import com.filipmoszczynski.module.books.entity.BooksDetailsEntity;
import com.filipmoszczynski.module.books.entity.BooksEntity;
import com.filipmoszczynski.module.books.entity.BooksTagsEntity;

import java.util.Set;
import java.util.stream.Collectors;
public class BookFormMapper {

    public static BooksEntity map(BookForm form) {
        BooksEntity entity = new BooksEntity();
        return entity
                .setAuthor(form.getAuthor())
                .setTitle(form.getTitle())
                .setDetails(getDetails(form))
                .setTags(getTags(form, entity));
    }

    private static BooksDetailsEntity getDetails(BookForm form) {
        return new BooksDetailsEntity()
                .setIsbn(form.getIsbn())
                .setLang(form.getLang());
    }

    private static Set<BooksTagsEntity> getTags(BookForm form, BooksEntity entity) {
        return form.getTags()
                .stream()
                .map(tag -> new BooksTagsEntity().setValue(tag).setBook(entity))
                .collect(Collectors.toSet());
    }
}
