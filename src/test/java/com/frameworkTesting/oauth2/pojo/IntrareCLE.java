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
package com.frameworkTesting.oauth2.pojo;

import java.util.LinkedHashMap;
import java.util.Map;

// intrareCLE.put("marcaSofer", "12345678");
// intrareCLE.put("vin", "12345678901234567");
import com.fasterxml.jackson.annotation.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)

public class IntrareCLE {

    @JsonProperty("marcaSofer")
    private String marcaSofer;
    @JsonProperty("culoare")
    private Object culoare;
    @JsonProperty("stare")
    private Object stare;
    @JsonProperty("tara")
    private Object tara;
    @JsonProperty("taraOK")
    private Boolean taraOK;
    @JsonProperty("zona")
    private String zona;
    @JsonProperty("zonaOK")
    private Boolean zonaOK;
    @JsonProperty("neafectat")
    private Boolean neafectat;
    @JsonProperty("plata")
    private Integer plata;
    @JsonProperty("plataOK")
    private Boolean plataOK;
    @JsonProperty("contDestinatar")
    private String contDestinatar;
    @JsonProperty("contDestinatarOK")
    private Boolean contDestinatarOK;
    @JsonProperty("compoundOcupat")
    private Integer compoundOcupat;
    @JsonProperty("compoundFull")
    private Boolean compoundFull;
    @JsonProperty("stocareCompound")
    private Boolean stocareCompound;
    @JsonProperty("stocareCLE")
    private Boolean stocareCLE;
    @JsonProperty("vinValid")
    private Boolean vinValid;
    @JsonProperty("soferValid")
    private Boolean soferValid;
    @JsonProperty("utilizator")
    private String utilizator;
    @JsonProperty("utilizatorMADC")
    private Boolean utilizatorMADC;
    @JsonProperty("utilizatorKIOSK")
    private Boolean utilizatorKIOSK;
    @JsonProperty("locuriLibere")
    private Integer locuriLibere;
    @JsonProperty("locuriLibereOk")
    private Boolean locuriLibereOk;
    @JsonProperty("amplasament")
    private Object amplasament;
    @JsonProperty("amplasamentOK")
    private Boolean amplasamentOK;
    @JsonProperty("zonaFluxIndirect")
    private Boolean zonaFluxIndirect;
    @JsonProperty("zonaFluxDirect")
    private Boolean zonaFluxDirect;
    @JsonProperty("du")
    private Object du;
    @JsonProperty("duOK")
    private Boolean duOK;
    @JsonProperty("taraDestinatie")
    private Object taraDestinatie;
    @JsonProperty("taraDestinatieOK")
    private Boolean taraDestinatieOK;
    @JsonProperty("modelVehicul")
    private Object modelVehicul;
    @JsonProperty("modelVehiculOK")
    private Boolean modelVehiculOK;
    @JsonProperty("codConditionare")
    private Object codConditionare;
    @JsonProperty("codConditionareOk")
    private Boolean codConditionareOk;
    @JsonProperty("zonaAlocataDU")
    private Object zonaAlocataDU;
    @JsonProperty("zonaAlocataDUOK")
    private Boolean zonaAlocataDUOK;
    @JsonProperty("nrAutoDinDU")
    private Object nrAutoDinDU;
    @JsonProperty("primaAutoDinDU")
    private Boolean primaAutoDinDU;
    @JsonProperty("fisaDuImprimata")
    private Object fisaDuImprimata;
    @JsonProperty("repetaImprimareaOK")
    private Boolean repetaImprimareaOK;
    @JsonProperty("vin")
    private String vin;
    @JsonProperty("vinok")
    private Boolean vinok;
    @JsonProperty("codUzina")
    private String codUzina;
    @JsonProperty("tipZona")
    private String tipZona;
    @JsonProperty("tipFlux")
    private String tipFlux;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("marcaSofer")
    public String getMarcaSofer() {
        return marcaSofer;
    }

    @JsonProperty("marcaSofer")
    public void setMarcaSofer(String marcaSofer) {
        this.marcaSofer = marcaSofer;
    }

