package com.restapi.response;

import com.restapi.request.AuthorRequest;
import com.restapi.request.CategoryRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class AuthorResponse {
    private List<AuthorRequest> authors = new ArrayList<>();
}
