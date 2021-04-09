package MyNewProjectAPI.TwitterAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class OneCreateANewTweet extends Base {
	@Test
	public void Post() throws IOException {
		Initial();
		RestAssured.baseURI=prop.getProperty("URL");
		Response res = given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
		queryParam("status","I am learning API testing#Qualitest").
		when().post("/update.json").then().extract().response();
		String response=res.asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response); 
		String id=js.get("id").toString();
		System.out.println(id);
		String text=js.get("text").toString();
		System.out.println(text);
	}
}
