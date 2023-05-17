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
package com.frameworkTesting.oauth2.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.frameworkTesting.oauth2.api.Route.BASE_PATH;

public class SpecBuilder {

    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder().
        // setBaseUri(System.getProperty("BASE_URI")).
                setBaseUri("https://api.spotify.com").setBasePath(BASE_PATH).setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured()).log(LogDetail.ALL).build();
    }

    public static RequestSpecification getAccountRequestSpec() {
        return new RequestSpecBuilder().
        // setBaseUri(System.getProperty("ACCOUNT_BASE_URI")).
                setBaseUri("https://accounts.spotify.com").setContentType(ContentType.URLENC)
                .addFilter(new AllureRestAssured()).log(LogDetail.ALL).build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }

    public static RequestSpecification getRequestSpec2() {
        return new RequestSpecBuilder().
        // setBaseUri(System.getProperty("BASE_URI")).
                setBaseUri("").setBasePath("http://localhost:8086/intrare_auto_cle/").setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured()).log(LogDetail.ALL).build();
    }

    public static RequestSpecification getAccountRequestSpec2() {
        return new RequestSpecBuilder().
        // setBaseUri(System.getProperty("ACCOUNT_BASE_URI")).
                setBaseUri("http://localhost:8086/").setContentType(ContentType.URLENC)
                .addFilter(new AllureRestAssured()).log(LogDetail.ALL).build();
    }

    public static ResponseSpecification getResponseSpec2() {
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }
}
