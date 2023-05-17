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

import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class General_Tests {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    public void beforeClass() {

        //Request specifications without builder
        //        requestSpecification=with().
        //                baseUri("https://api.getpostman.com").
        //                header("X-API-Key", "PMAK-636b9b6d0980c323f5426b50-69888587a930fe6124fae01e1383cac1d4").
        //                log().all();

        //Request Specifications builder
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://api.getpostman.com");
        requestSpecBuilder.addHeader("X-API-Key", "PMAK-636b9b6d0980c323f5426b50-69888587a930fe6124fae01e1383cac1d4");
        requestSpecification = requestSpecBuilder.build();
        responseSpecification = RestAssured.expect().statusCode(200).contentType(ContentType.JSON);

    }

    //Test case without BDD
    @org.testng.annotations.Test
    public void test1() {
        Response response = given().spec(requestSpecification).get("/workspaces");
        assertThat(response.statusCode(), is(equalTo(200)));
    }

    //Test case without BDD
    //with ResponseSpecification
    @org.testng.annotations.Test
    public void validate_responseSpecification() {
        given().spec(requestSpecification).get("/workspaces").then().spec(responseSpecification).log().all();
    }

    //Request Specifications Builder
    @org.testng.annotations.Test
    public void test() {
        Response response = requestSpecification.get("/workspaces");
        assertThat(response.statusCode(), is(equalTo(200)));
    }

    @org.testng.annotations.Test
    public void test2() {
        given().baseUri("https://api.getpostman.com").header("X-API-Key", "PMAK-636b9b6d0980c323f5426b50-69888587a930fe6124fae01e1383cac1d4").when().get("/workspaces").then().log().all().assertThat()
                .statusCode(200);
    }

    //Verificare status code 200 pentru GET pe endpoint-ul intrare_auto_cle
    @org.testng.annotations.Test
    public void testGet_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200);
    }

    //Verificare id-uri
    @org.testng.annotations.Test
    public void testPost_intrare_auto_cle() {
        Response res = given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).extract().response();
        System.out.println("response = " + res.asString());

    }

    //extract response
    @org.testng.annotations.Test
    public void extractResponse_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).body("id", hasItem("80aebf0f-b1c7-4d8e-b529-4a5cb0dbfc0c")).body("id",
                hasItem("0a0547ee-1b0a-4c48-82a1-bf49dcd980e2"));

    }

    //extract sigle value response

    @org.testng.annotations.Test
    public void extractSingleResponse_intrare_auto_cle() {
        Response res = given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).extract().response();
        JsonPath jsonPath = new JsonPath(res.asString());
        System.out.println("response = " + res.path("[0].id"));
        System.out.println("response = " + jsonPath.getString("[1].id"));

        System.out.println("response = " + jsonPath.getString("[1].id"));
        System.out.println();

    }

    @org.testng.annotations.Test
    public void extractResponseAndAssert_intrare_auto_cle() {
        String res = given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).extract().response().path("[0].id");

        assertThat(res, equalTo("e5bca575-5ebc-4f36-a31a-5f77a7e4dadb"));
        Assert.assertEquals(res, "e5bca575-5ebc-4f36-a31a-5f77a7e4dadb");
    }

    //test Hamcrest contains()
    @org.testng.annotations.Test
    public void ContainsID_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).body("id",
                contains("e5bca575-5ebc-4f36-a31a-5f77a7e4dadb", "2fe7d5b3-e0a9-48f3-a435-57ca8174b25e"));

    }

    //test Hamcrest empty()
    @org.testng.annotations.Test
    public void Empty_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).body("id", empty());

    }

    //test Hamcrest not(empltyArray())
    @org.testng.annotations.Test
    public void NotEmpty_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).body("id", not(emptyArray()));

    }

    //test Hamcrest hasSize())
    @org.testng.annotations.Test
    public void Size_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).body("id", hasSize(2));

    }

    //test Hamcrest hasValue())
    @org.testng.annotations.Test
    public void HasValue_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat().statusCode(200).body("[0]", hasValue("e5bca575-5ebc-4f36-a31a-5f77a7e4dadb"));
    }

    //test post method - Second Test
    @org.testng.annotations.Test
    public void Post2_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();

        try {
            requestParameters.put("stored", "true");
            requestParameters.put("intrareCLE", new JSONObject().put("marcaSofer", "12345678").put("vin", "12345678901234567"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        given().baseUri("http://localhost:8086/").header("Content-Type", "application/json").body(requestParameters.toString()).

                log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().statusCode(201);

    }

    //test post method
    @org.testng.annotations.Test
    public void Post1_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("http://localhost:8086/").body("{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}").header("Content-Type", "application/json").

                log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().statusCode(201);

    }

    //test post method - with Log
    @org.testng.annotations.Test
    public void Post3_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("http://localhost:8086/").body("{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}").header("Content-Type", "application/json").

                log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().statusCode(201);

    }

    //test post method - with Log if validaion failds
    @org.testng.annotations.Test
    public void PostLog_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("http://localhost:8086/").body("{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}").header("Content-Type", "application/json").

                log().ifValidationFails().

                when().

                post("/intrare_auto_cle").then().log().ifValidationFails().assertThat().statusCode(202);

    }

    //test post method - with Log if validaion failds with header blacklisted
    @org.testng.annotations.Test
    public void PostLogHeader_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("http://localhost:8086/").body("{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}").header("Content-Type", "application/json").
        //se foloseste pentru a bloca informatii sensibile precum API KEYs
                config(config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type"))).log().all().

                when().

                post("/intrare_auto_cle").then().log().ifValidationFails().assertThat().statusCode(202);

    }

    //Test 1 - Verify if vinok=true and soferValid=true
    @org.testng.annotations.Test
    public void Test1_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("http://localhost:8086/").body("{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}").header("Content-Type", "application/json").

                log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().statusCode(201).body("intrareCLE.vinok", equalToObject(true))
                .body("intrareCLE.soferValid", equalToObject(true));
    }

    //Test 2 - Verify Service task
    @org.testng.annotations.Test
    public void Test2_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("http://localhost:8086/").body("{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}").header("Content-Type", "application/json").

                log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().statusCode(201).body("intrareCLE.marcaSofer", equalToObject("12345678"))
                .body("intrareCLE.vin", equalToObject("12345678901234567")).body("intrareCLE.culoare", equalToObject("alb")).body("intrareCLE.tara", equalToObject("Romania"))
                .body("intrareCLE.stare", equalToObject("0")).body("intrareCLE.contDestinatar", equalToObject("contDestinatar"));
    }

    //Test 3 - Verify vinok is true
    @org.testng.annotations.Test
    public void Test3_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("http://localhost:8086/").body("{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}").header("Content-Type", "application/json").

                log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().statusCode(201).body("intrareCLE.vinok", equalToObject(true));

    }

    //Test 4 - Verify is Plata is OK
    @org.testng.annotations.Test
    public void Test4_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("http://localhost:8086/").body("{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n      " +
                "  \"marcaSofer\": \"12345678\",\r\n   " +
                "     \"plata\": 12345,\r\n  " +
                "      \"vin\": \"12345678901234567\"\r\n   " +
                " }\r\n}").header("Content-Type", "application/json").

                log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().statusCode(201).body("intrareCLE.plataOK", equalToObject(true));

    }

    //Test 5 - Verify ContDestinatar
    @org.testng.annotations.Test
    public void Test5_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("http://localhost:8086/").body("{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n      " +
                "  \"marcaSofer\": \"12345678\",\r\n   " +
                "     \"plata\": 12345,\r\n  " +
                "      \"vin\": \"12345678901234567\"\r\n   " +
                " }\r\n}").header("Content-Type", "application/json").

                log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().statusCode(201).body("intrareCLE.contDestinatar", equalToObject("contDestinatar"));

    }

    //Test 6 - Verify CompoundOcupat
    @org.testng.annotations.Test
    public void Test6_intrare_auto_cle() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("http://localhost:8086/").body("{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n     " +
                "   \"marcaSofer\": \"12345678\",\r\n    " +
                "    \"plata\": 12345,\r\n    " +
                "    \"vin\": \"12345678901234567\",\r\n     " +
                "   \"compoundOcupat\":12\r\n " +
                "   }\r\n}").header("Content-Type", "application/json").

                log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().statusCode(201).body("intrareCLE.compoundFull", equalToObject(true));

    }

    // MOCK Server //
    // Header Test//
    @org.testng.annotations.Test
    public void TestMock_Header1() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        given().baseUri("https://d394181c-df6b-4e5b-8d24-bcf0076d003f.mock.pstmn.io").header("header", "value2").header("x-mock-match-request-headers", "header").log().all().when().get("/get").then()
                .log().all().assertThat().statusCode(200);

    }

    // MOCK Server //
    // Header Test//
    @org.testng.annotations.Test
    public void TestMock_Header2() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        Header header1 = new Header("header", "value2");
        Header matchHeader = new Header("x-mock-match-request-headers", "header");
        given().baseUri("https://d394181c-df6b-4e5b-8d24-bcf0076d003f.mock.pstmn.io").header(header).header(matchHeader).log().all().when().get("/get").then().log().all().assertThat().statusCode(200);

    }

    // MOCK Server //
    // Header Test//
    @org.testng.annotations.Test
    public void TestMock_Header3() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        Header header1 = new Header("header", "value2");
        Header matchHeader = new Header("x-mock-match-request-headers", "header");
        Headers headers = new Headers(header, matchHeader);
        given().baseUri("https://d394181c-df6b-4e5b-8d24-bcf0076d003f.mock.pstmn.io").headers(headers).log().all().when().get("/get").then().log().all().assertThat().statusCode(200);

    }

    // MOCK Server //
    // Header Test//
    @org.testng.annotations.Test
    public void TestMock_Header4() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        Header header1 = new Header("header", "value2");
        Header matchHeader = new Header("x-mock-match-request-headers", "header");

        HashMap<String, String> headers = new HashMap<>();
        headers.put("header", "value2");
        headers.put("x-mock-match-request-headers", "header");

        given().baseUri("https://d394181c-df6b-4e5b-8d24-bcf0076d003f.mock.pstmn.io").headers(headers).log().all().when().get("/get").then().log().all().assertThat().statusCode(200);

    }

    // MOCK Server //
    // Header Test//
    @org.testng.annotations.Test
    public void TestMock_Header5() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();
        //        requestParameters.put("")
        Header header1 = new Header("header", "value2");
        Header matchHeader = new Header("x-mock-match-request-headers", "header");

        HashMap<String, String> headers = new HashMap<>();
        headers.put("header", "value2");
        headers.put("x-mock-match-request-headers", "header");

        given().baseUri("https://d394181c-df6b-4e5b-8d24-bcf0076d003f.mock.pstmn.io").header("header", "value1", "value2").log().all().when().get("/get").then().log().all().assertThat()
                .statusCode(200);

    }

    // MOCK Server //
    // Header Test//
    @org.testng.annotations.Test
    public void TestMock_Header6() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();

        given().baseUri("https://d394181c-df6b-4e5b-8d24-bcf0076d003f.mock.pstmn.io").header("header", "value2").header("x-mock-match-request-headers", "header").log().all().when().get("/get").then()
                .log().all().assertThat().statusCode(200).header("responseHeader", "resHeader2");

    }

    // MOCK Server //
    // Header Test//
    @org.testng.annotations.Test
    public void TestMock_Header7() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();

        Headers extractedHeaders = given().baseUri("https://d394181c-df6b-4e5b-8d24-bcf0076d003f.mock.pstmn.io").header("header", "value1").header("x-mock-match-request-headers", "header").log().all()
                .when().get("/get").then().log().all().assertThat().statusCode(200).header("responseHeader", "resHeader1").extract().headers();

        System.out.println("*****************");
        System.out.println("*****************");
        System.out.println("*****************");
        System.out.println("HEADER name:" + extractedHeaders.get("responseHeader").getName());
        System.out.println("HEADER value:" + extractedHeaders.get("responseHeader").getValue());
        System.out.println("HEADER value:" + extractedHeaders.getValue("responseHeader"));

    }

    // MOCK Server //
    // Header Test//
    @org.testng.annotations.Test
    public void TestMock_Header8() {
        Header header = new Header("Content-Type", "json");
        JSONObject requestParameters = new JSONObject();

        Headers extractedHeaders = given().baseUri("https://d394181c-df6b-4e5b-8d24-bcf0076d003f.mock.pstmn.io").header("header", "value1").header("x-mock-match-request-headers", "header").log().all()
                .when().get("/get").then().log().all().assertThat().statusCode(200).header("responseHeader", "resHeader1").extract().headers();

        System.out.println("*****************");
        System.out.println("*****************");
        System.out.println("*****************");
        System.out.println("HEADER name:" + extractedHeaders.get("responseHeader").getName());
        System.out.println("HEADER value:" + extractedHeaders.get("responseHeader").getValue());
        System.out.println("HEADER value:" + extractedHeaders.getValue("responseHeader"));

        List<String> values = extractedHeaders.getValues("multiValueHeader");

        for (String value : values) {
            System.out.println(value);
            System.out.println("----");
        }

    }

    //
    //Request specifications VS BDD
    //

    @org.testng.annotations.Test
    public void test3() {
        given().when().that();
    }

}
