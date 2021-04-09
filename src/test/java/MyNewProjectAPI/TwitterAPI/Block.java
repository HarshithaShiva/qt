package MyNewProjectAPI.TwitterAPI;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Block extends Base {
	@Test
	public void block_user() throws IOException {
	Initial();
	RestAssured.baseURI=prop.getProperty("BlockURL");;
	Response res = given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
	queryParam("screen_name","@azeemcandy").
	when().post("/create.json").then().extract().response();
	String response=res.asString();
	JsonPath jp=new JsonPath(response);
	String name=jp.get("name");
	System.out.println(name);
	}
}

