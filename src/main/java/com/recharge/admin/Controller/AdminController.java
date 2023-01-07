package com.recharge.admin.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recharge.admin.entity.RechargePlan;
import com.recharge.admin.service.RechargePlanService;

@RestController
@RequestMapping("api/posts")
public class AdminController {
	private RechargePlanService rechargePlanService;

	public AdminController(RechargePlanService rechargePlanService) {
		this.rechargePlanService = rechargePlanService;
	}

	// get all the plans
	@GetMapping
	public ResponseEntity<List<RechargePlan>> getAllPlans() {
		List<RechargePlan> rlist = rechargePlanService.fetchPlans();
		return new ResponseEntity<>(rlist, HttpStatus.OK);
	}

}
