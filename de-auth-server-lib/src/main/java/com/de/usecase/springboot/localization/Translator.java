package com.de.usecase.springboot.localization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Translator {

    private Logger logger = Logger.getLogger(Translator.class.getName());
    private final ResourceBundleMessageSource messageSource;

    @Autowired
    Translator(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String toLocale(String msgCode) {
        Locale locale = LocaleContextHolder.getLocale();
        logger.log(Level.FINE,"locale:"+locale.getCountry() +":"+locale.getDisplayName());
        return messageSource.getMessage(msgCode, null, locale);
    }
}