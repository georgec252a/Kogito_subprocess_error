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
package org.acme.intrareCle;

import java.io.Serializable;

public class IntrareCLE implements Serializable {

    private String VIN;
    private boolean VINok;

    private String vin;
    private boolean vinok;

    private String marcaSofer;

    private String culoare;

    private String stare;

    private String tara;
    private boolean taraOK;

    private String zona;
    private boolean zonaOK;

    private boolean neafectat;

    private int plata;
    private boolean plataOK;

    private String contDestinatar;
    private boolean contDestinatarOK;

    // stocare ca serviciu - info tb obtinuta
    private int compoundOcupat;
    private boolean compoundFull;

    private boolean stocareCompound;
    private boolean stocareCLE;

    private boolean vinValid;
    private boolean soferValid;

    private String utilizator;

    private boolean utilizatorMADC;
    private boolean utilizatorKIOSK;

    private int locuriLibere;
    private boolean locuriLibereOk;

    private String amplasament;
    private boolean amplasamentOK;

    private String tipFlux;
    private boolean zonaFluxIndirect;
    private boolean zonaFluxDirect;

    private String du;
    private boolean duOK;

    private String taraDestinatie;
    private boolean taraDestinatieOK;

    private String modelVehicul;
    private boolean modelVehiculOK;

    private String codConditionare;
    private boolean codConditionareOk;

    private String zonaAlocataDU;
    private boolean zonaAlocataDUOK;

    private String nrAutoDinDU;
    private boolean primaAutoDinDU;

    private String fisaDuImprimata;
    private boolean repetaImprimareaOK;

    private String codUzina;
    private boolean uzinaLocala;

    private String tipZona;
    private boolean zonaImport;
    private int nrLocuriLibere;

    public IntrareCLE() {

    }

    public IntrareCLE(String vIN, boolean vINok, String marcaSofer, String culoare, String stare, String tara,
            boolean taraOK, String zona, boolean zonaOK, boolean neafectat, int plata, boolean plataOK,
            String contDestinatar, boolean contDestinatarOK, int compoundOcupat, boolean compoundFull,
            boolean stocareCompound, boolean stocareCLE, boolean vinValid, boolean soferValid, String utilizator,
            boolean utilizatorMADC, boolean utilizatorKIOSK, int locuriLibere, boolean locuriLibereOk,
            String amplasament, boolean amplasamentOK, boolean zonaFluxIndirect, boolean zonaFluxDirect, String du,
            boolean duOK, String taraDestinatie, boolean taraDestinatieOK, String modelVehicul, boolean modelVehiculOK,
            String codConditionare, boolean codConditionareOk, String zonaAlocataDU, boolean zonaAlocataDUOK,
            String nrAutoDinDU, boolean primaAutoDinDU, String fisaDuImprimata, boolean repetaImprimareaOK,
            String codUzina, boolean uzinaLocala, String tipZona, boolean zonaImport, int nrLocuriLibere,
            String tipFlux, String vin, boolean vinok) {
        VIN = vIN;
        VINok = vINok;
        this.vin = vin;
        this.vinok = vinok;
        this.marcaSofer = marcaSofer;
        this.culoare = culoare;
        this.stare = stare;
        this.tara = tara;
        this.taraOK = taraOK;
        this.zona = zona;
        this.zonaOK = zonaOK;
        this.neafectat = neafectat;
        this.plata = plata;
        this.plataOK = plataOK;
        this.contDestinatar = contDestinatar;
        this.contDestinatarOK = contDestinatarOK;
        this.compoundOcupat = compoundOcupat;
        this.compoundFull = compoundFull;
        this.stocareCompound = stocareCompound;
        this.stocareCLE = stocareCLE;
        this.vinValid = vinValid;
        this.soferValid = soferValid;
        this.utilizator = utilizator;
        this.utilizatorMADC = utilizatorMADC;
        this.utilizatorKIOSK = utilizatorKIOSK;
        this.locuriLibere = locuriLibere;
        this.locuriLibereOk = locuriLibereOk;
        this.amplasament = amplasament;
        this.amplasamentOK = amplasamentOK;
        this.zonaFluxIndirect = zonaFluxIndirect;
        this.zonaFluxDirect = zonaFluxDirect;
        this.du = du;
        this.duOK = duOK;
        this.taraDestinatie = taraDestinatie;
        this.taraDestinatieOK = taraDestinatieOK;
        this.modelVehicul = modelVehicul;
        this.modelVehiculOK = modelVehiculOK;
        this.codConditionare = codConditionare;
        this.codConditionareOk = codConditionareOk;
        this.zonaAlocataDU = zonaAlocataDU;
        this.zonaAlocataDUOK = zonaAlocataDUOK;
        this.nrAutoDinDU = nrAutoDinDU;
        this.primaAutoDinDU = primaAutoDinDU;
        this.fisaDuImprimata = fisaDuImprimata;
        this.repetaImprimareaOK = repetaImprimareaOK;
        this.codUzina = codUzina;
        this.uzinaLocala = uzinaLocala;
        this.tipZona = tipZona;
        this.zonaImport = zonaImport;
        this.nrLocuriLibere = nrLocuriLibere;
        this.tipFlux = tipFlux;
    }

