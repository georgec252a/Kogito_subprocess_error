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
package com.frameworkTesting.oauth2.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

    public static String generateName() {
        Faker faker = new Faker();
        return "Playlist " + faker.regexify("[A-Za-z0-9 ,_-]{10}");
    }

    public static String generateDescription() {
        Faker faker = new Faker();
        return "Description " + faker.regexify("[ A-Za-z0-9_@./#&+-]{50}");
    }
}
