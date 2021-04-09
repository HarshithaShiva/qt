package MyNewProjectAPI.TwitterAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FiveListAllTheUsers extends Base {
	@Test
	public void ListUsers() throws IOException {
		Initial();
		RestAssured.baseURI=prop.getProperty("UTURL");
		Response res = given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
		queryParam("user_id","@azeemcandy").
		when().get("/user_timeline.json").then().extract().response();
		String response=res.asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response); 
		String id=js.get("id").toString();
		System.out.println(id);
		String text=js.get("text").toString();
		System.out.println(text);

	}

}
