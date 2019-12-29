package com.predisw.forone.gui.business.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.time.YearMonth;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class JsonProvider {

    @Bean
    public Gson gsonCreator(){
        return new GsonBuilder()
            .registerTypeAdapter(YearMonth.class,new YearMonthDeserializer())
            .setPrettyPrinting()
            .create();
    }

    private class YearMonthDeserializer implements JsonDeserializer<YearMonth> {
        public YearMonth deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
            return YearMonth.parse(json.getAsString());
        }
    }


}
