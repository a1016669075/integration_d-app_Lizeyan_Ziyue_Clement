package com.demo.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BlueT on 2017/3/3.
 */
@Component
public class WebConst {
    public static Map<String, String> initConfig = new HashMap<>();


    public static String LOGIN_SESSION_KEY = "login_user";
    public static String BASEURL = "http://192.168.17.48:8080";

    /**
     * Nombre maximum d'articles à obtenir
     */
    public static final int MAX_POSTS = 9999;

    /**
     * nombre maximal de pages
     */
    public static final int MAX_PAGE = 100;

    /**
     * Le nombre maximum de caractères pouvant être saisis dans un article
     */
    public static final int MAX_TEXT_COUNT = 200000;

    /**
     * Le nombre maximum de caractères pouvant être saisis dans le titre de l'article
     */
    public static final int MAX_TITLE_COUNT = 200;

    /**
     * Combien de résultats supplémentaires sont mis à jour dans la base de données
     */
    public static final int HIT_EXCEED = 10;

    /**
     * Le fichier de téléchargement maximum est de 1M
     */
    public static Integer MAX_FILE_SIZE = 104857600;

    /**
     * revenir avec succès
     */
    public static String SUCCESS_RESULT = "SUCCESS";
}
