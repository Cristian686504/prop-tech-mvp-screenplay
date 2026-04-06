package org.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import org.prueba.ui.PaginaRegistro;
import org.prueba.util.AppConfig;
import org.prueba.util.UsuarioDatos;

public class RegistrarUsuario implements Task {

    private final UsuarioDatos datos;

    public RegistrarUsuario(UsuarioDatos datos) {
        this.datos = datos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(AppConfig.registroUrl()));

        Target rolButton = "LANDLORD".equalsIgnoreCase(datos.rol())
                ? PaginaRegistro.BTN_ROL_LANDLORD
                : PaginaRegistro.BTN_ROL_TENANT;
        actor.attemptsTo(Click.on(rolButton));

        actor.attemptsTo(
                Enter.theValue(datos.nombre()).into(PaginaRegistro.CAMPO_NOMBRE),
                Enter.theValue(datos.email()).into(PaginaRegistro.CAMPO_EMAIL),
                Enter.theValue(datos.password()).into(PaginaRegistro.CAMPO_PASSWORD),
                Enter.theValue(datos.password()).into(PaginaRegistro.CAMPO_CONFIRM_PASSWORD),
                Enter.theValue(datos.telefono()).into(PaginaRegistro.CAMPO_TELEFONO),
                SelectFromOptions.byValue(datos.tipoDocumento()).from(PaginaRegistro.SELECT_TIPO_DOC),
                Enter.theValue(datos.idDocumento()).into(PaginaRegistro.CAMPO_ID_DOC),
                Click.on(PaginaRegistro.BTN_SUBMIT)
        );

    }
}

