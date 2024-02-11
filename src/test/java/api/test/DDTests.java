package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {

	@Test(priority=1, dataProvider="data", dataProviderClass=DataProviders.class)
	public void testPostUser(String userID, String userName, String fName,String lname,String useremail,String pwd,String ph)
	{
		User userpayload=new User();
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fName);
		userpayload.setLastName(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);
		
		Response res = UserEndPoints.CreateUsers(userpayload);
		  Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteUserByUserName(String userName)
	{
		Response res = UserEndPoints.DeleteUsers(userName);
		Assert.assertEquals(res.statusCode(), 200);
	}
}
