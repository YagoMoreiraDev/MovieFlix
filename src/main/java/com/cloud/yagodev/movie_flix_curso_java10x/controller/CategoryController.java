package com.cloud.yagodev.movie_flix_curso_java10x.controller;

import com.cloud.yagodev.movie_flix_curso_java10x.dtos.CategoryDTOCreate;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.CategoryDTOResponse;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.CategoryDTOUpdate;
import com.cloud.yagodev.movie_flix_curso_java10x.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/movieflix/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTOResponse>> getAll() {
        return ResponseEntity.ok(service.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryDTOResponse> create(@RequestBody CategoryDTOCreate dto) {
        CategoryDTOResponse response = service.createCategory(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTOResponse> getById(@PathVariable Long id) {
        CategoryDTOResponse response = service.getCategoryById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTOResponse> update(@PathVariable Long id,
                                                      @RequestBody CategoryDTOUpdate dto) {
        CategoryDTOResponse response = service.updateCategoryById(id, dto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }
}
