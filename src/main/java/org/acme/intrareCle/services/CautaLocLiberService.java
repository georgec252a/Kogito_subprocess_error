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
public class CautaLocLiberService {
    public final String STARE_FABRICATIE = "0";

    private static final Logger logger = LoggerFactory.getLogger(CautaLocLiberService.class);

    public IntrareCLE cautaLocLiber(IntrareCLE intrareCle) {

        // intrareCle.setVIN(intrareCle.getVIN()); // "UU1DJF00066759821"
        // intrareCle.setMarcaSofer(intrareCle.getMarcaSofer()); // "55032402"
        // intrareCle.setCuloare("alb");
        // intrareCle.setContDestinatar("aaaa");
        // intrareCle.setTara("Romania");
        // intrareCle.setStare("0");

        logger.info("Aici se cauta loc liber "
                + intrareCle.getVin() + ", " + intrareCle.getMarcaSofer());
        logger.info("Aici se cauta loc liber"
                + intrareCle.isVinValid() + ", " + intrareCle.isSoferValid());
        return intrareCle;

    }
}
