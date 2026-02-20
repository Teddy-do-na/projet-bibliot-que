package com.pkf.projet_bibliotheque.Presentation.Controller;

import com.pkf.projet_bibliotheque.Application.Ports.Input.Book.*;
import com.pkf.projet_bibliotheque.Domain.model.Book;
import com.pkf.projet_bibliotheque.Presentation.Dto.Request.BookRequestDto;
import com.pkf.projet_bibliotheque.Presentation.Dto.Response.BookResponseDto;
import com.pkf.projet_bibliotheque.Presentation.Mapper.BookDtoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {
    private final CreateBookUseCase createBookUseCase;
    private final ListBookUseCase listBookUseCase;
    private final GetBookUseCase getBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final BookDtoMapper bookDtoMapper;

    @PostMapping
    public ResponseEntity<BookResponseDto> createBook(@RequestBody BookRequestDto bookRequestDto) {
        Book book = bookDtoMapper.toDomain(bookRequestDto);
        Book createdBook = createBookUseCase.createBook(book);
        return ResponseEntity.ok(bookDtoMapper.toReponse(createdBook));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<Book> books = listBookUseCase.findAllBooks();
        List<BookResponseDto> responseDtos = books.stream()
                .map(bookDtoMapper::toReponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookResponseDto>> getBookById(@PathVariable Long id) {
        Optional<Book> book = getBookUseCase.findByIdBook(id);
        return ResponseEntity.ok(Optional.ofNullable(bookDtoMapper.toReponse(book.orElse(null))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updateBook(@PathVariable Long id,@Valid @RequestBody BookRequestDto bookRequestDto) {
        Book book = bookDtoMapper.toDomain(bookRequestDto);
        Book updatedBook = updateBookUseCase.updateBook(id, book);
        return ResponseEntity.ok(bookDtoMapper.toReponse(updatedBook));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        ResponseEntity.ok(deleteBookUseCase.deleteBook(id));
        return ResponseEntity.noContent().build();
    }
}
