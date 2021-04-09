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

public class FourWeatherUpdate extends Base {
	@Test
	public void WeatherUpdate() throws IOException {
		Initial();
		RestAssured.baseURI=prop.getProperty("SearchURL");
		Response res = given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
		queryParam("q","#Bangalore #Weather").
		when().get("/tweets.json").then().extract().response();
		String response=res.asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response); 
		ArrayList<Object> arr=new ArrayList<>();
		arr.addAll(js.getList("statuses"));
		Iterator itr=arr.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}

	}

}