    @JsonProperty("culoare")
    public Object getCuloare() {
        return culoare;
    }

    @JsonProperty("culoare")
    public void setCuloare(Object culoare) {
        this.culoare = culoare;
    }

    @JsonProperty("stare")
    public Object getStare() {
        return stare;
    }

    @JsonProperty("stare")
    public void setStare(Object stare) {
        this.stare = stare;
    }

    @JsonProperty("tara")
    public Object getTara() {
        return tara;
    }

    @JsonProperty("tara")
    public void setTara(Object tara) {
        this.tara = tara;
    }

    @JsonProperty("taraOK")
    public Boolean getTaraOK() {
        return taraOK;
    }

    @JsonProperty("taraOK")
    public void setTaraOK(Boolean taraOK) {
        this.taraOK = taraOK;
    }

    @JsonProperty("zona")
    public String getZona() {
        return zona;
    }

    @JsonProperty("zona")
    public void setZona(String zona) {
        this.zona = zona;
    }

    @JsonProperty("zonaOK")
    public Boolean getZonaOK() {
        return zonaOK;
    }

    @JsonProperty("zonaOK")
    public void setZonaOK(Boolean zonaOK) {
        this.zonaOK = zonaOK;
    }

    @JsonProperty("neafectat")
    public Boolean getNeafectat() {
        return neafectat;
    }

    @JsonProperty("neafectat")
    public void setNeafectat(Boolean neafectat) {
        this.neafectat = neafectat;
    }

    @JsonProperty("plata")
    public Integer getPlata() {
        return plata;
    }

    @JsonProperty("plata")
    public void setPlata(Integer plata) {
        this.plata = plata;
    }

    @JsonProperty("plataOK")
    public Boolean getPlataOK() {
        return plataOK;
    }

    @JsonProperty("plataOK")
    public void setPlataOK(Boolean plataOK) {
        this.plataOK = plataOK;
    }

    @JsonProperty("contDestinatar")
    public String getContDestinatar() {
        return contDestinatar;
    }

    @JsonProperty("contDestinatar")
    public void setContDestinatar(String contDestinatar) {
        this.contDestinatar = contDestinatar;
    }

    @JsonProperty("contDestinatarOK")
    public Boolean getContDestinatarOK() {
        return contDestinatarOK;
    }

    @JsonProperty("contDestinatarOK")
    public void setContDestinatarOK(Boolean contDestinatarOK) {
        this.contDestinatarOK = contDestinatarOK;
    }

    @JsonProperty("compoundOcupat")
    public Integer getCompoundOcupat() {
        return compoundOcupat;
    }

    @JsonProperty("compoundOcupat")
    public void setCompoundOcupat(Integer compoundOcupat) {
        this.compoundOcupat = compoundOcupat;
    }

    @JsonProperty("compoundFull")
    public Boolean getCompoundFull() {
        return compoundFull;
    }

    @JsonProperty("compoundFull")
    public void setCompoundFull(Boolean compoundFull) {
        this.compoundFull = compoundFull;
    }

    @JsonProperty("stocareCompound")
    public Boolean getStocareCompound() {
        return stocareCompound;
    }

    @JsonProperty("stocareCompound")
    public void setStocareCompound(Boolean stocareCompound) {
        this.stocareCompound = stocareCompound;
    }

    @JsonProperty("stocareCLE")
    public Boolean getStocareCLE() {
        return stocareCLE;
    }

    @JsonProperty("stocareCLE")
    public void setStocareCLE(Boolean stocareCLE) {
        this.stocareCLE = stocareCLE;
    }

    @JsonProperty("vinValid")
    public Boolean getVinValid() {
        return vinValid;
    }

    @JsonProperty("vinValid")
    public void setVinValid(Boolean vinValid) {
        this.vinValid = vinValid;
    }

    @JsonProperty("soferValid")
    public Boolean getSoferValid() {
        return soferValid;
    }

