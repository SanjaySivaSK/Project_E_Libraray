package com.restapi.controller.admin;

import com.restapi.model.Role;
import com.restapi.model.UserHistory;
import com.restapi.request.UserHistoryRequest;
import com.restapi.response.UserHistoryResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/admin/user-history")
//@PreAuthorize("hasRole('ROLE_ADMIN')")
@RolesAllowed(Role.ADMIN)
public class AdminUserHistoryController {
    @Autowired
    private APIResponse apiResponse;

@Autowired
private UserHistoryService userHistoryService;


    @GetMapping("/all")
    public ResponseEntity<APIResponse> getAllCategories() {
        List<UserHistoryResponse> userHistoryResponses=userHistoryService.findAll();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userHistoryResponses);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
            @PostMapping("/issue-book")
    public ResponseEntity<APIResponse> issueBook(@RequestBody UserHistoryRequest userHistoryRequest) {
        List<UserHistoryResponse> userHistoryList = userHistoryService.issueBook(userHistoryRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userHistoryList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    @PostMapping("/return-book")
    public ResponseEntity<APIResponse> returnBook(@RequestBody UserHistoryRequest userHistoryRequest) {
        List<UserHistoryResponse> userHistoryList = userHistoryService.returnBook(userHistoryRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(userHistoryList);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
