package com.recharge.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recharge.admin.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
