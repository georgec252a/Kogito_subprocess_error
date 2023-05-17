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
package com.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class MainObject {

    private int i;

    private String id;
    private boolean stored;
    private IntrareCLE intrareCLE;

    public MainObject() {
    }

    public MainObject(boolean stored, IntrareCLE intrareCLE) {
        this.stored = stored;
        this.intrareCLE = intrareCLE;
    }

    public boolean isStored() {
        return stored;
    }

    public void setStored(boolean stored) {
        this.stored = stored;
    }

    public IntrareCLE getIntrareCLE() {
        return intrareCLE;
    }

    public void setIntrareCLE(IntrareCLE intrareCLE) {
        this.intrareCLE = intrareCLE;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "MainObject{" +
                "id='" + id + '\'' +
                ", stored=" + stored +
                ", intrareCLE=" + intrareCLE.toString() +
                '}';
    }
}
