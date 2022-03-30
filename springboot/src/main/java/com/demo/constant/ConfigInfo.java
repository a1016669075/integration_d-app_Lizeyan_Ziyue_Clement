package com.demo.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Classe pour lire les propriétés des fichiers de configuration
 */
@Controller
@RequestMapping("/")
public class ConfigInfo {

    @Value("${httplocation.url}")
    private String BASE_URL;

    public String getBASE_URL() {
        return BASE_URL;
    }

}
