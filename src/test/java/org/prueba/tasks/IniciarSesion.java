package org.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.prueba.ui.PaginaLogin;
import org.prueba.util.AppConfig;

public class IniciarSesion implements Task {

    private final String email;
    private final String password;

    public IniciarSesion(String email, String password) {
        this.email    = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(AppConfig.loginUrl()),
                Enter.theValue(email).into(PaginaLogin.CAMPO_EMAIL),
                Enter.theValue(password).into(PaginaLogin.CAMPO_PASSWORD),
                Click.on(PaginaLogin.BTN_SUBMIT)
        );
    }
}

