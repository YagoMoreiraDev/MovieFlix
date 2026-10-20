package com.cloud.yagodev.movie_flix_curso_java10x.mappers;

import com.cloud.yagodev.movie_flix_curso_java10x.dtos.StreamingDTOCreate;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.StreamingDTOResponse;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.StreamingDTOUpdate;
import com.cloud.yagodev.movie_flix_curso_java10x.entity.Streaming;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

@UtilityClass
public class StreamingMapper {

    public static Streaming toEntity(StreamingDTOCreate dto) {
        return Streaming
                .builder()
                .name(dto.name())
                .build();
    }

    public static StreamingDTOResponse toDto(Streaming entity) {
        return StreamingDTOResponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static void updateStreaming(StreamingDTOUpdate dto, Streaming entity) {
        if(StringUtils.hasText(dto.name())) {
            entity.setName(dto.name());
        }
    }
}
