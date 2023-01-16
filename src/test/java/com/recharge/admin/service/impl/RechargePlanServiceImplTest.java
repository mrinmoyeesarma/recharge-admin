package com.recharge.admin.service.impl;

import com.recharge.admin.entity.RechargePlan;
import com.recharge.admin.entity.Subscription;
import com.recharge.admin.payload.SubscribedPlansDto;
import com.recharge.admin.repository.RechargePlanRepository;
import com.recharge.admin.repository.SubscriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RechargePlanServiceImplTest {
    private RechargePlanServiceImpl rechargePlanService;
    private RechargePlanRepository rechargePlanRepository;
    private SubscriptionRepository subscriptionRepository;

    @BeforeEach
    void setup() {
        // Initialize
        rechargePlanService = new RechargePlanServiceImpl();

        // Mockito
        rechargePlanRepository = Mockito.mock(RechargePlanRepository.class);
        subscriptionRepository = Mockito.mock(SubscriptionRepository.class);

        // Reflection Test Utils
        ReflectionTestUtils.setField(rechargePlanService, "rechargePlanRepository", rechargePlanRepository);
        ReflectionTestUtils.setField(rechargePlanService, "subscriptionRepository", subscriptionRepository);
    }

    @Test
    void testFetchPlans() {
        List<RechargePlan> data = new ArrayList<>();
        Mockito.when(rechargePlanRepository.findAll()).thenReturn(data);
        List<RechargePlan> plans = rechargePlanService.fetchPlans();
        assertEquals(plans, data);
    }

    @Test
    void testCreatePost() {
        RechargePlan rechargePlan = new RechargePlan();
        rechargePlan.setPlan_id(1);
        Mockito.when(rechargePlanRepository.save(Mockito.any())).thenReturn(rechargePlan);
        RechargePlan plan = rechargePlanService.createPost(rechargePlan);
        assertEquals(1, plan.getPlan_id());
    }

    @Test
    void testUpdatePost() {
        RechargePlan rechargePlan = new RechargePlan();
        rechargePlan.setPlan_id(1);
        Mockito.when(rechargePlanRepository.findById(Mockito.any())).thenReturn(Optional.of(rechargePlan));
        Mockito.when(rechargePlanRepository.save(Mockito.any())).thenReturn(rechargePlan);
        RechargePlan plan = rechargePlanService.updatePost(rechargePlan, 1);
        assertEquals(1, plan.getPlan_id());
    }

    @Test
    void testDeleteRechargePlanById() {
        RechargePlan rechargePlan = new RechargePlan();
        rechargePlan.setPlan_id(1);
        Mockito.when(rechargePlanRepository.findById(Mockito.any())).thenReturn(Optional.of(rechargePlan));
        rechargePlanService.deleteRechargePlanById(1);
        assertEquals(1, rechargePlan.getPlan_id());
    }

    @Test
    void testGetSubscribedPlans() {
        List<Subscription> subscriptions = new ArrayList<>();
        List<SubscribedPlansDto> subscribedPlansDtos = new ArrayList<>();
        Mockito.when(subscriptionRepository.findByUsername(Mockito.any())).thenReturn(subscriptions);
        List<SubscribedPlansDto> plansDtos = rechargePlanService.getSubscribedPlans("username");
        assertEquals(subscribedPlansDtos, plansDtos);
    }
}
