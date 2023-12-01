package com.restapi.controller.admin;

import com.restapi.model.Book;
import com.restapi.model.Role;
import com.restapi.request.BookRequest;
import com.restapi.response.BookResponse;
import com.restapi.response.CategoryResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.BookService;
import com.restapi.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
@RestController

@RequestMapping("/api/admin/book")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RolesAllowed(Role.ADMIN)
public class AdminBookController {

    @Autowired
    private APIResponse apiResponse;

    @Autowired
    private BookService bookService;
    @Autowired
    private StorageService storageService;

    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllBooks() {
        List<Book> bookList = bookService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<APIResponse> createBook(@RequestParam("photo") MultipartFile photo,
                                                  @RequestParam("categoryId")Long categoryId,
                                                  @RequestParam("book")String book,
                                                  @RequestParam("description")String description,
                                                  @RequestParam("authorId")Long authorId
                                                  ) throws IOException {


        String file = storageService.storeFile(photo);
        BookRequest bookRequest = new BookRequest();
        bookRequest.setBook(book);
        bookRequest.setDescription(description);
        bookRequest.setAuthorId(authorId);
       bookRequest.setCategoryId(categoryId);
       bookRequest.setPhoto(file);
        List<Book> bookList = bookService.createBook(bookRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);

    }







    @PutMapping
    public ResponseEntity<APIResponse> updateBook(@Valid @RequestBody
                                                  BookRequest bookRequest) {
        List<Book> bookList = bookService.updateBook(bookRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse> deleteBook(@PathVariable Integer id) {
        List<Book> bookList = bookService.deleteById(id);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(bookList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


//     @GetMapping("/request")   public ResponseEntity<APIResponse> notification() {
//        List<Book> notifications = bookService.requestedBook();
//        apiResponse.setStatus(HttpStatus.OK.value());
//        apiResponse.setData(notifications);
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

}