package org.prueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ElMensajeDeError implements Question<Boolean> {

    private static final Target MENSAJE =
            Target.the("mensaje de error").locatedBy(".error-message[role='alert']");

    public static ElMensajeDeError estaVisible() {
        return new ElMensajeDeError();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return MENSAJE.resolveFor(actor).isCurrentlyVisible();
    }
}
