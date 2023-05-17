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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ResponseAndRequestSpecifications {

    ResponseSpecification customResponseSpecification;

    @BeforeClass
    public void beforeClass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder()
                .setBaseUri("https://e990d5c2-35de-4cf8-ad61-c06f262e6ca3.mock.pstmn.io")
                .addHeader("x-mock-match-request-body", "true")
                .setContentType("application/json;charset=utf-8").log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType("application/json;charset=utf-8").log(LogDetail.ALL);
        customResponseSpecification = responseSpecBuilder.build();
    }

    @org.testng.annotations.Test
    public void validate_post_request_payload_complex_json() {

        List<Integer> idArrayList = new ArrayList<Integer>();
        idArrayList.add(5);
        idArrayList.add(9);

        HashMap<String, Object> batterHashMap2 = new HashMap<String, Object>();
        batterHashMap2.put("id", idArrayList);
        batterHashMap2.put("type", "Chocolate");

        HashMap<String, Object> batterHashMap1 = new HashMap<String, Object>();
        batterHashMap1.put("id", "1001");
        batterHashMap1.put("type", "Regular");

        List<HashMap<String, Object>> batterArrayList = new ArrayList<HashMap<String, Object>>();
        batterArrayList.add(batterHashMap1);
        batterArrayList.add(batterHashMap2);

        HashMap<String, List<HashMap<String, Object>>> battersHashMap = new HashMap<String, List<HashMap<String, Object>>>();
        battersHashMap.put("batter", batterArrayList);

        List<String> typeArrayList = new ArrayList<String>();
        typeArrayList.add("test1");
        typeArrayList.add("test2");

        HashMap<String, Object> toppingHashMap2 = new HashMap<String, Object>();
        toppingHashMap2.put("id", "5002");
        toppingHashMap2.put("type", typeArrayList);

        HashMap<String, Object> toppingHasMap1 = new HashMap<String, Object>();
        toppingHasMap1.put("id", "5001");
        toppingHasMap1.put("type", "None");

        List<HashMap<String, Object>> toppingArrayList = new ArrayList<HashMap<String, Object>>();
        toppingArrayList.add(toppingHashMap2);
        toppingArrayList.add(toppingHasMap1);

        HashMap<String, Object> mainHashMap = new HashMap<String, Object>();
        mainHashMap.put("id", "0001");
        mainHashMap.put("type", "donut");
        mainHashMap.put("name", "Cake");
        mainHashMap.put("ppu", "0.55");
        mainHashMap.put("batters", battersHashMap);
        mainHashMap.put("topping", toppingArrayList);

        given().body(mainHashMap).when().post("/postComplex").then().spec(customResponseSpecification).assertThat()
                .body("msg", equalTo("success"));
    }

}
