package com.predisw.forone.gui.business.view;

import com.predisw.forone.datatype.fund.FluctuateSetByTime;
import com.predisw.forone.gui.business.dataType.FluctuateKVListByTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import org.springframework.stereotype.Service;

@Service
public class EchartsViewConverter<T> {

  public FluctuateKVListByTime<T> getViewDataType(FluctuateSetByTime<T> fluctuateSet) {

    FluctuateKVListByTime<T> kvListByTime = new FluctuateKVListByTime<>();

    kvListByTime.setFundCode(fluctuateSet.getFundCode());
    kvListByTime.setFundName(fluctuateSet.getFundName());

    Map<T, Double> fluctuateMap = fluctuateSet.getFluctuatesByTime();

    kvListByTime.setTime(new ArrayList<>());
    kvListByTime.setFluctuate(new ArrayList<>());
    Optional
        .ofNullable(fluctuateMap)
        .ifPresent(map -> {
          map.entrySet().forEach(entry -> {
            kvListByTime.getTime().add(entry.getKey());
            kvListByTime.getFluctuate().add(entry.getValue());
          });
        });

    return kvListByTime;
  }

}
