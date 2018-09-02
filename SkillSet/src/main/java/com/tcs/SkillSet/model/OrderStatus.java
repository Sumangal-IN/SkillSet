package com.tcs.SkillSet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderStatus {
	@JsonProperty("order.orderNumber")
	String orderNumber;
	@JsonProperty("order.orderNumber.type")
	String orderNumberType;

	@JsonProperty("order.state")
	String orderState;
	@JsonProperty("order.state.type")
	String orderStateType;

	@JsonProperty("order.creationDate")
	String creationDate;
	@JsonProperty("order.creationDate.type")
	String creationDateType;

	@JsonProperty("order.totalToPay")
	String totalToPay;
	@JsonProperty("order.totalToPay.type")
	String totalToPayType;
	
	@JsonProperty("orderStatus.success")
	String success;
	@JsonProperty("orderStatus.success.type")
	String successType;

	@JsonProperty("orderStatus.failureReason")
	String failureReason;
	@JsonProperty("orderStatus.failureReason.type")
	String failureReasonType;

	public OrderStatus(String orderNumber, String orderState, String creationDate, String totalToPay, String success,
			String failureReason) {
		super();
		this.orderNumber = orderNumber;
		this.orderNumberType = "number";
		this.orderState = orderState;
		this.orderStateType = "string";
		this.creationDate = creationDate;
		this.creationDateType = "date|d/M/Y H:m:s";
		this.totalToPay = totalToPay;
		this.totalToPayType = "currency";
		this.success = success;
		this.successType = "boolean";
		this.failureReason = failureReason;
		this.failureReasonType = "string";
	}
}
