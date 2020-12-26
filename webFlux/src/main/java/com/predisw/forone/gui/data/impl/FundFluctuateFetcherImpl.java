package com.predisw.forone.gui.data.impl;

import com.google.gson.Gson;
import com.predisw.forone.datatype.fund.FluctuateSetByTime;
import com.predisw.forone.gui.data.api.FundFluctuateFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;
import java.time.YearMonth;

@Slf4j
@Service("fluctuateFetcherByMonth")
public class FundFluctuateFetcherImpl implements FundFluctuateFetcher<YearMonth> {

    @Autowired
    private Gson gson;

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<FluctuateSetByTime<YearMonth>> getFluctuatesOfLastNAmount(String fundCode, int amount) {

       Mono<FluctuateSetByTime<YearMonth>> res = webClient.get().uri("/fluctuate/{fundCode}/month/last/{amount}", fundCode, amount)
                .accept(MediaType.APPLICATION_JSON)
                .acceptCharset(Charset.forName("UTF-8"))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<FluctuateSetByTime<YearMonth>>(){});
       return res;
    }
}
