package rest;

import java.util.HashMap;
import java.util.Map;

import model.User;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import android.util.Log;

public class RemoteUserService implements IUserService {
	protected static final String TAG = RemoteUserService.class
			.getSimpleName();

	public void createUser(User user) {
		try {
			//DisableSSLCertificateCheckUtil.disableChecks();

			//create instance of request provider which helps with some convencience methods
			RequestProvider provider = new RequestProvider();
			HttpHeaders header = provider.getHttpHeader();
			//make rest request

			HttpEntity<User> requestEntity = new HttpEntity<User>(user,
					header);
					
			RestTemplate restTemplate = provider.getRestTemplate();
			
			//create map which contains url data

			Map<String, Object> urlVariables = new HashMap<String, Object>();
			
			//Rest der Daten hinzufügen
			//gehoert da Userinstance ? oder user ? 
			urlVariables.put("username", UserInstance.getInstance().getName());
			//VERSCHLÜSSELN
			urlVariables.put("password", UserInstance.getInstance().getPassword());
			
			restTemplate.put(RequestProvider.PUT_BASKET_URL, requestEntity, urlVariables);
		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
		}

	}

	public UserList getallUsers() {
		
		try
		{
		//DisableSSLCertificateCheckUtil.disableChecks();
		//create instance of request provider which helps with some convencience methods

		RequestProvider provider = new RequestProvider();
		HttpHeaders header = provider.getHttpHeader();

		RestTemplate restTemplate = provider.getRestTemplate();
		//create map which contains url data

		Map<String, Object> urlVariables = new HashMap<String, Object>();
		urlVariables.put("username", UserInstance.getInstance().getName());
		//make rest request

		ResponseEntity<UserList> userListEntity = restTemplate
				.getForEntity(RequestProvider.GET_ALL_USERS_URL,
						UserList.class, urlVariables);
		
		//map request data to business objects
		UserList alleUser = userListEntity.getBody();
		return alleUser;
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}


}
}
