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

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.matchesPattern;

public class JacksonAPI_JSONObject {

    private static ResponseSpecification responseSpecification;
    ResponseSpecification customResponseSpecification;

    @BeforeClass
    public void beforeClass() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder().setBaseUri("https://postman-echo.com/")
                .setContentType("application/json;charset=utf-8").log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType("application/json;charset=utf-8").log(LogDetail.ALL);
        customResponseSpecification = responseSpecBuilder.build();
    }

    @Test
    public void validate_post_request_payload_as_map() throws JsonProcessingException {

        HashMap<String, Object> mainObject = new HashMap<String, Object>();

        HashMap<String, Object> nestedObject = new HashMap<String, Object>();
        nestedObject.put("name", "myThirdWorkSpace");
        nestedObject.put("type", "personal");
        nestedObject.put("description", "Rest Assured Created this");

        mainObject.put("workspace", nestedObject);

        ObjectMapper objectMapper = new ObjectMapper();
        String mainObjectStr = objectMapper.writeValueAsString(mainObject);

        given().body(mainObjectStr).contentType("application/json;charset=utf-8").when().post("/workspaces")
                .then()
                .spec(customResponseSpecification).assertThat().body("workspace.name",
                        equalTo("myThirdWorkspace"), "workspace.id",
                        matchesPattern("^[a-z0-9-]{36}$"));

    }
}