    public String getZonaAlocataDU() {
        return zonaAlocataDU;
    }

    public void setZonaAlocataDU(String zonaAlocataDU) {
        this.zonaAlocataDU = zonaAlocataDU;
    }

    public boolean isZonaAlocataDUOK() {
        return zonaAlocataDUOK;
    }

    public void setZonaAlocataDUOK(boolean zonaAlocataDUOK) {
        this.zonaAlocataDUOK = zonaAlocataDUOK;
    }

    public String getNrAutoDinDU() {
        return nrAutoDinDU;
    }

    public void setNrAutoDinDU(String nrAutoDinDU) {
        this.nrAutoDinDU = nrAutoDinDU;
    }

    public boolean isPrimaAutoDinDU() {
        return primaAutoDinDU;
    }

    public void setPrimaAutoDinDU(boolean primaAutoDinDU) {
        this.primaAutoDinDU = primaAutoDinDU;
    }

    public String getFisaDuImprimata() {
        return fisaDuImprimata;
    }

    public void setFisaDuImprimata(String fisaDuImprimata) {
        this.fisaDuImprimata = fisaDuImprimata;
    }

    public boolean isRepetaImprimareaOK() {
        return repetaImprimareaOK;
    }

    public void setRepetaImprimareaOK(boolean repetaImprimareaOK) {
        this.repetaImprimareaOK = repetaImprimareaOK;
    }

    public String getCodConditionare() {
        return codConditionare;
    }

    public void setCodConditionare(String codConditionare) {
        this.codConditionare = codConditionare;
    }

    public boolean isCodConditionareOk() {
        return codConditionareOk;
    }

    public void setCodConditionareOk(boolean codConditionareOk) {
        this.codConditionareOk = codConditionareOk;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        vin = vin;
    }

    public boolean isNeafectat() {
        return neafectat;
    }

    public void setNeafectat(boolean neafectat) {
        this.neafectat = neafectat;
    }

    public boolean isPlataOK() {
        return plataOK;
    }

    public void setPlataOK(boolean plataOK) {
        this.plataOK = plataOK;
    }

    public String getContDestinatar() {
        return contDestinatar;
    }

    public void setContDestinatar(String contDestinatar) {
        this.contDestinatar = contDestinatar;
    }

    public boolean isCompoundFull() {
        return compoundFull;
    }

    public void setCompoundFull(boolean compoundFull) {
        this.compoundFull = compoundFull;
    }

    public boolean isStocareCompound() {
        return stocareCompound;
    }

    public void setStocareCompound(boolean stocareCompound) {
        this.stocareCompound = stocareCompound;
    }

