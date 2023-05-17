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

import java.util.Properties;

public class DataLoader {
    private final Properties properties;
    private static com.frameworkTesting.oauth2.utils.DataLoader dataLoader;

    private DataLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    public static com.frameworkTesting.oauth2.utils.DataLoader getInstance() {
        if (dataLoader == null) {
            dataLoader = new com.frameworkTesting.oauth2.utils.DataLoader();
        }
        return dataLoader;
    }

    public String getGetPlaylistId() {
        String prop = properties.getProperty("get_playlist_id");
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("property get_playlist_id is not specified in the data.properties file");
    }

    public String getUpdatePlaylistId() {
        String prop = properties.getProperty("update_playlist_id");
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("property update_playlist_id is not specified in the data.properties file");
    }
}
