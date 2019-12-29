package com.predisw.forone.gui.business.data.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.predisw.common.http.HttpClient;
import com.predisw.common.http.HttpRequest;
import com.predisw.common.http.HttpResponse;
import com.predisw.forone.datatype.fund.FluctuateSetByTime;
import com.predisw.forone.gui.business.common.Constants;
import com.predisw.forone.gui.business.data.api.FundFluctuateFetcher;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fluctuateFetcherByMonth")
public class FundFluctuateFetcherImpl<YearMonth> implements FundFluctuateFetcher {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HttpClient httpClient;

    @Autowired
    private Gson gson;

    @Override
    public FluctuateSetByTime<YearMonth> getFluctuatesOfLastNAmount(String fundCode, int amount) {

        String url = new StringBuilder(Constants.FORONE_URL)
            .append("fluctuate/")
            .append(fundCode)
            .append("/month")
            .append("/last/")
            .append(amount)
            .toString();

        logger.debug("the url is {}", url);
        HttpRequest httpRequest = new HttpRequest.Builder().url(url).build();
        CompletableFuture<HttpResponse>  response = httpClient.getAsync(httpRequest);

        String resContent = response
           .thenApply(fluctuate -> {
               logger.debug("the content is {}",fluctuate.getBody());
               return fluctuate.getBody();
           })
           .join();

        Type type = new TypeToken<FluctuateSetByTime<YearMonth>>(){}.getType();
        return gson.fromJson(resContent,type);
    }
}
