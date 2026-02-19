package com.pkf.projet_bibliotheque.Infrastructure.Persistence.Mapper;

import com.pkf.projet_bibliotheque.Domain.model.Book;
import com.pkf.projet_bibliotheque.Infrastructure.Persistence.Entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper()
public interface BookEntityMapper {
    BookEntity toEntity(Book book);
    Book toDomain(BookEntity bookEntity);
}
