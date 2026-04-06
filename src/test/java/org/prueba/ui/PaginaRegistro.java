package org.prueba.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaRegistro {

    public static final Target BTN_ROL_TENANT   = Target.the("radio arrendatario")
            .locatedBy("#register-radio-tenant + span.role-card");

    public static final Target BTN_ROL_LANDLORD = Target.the("radio arrendador")
            .locatedBy("#register-radio-landlord + span.role-card");

    public static final Target CAMPO_NOMBRE     = Target.the("campo nombre")
            .locatedBy("#name");

    public static final Target CAMPO_EMAIL      = Target.the("campo email")
            .locatedBy("#email");

    public static final Target CAMPO_PASSWORD   = Target.the("campo contraseña")
            .locatedBy("#password");

    public static final Target CAMPO_CONFIRM_PASSWORD = Target.the("confirmar contraseña")
            .locatedBy("#confirmPassword");

    public static final Target CAMPO_TELEFONO   = Target.the("campo teléfono")
            .locatedBy("#register-input-phone");

    public static final Target SELECT_TIPO_DOC  = Target.the("tipo de documento")
            .locatedBy("#register-select-document-type");

    public static final Target CAMPO_ID_DOC     = Target.the("número de documento")
            .locatedBy("#register-input-document-id");

    public static final Target BTN_SUBMIT       = Target.the("botón crear cuenta")
            .locatedBy("#register-btn-submit");
}
