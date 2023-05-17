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

public class ConfigLoader {
    private final Properties properties;
    private static com.frameworkTesting.oauth2.utils.ConfigLoader configLoader;

    private ConfigLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static com.frameworkTesting.oauth2.utils.ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new com.frameworkTesting.oauth2.utils.ConfigLoader();
        }
        return configLoader;
    }

    public String getClientId() {
        String prop = properties.getProperty("client_id");
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("property client_id is not specified in the config.properties file");
    }

    public String getClientSecret() {
        String prop = properties.getProperty("client_secret");
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("property client_secret is not specified in the config.properties file");
    }

    public String getGrantType() {
        String prop = properties.getProperty("grant_type");
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("property grant_type is not specified in the config.properties file");
    }

    public String getRefreshToken() {
        String prop = properties.getProperty("refresh_token");
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("property refresh_token is not specified in the config.properties file");
    }

    public String getUser() {
        String prop = properties.getProperty("user_id");
        if (prop != null)
            return prop;
        else
            throw new RuntimeException("property user_id is not specified in the config.properties file");
    }

}
