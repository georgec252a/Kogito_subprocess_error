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
import com.frameworkTesting.oauth2.api.applicationApi.IntrareCleApiFI;
import com.frameworkTesting.oauth2.pojo.IntrareCLE;
import com.frameworkTesting.oauth2.pojo.PayloadFluxIndirect;

import io.qameta.allure.*;
import io.restassured.response.Response;

@Epic("Spotify Oauth 2.0")
@Feature("Playlist API")
public class FluxIndirectTest extends BaseTest {

    @Story("Create a playlist story")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @TmsLink("12345")
    @Issue("1234567")
    @Description("this is the description")

    // Test1 FluxIndirect
    @Test(description = "should be able to create an IntrareCle")
    public void shouldBeAbleToCreateIntrareCLEFluxIndirect() {
        IntrareCLE intrareCle = intrareCleBuilderTest("12345678xx", "12345678901234567xx");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        // assertPayloadEqual(response.as(Payload.class), requestPayload);
    }

    // Test2 FluxIndirect
    @Test(description = "should be able to make a POST IntrareCle Flux Indirect")
    public void postFluxIndirect() {
        IntrareCLE intrareCle = intrareCleBuilderPost("UU1DJF00066759821", "55032402", "alb",
                "0", "Spania", 0, "contDestinatar", 0, "119",
                "10", 11, "MADC", "indirect", "amplasament1",
                "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        // assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqual(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    // Test 3
    @Test(description = "should be able to verify ContDestinatarOK True")
    public void shouldBeAbleToValidateVerificareContDestOK() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821", "contDestinatar", null, 2, "MADC",
                "indirect", "Romania", "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);

    }

    // Test 4
    @Test(description = "should be able to verify ContDestinatarOK False")
    public void shouldBeAbleToValidateVerifContDestNoOK() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821", "nuContDest", null, 2, "MADC",
                "indirect", "Romania", "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualContDestinatarFalse(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualContDestinatarFalse(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getContDestinatar(),
                Matchers.equalTo(requestPayload.getCle().getContDestinatar()));
        MatcherAssert.assertThat(responsePayload.getCle().getContDestinatarOK(), Matchers.equalTo(false));
    }

    // Test 5
    @Test(description = "should be able to verify VerificaTaraInZonaParc")
    public void shouldBeAbleToValidateVerificaTaraInZonaParc() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821", "contDestinatar", null, 2, "MADC",
                "indirect", "Romania", "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTaraInZonaParc(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTaraInZonaParc(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getContDestinatar(),
                Matchers.equalTo(requestPayload.getCle().getContDestinatar()));
        MatcherAssert.assertThat(responsePayload.getCle().getTaraOK(), Matchers.equalTo(true));

    }

    // Test 6
    @Test(description = "should be able to verify VerificaTaraInZonaParc False")
    public void shouldBeAbleToValidateVerificaTaraInZonaParcFalse() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821", "contDestinatar", null, 2, "MADC",
                "indirect", null, "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTaraInZonaParcFalse(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTaraInZonaParcFalse(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getContDestinatar(),
                Matchers.equalTo(requestPayload.getCle().getContDestinatar()));
        MatcherAssert.assertThat(responsePayload.getCle().getTaraOK(), Matchers.equalTo(false));

    }

    // Test 7
    @Test(description = "should be able to verify VerificaZonaLocuriLibereOK")
    public void shouldBeAbleToValidateVerificaZonaLocuriLibereOK() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "indirect", null, "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaLocuriLibereOK(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaLocuriLibereOK(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getLocuriLibere(),
                Matchers.equalTo(requestPayload.getCle().getLocuriLibere()));
        MatcherAssert.assertThat(responsePayload.getCle().getLocuriLibereOk(), Matchers.equalTo(true));
    }

    // Test 8
    // @Test(description = "should be able to verify VerificaZonaLocuriLibereOK
    // False")
    // public void shouldBeAbleToValidateVerificaZonaLocuriLibereOKFalse() {
    // IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
    // "contDestinatar", null, 0, "MADC",
    // "indirect", null, "amplasament");
    // PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
    // Response response = IntrareCleApiFI.post(requestPayload);
    // assertStatusCode(response.statusCode(), StatusCode.CODE_201);
    // assertPayloadEqualVerificaZonaLocuriLibereOKFalse(response.as(PayloadFluxIndirect.class),
    // requestPayload);
    // }

    // private void
    // assertPayloadEqualVerificaZonaLocuriLibereOKFalse(PayloadFluxIndirect
    // responsePayload,
    // PayloadFluxIndirect requestPayload) {
    // MatcherAssert.assertThat(responsePayload.getCle().getLocuriLibere(),
    // Matchers.equalTo(requestPayload.getCle().getLocuriLibere()));
    // MatcherAssert.assertThat(responsePayload.getCle().getLocuriLibereOk(),
    // Matchers.equalTo(false));
    // }

    // Test 9
    @Test(description = "should be able to verify VerificaZonaParcCuFluxIndirectOK")
    public void shouldBeAbleToValidateVerificaZonaParcCuFluxIndirectOK() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "indirect", null, "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaParcCuFluxIndirectOK(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaParcCuFluxIndirectOK(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getTipFlux(),
                Matchers.equalTo(requestPayload.getCle().getTipFlux()));
        MatcherAssert.assertThat(responsePayload.getCle().getZonaFluxIndirect(), Matchers.equalTo(true));
    }

    // Test 10
    @Test(description = "should be able to verify VerificaZonaParcCuFluxIndirectOK False")
    public void shouldBeAbleEqualVerificaZonaParcCuFluxIndirectFalse() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "direct", null, "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaParcCuFluxIndirectFalse(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaParcCuFluxIndirectFalse(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getTipFlux(),
                Matchers.equalTo(requestPayload.getCle().getTipFlux()));
        MatcherAssert.assertThat(responsePayload.getCle().getZonaFluxIndirect(), Matchers.equalTo(false));
    }

    // Test 11
    @Test(description = "should be able to verify VerificaZonaParcCuFluxDirectOK")
    public void shouldBeAbleToValidateVerificaZonaParcCuFluxDirectOK() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "direct", null, "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaParcCuFluxDirectOK(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaParcCuFluxDirectOK(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getTipFlux(),
                Matchers.equalTo(requestPayload.getCle().getTipFlux()));
        MatcherAssert.assertThat(responsePayload.getCle().getZonaFluxDirect(), Matchers.equalTo(true));
    }

    // Test 12
    @Test(description = "should be able to verify VerificaZonaParcCuFluxIndirectOK False")
    public void shouldBeAbleEqualVerificaZonaParcCuFluxDirectFalse() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "indirect", null, "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaZonaParcCuFluxDirectFalse(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaZonaParcCuFluxDirectFalse(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getTipFlux(),
                Matchers.equalTo(requestPayload.getCle().getTipFlux()));
        MatcherAssert.assertThat(responsePayload.getCle().getZonaFluxDirect(), Matchers.equalTo(false));
    }

    // Test 13
    @Test(description = "should be able to verify VerificaTipUtilizatorKIOSK")
    public void shouldBeAbleToValidateVerificaTipUtilizatorKIOSK() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "KIOSK",
                "indirect", null, "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTipUtilizatorKIOSK(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTipUtilizatorKIOSK(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getUtilizator(),
                Matchers.equalTo(requestPayload.getCle().getUtilizator()));
        MatcherAssert.assertThat(responsePayload.getCle().getUtilizatorKIOSK(), Matchers.equalTo(true));
    }

    // Test 14
    @Test(description = "should be able to verify VerificaTipUtilizatorKIOSKFalse")
    public void shouldBeAbleToValidateVerificaTipUtilizatorKIOSKFalse() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "indirect", null, "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTipUtilizatorKIOSKFalse(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTipUtilizatorKIOSKFalse(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getUtilizator(),
                Matchers.equalTo(requestPayload.getCle().getUtilizator()));
        MatcherAssert.assertThat(responsePayload.getCle().getUtilizatorKIOSK(), Matchers.equalTo(false));
    }

    // Test 15
    @Test(description = "should be able to verify VerificaTipUtilizatorMADC")
    public void shouldBeAbleToValidateVerificaTipUtilizatorMADC() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "indirect", null, "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTipUtilizatorMADC(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTipUtilizatorMADC(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getUtilizator(),
                Matchers.equalTo(requestPayload.getCle().getUtilizator()));
        MatcherAssert.assertThat(responsePayload.getCle().getUtilizatorMADC(), Matchers.equalTo(true));
    }

    // Test 16
    @Test(description = "should be able to verify VerificaTipUtilizatorMADCFalse")
    public void shouldBeAbleToValidateVerificaTipUtilizatorMADCFFalse() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "KIOSK",
                "indirect", null, "amplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaTipUtilizatorMADCFalse(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaTipUtilizatorMADCFalse(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getUtilizator(),
                Matchers.equalTo(requestPayload.getCle().getUtilizator()));
        MatcherAssert.assertThat(responsePayload.getCle().getUtilizatorMADC(), Matchers.equalTo(false));
    }

    // Test 17
    @Test(description = "should be able to verify VerificaValidareAmplasament")
    public void shouldBeAbleToValidateVerificaValidareAmplasament() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "indirect", null, "amplasament1", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaValidareAmplasament(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaValidareAmplasament(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getAmplasament(),
                Matchers.equalTo(requestPayload.getCle().getAmplasament()));
        MatcherAssert.assertThat(responsePayload.getCle().getAmplasamentOK(), Matchers.equalTo(true));
    }

    // Test 18
    @Test(description = "should be able to verify VerificaValidareAmplasamentFalse")
    public void shouldBeAbleToValidateVerificaValidareAmplasamentFalse() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "indirect", null, "NONamplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificaValidareAmplasamentFalse(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificaValidareAmplasamentFalse(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getAmplasament(),
                Matchers.equalTo(requestPayload.getCle().getAmplasament()));
        MatcherAssert.assertThat(responsePayload.getCle().getAmplasamentOK(), Matchers.equalTo(false));
    }

    // Test 19
    @Test(description = "should be able to verify VerificareCodConditionareBSD")
    public void shouldBeAbleToValidateVerificareCodConditionareBSD() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "indirect", null, "NONamplasament", "cod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificareCodConditionareBSD(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificareCodConditionareBSD(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getCodConditionare(),
                Matchers.equalTo(requestPayload.getCle().getCodConditionare()));
        MatcherAssert.assertThat(responsePayload.getCle().getCodConditionareOk(), Matchers.equalTo(true));
    }

    // Test 20
    @Test(description = "should be able to verify VerificareCodConditionareBSDFalse")
    public void shouldBeAbleToValidateVerificareCodConditionareBSDFalse() {
        IntrareCLE intrareCle = intrareCleBuilder("55032402", "UU1DJF00066759821",
                "contDestinatar", null, 2, "MADC",
                "indirect", null, "NONamplasament", "NOcod");
        PayloadFluxIndirect requestPayload = payloadBuilderFluxIndirect(intrareCle);
        Response response = IntrareCleApiFI.post(requestPayload);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPayloadEqualVerificareCodConditionareBSDFalse(response.as(PayloadFluxIndirect.class), requestPayload);
    }

    private void assertPayloadEqualVerificareCodConditionareBSDFalse(PayloadFluxIndirect responsePayload,
            PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getCodConditionare(),
                Matchers.equalTo(requestPayload.getCle().getCodConditionare()));
        MatcherAssert.assertThat(responsePayload.getCle().getCodConditionareOk(), Matchers.equalTo(false));
    }

    public IntrareCLE intrareCleBuilderPost(String vin, String marcaSofer, String culoare, String stare, String tara,
            Integer plata, String contDestinatar,
            Integer compoundOcupat, String codUzina, String tipZona, Integer locuriLibere, String utilizator,
            String tipFlux, String amplasament, String codConditionare) {
        return IntrareCLE.builder().vin(vin).marcaSofer(marcaSofer).culoare(culoare).stare(stare).tara(tara)
                .plata(plata).contDestinatar(contDestinatar).compoundOcupat(compoundOcupat).codUzina(codUzina)
                .tipZona(tipZona).locuriLibere(locuriLibere).utilizator(utilizator).tipFlux(tipFlux)
                .amplasament(amplasament).codConditionare(codConditionare).build();
    }

    @Step
    public IntrareCLE intrareCleBuilder(String marcaSofer, String vin, String contDestinatar, Integer plata,
            Integer locuriLibere, String utilizator, String tipFlux, String tara, String amplasament,
            String codConditionare) {
        return IntrareCLE.builder().marcaSofer(marcaSofer).vin(vin).contDestinatar(contDestinatar).plata(plata)
                .locuriLibere(locuriLibere).utilizator(utilizator).tipFlux(tipFlux).tara(tara)
                .amplasament(amplasament).codConditionare(codConditionare).build();
    }

    @Step
    public IntrareCLE intrareCleBuilderTest(String marcaSofer, String vin) {
        return IntrareCLE.builder().marcaSofer(marcaSofer).vin(vin).build();
    }

    @Step
    public PayloadFluxIndirect payloadBuilderFluxIndirect(IntrareCLE intrareCLE) {
        return PayloadFluxIndirect.builder().cle(intrareCLE).build();
    }

    @Step
    public void assertPayloadEqual(PayloadFluxIndirect responsePayload, PayloadFluxIndirect requestPayload) {
        MatcherAssert.assertThat(responsePayload.getCle().getVin(),
                Matchers.equalTo(requestPayload.getCle().getVin()));
        MatcherAssert.assertThat(responsePayload.getCle().getLocuriLibereOk(), Matchers.equalTo(true));
    }

    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        MatcherAssert.assertThat(actualStatusCode, Matchers.equalTo(statusCode.code));
    }

}
