package com.restapi.controller;

import com.restapi.model.Book;
import com.restapi.model.Notifications;
import com.restapi.model.Role;
import com.restapi.request.BookRequest;
import com.restapi.request.NotificationRequest;
import com.restapi.response.CategoryResponse;
import com.restapi.response.common.APIResponse;
import com.restapi.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
    @RequestMapping("/api/notification")
@RolesAllowed({Role.ADMIN, Role.USER})
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private APIResponse apiResponse;

    @PostMapping("/send")
    public ResponseEntity<APIResponse> Request(@RequestBody
                                               NotificationRequest notificationRequest) {
        List<Notifications> notifications = notificationService.Request(notificationRequest);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(notifications);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    //    @PostMapping("/clear")
//    public ResponseEntity<APIResponse> clear(@RequestBody
//                                               NotificationRequest notificationRequest) {
//        List<Notifications> notifications = notificationService.Request(notificationRequest);
//        apiResponse.setStatus(HttpStatus.OK.value());
//        apiResponse.setData(notifications);
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }
    @PutMapping("/{id}")
    public ResponseEntity<APIResponse> clear(@PathVariable Long id) {
        System.out.println(id + "fffffffffffffff");
        String RequestBook = notificationService.clear(id);
        System.out.println(RequestBook);
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(RequestBook);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/message")
    public ResponseEntity<APIResponse> getNotification() {
        List<Notifications> notifications = notificationService.getNotification();
        apiResponse.setStatus(HttpStatus.OK.value());
        apiResponse.setData(notifications);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}