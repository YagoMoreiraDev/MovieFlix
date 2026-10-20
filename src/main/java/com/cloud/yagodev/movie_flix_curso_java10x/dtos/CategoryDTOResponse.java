package com.cloud.yagodev.movie_flix_curso_java10x.dtos;

import lombok.Builder;

@Builder
public record CategoryDTOResponse(Long id, String name) {
}
