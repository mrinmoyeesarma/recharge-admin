package com.recharge.admin.payload;

import lombok.Data;

@Data

public class RechargePlanDto {
	private long plan_id;
	private String networkProvider;
	private double amount;
	private String planName;
	private int validity;
	private boolean isAvailable;

}
