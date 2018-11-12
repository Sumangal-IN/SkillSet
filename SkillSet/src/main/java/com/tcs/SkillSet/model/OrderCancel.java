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

	public OrderCancel(String orderNumber, String cancellable, String cancellableReason, String success, String failureReason) {
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

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderNumberType() {
		return orderNumberType;
	}

	public void setOrderNumberType(String orderNumberType) {
		this.orderNumberType = orderNumberType;
	}

	public String getCancellable() {
		return cancellable;
	}

	public void setCancellable(String cancellable) {
		this.cancellable = cancellable;
	}

	public String getCancellableType() {
		return cancellableType;
	}

	public void setCancellableType(String cancellableType) {
		this.cancellableType = cancellableType;
	}

	public String getCancellableReason() {
		return cancellableReason;
	}

	public void setCancellableReason(String cancellableReason) {
		this.cancellableReason = cancellableReason;
	}

	public String getCancellableReasonType() {
		return cancellableReasonType;
	}

	public void setCancellableReasonType(String cancellableReasonType) {
		this.cancellableReasonType = cancellableReasonType;
	}

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getSuccessType() {
		return successType;
	}

	public void setSuccessType(String successType) {
		this.successType = successType;
	}

	public String getFailureReason() {
		return failureReason;
	}

	public void setFailureReason(String failureReason) {
		this.failureReason = failureReason;
	}

	public String getFailureReasonType() {
		return failureReasonType;
	}

	public void setFailureReasonType(String failureReasonType) {
		this.failureReasonType = failureReasonType;
	}

}
