package com.playstr.security.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.playstr.security.category.Category;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public Category createCategory(CategoryRequest categoryRequest) {
        var category = Category.builder()
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .build();
        categoryRepository.save(category);
        return category;
    }
}
