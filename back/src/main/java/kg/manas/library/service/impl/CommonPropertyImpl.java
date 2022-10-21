package kg.manas.library.service.impl;

import kg.manas.library.repository.CommonPropertyRepository;
import kg.manas.library.service.CommonPropertyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CommonPropertyImpl implements CommonPropertyService {
    private final CommonPropertyRepository commonPropertyRepositoryRepository;

    @Override
    public String getStringValueByKey(String key) {
        return commonPropertyRepositoryRepository.findByKey(key)
                .orElseThrow(() -> new NoSuchElementException("Common property by key: " + key + " cannot be found !"));
    }

    @Override
    public Integer getIntegerValueByKey(String key) {
        return Integer.parseInt(commonPropertyRepositoryRepository.findByKey(key)
                .orElseThrow(() -> new NoSuchElementException("Common property by key: " + key + " cannot be found !")));
    }
}
