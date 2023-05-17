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
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class A4_NonBDD_POST {

    RequestSpecification requestSpecification;

    ResponseSpecification responseSpecification;

    String payload;

    @BeforeClass
    public void beforeClass() {
        // I. Version without Builder
        // **********************************************************************
        // Using NonBDD RequestSpecification
        // requestSpecification=given().baseUri("http://localhost:8086/").
        // header("Content-Type", "json").
        // log().all();
        // RestAssured.requestSpecification=requestSpecification;

        // Using NonBDD ResponseSpecification
        // responseSpecification= RestAssured.expect().
        // statusCode(200).
        // contentType(ContentType.JSON).
        // log().all();
        // RestAssured.responseSpecification=responseSpecification;
        // **********************************************************************

        // II. Version with Builder
        // **********************************************************************
        // Using the builder - RequestSpecBuilder

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("http://localhost:8086/");
        requestSpecBuilder.addHeader("Content-Type", "json");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        // Using the builder - ResponseSpecBuilder
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(201);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        RestAssured.responseSpecification = responseSpecBuilder.build();

        // **********************************************************************

    }

    // -------------TEST1-------------------
    // --------------------------------------
    // Verificare status code 201 pentru POST pe endpoint-ul intrare_auto_cle
    @org.testng.annotations.Test
    public void POST1_intrare_auto_cle() {
        payload = "{\n" +
                "    \"stored\": true,\n" +
                "    \"intrareCLE\": {\n" +
                "        \"marcaSofer\": \"12345678\",\n" +
                "        \"plata\": 12345,\n" +
                "        \"vin\": \"12345678901234567\"\n" +
                "    }\n" +
                "}";

        Response response = with().body(payload).post("/intrare_auto_cle");
        assertThat(response.statusCode(), equalTo(201));
    }

    // -------------TEST2-------------------
    // --------------------------------------
    // Test 2 - Verify if vinok=true and soferValid=true
    @org.testng.annotations.Test
    public void POST2_intrare_auto_cle() {

        payload = "{\n" +
                "    \"stored\": true,\n" +
                "    \"intrareCLE\": {\n" +
                "        \"marcaSofer\": \"12345678\",\n" +
                "        \"plata\": 12345,\n" +
                "        \"vin\": \"12345678901234567\"\n" +
                "    }\n" +
                "}";

        Response response = with().body(payload).post("/intrare_auto_cle");
        assertThat(response.path("intrareCLE.vinok"), equalTo(true));
        assertThat(response.path("intrareCLE.soferValid"), equalTo(true));

    }

    // -------------TEST3-------------------
    // --------------------------------------
    // Test 3 - Verify Service task
    @org.testng.annotations.Test
    public void POST3_intrare_auto_cle() {

        payload = "{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}";

        Response response = with().body(payload).post("/intrare_auto_cle");
        assertThat(response.path("intrareCLE.marcaSofer"), equalTo("12345678"));
        assertThat(response.path("intrareCLE.culoare"), equalTo("alb"));
        assertThat(response.path("intrareCLE.tara"), equalTo("Romania"));
        assertThat(response.path("intrareCLE.stare"), equalTo("0"));
        assertThat(response.path("intrareCLE.contDestinatar"), equalTo("contDestinatar"));

    }

    // -------------TEST4-------------------
    // --------------------------------------
    // Test 4 - Verify VIN OK
    @org.testng.annotations.Test
    public void POST4_intrare_auto_cle() {

        payload = "{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}";

        Response response = with().body(payload).post("/intrare_auto_cle");
        assertThat(response.path("intrareCLE.vinok"), equalTo(true));

    }

    // -------------TEST5-------------------
    // --------------------------------------
    // Test 5 - Verify Plata OK
    @org.testng.annotations.Test
    public void POST5_intrare_auto_cle() {

        payload = "{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n      " +
                "  \"marcaSofer\": \"12345678\",\r\n   " +
                "     \"plata\": 12345,\r\n  " +
                "      \"vin\": \"12345678901234567\"\r\n   " +
                " }\r\n}";

        Response response = with().body(payload).post("/intrare_auto_cle");
        assertThat(response.path("intrareCLE.plataOK"), equalTo(true));
    }

    // -------------TEST7-------------------
    // --------------------------------------
    // Test 7 - Verify Cont Destinatar
    @org.testng.annotations.Test
    public void POST7_intrare_auto_cle() {

        payload = "{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n      " +
                "  \"marcaSofer\": \"12345678\",\r\n   " +
                "     \"plata\": 12345,\r\n  " +
                "      \"vin\": \"12345678901234567\"\r\n   " +
                " }\r\n}";

        Response response = with().body(payload).post("/intrare_auto_cle");
        assertThat(response.path("intrareCLE.contDestinatar"), equalTo("contDestinatar"));
    }

    // -------------TEST8-------------------
    // --------------------------------------
    // Test 8 - Verify CompoundFull
    @org.testng.annotations.Test
    public void POST8_intrare_auto_cle() {

        payload = "{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n     " +
                "   \"marcaSofer\": \"12345678\",\r\n    " +
                "    \"plata\": 12345,\r\n    " +
                "    \"vin\": \"12345678901234567\",\r\n     " +
                "   \"compoundOcupat\":0\r\n " +
                "   }\r\n}";

        Response response = with().body(payload).post("/intrare_auto_cle");
        assertThat(response.path("intrareCLE.compoundFull"), equalTo(true));
    }

    // -------------TEST9-------------------
    // --------------------------------------
    // Test 9 - Verify Cont Destinatar is equal to a matcher REGEX
    @org.testng.annotations.Test
    public void POST9_intrare_auto_cle() {

        payload = "{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n      " +
                "  \"marcaSofer\": \"12345678\",\r\n   " +
                "     \"plata\": 12345,\r\n  " +
                "      \"vin\": \"12345678901234567\"\r\n   " +
                " }\r\n}";

        Response response = with().body(payload).post("/intrare_auto_cle");
        assertThat(response.<String> path("intrareCLE.contDestinatar"), matchesPattern("[a-z]*D{1}[a-z]{9}"));
    }

}
