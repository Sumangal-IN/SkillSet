package com.tcs.SkillSet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderCancel {
	@JsonProperty("order.orderNumber")
	String orderNumber;
	@JsonProperty("order.orderNumber.type")
	String orderNumberType;

	@JsonProperty("orderCancel.cancelled")
	String cancellable;
	@JsonProperty("orderCancel.cancelled.type")
	String cancellableType;

	@JsonProperty("orderCancel.notCancelledReason")
	String cancellableReason;
	@JsonProperty("orderCancel.notCancelledReason.type")
	String cancellableReasonType;

	@JsonProperty("orderCancel.success")
	String success;
	@JsonProperty("orderCancel.success.type")
	String successType;

	@JsonProperty("orderCancel.failureReason")
	String failureReason;
	@JsonProperty("orderCancel.failureReason.type")
	String failureReasonType;

	public OrderCancel(String orderNumber, String cancellable, String cancellableReason, String success,
			String failureReason) {
		super();
		this.orderNumber = orderNumber;
		this.orderNumberType = "number";
		this.cancellable = cancellable;
		this.cancellableType = "boolean";
		this.cancellableReason = cancellableReason;
		this.cancellableReasonType = "string";
		this.success = success;
		this.successType = "boolean";
		this.failureReason = failureReason;
		this.failureReasonType = "string";
	}

}
