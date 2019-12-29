package com.predisw.forone.gui.business.data.test;

import com.google.gson.Gson;
import com.predisw.common.http.HttpClient;
import com.predisw.common.http.HttpRequest;
import com.predisw.common.http.HttpResponse;
import com.predisw.forone.datatype.fund.FluctuateSetByTime;
import com.predisw.forone.gui.Application;
import com.predisw.forone.gui.business.data.impl.FundFluctuateFetcherImpl;
import java.time.YearMonth;
import java.util.concurrent.CompletableFuture;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FundFluctuateFetcherImplT {

    /**
     * @InjectMocks can not instantiate interface FundFluctuateFetcher,
     * So here have to use the FundFluctuateFetcherImpl
     *
     * As Mockito will instantiate the class marked with @InjectMocks
     * but not fetch from the spring context.
     * The @Autowired just inject the field of instance instantiated by mockito which doesn't mock from spring context
     *
     */
    @InjectMocks
    @Autowired
    private FundFluctuateFetcherImpl fundFluctuateFetcher;

    @Mock
    private HttpClient httpClient;

    @Autowired
    private Gson gson;

    private String fundName = "LongTouZhiShu";


    @Before
    public void setup(){

        MockitoAnnotations.initMocks(this);

        String mockBody = "{\"fundCode\":\"540012\",\"fundName\":"+fundName+",\"fluctuatesByTime\":{\"2019-09\":0.76,\"2019-10\":2.36,\"2019-11\":-1.5,\"2019-12\":3.42}}";

        Mockito
            .when(httpClient.getAsync(Mockito.any(HttpRequest.class)))
            .thenReturn(CompletableFuture.completedFuture(new HttpResponse.Builder().body(mockBody).build()));
    }



    @Test
    public void getFluctuatesOfLastNMonthsTest(){

        FluctuateSetByTime<YearMonth> values = fundFluctuateFetcher.getFluctuatesOfLastNAmount("540012",3);

        System.out.println("the response content is: "+gson.toJson(values));

        Assertions.assertThat(values.getFundName()).isEqualTo(fundName);
        Assertions.assertThat(values.getFluctuatesByTime()).isNotEmpty();

    }




}
