package org.prueba.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaPublicarPropiedad {

    public static final Target CAMPO_TITULO       = Target.the("campo título")
            .locatedBy("#title");

    public static final Target CAMPO_DESCRIPCION  = Target.the("campo descripción")
            .locatedBy("#description");

    public static final Target CAMPO_DIRECCION    = Target.the("campo dirección")
            .locatedBy("#address");

    public static final Target CAMPO_PRECIO       = Target.the("campo precio")
            .locatedBy("#price");

    public static final Target INPUT_IMAGENES     = Target.the("input de imágenes")
            .locatedBy("#publish-input-images");

    public static final Target LABEL_UPLOAD       = Target.the("botón subir imagen")
            .locatedBy("#publish-label-upload");

    public static final Target BTN_SUBMIT         = Target.the("botón publicar propiedad")
            .locatedBy("#publish-btn-submit");
}
