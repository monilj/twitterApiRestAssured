package ContractTest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class twitter extends BaseClassForTwitterApi {

        @Test
        public void getLatestTweet() throws IOException {

            RestAssured.baseURI=getBaseUri();
            Response res=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
                    .queryParam("count", "1")
                    .when().get("/home_timeline.json").then().assertThat().statusCode(200).
                            extract().response();
            String response =res.asString();
            System.out.println(response);
            JsonPath js= new JsonPath(response);

            System.out.println((char[]) js.get("text"));
            System.out.println((char[]) js.get("id"));
            System.out.println("Test case Pass");

        }
    @Test(priority = 0)
    public void createTweet()
    {

        RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
        Response res=	given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret)
                .queryParam("status", "I am creating this tweet with Automation")
                .when().post("/update.json").then().assertThat().statusCode(200).extract().response();

        String response =res.asString();
        System.out.println(response);
        JsonPath js= new JsonPath(response);
        System.out.println("Below is the tweet added");
        id=js.get("id").toString();


    }

    }


