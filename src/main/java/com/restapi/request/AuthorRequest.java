package com.restapi.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AuthorRequest {
    private Long id;
    @NotEmpty(message = "author name must not be empty")
    @Size(min =2, message = "author  should have at least 2 characters")
    private String author;
    public AuthorRequest(String author) {
        this.author = author;
    }
}
