package com.predisw.forone.gui.business.dataType;

import com.predisw.forone.datatype.fund.FundBase;
import java.util.List;
import java.util.TreeSet;

public class FluctuateKVListByTime<T> extends FundBase {

    private List<T> time;

    private List<Double> fluctuate;

    public List<T> getTime() {
        return time;
    }

    public void setTime(List<T> time) {
        this.time = time;
    }

    public List<Double> getFluctuate() {
        return fluctuate;
    }

    public void setFluctuate(List<Double> fluctuate) {
        this.fluctuate = fluctuate;
    }
}
