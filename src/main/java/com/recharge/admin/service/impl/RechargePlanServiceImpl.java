package com.recharge.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.recharge.admin.entity.RechargePlan;
import com.recharge.admin.exception.ResourceNotFoundException;
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
	// To fetch all the plans
	public List<RechargePlan> fetchPlans() {
		List<RechargePlan> list = rechargePlanRepository.findAll();
		return list;
	}

	// to add new plans
	public RechargePlan createPost(RechargePlan rechargePlan) {
		RechargePlan newRechargePlan = rechargePlanRepository.save(rechargePlan);
		return newRechargePlan;
	}

	// To update and get recharge id from database
	public RechargePlan updatePost(RechargePlan rechargePlanDto, long id) {
		RechargePlan planupdate = rechargePlanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RechargePlan", "id", id));
		planupdate.setPlan_id(rechargePlanDto.getPlan_id());
		planupdate.setPlanName(rechargePlanDto.getPlanName());
		planupdate.setNetworkProvider(rechargePlanDto.getNetworkProvider());
		planupdate.setAmount(rechargePlanDto.getAmount());
		planupdate.setValidity(rechargePlanDto.getValidity());
		planupdate.setAvailable(rechargePlanDto.isAvailable());

		RechargePlan updatedPost = rechargePlanRepository.save(planupdate);

		return updatedPost;

	}
	// get deleted rechargeid
	public void deleteRechargePlanById(long id) {
	
		RechargePlan rechargePlan = rechargePlanRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RechargePlan", "id", id));
		rechargePlanRepository.delete(rechargePlan);
	}

}
