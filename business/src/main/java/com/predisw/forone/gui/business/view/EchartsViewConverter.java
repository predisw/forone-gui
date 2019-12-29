package com.predisw.forone.gui.business.view;

import com.predisw.forone.datatype.fund.FluctuateSetByTime;
import com.predisw.forone.gui.business.dataType.FluctuateKVListByTime;
import java.util.ArrayList;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class EchartsViewConverter<T> {


    public FluctuateKVListByTime<T> getViewDataType(FluctuateSetByTime<T> fluctuateSet){

        FluctuateKVListByTime<T> kvListByTime = new FluctuateKVListByTime<>();

        kvListByTime.setFundCode(fluctuateSet.getFundCode());
        kvListByTime.setFundName(fluctuateSet.getFundName());

        Map<T, Double> fluctuateMap = fluctuateSet.getFluctuatesByTime();

        if (fluctuateMap != null){
            kvListByTime.setTime(new ArrayList<>(fluctuateMap.keySet()));
            kvListByTime.setFluctuate(new ArrayList<>(fluctuateMap.values()));
        }

        return kvListByTime;
    }




    
}
