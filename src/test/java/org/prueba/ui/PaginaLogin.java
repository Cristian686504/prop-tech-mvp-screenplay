package org.prueba.ui;

import net.serenitybdd.screenplay.targets.Target;


public class PaginaLogin {

    public static final Target CAMPO_EMAIL  = Target.the("campo email")
            .locatedBy("#email");

    public static final Target CAMPO_PASSWORD = Target.the("campo contraseña")
            .locatedBy("#password");

    public static final Target BTN_SUBMIT   = Target.the("botón iniciar sesión")
            .locatedBy("#login-btn-submit");
}
