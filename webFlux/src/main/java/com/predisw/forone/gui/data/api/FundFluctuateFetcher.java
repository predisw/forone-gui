package com.predisw.forone.gui.data.api;

import com.predisw.forone.datatype.fund.FluctuateSetByTime;
import reactor.core.publisher.Mono;

public interface FundFluctuateFetcher<T> {

    Mono<FluctuateSetByTime<T>> getFluctuatesOfLastNAmount(String fundCode, int amount);

}
