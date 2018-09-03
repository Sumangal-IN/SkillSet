package com.tcs.SkillSet.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelOrderCustomer {
	@JsonProperty("order.orderNumber")
	String orderNumber;
	@JsonProperty("order.orderNumber.type")
	String orderNumberType;

	@JsonProperty("customer.customerID")
	String customerID;
	@JsonProperty("customer.customerID.type")
	String customerIDType;

	@JsonProperty("rel.order.orderNumber.customer.customerID")
	String relation;
	@JsonProperty("rel.order.orderNumber.customer.customerID.type")
	String relationType;

	@JsonProperty("relOrderCustomer.success")
	String success;
	@JsonProperty("relOrderCustomer.success.type")
	String successType;

	@JsonProperty("relOrderCustomer.failureReason")
	String failureReason;
	@JsonProperty("relOrderCustomer.failureReason.type")
	String failureReasonType;

	public RelOrderCustomer(String orderNumber, String customerID, String relation, String success,
			String failureReason) {
		super();
		this.orderNumber = orderNumber;
		this.orderNumberType = "number";
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