    public boolean isStocareCLE() {
        return stocareCLE;
    }

    public void setStocareCLE(boolean stocareCLE) {
        this.stocareCLE = stocareCLE;
    }

    public boolean isVinok() {
        return vinok;
    }

    public void setVinok(boolean vinok) {
        vinok = vinok;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    public boolean isContDestinatarOK() {
        return contDestinatarOK;
    }

    public void setContDestinatarOK(boolean contDestinatarOK) {
        this.contDestinatarOK = contDestinatarOK;
    }

    public int getCompoundOcupat() {
        return compoundOcupat;
    }

    public void setCompoundOcupat(int compoundOcupat) {
        this.compoundOcupat = compoundOcupat;
    }

    public boolean isVinValid() {
        return vinValid;
    }

    public void setVinValid(boolean vinValid) {
        this.vinValid = vinValid;
    }

    public boolean isSoferValid() {
        return soferValid;
    }

    public void setSoferValid(boolean soferValid) {
        this.soferValid = soferValid;
    }

    public String getMarcaSofer() {
        return marcaSofer;
    }

    public void setMarcaSofer(String marcaSofer) {
        this.marcaSofer = marcaSofer;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getStare() {
        return stare;
    }

    public void setStare(String stare) {
        this.stare = stare;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public boolean isZonaOK() {
        return zonaOK;
    }

    public void setZonaOK(boolean zonaOK) {
        this.zonaOK = zonaOK;
    }

    public boolean isTaraOK() {
        return taraOK;
    }

    public void setTaraOK(boolean taraOK) {
        this.taraOK = taraOK;
    }

    public String getUtilizator() {
        return utilizator;
    }

    public void setUtilizator(String utilizator) {
        this.utilizator = utilizator;
    }

    public boolean isUtilizatorMADC() {
        return utilizatorMADC;
    }

    public void setUtilizatorMADC(boolean utilizatorMADC) {
        this.utilizatorMADC = utilizatorMADC;
    }

    public boolean isUtilizatorKIOSK() {
        return utilizatorKIOSK;
    }

    public void setUtilizatorKIOSK(boolean utilizatorKIOSK) {
        this.utilizatorKIOSK = utilizatorKIOSK;
    }

    public int getLocuriLibere() {
        return locuriLibere;
    }

    public void setLocuriLibere(int locuriLibere) {
        this.locuriLibere = locuriLibere;
    }

    public boolean isLocuriLibereOk() {
        return locuriLibereOk;
    }

    public void setLocuriLibereOk(boolean locuriLibereOk) {
        this.locuriLibereOk = locuriLibereOk;
    }

    public String getAmplasament() {
        return amplasament;
    }

    public void setAmplasament(String amplasament) {
        this.amplasament = amplasament;
    }

    public boolean isAmplasamentOK() {
        return amplasamentOK;
    }

    public void setAmplasamentOK(boolean amplasamentOK) {
        this.amplasamentOK = amplasamentOK;
    }

    public boolean isZonaFluxIndirect() {
        return zonaFluxIndirect;
    }

    public void setZonaFluxIndirect(boolean zonaFluxIndirect) {
        this.zonaFluxIndirect = zonaFluxIndirect;
    }

    public boolean isZonaFluxDirect() {
        return zonaFluxDirect;
    }

    public void setZonaFluxDirect(boolean zonaFluxDirect) {
        this.zonaFluxDirect = zonaFluxDirect;
    }

    public String getDu() {
        return du;
    }

    public void setDu(String du) {
        this.du = du;
    }

    public boolean isDuOK() {
        return duOK;
    }

    public void setDuOK(boolean duOK) {
        this.duOK = duOK;
    }

    public String getTaraDestinatie() {
        return taraDestinatie;
    }

    public void setTaraDestinatie(String taraDestinatie) {
        this.taraDestinatie = taraDestinatie;
    }

    public boolean isTaraDestinatieOK() {
        return taraDestinatieOK;
    }

    public void setTaraDestinatieOK(boolean taraDestinatieOK) {
        this.taraDestinatieOK = taraDestinatieOK;
    }

    public String getModelVehicul() {
        return modelVehicul;
    }

    public void setModelVehicul(String modelVehicul) {
        this.modelVehicul = modelVehicul;
    }

    public boolean isModelVehiculOK() {
        return modelVehiculOK;
    }

    public void setModelVehiculOK(boolean modelVehiculOK) {
        this.modelVehiculOK = modelVehiculOK;
    }

    public String getCodUzina() {
        return codUzina;
    }

    public void setCodUzina(String codUzina) {
        this.codUzina = codUzina;
    }

    public boolean isUzinaLocala() {
        return uzinaLocala;
    }

    public void setUzinaLocala(boolean uzinaLocala) {
        this.uzinaLocala = uzinaLocala;
    }

    public String getTipZona() {
        return tipZona;
    }

    public void setTipZona(String tipZona) {
        this.tipZona = tipZona;
    }

    public boolean isZonaImport() {
        return zonaImport;
    }

    public void setZonaImport(boolean zonaImport) {
        this.zonaImport = zonaImport;
    }

    public int getNrLocuriLibere() {
        return nrLocuriLibere;
    }

    public void setNrLocuriLibere(int nrLocuriLibere) {
        this.nrLocuriLibere = nrLocuriLibere;
    }

    public String getTipFlux() {
        return tipFlux;
    }

    public void setTipFlux(String tipFlux) {
        this.tipFlux = tipFlux;
    }

    @Override
    public String toString() {
        return "IntrareCLE [VIN=" + VIN + ", VINok=" + VINok + ", marcaSofer=" + marcaSofer + ", culoare=" + culoare
                + ", stare=" + stare + ", tara=" + tara + ", taraOK=" + taraOK + ", zona=" + zona + ", zonaOK=" + zonaOK
                + ", neafectat=" + neafectat + ", plata=" + plata + ", plataOK=" + plataOK + ", contDestinatar="
                + contDestinatar + ", contDestinatarOK=" + contDestinatarOK + ", compoundOcupat=" + compoundOcupat
                + ", compoundFull=" + compoundFull + ", stocareCompound=" + stocareCompound + ", stocareCLE="
                + stocareCLE + ", vinValid=" + vinValid + ", soferValid=" + soferValid + ", utilizator=" + utilizator
                + ", utilizatorMADC=" + utilizatorMADC + ", utilizatorKIOSK=" + utilizatorKIOSK + ", locuriLibere="
                + locuriLibere + ", locuriLibereOk=" + locuriLibereOk + ", amplasament=" + amplasament
                + ", amplasamentOK=" + amplasamentOK + ", zonaFluxIndirect=" + zonaFluxIndirect + ", zonaFluxDirect="
                + zonaFluxDirect + ", du=" + du + ", duOK=" + duOK + ", taraDestinatie=" + taraDestinatie
                + ", taraDestinatieOK=" + taraDestinatieOK + ", modelVehicul=" + modelVehicul + ", modelVehiculOK="
                + modelVehiculOK + ", codConditionare=" + codConditionare + ", codConditionareOk=" + codConditionareOk
                + ", zonaAlocataDU=" + zonaAlocataDU + ", zonaAlocataDUOK=" + zonaAlocataDUOK + ", nrAutoDinDU="
                + nrAutoDinDU + ", primaAutoDinDU=" + primaAutoDinDU + ", fisaDuImprimata=" + fisaDuImprimata
                + ", repetaImprimareaOK=" + repetaImprimareaOK + ", codUzina=" + codUzina + ", uzinaLocala="
                + uzinaLocala + ", tipZona=" + tipZona + ", zonaImport=" + zonaImport + ", nrLocuriLibere="
                + nrLocuriLibere + "]";
    }

}
