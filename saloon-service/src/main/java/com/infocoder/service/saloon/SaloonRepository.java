package com.infocoder.service.saloon;

import com.infocoder.service.saloon.model.Saloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SaloonRepository extends JpaRepository<Saloon, Long> {
    Saloon findByOwnerId(Long ownerId);

    @Query("SELECT s from Saloon s where " +
            "(lower(s.city) like lower(concat('%', :keyword, '%')) OR " +
            "lower(s.name) like lower(concat('%',:keyword,'%') )OR " +
            "lower(s.address) like lower(concat('%',:keyword,'%') ) )"
    )
    List<Saloon> searchSaloons(String keyword);
}
