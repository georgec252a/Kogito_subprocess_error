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
package com.frameworkTesting.oauth2.api.applicationApi;

import com.frameworkTesting.oauth2.api.RestResource;
import com.frameworkTesting.oauth2.pojo.IntrareCLE;
import com.frameworkTesting.oauth2.pojo.Payload;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class IntrareCleAPI2 {

    @Step
    public static Response post(Payload requestPayload) {
        // System.out.println(RestResource.post("http://localhost:8086/intrare_auto_cle/",
        // requestPayload));
        return RestResource.post("http://localhost:8086/intrare_auto_cle/", requestPayload);
    }

    public static Response get(String playlistId) {
        return RestResource.get("http://localhost:8086/intrare_auto_cle/");
    }

    public static Response update(String playlistId, IntrareCLE requestIntrareCle) {
        return RestResource.update("http://localhost:8086/intrare_auto_cle", requestIntrareCle);
    }
}
