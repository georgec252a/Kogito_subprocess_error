/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rest;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class A2_NonBDD_GET {

    RequestSpecification requestSpecification;

    ResponseSpecification responseSpecification;

    @BeforeClass
    public void beforeClass() {
        //I. Version without Builder
        //**********************************************************************
        //Using NonBDD RequestSpecification
        requestSpecification = given().baseUri("http://localhost:8086/").header("Content-Type", "json").log().all();
        RestAssured.requestSpecification = requestSpecification;

        //Using NonBDD ResponseSpecification
        responseSpecification = RestAssured.expect().statusCode(200).contentType(ContentType.JSON).log().all();
        RestAssured.responseSpecification = responseSpecification;
        //**********************************************************************

        //II. Version with Builder
        //**********************************************************************
        //Using the builder - RequestSpecBuilder

        //        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        //        requestSpecBuilder.setBaseUri("http://localhost:8086/");
        //        requestSpecBuilder.addHeader("Content-Type", "json");
        //        requestSpecBuilder.log(LogDetail.ALL);
        //        RestAssured.requestSpecification = requestSpecBuilder.build();

        //Using the builder - ResponseSpecBuilder
        //        ResponseSpecBuilder responseSpecBuilder=new ResponseSpecBuilder();
        //        responseSpecBuilder.expectStatusCode(200);
        //        responseSpecBuilder.expectContentType(ContentType.JSON);
        //        RestAssured.responseSpecification=responseSpecBuilder.build();

        //**********************************************************************

    }

    //-------------TEST1-------------------
    //--------------------------------------
    //test get method - First Test with RequestSpecification
    @org.testng.annotations.Test
    public void Get_intrare_auto_cle() {
        Response response = given().spec(RestAssured.requestSpecification).get("/intrare_auto_cle").then().log().all().extract().response();
        assertThat(response.statusCode(), is(equalTo(200)));
    }

    //-------------TEST1-------------------
    //--------------------------------------
    //test get method - Second Test with RequestSpecification and ResponseSpecification
    @org.testng.annotations.Test
    public void Get_intrare_auto_cle_2() {
        get("/intrare_auto_cle").then().spec(RestAssured.responseSpecification).log().all();
    }

    //-------------TEST2-------------------
    //--------------------------------------
    //test get method - First Test with RequestSpecification
    //Extrage din raspuns anumite valori
    @org.testng.annotations.Test
    public void extractSingleResponse_intrare_auto_cle() {
        Response res =
                given().spec(RestAssured.requestSpecification).get("/intrare_auto_cle").then().log().all().extract().response();

        JsonPath jsonPath = new JsonPath(res.asString());
        System.out.println("response = " + res.path("[0].id"));
        System.out.println("response = " + jsonPath.getString("[1].id"));
        System.out.println();
    }

    //-------------TEST2-------------------
    //--------------------------------------
    //test get method - Second Test with RequestSpecification and ResponseSpecification
    //Extrage din raspuns anumite valori
    @org.testng.annotations.Test
    public void Get_extractSingleResponse_intrare_auto_cle() {

        Response res = get("/intrare_auto_cle").then().spec(RestAssured.responseSpecification).log().all().extract().response();

        JsonPath jsonPath = new JsonPath(res.asString());
        System.out.println("response = " + res.path("[0].id"));
        System.out.println("response = " + jsonPath.getString("[1].id"));
        System.out.println();
    }

    //-------------TEST3-------------------
    //--------------------------------------
    //TEST get method - First Test with RequestSpecification
    //test Hamcrest empty() - verifica daca in raspuns id-ul este vid
    @org.testng.annotations.Test
    public void Empty_intrare_auto_cle() {
        given().spec(RestAssured.requestSpecification).get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).body("id", empty());
    }

    //-------------TEST3-------------------
    //--------------------------------------
    //TEST get method - Second Test with RequestSpecification and ResponseSpecification
    //test Hamcrest empty() - verifica daca in raspuns id-ul este vid
    @org.testng.annotations.Test
    public void Empty_intrare_auto_cle2() {
        get("/intrare_auto_cle").then().spec(RestAssured.responseSpecification).log().all().assertThat().statusCode(200).body("id", empty());
    }

    //-------------TEST4-------------------
    //--------------------------------------
    //TEST get method - First Test with RequestSpecification
    //test Hamcrest not(emptyArray()) - verifica daca vreun ID este null
    @org.testng.annotations.Test
    public void GET_Empty_intrare_auto_cle() {

        get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).body("id", empty());
    }

    //-------------TEST4-------------------
    //test Hamcrest not(emptyArray()) - verifica daca vreun ID este null
    //TEST get method - Second Test with RequestSpecification and ResponseSpecification
    @org.testng.annotations.Test
    public void NotEmpty_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).body("id", not(emptyArray()));

    }

}
