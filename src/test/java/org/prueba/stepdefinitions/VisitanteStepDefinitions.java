package org.prueba.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.prueba.questions.ElFormularioDeLogin;
import org.prueba.questions.LaUrlActual;
import org.prueba.tasks.NavegarA;
import org.prueba.util.AppConfig;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class VisitanteStepDefinitions {

    @Dado("que un visitante no ha iniciado sesión en la plataforma")
    public void queUnVisitanteNoHaIniciadoSesion() {
        theActorCalled("Visitante");
    }

    @Cuando("el visitante intenta publicar una propiedad sin tener una sesión activa")
    public void elVisitanteIntentaPublicar() {
        theActorInTheSpotlight().attemptsTo(NavegarA.laUrl(AppConfig.publicarPropiedadUrl()));
    }

    @Cuando("el visitante intenta acceder al catálogo de propiedades sin tener una sesión activa")
    public void elVisitanteIntentaConsultar() {
        theActorInTheSpotlight().attemptsTo(NavegarA.laUrl(AppConfig.propiedadesUrl()));
    }

    @Entonces("la plataforma le deniega el acceso y le solicita que inicie sesión")
    public void laPlatformaLeDeniegaElAcceso() {
        theActorInTheSpotlight().should(
                seeThat("el navegador debe ser redirigido a la página de login",
                        LaUrlActual.delNavegador(), containsString("/login")),
                seeThat("el formulario de login debe estar visible",
                        ElFormularioDeLogin.esVisible(), is(true))
        );
    }
}

