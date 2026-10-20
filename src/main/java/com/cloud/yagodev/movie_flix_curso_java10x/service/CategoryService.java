package com.cloud.yagodev.movie_flix_curso_java10x.service;

import com.cloud.yagodev.movie_flix_curso_java10x.dtos.CategoryDTOCreate;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.CategoryDTOResponse;
import com.cloud.yagodev.movie_flix_curso_java10x.dtos.CategoryDTOUpdate;
import com.cloud.yagodev.movie_flix_curso_java10x.entity.Category;
import com.cloud.yagodev.movie_flix_curso_java10x.mappers.CategoryMapper;
import com.cloud.yagodev.movie_flix_curso_java10x.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTOResponse> getAllCategories() {
        List<Category> categoriesList = repository.findAll();
        return categoriesList.stream()
                .map(itemDaLista -> CategoryMapper.toDto(itemDaLista))
                .toList();
    }

    @Transactional
    public CategoryDTOResponse createCategory(CategoryDTOCreate dto) {
        Category entity = CategoryMapper.toEntity(dto);
        entity = repository.save(entity);
        return CategoryMapper.toDto(entity);
    }

    @Transactional(readOnly = true)
    public CategoryDTOResponse getCategoryById(Long id) {
        Category entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada"));
        return CategoryMapper.toDto(entity);
    }

    @Transactional
    public CategoryDTOResponse updateCategoryById(Long id, CategoryDTOUpdate dto) {
        Category entity = repository.getReferenceById(id);
        CategoryMapper.updateMapperCategory(dto, entity);
        entity = repository.save(entity);
        return CategoryMapper.toDto(entity);
    }

    @Transactional
    public void deleteCategoryById(Long id) {
        repository.deleteById(id);
    }
}
