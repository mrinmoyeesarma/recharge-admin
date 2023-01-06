package com.recharge.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recharge.admin.entity.RechargePlan;

public interface RechargePlanRepository extends JpaRepository<RechargePlan, Long> {

}
