package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	public static Response CreateUsers(User payload)
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()		
			.post(Routes.post_url);
		return response;
	}
	
	public static Response GetUsers(String userName)
	{
		Response response = given()
								.pathParam("username", userName)
							.when()
								.get(Routes.get_url);
		return response;
	}
	
	public static Response Updateusers(String userName,User payload)
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.contentType("application/JSON")
			.body(payload)
			.pathParam("username", userName)
		.when()		
			.put(Routes.put_url);
		return response;
	}
	public static Response DeleteUsers(String userName)
	{
		Response response = given()
								.pathParam("username", userName)
			
		.when()		
			.delete(Routes.delete_url);
		return response;
	}

}
