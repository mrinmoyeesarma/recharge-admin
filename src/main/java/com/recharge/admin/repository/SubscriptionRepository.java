package com.recharge.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recharge.admin.entity.Subscription;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUsername(String username);
}
