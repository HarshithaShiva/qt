package MyNewProjectAPI.TwitterAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TwoSearchTweet extends Base{
	@Test
	public void SearchTweet() throws IOException {
		Initial();
		RestAssured.baseURI=prop.getProperty("SearchURL");
		Response res = given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
		queryParam("q","Qualitest").
		when().get("/tweets.json").then().extract().response();
		String response=res.prettyPrint();
		System.out.println(response);
//		JsonPath js=new JsonPath(response);
//		String id=js.get("id").toString();
//		System.out.println(id);
//		String text=js.get("text").toString();
//		System.out.println(text);
				
		
	}

}
