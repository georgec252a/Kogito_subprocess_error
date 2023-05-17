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

public enum StatusCode {
    CODE_200(200, ""),
    CODE_201(201, ""),
    CODE_400(400, "Missing required field: name"),
    CODE_401(401, "Invalid access token"),
    CODE_403(403, "Not Allowed");

    public final int code;
    public final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /*
     * public int getCode(){
     * return code;
     * }
     * 
     * public String getMsg(){
     * return msg;
     * }
     */
}
