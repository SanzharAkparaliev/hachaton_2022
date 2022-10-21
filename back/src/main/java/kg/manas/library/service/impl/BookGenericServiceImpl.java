package kg.manas.library.service.impl;

import kg.manas.library.converters.BookGenericConverter;
import kg.manas.library.entity.BookGeneric;
import kg.manas.library.model.BookGenericModel;
import kg.manas.library.repository.BookGenericRepository;
import kg.manas.library.service.BookGenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookGenericServiceImpl implements BookGenericService {
    private final BookGenericRepository bookGenericRepository;
    private final BookGenericConverter bookGenericConverter;
    @Override
    public BookGenericModel getBookGenericById(Long id) {
        return bookGenericRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("book generic by id: " + id + " was not found")).toModel();
    }

    @Override
    public List<BookGenericModel> getAllBookGenerics() {
        return bookGenericRepository.findAll().stream().map(BookGeneric::toModel).collect(Collectors.toList());
    }

    @Override
    public BookGenericModel saveBookGeneric(BookGenericModel bookGenericModel) {
        return bookGenericRepository.save(bookGenericConverter.convertFromModel(bookGenericModel)).toModel();
    }
}
