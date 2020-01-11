package com.predisw.forone.gui.web.fund;

import com.predisw.forone.gui.business.data.api.FundFluctuateFetcher;
import com.predisw.forone.gui.business.dataType.FluctuateKVListByTime;
import com.predisw.forone.gui.business.view.EchartsViewConverter;
import java.time.YearMonth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FluctuateContorller {

    @Autowired
    @Qualifier("fluctuateFetcherByMonth")
    private FundFluctuateFetcher<YearMonth> fetcherYM;

    @Autowired
    private EchartsViewConverter<YearMonth> viewConverterYM;

    @RequestMapping("/mainFundFl")
    public String getMainFundFluctuateView(ModelMap model){
        model.addAttribute("description","Fund Fluctuate Status");
        return "fundFluctuate";
    }


    @RequestMapping("/singleFundFl")
    public String getSingleFundFluctuateView(ModelMap model){
        model.addAttribute("description","Fund Fluctuate Status");
        return "singleFundFluctuate";
    }


    @ResponseBody
    @RequestMapping("/{fundCode}/month/last/{backwardMonthAmount}")
    public FluctuateKVListByTime<YearMonth> getFundFluctuateByYearMonth(@PathVariable String fundCode, @PathVariable int backwardMonthAmount){
        return viewConverterYM.getViewDataType(fetcherYM.getFluctuatesOfLastNAmount(fundCode, backwardMonthAmount));
    }

}
