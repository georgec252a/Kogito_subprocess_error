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

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.IntrareCLE;
import com.pojo.MainObject;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class A3_BDD_POST {

    RequestSpecification requestSpecification;

    ResponseSpecification responseSpecification;
    String payload;

    @BeforeClass
    public void beforeClass() {
        //I. Version without Builder
        //**********************************************************************
        //Using NonBDD RequestSpecification
        //        requestSpecification=given().baseUri("http://localhost:8086/").
        //                header("Content-Type", "json").
        //                log().all();
        //        RestAssured.requestSpecification=requestSpecification;

        //Using NonBDD ResponseSpecification
        //        responseSpecification= RestAssured.expect().
        //                statusCode(200).
        //                contentType(ContentType.JSON).
        //                log().all();
        //        RestAssured.responseSpecification=responseSpecification;
        //**********************************************************************

        //II. Version with Builder
        //**********************************************************************
        //Using the builder - RequestSpecBuilder

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("http://localhost:8086/");
        requestSpecBuilder.addHeader("Content-Type", "json");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        RestAssured.requestSpecification = requestSpecBuilder.build();

        //Using the builder - ResponseSpecBuilder
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(201);
        responseSpecBuilder.expectContentType(ContentType.JSON);
        RestAssured.responseSpecification = responseSpecBuilder.build();

        //**********************************************************************

    }

    //-------------TEST1-------------------
    //--------------------------------------
    //Verificare status code 201 pentru POST pe endpoint-ul intrare_auto_cle
    @org.testng.annotations.Test
    public void POST1_intrare_auto_cle() {
        payload = "{\n" +
                "    \"stored\": true,\n" +
                "    \"intrareCLE\": {\n" +
                "        \"marcaSofer\": \"12345678\",\n" +
                "        \"plata\": 12345,\n" +
                "        \"vin\": \"12345678901234567\"\n" +
                "    }\n" +
                "}";

        given().body(payload).when().post("/intrare_auto_cle").then().log().all();
    }

    //-------------TEST2-------------------
    //--------------------------------------
    //Test 2 - Verify if vinok=true and soferValid=true
    @org.testng.annotations.Test
    public void POST2_intrare_auto_cle() {

        payload = "{\n" +
                "    \"stored\": true,\n" +
                "    \"intrareCLE\": {\n" +
                "        \"marcaSofer\": \"12345678\",\n" +
                "        \"plata\": 12345,\n" +
                "        \"vin\": \"12345678901234567\"\n" +
                "    }\n" +
                "}";

        given().body(payload).log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().body("intrareCLE.vinok", equalToObject(true)).body("intrareCLE.soferValid",
                equalToObject(true));
    }

    //-------------TEST3-------------------
    //--------------------------------------
    //Test 3 - Verify Service task
    @org.testng.annotations.Test
    public void POST3_intrare_auto_cle() {

        payload = "{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}";

        given().body(payload).log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().body("intrareCLE.marcaSofer", equalToObject("12345678"))
                .body("intrareCLE.vin", equalToObject("12345678901234567")).body("intrareCLE.culoare", equalToObject("alb")).body("intrareCLE.tara", equalToObject("Romania"))
                .body("intrareCLE.stare", equalToObject("0")).body("intrareCLE.contDestinatar", equalToObject("contDestinatar"));
    }

    //-------------TEST4-------------------
    //--------------------------------------
    //Test 4 - Verify VIN OK
    @org.testng.annotations.Test
    public void POST4_intrare_auto_cle() {

        payload = "{\n" +
                "  \"stored\": true,\n" +
                "  \"intrareCLE\": {\n" +
                "    \"marcaSofer\": \"12345678\",\n" +
                "  \n" +
                "    \"vin\": \"12345678901234567\"\n" +
                "  }\n" +
                "}";

        given().body(payload).log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().body("intrareCLE.vinok", equalToObject(true));
    }

    //-------------TEST5-------------------
    //--------------------------------------
    //Test 5 - Verify Plata OK
    @org.testng.annotations.Test
    public void POST5_intrare_auto_cle() {

        payload = "{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n      " +
                "  \"marcaSofer\": \"12345678\",\r\n   " +
                "     \"plata\": 12345,\r\n  " +
                "      \"vin\": \"12345678901234567\"\r\n   " +
                " }\r\n}";

        given().body(payload).log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().body("intrareCLE.plataOK", equalToObject(true));
    }

    //-------------TEST7-------------------
    //--------------------------------------
    //Test 7 - Verify Cont Destinatar
    @org.testng.annotations.Test
    public void POST7_intrare_auto_cle() {

        payload = "{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n      " +
                "  \"marcaSofer\": \"12345678\",\r\n   " +
                "     \"plata\": 12345,\r\n  " +
                "      \"vin\": \"12345678901234567\"\r\n   " +
                " }\r\n}";

        given().body(payload).log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().body("intrareCLE.contDestinatar", equalToObject("contDestinatar"));
    }

    //-------------TEST8-------------------
    //--------------------------------------
    //Test 8 - Verify CompoundFull
    @org.testng.annotations.Test
    public void POST8_intrare_auto_cle() {

        payload = "{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n     " +
                "   \"marcaSofer\": \"12345678\",\r\n    " +
                "    \"plata\": 12345,\r\n    " +
                "    \"vin\": \"12345678901234567\",\r\n     " +
                "   \"compoundOcupat\":0\r\n " +
                "   }\r\n}";

        given().body(payload).log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().body("intrareCLE.compoundFull", equalToObject(true));
    }

    //-------------TEST9-------------------
    //--------------------------------------
    //Test 9 - Verify Cont Destinatar is equal to a matcher REGEX
    @org.testng.annotations.Test
    public void POST9_intrare_auto_cle() {

        payload = "{\r\n  " +
                "  \"stored\": true,\r\n  " +
                "  \"intrareCLE\": {\r\n      " +
                "  \"marcaSofer\": \"12345678\",\r\n   " +
                "     \"plata\": 12345,\r\n  " +
                "      \"vin\": \"12345678901234567\"\r\n   " +
                " }\r\n}";

        given().body(payload).log().all().when().post("/intrare_auto_cle").then().log().all().assertThat().body("intrareCLE.contDestinatar", matchesPattern("[a-z]*D{1}[a-z]{9}"));
    }

    //-------------TEST10-------------------
    //--------------------------------------
    //Verificare status code 201 pentru POST pe endpoint-ul intrare_auto_cle
    //Obiectul JSON este luat din fisier
    @org.testng.annotations.Test
    public void POST10_intrare_auto_cle() {

        File file = new File("src/test/resources/Create_Intrare_CLE_Payload.json");
        given().body(file).when().post("/intrare_auto_cle").then().log().all();
    }

    //-------------TEST11-------------------
    //--------------------------------------
    //Verificare status code 201 pentru POST pe endpoint-ul intrare_auto_cle
    //Datele in format JSON sunt reprezentate sub forma de Java JSON Object ca MAP/ARRAY/LIST
    @org.testng.annotations.Test
    public void POST11_intrare_auto_cle() throws JsonProcessingException {

        HashMap<String, Object> mainObject = new HashMap<String, Object>();

        HashMap<String, String> intrareCLE = new HashMap<String, String>();
        intrareCLE.put("marcaSofer", "12345678");
        intrareCLE.put("vin", "12345678901234567");

        mainObject.put("stored", "true");
        mainObject.put("intrareCLE", intrareCLE);

        ObjectMapper objectMapper = new ObjectMapper();
        String mainObjectStr = objectMapper.writeValueAsString(mainObject);

        given().body(mainObjectStr).when().post("/intrare_auto_cle").then().log().all();
    }

    //-------------TEST12-------------------
    //--------------------------------------
    //Verificare status code 201 pentru POST pe endpoint-ul intrare_auto_cle
    //Datele in format JSON sunt reprezentate sub forma de Java JSON Object ca Obiect POJO
    @org.testng.annotations.Test
    public void POST12_intrare_auto_cle() throws JsonProcessingException {

        IntrareCLE intrareCLE1 = new IntrareCLE("1", "12345678901234567");
        MainObject mainObject1 = new MainObject(true, intrareCLE1);

        ObjectMapper objectMapper = new ObjectMapper();
        String mainObjectStr = objectMapper.writeValueAsString(mainObject1);

        given().body(mainObjectStr).when().post("/intrare_auto_cle").then().log().all();
    }

    //-------------TEST13-------------------
    //--------------------------------------
    //Verificare status code 201 pentru POST pe endpoint-ul intrare_auto_cle
    //Datele in format JSON sunt reprezentate sub forma de Java JSON Object ca Obiect POJO
    // Verifica campurile Vin si MarcaSofer
    @org.testng.annotations.Test
    public void POST13_intrare_auto_cle() throws JsonProcessingException {

        IntrareCLE intrareCLE1 = new IntrareCLE("12345678", "12345678901234567");
        MainObject mainObject1 = new MainObject(true, intrareCLE1);

        //        ObjectMapper objectMapper = new ObjectMapper();
        //        String mainObjectStr = objectMapper.writeValueAsString(mainObject1);

        MainObject deserielizedMainObject = given().body(mainObject1).when().post("/intrare_auto_cle").then().extract().response().as(MainObject.class);

        System.out.println(deserielizedMainObject.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        String deserializedMainObjectStr = objectMapper.writeValueAsString(deserielizedMainObject.getIntrareCLE().getMarcaSofer() + " " + deserielizedMainObject.getIntrareCLE().getVin());
        String mainObjectStr = objectMapper.writeValueAsString(mainObject1.getIntrareCLE().getMarcaSofer() + " " + mainObject1.getIntrareCLE().getVin());
        assertThat(objectMapper.readTree(deserializedMainObjectStr), equalTo(objectMapper.readTree(mainObjectStr)));
    }

    //-------------TEST14-------------------
    //--------------------------------------
    //Verificare status code 201 pentru POST pe endpoint-ul intrare_auto_cle
    //Datele in format JSON sunt reprezentate sub forma de Java JSON Object ca Obiect POJO
    // Verifica campurile Vin si MarcaSofer
    // Se foloseste dataProvider pentru a asigura mai multe valori de test

    @org.testng.annotations.Test(dataProvider = "IntrareCLE")
    public void POST14_intrare_auto_cle(String marcaSofer, String vin) throws JsonProcessingException {

        IntrareCLE intrareCLE1 = new IntrareCLE(marcaSofer, vin);
        MainObject mainObject1 = new MainObject(true, intrareCLE1);

        //        ObjectMapper objectMapper = new ObjectMapper();
        //        String mainObjectStr = objectMapper.writeValueAsString(mainObject1);

        MainObject deserielizedMainObject = given().body(mainObject1).when().post("/intrare_auto_cle").then().extract().response().as(MainObject.class);

        System.out.println(deserielizedMainObject.toString());

        ObjectMapper objectMapper = new ObjectMapper();
        String deserializedMainObjectStr = objectMapper.writeValueAsString(deserielizedMainObject.getIntrareCLE().getMarcaSofer() + " " + deserielizedMainObject.getIntrareCLE().getVin());
        String mainObjectStr = objectMapper.writeValueAsString(mainObject1.getIntrareCLE().getMarcaSofer() + " " + mainObject1.getIntrareCLE().getVin());
        assertThat(objectMapper.readTree(deserializedMainObjectStr), equalTo(objectMapper.readTree(mainObjectStr)));
    }

    @DataProvider(name = "IntrareCLE")
    public Object[][] getIntrareCLE() {
        return new Object[][] {
                { "12345678", "12345678901234567" },
                { "12345678", "123456789012345" },
                { "123456", "12345678901234567" }
        };
    }
}
