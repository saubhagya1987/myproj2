package com.golenchi.web.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.golenchi.web.configuration.SpringMVCConfiguration;
import com.golenchi.web.dto.ResponseDto;
import com.golenchi.web.response.GolenchiResponse;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringMVCConfiguration.class)
@Rollback(false)
@WebAppConfiguration
@Transactional
public abstract class BaseSetUpEntity {
	@Autowired
	protected  WebApplicationContext wac;
	
	@Autowired
	protected Gson gson;
	
	protected  MockMvc mockMVC;

	@Before
	public  void setUp() throws Exception {
		mockMVC = MockMvcBuilders.webAppContextSetup(wac)/*.alwaysExpect(status().isOk())*/.build();
	}

	
	/**
	 * @param requestJson
	 * @throws Exception
	 */
	public GolenchiResponse sendRequest(String requestJson, String relativeUrl, ResponseDto expectedResponseResult) throws Exception  {
		MvcResult  refreshToken = mockMVC.perform(post(OAUTH_PASSWORD_GRANT).contentType(MediaType.APPLICATION_JSON).content(requestJson)/*.param("client_id", "golenchi")
                .param("client_secret", "12345").param("grant_type", "password")
                .param("username", "12345").param("password", "XYZ123")*/
                ).andDo(print()).andReturn();
		
		Map<String, String> refreshtokenMap =  gson.fromJson(refreshToken.getResponse().getContentAsString(), Map.class);
		
		MvcResult  aaccessToken = mockMVC.perform(post(AUTH_SERVER_URI).contentType(MediaType.APPLICATION_JSON).content(requestJson).param("client_id", "golenchi")
				.param("client_secret", "12345").param("refresh_token", refreshtokenMap.get("refresh_token"))).andDo(print()).andReturn();
		Map<String, String> aaccessTokenMap =  gson.fromJson(aaccessToken.getResponse().getContentAsString(), Map.class);
		
		MvcResult  result = mockMVC.perform(post(relativeUrl).contentType(MediaType.APPLICATION_JSON).content(requestJson).param("access_token", refreshtokenMap.get("access_token"))).andDo(print()).andReturn();
		
		Assert.assertNotNull(result);// Change assert statement to use full 
		String ContentAsString = result.getResponse().getContentAsString()  ;
	
		GolenchiResponse responseObj = gson.fromJson(ContentAsString, GolenchiResponse.class);
		Assert.assertNotNull(responseObj);
		Assert.assertEquals("Result of response not matched", expectedResponseResult.getResponseDescription(), responseObj.getResponseDto().getResponseDescription());
		Assert.assertEquals("Result code of response not matched", expectedResponseResult.getResponseCode(), responseObj.getResponseDto().getResponseCode());
		return responseObj;
	}
	
	
	public Map<String, JsonNode> parse(String json) throws JsonProcessingException, IOException {
		JsonFactory factory = new JsonFactory();

		ObjectMapper mapper = new ObjectMapper(factory);
		JsonNode rootNode = mapper.readTree(json);
	//	System.out.println(json);

		Iterator<Map.Entry<String, JsonNode>> fieldsIterator = rootNode.getFields();

		Map<String, JsonNode> mstyleMap = new HashMap<String, JsonNode>();

		while (fieldsIterator.hasNext()) {
			Map.Entry<String, JsonNode> field = fieldsIterator.next();
			mstyleMap.put(field.getKey(), field.getValue());
		//	System.out.println("Key: " + field.getKey() + "\tValue:" + field.getValue());

		}
		return mstyleMap;
	}
	
	
	  private static HttpHeaders getHeaders(){
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        return headers;
	    }
	     
	  private static final String AUTH_SERVER_URI = "/oauth/token";
	  private static final String CLIENT_CREDENTIAL = "&client_id=golenchi&client_secret=12345";
	  private static final String OAUTH_PASSWORD_GRANT = AUTH_SERVER_URI+ "?grant_type=password&username=testUser&password=XYZ123" + CLIENT_CREDENTIAL;
	     
	  private static final String OAUTH_ACCESS_TOKEN = "?access_token=";
	  private static final String OAUTH_REFRESH_TOKEN = "?grant_type=refresh_token " + CLIENT_CREDENTIAL;
	  
	 
	
}
