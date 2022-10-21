package kg.manas.library.controller;

import kg.manas.library.model.ShopModel;
import kg.manas.library.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;

    @PostMapping
    ResponseEntity<ShopModel> save(@RequestBody ShopModel shopModel) {
        try {
            return ResponseEntity.ok(shopService.save(shopModel));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }

    @GetMapping("getById")
    ResponseEntity<ShopModel> get(Long id) {
        try {
            return ResponseEntity.ok(shopService.get(id));
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }

    }

    @GetMapping
    ResponseEntity<List<ShopModel>> getAll() {
        try {
            return ResponseEntity.ok(shopService.getAll());
        } catch (Exception ex) {
            log.error(ex.getMessage());
            throw ex;
        }
    }
}
