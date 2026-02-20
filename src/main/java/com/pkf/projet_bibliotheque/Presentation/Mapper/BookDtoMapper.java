package com.pkf.projet_bibliotheque.Presentation.Mapper;

import com.pkf.projet_bibliotheque.Domain.model.Book;
import com.pkf.projet_bibliotheque.Presentation.Dto.Request.BookRequestDto;
import com.pkf.projet_bibliotheque.Presentation.Dto.Response.BookResponseDto;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface BookDtoMapper {
    BookResponseDto toReponse(Book book);
    Book toDomain(BookRequestDto bookRequestDto);
}
