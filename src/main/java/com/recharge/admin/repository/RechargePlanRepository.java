package com.recharge.admin.repository;

import com.recharge.admin.entity.RechargePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargePlanRepository extends JpaRepository<RechargePlan, Long> {

}
