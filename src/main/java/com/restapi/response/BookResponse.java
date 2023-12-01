package com.restapi.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restapi.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class BookResponse {
    public List<Book> books= new ArrayList<>();


    public BookResponse(List<Book> books) {
    }
}
