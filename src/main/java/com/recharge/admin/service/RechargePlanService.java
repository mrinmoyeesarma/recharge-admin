package com.recharge.admin.service;

import java.util.List;

import com.recharge.admin.entity.RechargePlan;
import com.recharge.admin.payload.RechargePlanDto;

public interface RechargePlanService {
	List<RechargePlan> fetchPlans();
}
