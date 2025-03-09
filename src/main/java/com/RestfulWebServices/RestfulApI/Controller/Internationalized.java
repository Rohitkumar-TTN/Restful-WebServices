package com.RestfulWebServices.RestfulApI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
@RestController
public class Internationalized {

    private final MessageSource messageSource;
    public Internationalized(MessageSource messageSource){
        this.messageSource=messageSource;
    }
    @GetMapping(path="/intern")
    public String helloWorldInternationalized(@RequestParam(required = false) String username){
        Locale locale= LocaleContextHolder.getLocale();

        return  messageSource.getMessage("good.morning.message",new Object[]{username},"Default Message",locale);
    }
}
