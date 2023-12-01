package com.restapi.controller.user;

import com.restapi.model.Book;
import com.restapi.model.Role;
import com.restapi.model.UserHistory;
import com.restapi.response.UserHistoryResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.BookService;
import com.restapi.service.UserHistoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-book")
@RolesAllowed(Role.USER)
public class UserHistoryController {
    @Autowired
    private APIResponse apiResponse;

     @Autowired
    private UserHistoryService userHistoryService;
    @GetMapping("/{userId}")
   public ResponseEntity<APIResponse> getUserBook(@PathVariable Long userId) {
       List<UserHistoryResponse> userBookList = userHistoryService.findById(userId);
        apiResponse.setStatus(HttpStatus.OK.value());
       apiResponse.setData(userBookList);
      return new ResponseEntity<>(apiResponse, HttpStatus.OK);

   }
   @PutMapping("/{id}")
    public ResponseEntity<APIResponse>returnBooks(@PathVariable Long id){
        String rBOOK= userHistoryService.returnBooks(id);
       apiResponse.setStatus(HttpStatus.OK.value());
       apiResponse.setData(rBOOK);
       return new ResponseEntity<>(apiResponse, HttpStatus.OK);
   }

}
