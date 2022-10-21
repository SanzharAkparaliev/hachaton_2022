package kg.manas.library.service.impl;

import kg.manas.library.converters.BookGenericConverter;
import kg.manas.library.converters.BookUnitConverter;
import kg.manas.library.entity.BookGeneric;
import kg.manas.library.entity.BookUnit;
import kg.manas.library.enums.BookStatus;
import kg.manas.library.model.BookGenericModel;
import kg.manas.library.model.BookUnitModel;
import kg.manas.library.repository.BookGenericRepository;
import kg.manas.library.repository.BookUnitRepository;
import kg.manas.library.service.BookUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookUnitServiceImpl implements BookUnitService {
    private final BookUnitRepository bookUnitRepository;
    private final BookGenericRepository bookGenericRepository;
    private final BookGenericConverter bookGenericConverter;
    private final BookUnitConverter bookUnitConverter;
    @Override
    public BookUnitModel getBookUnitById(Long id) {
        return bookUnitRepository.findById(id).orElseThrow(NoSuchElementException::new).toModel();
    }

    @Override
    public List<BookUnitModel> getAllBookUnits() {
        return bookUnitRepository.findAll().stream().map(BookUnit::toModel).collect(Collectors.toList());
    }

    @Override
    public BookUnitModel saveBookUnit(BookUnitModel bookUnitModel) {
        BookUnit bookUnit = bookUnitModel.getId() != null ?
                bookUnitRepository.findById(bookUnitModel.getId()).orElseThrow(NoSuchElementException::new) :
                new BookUnit();
        bookUnit.setBookGeneric(bookGenericConverter.convertFromModel(bookUnitModel.getBookGenericModel()));
        bookUnit.setImage(bookUnitModel.getImage());
        bookUnit.setStatus(bookUnitModel.getStatus());
        return bookUnitRepository.save(bookUnit).toModel();
    }

    @Override
    public List<BookUnitModel> saveBookUnitsByBookGeneric(BookGenericModel bookGenericModel, Integer booksAmount, byte[] image) {
        BookGeneric bookGeneric = bookGenericModel.getId() != null ? bookGenericConverter.convertFromModel(bookGenericModel) :
                bookGenericRepository.save(bookGenericConverter.convertFromModel(bookGenericModel));
        BookUnit bookUnit = new BookUnit();
        bookUnit.setBookGeneric(bookGeneric);
        bookUnit.setStatus(BookStatus.AVAILABLE);
        if (image != null)
            bookUnit.setImage(image);
        List<BookUnitModel> bookUnits = new ArrayList<>();
        while (booksAmount < 1) {
            bookUnits.add(bookUnitConverter.convertFromEntity(bookUnitRepository.save(bookUnit)));
            booksAmount--;
        }
        return bookUnits;
    }
}
