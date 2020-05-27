/**
 * 
 */
package glue;

import org.json.JSONObject;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

/**
 * @author PRAJJU
 *
 */
public class StepDefs {

	public RequestSpecification req;
	public Response res;
	public Scenario s;
	
	@Before
	public void method234(Scenario s)
	{
		this.s = s;
	}
	
	@Given("^register end point \"(.*)\"$")
	public void method432(String x)
	{
		RestAssured.baseURI = x;
	}
	
	@And("^define request$")
	public void method657()
	{
		req=RestAssured.given();
	}
	
	@When("^request is sent to Restfull service$")
	public void method87()
	{
		res=req.request(Method.GET,"/users");
	}
	
	@When("^request is sent for respective employee \"(.*)\" details$")
	public void method92(String x)
	{
		res=req.request(Method.GET,"/users/"+x);
	}
	
	@When("^post request is sent with \"(.*)\" and \"(.*)\"$")
	public void method098(String x, String y)
	{
		JSONObject jo = new JSONObject();
		jo.put("name", x);
		jo.put("job", y);
		req.body(jo.toString());
		res=req.request(Method.POST,"/users");	
	}
	
	@Then("^response received shows employee ID created$")
	public void method7021()
	{
		int scode = res.getStatusCode();
		System.out.println("status code :"+scode);
		JsonPath jp = res.jsonPath();
		String id = jp.get("id");
		String createdAt = jp.get("createdAt");
		System.out.println("   ID:"+id+"   createdAt: "+createdAt);
		if(scode==201)
		{
			s.write("Test passed");
		}
		else
		{
			s.write("Test failed as "+scode);
			Assert.assertTrue(false);
		}
	}
	
	@Then("^response received should be in JSON$")
	public void method98()
	{
		int statusCode = 200;
		String format = "application/json";
		int actualStatusCode = res.getStatusCode();
		String actualFormat = res.getContentType();
		if(statusCode==actualStatusCode && actualFormat.contains(format))
		{
			s.write("Test passed");
		}
		else
		{
			s.write("Test failed as "+statusCode+"  "+actualFormat);
			Assert.assertTrue(false);
		}
		
	}
	
	@Then("^JSON response received should contain employee details only$")
	public void method786()
	{
			JsonPath jp = res.jsonPath();
			String first_name = jp.get("data.first_name");
			String last_name = jp.get("data.last_name");
			String email = jp.get("data.email");
			System.out.println("employee details:");
			System.out.println("name  : "+first_name+" "+last_name);
			System.out.println("email : "+email);
			s.write("Test passed");		
	}
}
