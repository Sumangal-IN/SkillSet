package com.tcs.SkillSet;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class Try {
	private static final String ATG_HOST = "http://atg-sqa3-fdc-app01.uk.b-and-q.com:8030";
	private static final String URL_ORDER_REPOSITORY = ATG_HOST
			+ "/dyn/admin/nucleus//atg/commerce/order/OrderRepository/";
	private static final String URL_PRODUCT_CATALOG = ATG_HOST
			+ "/dyn/admin/nucleus//atg/registry/ContentRepositories/ProductCatalog/";
	private static final String URL_AGENT_LOGIN = ATG_HOST
			+ "/agent-front/jsp/agent/login.jsp?_DARGS=/agent-front/jsp/agent/login.jsp";

	public static String cancelOrder(String sapOrderId) throws ClientProtocolException, IOException {

		CookieHandler.setDefault(new CookieManager());
		CloseableHttpClient instance = HttpClients.createDefault();

		List<String> orderProperties = getPropertyData(
				"<query-items item-descriptor=\"order\">sapOrderId=\"" + sapOrderId + "\"</query-items>",
				URL_ORDER_REPOSITORY);
		String omsOrderId = getProperty(orderProperties, "omsOrderId");
		System.out.println("OrderID:" + omsOrderId);
		String commerceItems[] = getProperty(orderProperties, "commerceItems").split(",");
		System.out.println("commerceItems:" + getProperty(orderProperties, "commerceItems"));
		HttpPost httpPost = new HttpPost(URL_AGENT_LOGIN);

		List<NameValuePair> map = new ArrayList<NameValuePair>();
		map.add(new BasicNameValuePair("_dyncharset", "UTF-8"));
		map.add(new BasicNameValuePair("_dynSessConf", "4943013688166579489"));
		map.add(new BasicNameValuePair("/kf/csc/navigation/formhandler/AgentLoginFormHandler.loginSuccessURL",
				"main.jsp?"));
		map.add(new BasicNameValuePair("_D:/kf/csc/navigation/formhandler/AgentLoginFormHandler.loginSuccessURL", " "));
		map.add(new BasicNameValuePair("user", "service"));
		map.add(new BasicNameValuePair("_D:user", " "));
		map.add(new BasicNameValuePair("pwd", "Service123"));
		map.add(new BasicNameValuePair("_D:pwd", " "));
		map.add(new BasicNameValuePair(
				"/kf/csc/navigation/formhandler/AgentLoginFormHandler.agentContext.sapCrmCustomerNo", ""));
		map.add(new BasicNameValuePair(
				"_D:/kf/csc/navigation/formhandler/AgentLoginFormHandler.agentContext.sapCrmCustomerNo", " "));
		map.add(new BasicNameValuePair(
				"/kf/csc/navigation/formhandler/AgentLoginFormHandler.agentContext.sapCrmOrderNo", ""));
		map.add(new BasicNameValuePair(
				"_D:/kf/csc/navigation/formhandler/AgentLoginFormHandler.agentContext.sapCrmOrderNo", " "));
		map.add(new BasicNameValuePair("/kf/csc/navigation/formhandler/AgentLoginFormHandler.agentContext.sapCrmAction",
				""));
		map.add(new BasicNameValuePair(
				"_D:/kf/csc/navigation/formhandler/AgentLoginFormHandler.agentContext.sapCrmAction", " "));
		map.add(new BasicNameValuePair("/kf/csc/navigation/formhandler/AgentLoginFormHandler.agentContext.sapCrm", ""));
		map.add(new BasicNameValuePair("_D:/kf/csc/navigation/formhandler/AgentLoginFormHandler.agentContext.sapCrm",
				" "));
		map.add(new BasicNameValuePair("/kf/csc/navigation/formhandler/AgentLoginFormHandler.agentContext.jsLocation",
				""));
		map.add(new BasicNameValuePair(
				"_D:/kf/csc/navigation/formhandler/AgentLoginFormHandler.agentContext.jsLocation", " "));
		map.add(new BasicNameValuePair("/kf/csc/navigation/formhandler/AgentLoginFormHandler.login", "Sign in"));
		map.add(new BasicNameValuePair("_D:/kf/csc/navigation/formhandler/AgentLoginFormHandler.login", " "));
		map.add(new BasicNameValuePair("_DARGS", "/agent-front/jsp/agent/login.jsp"));
		httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
		CloseableHttpResponse response = instance.execute(httpPost);
		String location = response.getFirstHeader("Location").getValue();
		System.out.println(location);
		response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		response = instance.execute(httpPost);
		location = response.getFirstHeader("Location").getValue();
		System.out.println(location);
		response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		response = instance.execute(httpPost);
		response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		location = ATG_HOST + "/agent-front/jsp/store/searchStoreResults.jsp";
		System.out.println(location);
		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		response = instance.execute(httpPost);
		map.clear();
		map.add(new BasicNameValuePair("location", "0505"));
		httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
		response = instance.execute(httpPost);
		response.close();

		// /********************************************************/
		// System.out.println("/********************************************************/");
		// /********************************************************/
		//
		// httpPost = new HttpPost(location);
		// httpPost = setHeaders(httpPost);
		// map.clear();
		// map.add(new BasicNameValuePair("location", "0505"));
		// httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
		// response = instance.execute(httpPost);
		// location =
		// "http://lnxs0506.uk.b-and-q.com:8030/agent-front/jsp/agent/main.jsp?";
		// System.out.println(location);
		// response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		location = ATG_HOST + "/agent-front/jsp/agent/main.jsp?";
		System.out.println(location);
		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		response = instance.execute(httpPost);
		response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		location = ATG_HOST + "/agent-front/jsp/customer/order.jsp?orderId=" + omsOrderId;
		System.out.println(location);
		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		map.clear();
		map.add(new BasicNameValuePair("orderNumber", sapOrderId));
		httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
		response = instance.execute(httpPost);
		System.out.println(EntityUtils.toString(response.getEntity()).contains("5014869104125"));
		response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		location = ATG_HOST + "/agent-front/jsp/orderAmend/cloneOrderJSON.jsp";
		System.out.println(location);
		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		map.clear();
		map.add(new BasicNameValuePair("orderId", omsOrderId));
		map.add(new BasicNameValuePair("action", ""));
		httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
		response = instance.execute(httpPost);
		if (EntityUtils.toString(response.getEntity()).contains("INVALID_ORDER_IN_SAP")) {
			response.close();
			return "order is not processed in SAP yet";
		}
		response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		location = ATG_HOST + "/agent-front/jsp/orderAmend/orderAmend.jsp";
		System.out.println(location);
		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		map.clear();
		map.add(new BasicNameValuePair("orderId", omsOrderId));
		map.add(new BasicNameValuePair("action", ""));
		httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
		response = instance.execute(httpPost);
		System.out.println(EntityUtils.toString(response.getEntity()).contains("5014869104125"));
		response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		for (int i = 0; i < commerceItems.length; i++) {
			List<String> commerceItemsProperties = getPropertyData(
					"<print-item item-descriptor=\"commerceItem\" id=\"" + commerceItems[i] + "\"/>",
					URL_ORDER_REPOSITORY);
			String productId = getProperty(commerceItemsProperties, "productId");
			System.out.println(productId);
			String commerceItemState = getProperty(commerceItemsProperties, "state");
			System.out.println(commerceItemState);
			if (commerceItemState.equals("CANCELLED")) {
				continue;
			}
			String shippingMethod = getProperty(commerceItemsProperties, "shippingMethod");
			System.out.println(shippingMethod);
			if (!shippingMethod.equals("homeDelivery")) {
				continue;
			}
			List<String> skuProperties = getPropertyData(
					"<print-item item-descriptor=\"sku\" id=\"" + productId + "\"/>", URL_PRODUCT_CATALOG);
			String productName = getProperty(skuProperties, "displayName").replaceAll("&amp;", "&");
			System.out.println(productName);
			String ean = getProperty(skuProperties, "ean");
			System.out.println(ean);

			location = ATG_HOST + "/agent-front/jsp/orderAmend/amendOrderJSON.jsp";
			System.out.println(location);
			httpPost = new HttpPost(location);
			httpPost = setHeaders(httpPost);
			map.clear();
			map.add(new BasicNameValuePair("productname", productName));
			map.add(new BasicNameValuePair("orderId", omsOrderId));
			map.add(new BasicNameValuePair("lineno", Integer.toString(i + 1)));
			map.add(new BasicNameValuePair("action", "check"));
			map.add(new BasicNameValuePair("ean", ean));
			map.add(new BasicNameValuePair("skuid", productId));
			System.out.println(map);
			httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
			response = instance.execute(httpPost);
			System.out.println(EntityUtils.toString(response.getEntity()).contains(
					"{\"externalProduct\":\"false\",\"bespokeProduct\":\"false\",\"warrantyProduct\":\"false\"}"));
			response.close();

			/********************************************************/
			System.out.println("/********************************************************/");
			/********************************************************/

			location = ATG_HOST + "/agent-front/jsp/orderAmend/cancelProduct.jsp";
			System.out.println(location);
			httpPost = new HttpPost(location);
			httpPost = setHeaders(httpPost);
			map.clear();
			map.add(new BasicNameValuePair("orderId", omsOrderId));
			map.add(new BasicNameValuePair("action", "check"));
			map.add(new BasicNameValuePair("ean", ean));
			map.add(new BasicNameValuePair("skuid", productId));
			map.add(new BasicNameValuePair("productname", productName));
			map.add(new BasicNameValuePair("lineno", Integer.toString(i + 1)));
			System.out.println(map);
			httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
			response = instance.execute(httpPost);
			System.out.println(EntityUtils.toString(response.getEntity()).contains("Reason for cancellation"));
			response.close();

			/********************************************************/
			System.out.println("/********************************************************/");
			/********************************************************/

			location = ATG_HOST + "/agent-front/jsp/orderAmend/orderAmendResult.jsp";
			System.out.println(location);
			httpPost = new HttpPost(location);
			httpPost = setHeaders(httpPost);
			map.clear();
			map.add(new BasicNameValuePair("reason", "Z2"));
			map.add(new BasicNameValuePair("notes", "As requested by user"));
			map.add(new BasicNameValuePair("lineIds", Integer.toString(i + 1)));
			map.add(new BasicNameValuePair("action", "cancelLineItem"));
			System.out.println(map);
			httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
			response = instance.execute(httpPost);
			response.close();

			/********************************************************/
			System.out.println("/********************************************************/");
			/********************************************************/
		}

		location = ATG_HOST + "/agent-front/jsp/checkout/actionControllerJson.jsp";
		System.out.println(location);
		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		map.clear();
		map.add(new BasicNameValuePair("action", "proceedToCheckout"));
		httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
		response = instance.execute(httpPost);
		response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		location = ATG_HOST + "/agent-front/jsp/customer/landing.jsp";
		System.out.println(location);
		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		map.clear();
		map.add(new BasicNameValuePair("accounttype", "BQ"));
		map.add(new BasicNameValuePair("isatg", "1"));
		map.add(new BasicNameValuePair("accountnumber", "52910049"));
		httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
		response = instance.execute(httpPost);
		response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		location = ATG_HOST + "/agent-front/jsp/checkout/stdCheckoutdetails.jsp";
		System.out.println(location);
		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		response = instance.execute(httpPost);
		response.close();

		/********************************************************/
		System.out.println("/********************************************************/");
		/********************************************************/

		location = ATG_HOST + "/agent-front/jsp/checkout/include/newOrderConfirmation.jsp";
		System.out.println(location);
		httpPost = new HttpPost(location);
		httpPost = setHeaders(httpPost);
		map.clear();
		map.add(new BasicNameValuePair("referenceNumber", ""));
		map.add(new BasicNameValuePair("cvcNumber", ""));
		map.add(new BasicNameValuePair("action", "payAndPlaceOrder"));
		map.add(new BasicNameValuePair("visaProcurementCostCentre", ""));
		map.add(new BasicNameValuePair("visaProcurementCostCentre", ""));
		map.add(new BasicNameValuePair("orderId", "undefined"));
		map.add(new BasicNameValuePair("isRefundOnReceipt", "undefined"));
		httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
		response = instance.execute(httpPost);
		System.out.println(EntityUtils.toString(response.getEntity()).contains("\"orderSubmitStatus\":true"));
		response.close();
		return null;
	}

	private static HttpPost setHeaders(HttpPost httpPost) {
		httpPost.setHeader("Host", "lnxs0506.uk.b-and-q.com:8030");
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		httpPost.setHeader("Upgrade-Insecure-Requests", "1");
		httpPost.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36");
		httpPost.setHeader("Accept",
				"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
		httpPost.setHeader("Accept-Language", "en-US,en;q=0.9");
		httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
		httpPost.setHeader("Accept-Encoding", "gzip, deflate");
		return httpPost;
	}

	private static List<String> getPropertyData(String xmltext, String url)
			throws ClientProtocolException, IOException {
		CloseableHttpClient instance = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(url);

		List<NameValuePair> map = new ArrayList<NameValuePair>();
		map.add(new BasicNameValuePair("xmltext", xmltext));
		httpPost.setEntity(new UrlEncodedFormEntity(map, "utf-8"));
		CloseableHttpResponse response = instance.execute(httpPost);
		String body = EntityUtils.toString(response.getEntity());
		List<String> lines = Arrays.asList(body.split("\r\n"));
		for (String line : lines) {
			if (line.startsWith("Query: "))
				return (Arrays.asList(line.split("\n")));
		}
		for (String line : lines) {
			if (line.startsWith("------ Printing item with"))
				return (Arrays.asList(line.split("\n")));
		}
		response.close();
		instance.close();
		return null;
	}

	private static String getProperty(List<String> propertiesData, String property) {
		for (String propertyData : propertiesData) {
			if (propertyData.contains("name=&quot;" + property + "&quot;")) {
				propertyData = propertyData.substring(propertyData.indexOf("CDATA") + 6,
						propertyData.indexOf("]", propertyData.indexOf("CDATA") + 1));
				return propertyData;
			}
		}
		return "";
	}

	public static void main(String args[]) throws ClientProtocolException, IOException {
		long startTime = System.nanoTime();
		cancelOrder("1000020247");

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
	}

}
