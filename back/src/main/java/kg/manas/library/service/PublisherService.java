package kg.manas.library.service;

import kg.manas.library.model.PublisherModel;

import java.util.List;

public interface PublisherService {
    PublisherModel get(Long id);

    PublisherModel save(PublisherModel publisherModel);

    List<PublisherModel> getAll();
}
