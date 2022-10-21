package kg.manas.library.service.impl;

import kg.manas.library.entity.BookAuthor;
import kg.manas.library.model.BookAuthorModel;
import kg.manas.library.repository.BookAuthorRepository;
import kg.manas.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final BookAuthorRepository authorRepository;


    @Override
    public BookAuthorModel get(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Author by id: " + id + " cannot be found !"))
                .toModel();
    }

    @Override
    public BookAuthorModel getByName(String name) {
        return authorRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Author by name: " + name + " cannot be found !"))
                .toModel();
    }

    @Override
    public BookAuthorModel save(BookAuthorModel bookAuthorModel) {
        BookAuthor bookAuthor = bookAuthorModel.getId() == null ? new BookAuthor() : authorRepository.getById(bookAuthorModel.getId());
        bookAuthor.setName(bookAuthorModel.getName());
        return authorRepository.save(bookAuthor).toModel();
    }

    @Override
    public List<BookAuthorModel> getAll() {
        return authorRepository.findAll().stream()
                .map(BookAuthor::toModel).collect(Collectors.toList());
    }
}
