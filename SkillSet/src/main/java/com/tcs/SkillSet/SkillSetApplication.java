package com.tcs.SkillSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.SkillSet.model.OrderCancel;
import com.tcs.SkillSet.model.OrderStatus;
import com.tcs.SkillSet.model.RelOrderCustomer;

@RestController
@SpringBootApplication
public class SkillSetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillSetApplication.class, args);
	}

	@RequestMapping(value = "/orderCancel/{orderNumber}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public OrderCancel orderCancel(@PathVariable("orderNumber") String orderNumber) {
		String result = Try.orderCancel(orderNumber);
		if (result == null)
			return new OrderCancel(orderNumber, "true", "");
		return new OrderCancel(orderNumber, "false", result);
	}

	@RequestMapping(value = "/orderStatus/{orderNumber}", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public OrderStatus finalresult(@PathVariable("orderNumber") String orderNumber) {
		return Try.orderStatus(orderNumber);
	}

	@RequestMapping(value = "/relOrderCustomer/{orderNumber}/{customerID}", method = RequestMethod.GET, produces = {
			"application/json" })
	@ResponseBody
	public RelOrderCustomer finalresult(@PathVariable("orderNumber") String orderNumber,
			@PathVariable("customerID") String customerID) {
		return Try.relOrderCustomer(orderNumber, customerID);
	}
}
