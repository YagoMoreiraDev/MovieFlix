package com.cloud.yagodev.movie_flix_curso_java10x.dtos;

import lombok.Builder;

@Builder
public record StreamingDTOResponse(Long id, String name) {
}
