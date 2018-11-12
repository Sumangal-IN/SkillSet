package com.tcs.SkillSet;

import org.springframework.web.client.RestTemplate;

import com.tcs.SkillSet.model.OrderCancel;

public class Watch {

	public static void main(String args[]) throws InterruptedException {
		//Try.orderCancel("1000025120");
		System.setProperty("http.proxyHost", "165.225.80.32");
		System.setProperty("http.proxyPort", "80");
		System.setProperty("http.nonProxyHosts", "localhost|127.0.0.1");
		System.out.println("STARTED");
		RestTemplate r = new RestTemplate();
		long i = 0;
		while (true) {
			String orderToCancel = r.getForEntity("http://ec2-34-229-239-50.compute-1.amazonaws.com:9090/getOrderToCancel", String.class).getBody();
			if (orderToCancel != null) {
				OrderCancel orderCancel = Try.orderCancel(orderToCancel);
				System.out.println(orderCancel.getSuccess());
				r.getForEntity("http://ec2-34-229-239-50.compute-1.amazonaws.com:9090/setOrderCancelled/" + orderCancel.getSuccess(), String.class).getBody();
			}
			Thread.sleep(500);
			i++;
			if (i % 1000 == 0)
				System.gc();
		}
	}

}