    @JsonProperty("soferValid")
    public void setSoferValid(Boolean soferValid) {
        this.soferValid = soferValid;
    }

    @JsonProperty("utilizator")
    public String getUtilizator() {
        return utilizator;
    }

    @JsonProperty("utilizator")
    public void setUtilizator(String utilizator) {
        this.utilizator = utilizator;
    }

    @JsonProperty("utilizatorMADC")
    public Boolean getUtilizatorMADC() {
        return utilizatorMADC;
    }

    @JsonProperty("utilizatorMADC")
    public void setUtilizatorMADC(Boolean utilizatorMADC) {
        this.utilizatorMADC = utilizatorMADC;
    }

    @JsonProperty("utilizatorKIOSK")
    public Boolean getUtilizatorKIOSK() {
        return utilizatorKIOSK;
    }

    @JsonProperty("utilizatorKIOSK")
    public void setUtilizatorKIOSK(Boolean utilizatorKIOSK) {
        this.utilizatorKIOSK = utilizatorKIOSK;
    }

    @JsonProperty("locuriLibere")
    public Integer getLocuriLibere() {
        return locuriLibere;
    }

    @JsonProperty("locuriLibere")
    public void setLocuriLibere(Integer locuriLibere) {
        this.locuriLibere = locuriLibere;
    }

    @JsonProperty("locuriLibereOk")
    public Boolean getLocuriLibereOk() {
        return locuriLibereOk;
    }

    @JsonProperty("locuriLibereOk")
    public void setLocuriLibereOk(Boolean locuriLibereOk) {
        this.locuriLibereOk = locuriLibereOk;
    }

    @JsonProperty("amplasament")
    public Object getAmplasament() {
        return amplasament;
    }

    @JsonProperty("amplasament")
    public void setAmplasament(Object amplasament) {
        this.amplasament = amplasament;
    }

    @JsonProperty("amplasamentOK")
    public Boolean getAmplasamentOK() {
        return amplasamentOK;
    }

    @JsonProperty("amplasamentOK")
    public void setAmplasamentOK(Boolean amplasamentOK) {
        this.amplasamentOK = amplasamentOK;
    }

    @JsonProperty("zonaFluxIndirect")
    public Boolean getZonaFluxIndirect() {
        return zonaFluxIndirect;
    }

    @JsonProperty("zonaFluxIndirect")
    public void setZonaFluxIndirect(Boolean zonaFluxIndirect) {
        this.zonaFluxIndirect = zonaFluxIndirect;
    }

    @JsonProperty("zonaFluxDirect")
    public Boolean getZonaFluxDirect() {
        return zonaFluxDirect;
    }

    @JsonProperty("zonaFluxDirect")
    public void setZonaFluxDirect(Boolean zonaFluxDirect) {
        this.zonaFluxDirect = zonaFluxDirect;
    }

    @JsonProperty("du")
    public Object getDu() {
        return du;
    }

    @JsonProperty("du")
    public void setDu(Object du) {
        this.du = du;
    }

    @JsonProperty("duOK")
    public Boolean getDuOK() {
        return duOK;
    }

    @JsonProperty("duOK")
    public void setDuOK(Boolean duOK) {
        this.duOK = duOK;
    }

    @JsonProperty("taraDestinatie")
    public Object getTaraDestinatie() {
        return taraDestinatie;
    }

    @JsonProperty("taraDestinatie")
    public void setTaraDestinatie(Object taraDestinatie) {
        this.taraDestinatie = taraDestinatie;
    }

    @JsonProperty("taraDestinatieOK")
    public Boolean getTaraDestinatieOK() {
        return taraDestinatieOK;
    }

    @JsonProperty("taraDestinatieOK")
    public void setTaraDestinatieOK(Boolean taraDestinatieOK) {
        this.taraDestinatieOK = taraDestinatieOK;
    }

    @JsonProperty("modelVehicul")
    public Object getModelVehicul() {
        return modelVehicul;
    }

    @JsonProperty("modelVehicul")
    public void setModelVehicul(Object modelVehicul) {
        this.modelVehicul = modelVehicul;
    }

