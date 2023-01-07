package com.recharge.admin.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recharge.admin.entity.RechargePlan;

@RestController
@RequestMapping("api/posts")
public class AdminController {

	// get all the plans
	@GetMapping
	public List<RechargePlan> getAllPlans() {
		List<RechargePlan> rlist = new ArrayList<RechargePlan>();
		return rlist;
	}

}
