package com.tcs.SkillSet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelOrderCustomer {
	@JsonProperty("order.orderNumber")
	String orderNumber;
	@JsonProperty("order.orderNumber.type")
	String orderNumberType;

	@JsonProperty("order.customerID")
	String customerID;
	@JsonProperty("order.customerID.type")
	String customerIDType;

	@JsonProperty("rel.order.orderNumber.customer.customerID")
	String relation;
	@JsonProperty("rel.order.orderNumber.customer.customerID.type")
	String relationType;

	@JsonProperty("orderCancel.success")
	String success;
	@JsonProperty("orderCancel.success.type")
	String successType;

	@JsonProperty("orderCancel.failureReason")
	String failureReason;
	@JsonProperty("orderCancel.failureReason.type")
	String failureReasonType;

	public RelOrderCustomer(String orderNumber, String customerID, String relation, String success,
			String failureReason) {
		super();
		this.orderNumber = orderNumber;
		this.orderNumberType = "order";
		this.customerID = customerID;
		this.customerIDType = "number";
		this.relation = relation;
		this.relationType = "boolean";
		this.success = success;
		this.successType = "boolean";
		this.failureReason = failureReason;
		this.failureReasonType = "string";
	}
}
