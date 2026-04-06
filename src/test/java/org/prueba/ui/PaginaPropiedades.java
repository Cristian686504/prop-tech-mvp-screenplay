package org.prueba.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaPropiedades {

    public static final Target CONTENEDOR = Target.the("contenedor de propiedades")
            .locatedBy(".property-list-container");

    public static final Target TARJETA_PROPIEDAD = Target.the("tarjeta de propiedad")
            .locatedBy(".property-card");

    public static final Target TITULO_PROPIEDAD = Target.the("título de propiedad")
            .locatedBy(".property-title");

    public static final Target BTN_LOGOUT = Target.the("botón cerrar sesión")
            .locatedBy("#navbar-btn-logout");

    public static final Target LINK_NAVBAR_HOME = Target.the("logo navbar")
            .locatedBy("#navbar-link-home");
}
