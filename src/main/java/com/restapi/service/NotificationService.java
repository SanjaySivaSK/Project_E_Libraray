package com.restapi.service;

import com.restapi.exception.common.ResourceNotFoundException;
import com.restapi.model.AppUser;
import com.restapi.model.Book;
import com.restapi.model.Notifications;
import com.restapi.repository.BookRepository;
import com.restapi.repository.NotificationRepository;
import com.restapi.repository.UserRepository;
import com.restapi.request.BookRequest;
import com.restapi.request.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Notifications> findAll() {
        return notificationRepository.findAll();
    }

    public List<Notifications> Request(NotificationRequest notificationRequest) {
        Notifications notifications = new Notifications();


        AppUser appuser = userRepository.findById(notificationRequest.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("userId",
                        "userId", notificationRequest.getUserId()));

        Book book = bookRepository.findById(notificationRequest.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("bookId",
                        "bookId", notificationRequest.getBookId()));

        notifications.setAppUser(appuser);
        notifications.setBook(book);
        notifications.setRequest(true);
        notificationRepository.save(notifications);

        return findAll();
    }
//    public List<Notifications> accepted(NotificationRequest notificationRequest) {
//        Notifications notifications = new Notifications();
//
//
//        AppUser appuser = userRepository.findById(notificationRequest.getUserId())
//                .orElseThrow(() -> new ResourceNotFoundException("userId",
//                        "userId", notificationRequest.getUserId()));
//
//        Book book = bookRepository.findById(notificationRequest.getBookId())
//                .orElseThrow(() -> new ResourceNotFoundException("bookId",
//                        "bookId", notificationRequest.getBookId()));
//
//        notifications.setAppUser(appuser);
//        notifications.setBook(book);
//        notifications.setRequest(false);
//        notificationRepository.save(notifications);
//
//        return findAll();
//    }

   public String clear(Long id) {
       notificationRepository.clear(id);
        return "success";
   }
    public List<Notifications> getNotification(){
       return notificationRepository.notifications();
    }


}
