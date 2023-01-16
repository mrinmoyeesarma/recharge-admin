package com.recharge.admin.controller;

import com.recharge.admin.entity.RechargePlan;
import com.recharge.admin.payload.SubscribedPlansDto;
import com.recharge.admin.service.RechargePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class AdminController {
	@Autowired
	private RechargePlanService rechargePlanService;

//	public AdminController(RechargePlanService rechargePlanService) {
//		this.rechargePlanService = rechargePlanService;
//	}

	// get all the plans
	@GetMapping
	public ResponseEntity<List<RechargePlan>> getAllPlans() {
		List<RechargePlan> rlist = rechargePlanService.fetchPlans();
		return new ResponseEntity<>(rlist, HttpStatus.OK);
	}

	// Add all the rechargePlans for the rest API
	@PostMapping
	public ResponseEntity<RechargePlan> createPost(@RequestBody RechargePlan rechargePlan) {
		return new ResponseEntity<>(rechargePlanService.createPost(rechargePlan), HttpStatus.CREATED);
	}

	// update post by id using rest api
	@PutMapping("/{id}")
	public ResponseEntity<RechargePlan> updatePost(@RequestBody RechargePlan rechargePlanDto,
			@PathVariable(name = "id") long id) {
		RechargePlan rechargeResponse = rechargePlanService.updatePost(rechargePlanDto, id);
			return new ResponseEntity<>(rechargeResponse,HttpStatus.OK); 
	}

	// delete post by id using rest api
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePost(@PathVariable(name = "id") long id) {
		rechargePlanService.deleteRechargePlanById(id);
		return new ResponseEntity<>("Recharge deleted succesfully", HttpStatus.OK);
	}

	// View Subscribed Plans
	@GetMapping("/view-subscribed-plans/{username}")
	public ResponseEntity<List<SubscribedPlansDto>> viewSubscribedPlans(@PathVariable(name = "username") String username) {
		List<SubscribedPlansDto> response = rechargePlanService.getSubscribedPlans(username);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
