package com.recharge.admin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recharge.admin.entity.RechargePlan;
import com.recharge.admin.payload.RechargePlanDto;
import com.recharge.admin.repository.RechargePlanRepository;
import com.recharge.admin.service.RechargePlanService;

@Service
public class RechargePlanServiceImpl implements RechargePlanService {
	private RechargePlanRepository rechargePlanRepository;

	public RechargePlanServiceImpl(RechargePlanRepository rechargePlanRepository) {

		this.rechargePlanRepository = rechargePlanRepository;
	}

	@Override
	public List<RechargePlan> fetchPlans() {
		List<RechargePlan> list = rechargePlanRepository.findAll();
		return list;
	}

}
