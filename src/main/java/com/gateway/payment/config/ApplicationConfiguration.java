package com.gateway.payment.config;

import com.gateway.payment.domain.E588Request;
import com.gateway.payment.domain.E588RequestDto;
import com.gateway.payment.domain.E588Response;
import com.gateway.payment.procedures.MessageTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.lang.reflect.Method;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.gateway.payment")
public class ApplicationConfiguration {

    @Bean
    public MessageTransformer<E588RequestDto> messageTransformer(){
        return (Object... args) -> {
            E588Request clientRequest = (E588Request) args[0];
            E588RequestDto e588Request = new E588RequestDto();
            e588Request.setCbsAccountNumber(clientRequest.getAccountNumber());
            e588Request.setInputOfficerFlag(0);
            e588Request.setMaxGroupQuantity(0);
            e588Request.setOverrideFlag(1);
            e588Request.setProductFlag(1);
            e588Request.setProductNumber(findProductFamilyId());
            e588Request.setSourceId("777505");
            e588Request.setTariffFlag(1);
            e588Request.setTariffId(clientRequest.getTariff());
            return e588Request;
        };
    }

    private int findProductFamilyId() {
        return 1;
    }


}
