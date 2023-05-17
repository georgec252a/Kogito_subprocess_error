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

import java.util.HashMap;

import io.restassured.response.Response;

import static com.frameworkTesting.oauth2.api.Route.API;
import static com.frameworkTesting.oauth2.api.Route.TOKEN;
import static com.frameworkTesting.oauth2.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

public class RestResource {

    public static Response post(String path, String token, Object requestPlaylist) {
        return given(getRequestSpec()).body(requestPlaylist).auth().oauth2(token).when().post(path).then()
                .spec(getResponseSpec()).extract().response();
    }

    public static Response post(String path, Object requestIntrareCle) {
        return given(getRequestSpec2()).body(requestIntrareCle).when().post(path).then().spec(getResponseSpec2())
                .extract().response();
    }

    public static Response postAccount(HashMap<String, String> formParams) {
        return given(getAccountRequestSpec()).formParams(formParams).when().post(API + TOKEN).then()
                .spec(getResponseSpec()).extract().response();
    }

    public static Response get(String path, String token) {
        return given(getRequestSpec()).auth().oauth2(token).when().get(path).then().spec(getResponseSpec()).extract()
                .response();
    }

    public static Response get(String path) {
        return given(getRequestSpec()).when().get(path).then().spec(getResponseSpec()).extract().response();
    }

    public static Response update(String path, String token, Object requestPlaylist) {
        return given(getRequestSpec()).auth().oauth2(token).body(requestPlaylist).when().put(path).then()
                .spec(getResponseSpec()).extract().response();
    }

    public static Response update(String path, Object requestPlaylist) {
        return given(getRequestSpec()).body(requestPlaylist).when().put(path).then().spec(getResponseSpec()).extract()
                .response();
    }
}
