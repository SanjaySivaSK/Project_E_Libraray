package com.restapi.repository;

import com.restapi.model.Book;
import com.restapi.model.Notifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notifications,Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Notifications n SET n.request = false WHERE n.id = ?1")
    void    clear(Long id);

    @Query("SELECT n FROM Notifications n WHERE n.request = true")
    List<Notifications> notifications();
}
