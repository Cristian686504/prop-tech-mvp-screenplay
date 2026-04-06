package org.prueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.prueba.ui.PaginaLogin;

public class ElFormularioDeLogin implements Question<Boolean> {

    public static ElFormularioDeLogin esVisible() {
        return new ElFormularioDeLogin();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return PaginaLogin.CAMPO_EMAIL.resolveFor(actor).isCurrentlyVisible()
                && PaginaLogin.BTN_SUBMIT.resolveFor(actor).isCurrentlyVisible();
    }
}
