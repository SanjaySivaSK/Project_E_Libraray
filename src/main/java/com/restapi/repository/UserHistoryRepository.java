package com.restapi.repository;

import com.restapi.model.Notifications;
import com.restapi.model.UserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserHistoryRepository extends JpaRepository<UserHistory,Long> {
    @Query("Select u from UserHistory u INNER JOIN u.appUser a WHERE a.id=?1 ")
    List<UserHistory> findByUserId(Long userId);

    @Query("SELECT u FROM UserHistory u WHERE u.returned = true")
    List<UserHistory> returnedBook();


    @Modifying
    @Transactional
    @Query("UPDATE UserHistory u SET u.returned = true WHERE u.id = ?1")
    void returnBook(Long id);
}