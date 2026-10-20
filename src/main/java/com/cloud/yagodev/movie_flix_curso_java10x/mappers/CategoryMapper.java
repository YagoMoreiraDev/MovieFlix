package com.cloud.yagodev.movie_flix_curso_java10x.mappers;

import com.cloud.yagodev.movie_flix_curso_java10x.dtos.CategoryDTOCreate;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.CategoryDTOResponse;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.CategoryDTOUpdate;
import com.cloud.yagodev.movie_flix_curso_java10x.entity.Category;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@UtilityClass
public class CategoryMapper {

    public static Category toEntity(CategoryDTOCreate dto) {
        return Category
                .builder()
                .name(dto.name())
                .build();
    }

    public static CategoryDTOResponse toDto(Category entity) {
        return CategoryDTOResponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static void updateMapperCategory(CategoryDTOUpdate dto, Category entity) {
        if(StringUtils.hasText(dto.name())) {
            entity.setName(dto.name());
        }
    }
}
