package com.qa.apitest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;

import files.payload;

public class Post {

    public static void main(String[] args) {
        // Add->update->get (CRUD) place
        // validate post method and assert
        RestAssured.baseURI = "https://rahulshettyacademy.com/";
        String response = given().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload.addPlace())
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.52 (Ubuntu)")
                .extract().response().asString();
        System.out.println(response);

        // parse json
        JsonPath js = new JsonPath(response);
        String placeId = js.getString("place_id");
        System.out.println(placeId);

        // update place with place id
        String updateAddress = "Epping, sydney, nsw, 2121";
        given().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json").body(
                        "{\n\"place_id\":\"" + placeId
                                + "\",\n\"address\":\"" + updateAddress + "\",\n\"key\":\"qaclick123\"\n}\n")
                .when().put("maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));

        // read->get place
        String getPlaceResponse = given().queryParam("key", "qaclick123").queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js1 = new JsonPath(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(updateAddress, actualAddress);

    }

}
