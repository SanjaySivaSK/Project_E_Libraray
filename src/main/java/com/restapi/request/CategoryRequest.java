package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class    CategoryRequest {
    private Long id;
    @NotEmpty(message = "Category name must not be empty")
    @Size(min =2, message = "category  should have at least 2 characters")
    private String category;
    public CategoryRequest(String category) {
        this.category = category;
    }
}
