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

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class A1_BDD_GET {

    RequestSpecification requestSpecification;

    ResponseSpecification responseSpecification;

    // -------------TEST1-------------------
    // --------------------------------------
    // Verificare status code 200 pentru GET pe endpoint-ul intrare_auto_cle
    @org.testng.annotations.Test
    public void testGet_intrare_auto_cle() {

        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat()
                .statusCode(200);
    }

    // -------------TEST2-------------------
    // --------------------------------------
    // Extrage din raspuns anumite valori
    @org.testng.annotations.Test
    public void extractSingleResponse_intrare_auto_cle() {
        Response res = given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all()
                .assertThat().statusCode(200).extract().response();

        JsonPath jsonPath = new JsonPath(res.asString());
        System.out.println("response = " + res.path("[0].id"));
        System.out.println("response = " + jsonPath.getString("[1].id"));
        System.out.println("response = " + jsonPath.getString("[1].id"));
        System.out.println();
    }

    // -------------TEST3-------------------
    // --------------------------------------
    // Extrage din raspuns valoarea ID-ului si verifica daca corespunde cu o anumita
    // valoare
    @org.testng.annotations.Test
    public void extractResponseAndAssert_intrare_auto_cle() {
        String res = given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all()
                .assertThat().statusCode(200).extract().response().path("[0].id");

        assertThat(res, equalTo("e5bca575-5ebc-4f36-a31a-5f77a7e4dadb"));
        Assert.assertEquals(res, "e5bca575-5ebc-4f36-a31a-5f77a7e4dadb");
    }

    // -------------TEST4-------------------
    // --------------------------------------
    // test Hamcrest contains() - verifica daca id-ul din raspuns contine o anumita
    // valoare
    @org.testng.annotations.Test
    public void ContainsID_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat()
                .statusCode(200).body("id",
                        contains("e5bca575-5ebc-4f36-a31a-5f77a7e4dadb", "2fe7d5b3-e0a9-48f3-a435-57ca8174b25e"));
    }

    // -------------TEST5-------------------
    // --------------------------------------
    // test Hamcrest empty() - verifica daca in raspuns id-ul este vid
    @org.testng.annotations.Test
    public void Empty_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat()
                .statusCode(200).body("id", empty());
    }

    // -------------TEST6-------------------
    // --------------------------------------
    // test Hamcrest not(emptyArray()) - verifica daca vreun ID este null
    @org.testng.annotations.Test
    public void NotEmpty_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat()
                .statusCode(200).body("id", not(emptyArray()));

    }

    // -------------TEST7-------------------
    // --------------------------------------
    // test Hamcrest hasSize()) - verifica daca dimensiunea ID-ului are dimensiunea
    // 2
    @org.testng.annotations.Test
    public void Size_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat()
                .statusCode(200).body("id", hasSize(2));

    }

    // -------------TEST8-------------------
    // --------------------------------------
    // test Hamcrest hasValue()) - verifica daca exista o anumita valoarea in
    // locatia[0]
    @org.testng.annotations.Test
    public void HasValue_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").when().get("/intrare_auto_cle").then().log().all().assertThat()
                .statusCode(200).body("[0]", hasValue("e5bca575-5ebc-4f36-a31a-5f77a7e4dadb"));
    }

    // -------------TEST9-------------------
    // --------------------------------------
    // Verificare status code 200 pentru GET pe endpoint-ul intrare_auto_cle
    // Trimitere de parametrii in URL
    @org.testng.annotations.Test
    public void TestGet9_intrare_auto_cle() {

        HashMap<String, String> parametrii = new HashMap<String, String>();
        parametrii.put("foo1", "bar1");
        parametrii.put("foo12", "bar12");
        parametrii.put("foo123", "bar123");

        given().baseUri("http://localhost:8086/").
        // param("foo","bar").
        // queryParam("foo","bar").
                queryParams(parametrii).log().all().when().get("/intrare_auto_cle").then().log().all().assertThat()
                .statusCode(200);
    }

    // -------------TEST10-------------------
    // --------------------------------------
    // Verificare status code 200 pentru GET pe endpoint-ul intrare_auto_cle
    // Trimitere de parametrii Path in URL
    @org.testng.annotations.Test
    public void TestGet10_intrare_auto_cle() {
        given().baseUri("http://localhost:8086/").pathParam("id", "1").log().all().when().get("/intrare_auto_cle/{id}")
                .then().log().all().assertThat().statusCode(200);
    }

}
