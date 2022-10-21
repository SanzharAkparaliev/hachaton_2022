package kg.manas.library.controller;

import kg.manas.library.model.RentModel;
import kg.manas.library.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/rents")
public class RentController {

    private final RentService rentService;

    @PostMapping
    ResponseEntity<RentModel> save(@RequestBody RentModel rentModel) {
        return ResponseEntity.ok(rentService.save(rentModel));
    }

    @GetMapping("/getById")
    ResponseEntity<RentModel> get(Long id) {
        return ResponseEntity.ok(rentService.get(id));
    }

    @GetMapping
    ResponseEntity<List<RentModel>> getAll() {
        return ResponseEntity.ok(rentService.getAll());
    }
}
