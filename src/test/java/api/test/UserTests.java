package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	
	User userpayload;
	
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority=1)
	public void postUser()
	{
	  Response res = UserEndPoints.CreateUsers(userpayload);
	  res.then().log().all();
	  
	  Assert.assertEquals(res.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void getUser() 
	{
		Response res = UserEndPoints.GetUsers(this.userpayload.getUsername());
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	
	@Test(priority=3)
	public void updateUser()
	{
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res = UserEndPoints.Updateusers(this.userpayload.getUsername(),userpayload);
		res.then().log().all();
		Assert.assertEquals(res.statusCode(),200);
		
		Response re = UserEndPoints.GetUsers(this.userpayload.getUsername());
		re.then().log().all();
	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		Response res = UserEndPoints.DeleteUsers(this.userpayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.statusCode(), 200);
		
		Response re = UserEndPoints.GetUsers(this.userpayload.getUsername());
		re.then().log().all();
		Assert.assertEquals(re.statusCode(), 404);
	}
}
