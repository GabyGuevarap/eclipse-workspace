import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Test01_GET {
	@Test
	void test_01 () {
		
		Response response = RestAssured.get("https://cc.healthrecoverysolutions.com/login");
		
		
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());		
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
			
		Assert.assertEquals(statusCode, 200);
		
		
	}	
}
