package com.cloud.yagodev.movie_flix_curso_java10x.service;

import com.cloud.yagodev.movie_flix_curso_java10x.dtos.StreamingDTOCreate;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.StreamingDTOResponse;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.StreamingDTOUpdate;
import com.cloud.yagodev.movie_flix_curso_java10x.mappers.StreamingMapper;
import com.cloud.yagodev.movie_flix_curso_java10x.repository.StreamingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    @Transactional(readOnly = true)
    public List<StreamingDTOResponse> getAllStreaming() {
        return repository.findAll().stream()
                .map(item -> StreamingMapper.toDto(item))
                .toList();
    }

    @Transactional
    public StreamingDTOResponse createStreaming(StreamingDTOCreate dto) {
        var entity = StreamingMapper.toEntity(dto);
        entity = repository.save(entity);
        return StreamingMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public StreamingDTOResponse getStreamingById(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Streaming não encontrado."));
        return StreamingMapper.toDto(entity);
    }

    @Transactional
    public StreamingDTOResponse updateStreamingById(Long id, StreamingDTOUpdate dto) {
        var entity = repository.getReferenceById(id);
        StreamingMapper.updateStreaming(dto, entity);
        entity = repository.save(entity);
        return StreamingMapper.toDto(entity);
    }

    @Transactional
    public void deleteStreamingById(Long id) {
        repository.deleteById(id);
    }
}
