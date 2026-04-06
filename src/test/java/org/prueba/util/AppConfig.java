package org.prueba.util;

import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class AppConfig {

    private static final EnvironmentVariables ENV =
            SystemEnvironmentVariables.createEnvironmentVariables();

    private AppConfig() {}

    public static String baseUrl() {
        return ENV.getProperty("webdriver.base.url", "http://localhost");
    }

    public static String registroUrl()          { return baseUrl() + "/register"; }
    public static String loginUrl()             { return baseUrl() + "/login"; }
    public static String propiedadesUrl()       { return baseUrl() + "/properties"; }
    public static String publicarPropiedadUrl() { return baseUrl() + "/publish-property"; }
}