    @JsonProperty("modelVehiculOK")
    public Boolean getModelVehiculOK() {
        return modelVehiculOK;
    }

    @JsonProperty("modelVehiculOK")
    public void setModelVehiculOK(Boolean modelVehiculOK) {
        this.modelVehiculOK = modelVehiculOK;
    }

    @JsonProperty("codConditionare")
    public Object getCodConditionare() {
        return codConditionare;
    }

    @JsonProperty("codConditionare")
    public void setCodConditionare(Object codConditionare) {
        this.codConditionare = codConditionare;
    }

    @JsonProperty("codConditionareOk")
    public Boolean getCodConditionareOk() {
        return codConditionareOk;
    }

    @JsonProperty("codConditionareOk")
    public void setCodConditionareOk(Boolean codConditionareOk) {
        this.codConditionareOk = codConditionareOk;
    }

    @JsonProperty("zonaAlocataDU")
    public Object getZonaAlocataDU() {
        return zonaAlocataDU;
    }

    @JsonProperty("zonaAlocataDU")
    public void setZonaAlocataDU(Object zonaAlocataDU) {
        this.zonaAlocataDU = zonaAlocataDU;
    }

    @JsonProperty("zonaAlocataDUOK")
    public Boolean getZonaAlocataDUOK() {
        return zonaAlocataDUOK;
    }

    @JsonProperty("zonaAlocataDUOK")
    public void setZonaAlocataDUOK(Boolean zonaAlocataDUOK) {
        this.zonaAlocataDUOK = zonaAlocataDUOK;
    }

    @JsonProperty("nrAutoDinDU")
    public Object getNrAutoDinDU() {
        return nrAutoDinDU;
    }

    @JsonProperty("nrAutoDinDU")
    public void setNrAutoDinDU(Object nrAutoDinDU) {
        this.nrAutoDinDU = nrAutoDinDU;
    }

    @JsonProperty("primaAutoDinDU")
    public Boolean getPrimaAutoDinDU() {
        return primaAutoDinDU;
    }

    @JsonProperty("primaAutoDinDU")
    public void setPrimaAutoDinDU(Boolean primaAutoDinDU) {
        this.primaAutoDinDU = primaAutoDinDU;
    }

    @JsonProperty("fisaDuImprimata")
    public Object getFisaDuImprimata() {
        return fisaDuImprimata;
    }

    @JsonProperty("fisaDuImprimata")
    public void setFisaDuImprimata(Object fisaDuImprimata) {
        this.fisaDuImprimata = fisaDuImprimata;
    }

    @JsonProperty("repetaImprimareaOK")
    public Boolean getRepetaImprimareaOK() {
        return repetaImprimareaOK;
    }

    @JsonProperty("repetaImprimareaOK")
    public void setRepetaImprimareaOK(Boolean repetaImprimareaOK) {
        this.repetaImprimareaOK = repetaImprimareaOK;
    }

    @JsonProperty("vin")
    public String getVin() {
        return vin;
    }

    @JsonProperty("vin")
    public void setVin(String vin) {
        this.vin = vin;
    }

    @JsonProperty("vinok")
    public Boolean getVinok() {
        return vinok;
    }

    @JsonProperty("vinok")
    public void setVinok(Boolean vinok) {
        this.vinok = vinok;
    }

    @JsonProperty("codUzina")
    public String getCodUzina() {
        return codUzina;
    }

    @JsonProperty("codUzina")
    public void setCodUzina(String codUzina) {
        this.codUzina = codUzina;
    }

    @JsonProperty("tipZona")
    public String getTipZona() {
        return tipZona;
    }

    @JsonProperty("tipZona")
    public void setTipZona(String tipZona) {
        this.tipZona = tipZona;
    }

    @JsonProperty("tipFlux")
    public String getTipFlux() {
        return tipFlux;
    }

    @JsonProperty("tipFlux")
    public void setTipFlux(String tipFlux) {
        this.tipFlux = tipFlux;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
