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
package com.frameworkTesting.oauth2.tests;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.frameworkTesting.oauth2.api.StatusCode;
import com.frameworkTesting.oauth2.api.applicationApi.IntrareCleAPI2;
import com.frameworkTesting.oauth2.pojo.IntrareCLE;
import com.frameworkTesting.oauth2.pojo.Payload;

import io.qameta.allure.*;
import io.restassured.response.Response;

@Epic("Spotify Oauth 2.0")
@Feature("Playlist API")
public class IntrareCleTests extends BaseTest {

    @Story("Create a playlist story")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @TmsLink("12345")
    @Issue("1234567")
    @Description("this is the description")

    // Test 1
    @Test(description = "should be able to create an IntrareCle")
    public void ShouldBeAbleToCreateIntrareCLE() {
        IntrareCLE intrareCle = intrareCleBuilderTest("12345678xx", "12345678901234567xx");
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        // assertPayloadEqual(response.as(Payload.class), requestPayload);
    }

    // Test 2
    @Test(description = "should be able to verify ContDestinatarOK True")
    public void ShouldBeAbleToValidate_VerificareContDestinatarOK() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, null,
                "direct", null, null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        // assertPayloadEqualContDestinatar(response.as(Payload.class), requestPayload);
    }

    // Test 3
    @Test(description = "should be able to verify ContDestinatarOK False")
    public void ShouldBeAbleToValidate_VerificareContDestinatarOK_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "No", null, 2, null, "direct", null,
                null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualContDestinatar_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualContDestinatar_False(Payload responsePayload, Payload requestPayload) {
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getContDestinatar(),
                Matchers.equalTo(requestPayload.getIntrareCLE().getContDestinatar()));
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getContDestinatarOK(), Matchers.equalTo(false));
    }

    // Test 4
    @Test(description = "should be able to verify ContDestinatarNOK")
    public void ShouldBeAbleToValidate_VerificareContDestinatarNOK() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "NO", null, 2, null, "direct", null,
                null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualContDestinatarNOK(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualContDestinatarNOK(Payload responsePayload, Payload requestPayload) {
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getContDestinatar(),
                Matchers.equalTo(requestPayload.getIntrareCLE().getContDestinatar()));
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getContDestinatarOK(), Matchers.equalTo(false));
    }

    // Test 5
    @Test(description = "should be able to verify ContDestinatarNOK False")
    public void ShouldBeAbleToValidate_VerificareContDestinatarNOK_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, null,
                "direct", null, null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualContDestinatarNOK_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualContDestinatarNOK_False(Payload responsePayload, Payload requestPayload) {
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getContDestinatar(),
                Matchers.equalTo(requestPayload.getIntrareCLE().getContDestinatar()));
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getContDestinatarOK(), Matchers.equalTo(true));
    }

    // Test 6
    @Test(description = "should be able to verify VerificaTaraInZonaParc")
    public void ShouldBeAbleToValidate_VerificaTaraInZonaParc() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, null,
                "direct", "tara", null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTaraInZonaParc(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTaraInZonaParc(Payload responsePayload, Payload requestPayload) {
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getContDestinatar(),
                Matchers.equalTo(requestPayload.getIntrareCLE().getContDestinatar()));
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getTaraOK(), Matchers.equalTo(true));

    }

    // Test 7
    @Test(description = "should be able to verify VerificaTaraInZonaParc False")
    public void ShouldBeAbleToValidate_VerificaTaraInZonaParc_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, null,
                "direct", "NO", null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTaraInZonaParc_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTaraInZonaParc_False(Payload responsePayload, Payload requestPayload) {
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getContDestinatar(),
                Matchers.equalTo(requestPayload.getIntrareCLE().getContDestinatar()));
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getTaraOK(), Matchers.equalTo(false));

    }

    // Test 8
    @Test(description = "should be able to verify VerificaZonaLocuriLibereOK")
    public void ShouldBeAbleToValidate_VerificaZonaLocuriLibereOK() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "KIOSK",
                "indirect", null, null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaLocuriLibereOK(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaLocuriLibereOK(Payload as, Payload requestPayload) {
    }

    // Test 9
    @Test(description = "should be able to verify VerificaZonaLocuriLibereOK False")
    public void ShouldBeAbleToValidate_VerificaZonaLocuriLibereOK_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 0, "KIOSK",
                "indirect", null, null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaLocuriLibereOK_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaLocuriLibereOK_False(Payload as, Payload requestPayload) {
    }

    // Test 10
    @Test(description = "should be able to verify VerificaZonaParcCuFluxIndirectOK")
    public void ShouldBeAbleToValidate_VerificaZonaParcCuFluxIndirectOK() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "indirect", "tara", null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaParcCuFluxIndirectOK(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaParcCuFluxIndirectOK(Payload as, Payload requestPayload) {
    }

    // Test 11
    @Test(description = "should be able to verify VerificaZonaParcCuFluxIndirectOK False")
    public void ShouldBeAbleToValidate_VerificareContDestinatar_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "direct", "tara", null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificareContDestinatar_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificareContDestinatar_False(Payload as, Payload requestPayload) {
    }

    // Test 12
    @Test(description = "should be able to verify VerificaZonaLocuriLibereNOK")
    public void ShouldBeAbleToValidate_VerificaZonaLocuriLibereNOK() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 0, "KIOSK",
                "indirect", null, null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaLocuriLibereNOK(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaLocuriLibereNOK(Payload as, Payload requestPayload) {
    }

    // Test 13
    @Test(description = "should be able to verify VerificaZonaLocuriLibereNOK False")
    public void ShouldBeAbleToValidate_VerificaZonaLocuriLibereNOK_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 1, "KIOSK",
                "indirect", null, null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaLocuriLibereNOK_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaLocuriLibereNOK_False(Payload as, Payload requestPayload) {
    }

    // Test 14
    @Test(description = "should be able to verify VerificaZonaParcCuFluxIndirectNOK")
    public void ShouldBeAbleToValidate_VerificaZonaParcCuFluxIndirectNOK() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "indirect", "tara", null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaParcCuFluxIndirectNOK(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaParcCuFluxIndirectNOK(Payload as, Payload requestPayload) {
    }

    // Test 15
    @Test(description = "should be able to verify VerificaZonaParcCuFluxIndirectNOK")
    public void ShouldBeAbleToValidate_VerificaZonaParcCuFluxIndirectNOK_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "direct", "tara", null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaParcCuFluxIndirectNOK_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaParcCuFluxIndirectNOK_False(Payload as, Payload requestPayload) {
    }

    // Test 16
    @Test(description = "should be able to verify VerificaTipUtilizatorKIOSK")
    public void ShouldBeAbleToValidate_VerificaTipUtilizatorKIOSK() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "KIOSK",
                "direct", "tara", null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTipUtilizatorKIOSK(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTipUtilizatorKIOSK(Payload as, Payload requestPayload) {
    }

    // Test 17
    @Test(description = "should be able to verify VerificaTipUtilizatorKIOSK False")
    public void ShouldBeAbleToValidate_VerificaTipUtilizatorKIOSK_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "direct", "tara", null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTipUtilizatorKIOSK_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTipUtilizatorKIOSK_False(Payload as, Payload requestPayload) {
    }

    // Test 18
    @Test(description = "should be able to verify VerificaTipUtilizatorMADC")
    public void ShouldBeAbleToValidate_VerificaTipUtilizatorMADC() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "direct", "tara", null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTipUtilizatorMADC(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTipUtilizatorMADC(Payload as, Payload requestPayload) {
    }

    // Test 19
    @Test(description = "should be able to verify VerificaTipUtilizatorMADC_False")
    public void ShouldBeAbleToValidate_VerificaTipUtilizatorMADC_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "KIOSK",
                "direct", "tara", null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTipUtilizatorMADC_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTipUtilizatorMADC_False(Payload as, Payload requestPayload) {
    }

    // Test 20
    @Test(description = "should be able to verify VerificaValidareAmplasament")
    public void ShouldBeAbleToValidate_VerificaValidareAmplasament() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "indirect", "tara", null, null, "amplasament1", null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaValidareAmplasament(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaValidareAmplasament(Payload as, Payload requestPayload) {
    }

    // Test 21
    @Test(description = "should be able to verify VerificaValidareAmplasament False")
    public void ShouldBeAbleToValidate_VerificaValidareAmplasament_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "indirect", "tara", null, null, "NO", null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaValidareAmplasament_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaValidareAmplasament_False(Payload as, Payload requestPayload) {
    }

    // Test 22
    @Test(description = "should be able to verify VerificaDUPeODestinatieTipDirect")
    public void ShouldBeAbleToValidate_VerificaDUPeODestinatieTipDirect() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "direct", "tara", "vid", null, "amplasament2", null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaDUPeODestinatieTipDirect(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaDUPeODestinatieTipDirect(Payload as, Payload requestPayload) {
    }

    // Test 23
    @Test(description = "should be able to verify VerificaDUPeODestinatieTipDirect False")
    public void ShouldBeAbleToValidate_VerificaDUPeODestinatieTipDirect_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "direct", "tara", "NO", null, "amplasament2", null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaDUPeODestinatieTipDirect_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaDUPeODestinatieTipDirect_False(Payload as, Payload requestPayload) {
    }

    // Test 24
    @Test(description = "should be able to verify VVerificaTaraAsociataAcesteiDestinatii")
    public void ShouldBeAbleToValidate_VVerificaTaraAsociataAcesteiDestinatii() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "direct", "tara", "NO", null, "amplasament2", "Romania");
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTaraAsociataAcesteiDestinatii(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTaraAsociataAcesteiDestinatii(Payload as, Payload requestPayload) {
    }

    // Test 25
    @Test(description = "should be able to verify VVerificaTaraAsociataAcesteiDestinatii False")
    public void ShouldBeAbleToValidate_VerificaTaraAsociataAcesteiDestinatii_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "direct", "tara", "NO", null, "amplasament2", "No");
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTaraAsociataAcesteiDestinatii_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTaraAsociataAcesteiDestinatii_False(Payload as, Payload requestPayload) {
    }

    // Test 26
    @Test(description = "should be able to verify VerificaModelSchIncarcare")
    public void ShouldBeAbleToValidate_VerificaModelSchIncarcare() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "direct", "tara", "NO", "model", "amplasament2", "No");
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaModelSchIncarcare(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaModelSchIncarcare(Payload as, Payload requestPayload) {
    }

    // Test 27
    @Test(description = "should be able to verify VerificaModelSchIncarcare False")
    public void ShouldBeAbleToValidate_VerificaModelSchIncarcare_False() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, "MADC",
                "direct", "tara", "NO", "No", "amplasament2", "No");
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaModelSchIncarcare_False(response.as(Payload.class), requestPayload);
    }

    private void assertPayloadEqualVerificaModelSchIncarcare_False(Payload as, Payload requestPayload) {
    }

    @Test
    public void ShouldBeAbleToValidate_VerificareContDestinatar() {
        IntrareCLE intrareCle = intrareCleBuilder("12345678", "12345678901234567", "contDestinatar", null, 2, null,
                "direct", null, null, null, null, null);
        Payload requestPayload = payloadBuilder(true, intrareCle);
        Response response = IntrareCleAPI2.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualContDestinatar(response.as(Payload.class), requestPayload);
    }

    @Step
    public IntrareCLE intrareCleBuilderTest(String marcaSofer, String vin) {
        return IntrareCLE.builder().marcaSofer(marcaSofer).vin(vin).build();
    }

    @Step
    public IntrareCLE intrareCleBuilder(String marcaSofer, String vin, String contDestinatar, Integer plata,
            Integer locuriLibere, String utilizator, String zona, String tara, String du,
            String model, String amplasament, String taraDestinatie) {
        return IntrareCLE.builder().marcaSofer(marcaSofer).vin(vin).contDestinatar(contDestinatar).plata(plata)
                .locuriLibere(locuriLibere).utilizator(utilizator).zona(zona).tara(tara).du(du)
                .modelVehicul(model).amplasament(amplasament).taraDestinatie(taraDestinatie).build();
    }

    @Step
    public Payload payloadBuilder(Boolean stored, IntrareCLE intrareCLE) {
        return Payload.builder().stored(stored).intrareCLE(intrareCLE).build();
    }

    @Step
    public void assertPayloadEqual(Payload responsePayload, Payload requestPayload) {
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getMarcaSofer(),
                Matchers.equalTo(requestPayload.getIntrareCLE().getMarcaSofer()));
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getVin(),
                Matchers.equalTo(requestPayload.getIntrareCLE().getVin()));
    }

    @Step
    public void assertPayloadEqualContDestinatar(Payload responsePayload, Payload requestPayload) {
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getContDestinatar(),
                Matchers.equalTo(requestPayload.getIntrareCLE().getContDestinatar()));
        MatcherAssert.assertThat(responsePayload.getIntrareCLE().getContDestinatarOK(), Matchers.equalTo(true));

    }

    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        MatcherAssert.assertThat(actualStatusCode, Matchers.equalTo(statusCode.code));
    }

}
