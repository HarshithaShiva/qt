package MyNewProjectAPI.TwitterAPI;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class SixTrending extends Base {
	@Test(dataProvider="countries")
	public void Post(String country,String geolocation) throws IOException {
		Initial();
		RestAssured.baseURI=prop.getProperty("TrendURL");
		Response res = given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("Token"),prop.getProperty("TokenSecret")).
		queryParam("id",geolocation).when().get("/place.json").then().extract().response();
		String response=res.asString();
		JsonPath jp=new JsonPath(response);
		ArrayList<String> arr=new ArrayList<>();
		String s=null;
		arr.addAll((Collection<? extends String>) jp.get("trends.name"));
		Iterator itr=arr.iterator();
		while(itr.hasNext())
		{
		s=itr.next().toString();
		}
	
		s=s.substring(1,s.length()-1);
		String result[]=s.split(",");
		System.out.println("-------------------"+country+"-----------------------");
		for(int i=0;i<5;i++)
		{
			System.out.println(result[i]);
		}
		
}
		@DataProvider
		public Object[][] countries(){
		Object country[][]=new Object[4][2];
		country[0][0]="India";
		country[0][1] ="23424848";
		country[1][0]="US";
		country[1][1]="23424977";
		country[2][0]="UK";
		country[2][1]="23424975";
		country[3][0]="Israel";
		country[3][1]="23424852";
		return country;
	}
	

}


