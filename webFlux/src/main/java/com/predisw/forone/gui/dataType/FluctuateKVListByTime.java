package com.predisw.forone.gui.dataType;

import com.predisw.forone.datatype.fund.FundBase;
import lombok.Data;

import java.util.List;

@Data
public class FluctuateKVListByTime<T> extends FundBase {

    private List<T> time;

    private List<Double> fluctuate;

}
