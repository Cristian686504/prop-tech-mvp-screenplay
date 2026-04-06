package org.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavegarA implements Task {

    private final String url;

    private NavegarA(String url) {
        this.url = url;
    }

    public static NavegarA laUrl(String url) {
        return new NavegarA(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(url));
    }
}
