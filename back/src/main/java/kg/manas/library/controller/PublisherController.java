package kg.manas.library.controller;

import kg.manas.library.model.PublisherModel;
import kg.manas.library.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherService publisherService;

    @PostMapping
    public ResponseEntity<PublisherModel> createPublisher(@RequestBody PublisherModel publisherModel){
        PublisherModel newPublisher = publisherService.save(publisherModel);
        return new ResponseEntity<>(newPublisher, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherModel> getPublisher(@PathVariable("id") Long id){
        PublisherModel publisher = publisherService.get(id);
        return new ResponseEntity<>(publisher,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PublisherModel>> getAllPublisher(){
        List<PublisherModel> publishers = publisherService.getAll();
        return new ResponseEntity<>(publishers,HttpStatus.OK);
    }
}
