package com.recharge.admin.service;

import com.recharge.admin.entity.RechargePlan;
import com.recharge.admin.payload.SubscribedPlansDto;

import java.util.List;

public interface RechargePlanService {
	List<RechargePlan> fetchPlans();

	RechargePlan createPost(RechargePlan rechargePlan);

	RechargePlan updatePost(RechargePlan rechargePlan, long id);

	void deleteRechargePlanById(long id);

	List<SubscribedPlansDto> getSubscribedPlans(String username);

}
