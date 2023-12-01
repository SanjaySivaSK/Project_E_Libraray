package com.restapi.response;

import com.restapi.request.CategoryRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class CategoryResponse {

    private List<CategoryRequest> categories = new ArrayList<>();



}
