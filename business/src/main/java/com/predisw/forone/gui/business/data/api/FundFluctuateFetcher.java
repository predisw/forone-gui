package com.predisw.forone.gui.business.data.api;

import com.predisw.forone.datatype.fund.FluctuateSetByTime;

public interface FundFluctuateFetcher<T> {

    FluctuateSetByTime<T> getFluctuatesOfLastNAmount(String fundCode, int amount);

}
