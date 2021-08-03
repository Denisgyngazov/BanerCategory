package test.BannerCategory.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.BannerCategory.model.Request;
import test.BannerCategory.service.RequestService;

import javax.validation.Valid;
import javax.validation.constraints.Min;


@RestController
@RequestMapping("request")
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    @SuppressWarnings("rawtypes")
    public ResponseEntity<Iterable> findAll() {
        return ResponseEntity.ok(requestService.findAll());
    }

    @PostMapping
    public ResponseEntity<Request> create(@RequestBody @Valid Request request) {
        return ResponseEntity.ok(requestService.save(request));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable @Min(1) int id) {
        requestService.delete(id);
    }

    @PutMapping("/update/{request}")
    public ResponseEntity<Request> update(@RequestBody @Valid Request request) {
        return ResponseEntity.ok(requestService.update(request));
    }
}
