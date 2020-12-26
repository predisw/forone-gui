package com.predisw.forone.gui.web.fund;

import com.predisw.forone.gui.data.api.FundFluctuateFetcher;
import com.predisw.forone.gui.dataType.FluctuateKVListByTime;
import com.predisw.forone.gui.view.EchartsViewConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

import java.time.YearMonth;

@Controller
public class FluctuateController {

    @Autowired
    @Qualifier("fluctuateFetcherByMonth")
    private FundFluctuateFetcher<YearMonth> fetcherYM;

    @Autowired
    private EchartsViewConverter<YearMonth> viewConverterYM;

    @GetMapping("/mainFundFl")
    public String getMainFundFluctuateView(){
        return "fundFluctuate";
    }


    @GetMapping("/singleFundFl")
    public Mono<String> getSingleFundFluctuateView(Model model){
        model.addAttribute("description","Fund Fluctuate Status");
        return Mono.just("singleFundFluctuate");
    }


    @ResponseBody
    @GetMapping("/{fundCode}/month/last/{backwardMonthAmount}")
    public Mono<FluctuateKVListByTime<YearMonth>> getFundFluctuateByYearMonth(@PathVariable String fundCode, @PathVariable int backwardMonthAmount){
        return fetcherYM.getFluctuatesOfLastNAmount(fundCode,backwardMonthAmount)
                .map(timeFluctuate -> viewConverterYM.getViewDataType(timeFluctuate));
    }

}
