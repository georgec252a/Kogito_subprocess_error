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

package org.acme.intrareCle.services;

import org.acme.intrareCle.IntrareCLE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StocareInCLEService {
    public final String STARE_FABRICATIE = "0";

    private static final Logger logger = LoggerFactory.getLogger(StocareInCLEService.class);

    public IntrareCLE stocareCLE(IntrareCLE intrareCle) {

        // intrareCle.setVIN(intrareCle.getVIN()); // "UU1DJF00066759821"
        // intrareCle.setMarcaSofer(intrareCle.getMarcaSofer()); // "55032402"
        // intrareCle.setCuloare("alb");
        // intrareCle.setContDestinatar("aaaa");
        // intrareCle.setTara("Romania");
        // intrareCle.setStare("0");

        intrareCle.setStocareCLE(true);
        intrareCle.setLocuriLibere(2);
        intrareCle.setLocuriLibereOk(true);

        logger.info("Aici se stocheaza auto in CLE "
                + intrareCle.getVin() + ", " + intrareCle.getMarcaSofer());

        return intrareCle;

    }
}
