package org.prueba.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.prueba.ui.PaginaPropiedades;

public class ElCatalogo implements Question<Boolean> {

    public static ElCatalogo dePropiedadesEsVisible() {
        return new ElCatalogo();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return PaginaPropiedades.CONTENEDOR
                .resolveFor(actor)
                .isCurrentlyVisible();
    }
}
