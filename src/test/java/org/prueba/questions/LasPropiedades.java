package org.prueba.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.prueba.ui.PaginaPropiedades;

import java.util.List;
import java.util.stream.Collectors;

public class LasPropiedades implements Question<List<String>> {

    public static LasPropiedades visiblesEnElCatalogo() {
        return new LasPropiedades();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return PaginaPropiedades.TITULO_PROPIEDAD
                .resolveAllFor(actor)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
