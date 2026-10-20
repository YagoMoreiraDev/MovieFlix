package com.cloud.yagodev.movie_flix_curso_java10x.controller;

import com.cloud.yagodev.movie_flix_curso_java10x.dtos.StreamingDTOCreate;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.StreamingDTOResponse;
import com.cloud.yagodev.movie_flix_curso_java10x.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movieflix/streamings")
@RequiredArgsConstructor
public class StreamingController {

    private final StreamingService service;

    @GetMapping
    public ResponseEntity<List<StreamingDTOResponse>> getAll() {
        return ResponseEntity.ok(service.getAllStreaming());
    }

    @PostMapping
    public ResponseEntity<StreamingDTOResponse> create(@RequestBody StreamingDTOCreate dto) {
        var response = service.createStreaming(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();
        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreamingDTOResponse> getById(@PathVariable Long id) {
        var response = service.getStreamingById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteStreamingById(id);
        return ResponseEntity.noContent().build();
    }
}
