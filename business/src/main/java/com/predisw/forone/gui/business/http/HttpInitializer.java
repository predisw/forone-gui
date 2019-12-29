package com.predisw.forone.gui.business.http;

import com.predisw.common.http.HttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class HttpInitializer {
    
    @Bean
    public HttpClient httpClientCreator(){
        return new HttpClient();
    }
    
    
    
    

}
