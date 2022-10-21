package kg.manas.library.service.impl;

import kg.manas.library.entity.BookCategory;
import kg.manas.library.entity.BookPublisher;
import kg.manas.library.model.PublisherModel;
import kg.manas.library.repository.PublisherRepository;
import kg.manas.library.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public PublisherModel get(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Publisher by id: " + id + " cannot be found !"))
                .toModel();
    }

    @Override
    public PublisherModel save(PublisherModel publisherModel) {
        BookPublisher bookPublisher = publisherModel.getId() == null ? new BookPublisher() : publisherRepository.getById(publisherModel.getId());
        bookPublisher.setName(publisherModel.getName());
        return publisherRepository.save(bookPublisher).toModel();
    }

    @Override
    public List<PublisherModel> getAll() {
        return publisherRepository.findAll().stream()
                .map(BookPublisher::toModel).collect(Collectors.toList());
    }
}
