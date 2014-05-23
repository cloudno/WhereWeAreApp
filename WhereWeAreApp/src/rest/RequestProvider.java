package rest;

import java.util.Collections;

import org.springframework.http.HttpAuthentication;
import org.springframework.http.HttpBasicAuthentication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RequestProvider {
	
	///rest/groups/users 
	private static String PROTOCOL = "http";
	private static String IP_ADDRESS = "localhost";
	private static String PORT = "8080";
	private static String SERVICE_NAME = "Where";
	
	private static String SERVICE_URL = PROTOCOL + "://" + IP_ADDRESS + ":" + PORT + "/" + SERVICE_NAME;
	
	public static String PUT_BASKET_URL = SERVICE_URL + "/basket/{username}/basket/{timestamp}";
	public static String GET_ALL_USERS_URL = SERVICE_URL + "/rest/groups/users";
	public static String GET_LATEST_BASKET_URL = SERVICE_URL + "/basket/{username}/basket/latest";
		
	public static String GET_USER_URL = SERVICE_URL + "/user/{username}";
	
	public static String GET_ARTICLE_URL = SERVICE_URL + "/article/{barcode}";
	
	public static String GET_SHOP_URL = SERVICE_URL + "/shop/{shopId}";
	
	
	
	/**
	 * returns http header which contains basic authentication data from business data context
	 * @return Header
	 */
	public HttpHeaders getHttpHeader() {
		String username = UserInstance.getInstance().getName();
		String password = UserInstance.getInstance().getPassword();
		HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAuthorization(authHeader);
		return requestHeaders;
	}
	
	/**
	 * returns http header which contains given basic authentication data
	 * @param username
	 * @param password
	 * @return Header
	 */
	public HttpHeaders getHttpHeader(String username, String password) {
		HttpAuthentication authHeader = new HttpBasicAuthentication(username, password);
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setAuthorization(authHeader);
		return requestHeaders;
	}

	/**
	 * returns rest request temaplte which can be used for sending requests to server
	 * @return
	 */
	public RestTemplate getRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		messageConverter.setSupportedMediaTypes(Collections
				.singletonList(new MediaType("application", "json")));
		restTemplate.getMessageConverters().add(messageConverter);
		return restTemplate;
	}
	
	
	

}
