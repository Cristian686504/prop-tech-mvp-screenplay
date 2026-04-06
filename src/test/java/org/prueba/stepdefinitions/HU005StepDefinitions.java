package org.prueba.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import org.prueba.questions.ElCatalogo;
import org.prueba.questions.LasPropiedades;
import org.prueba.tasks.NavegarA;
import org.prueba.tasks.PrepararEscenario;
import org.prueba.tasks.RegistrarUsuario;
import org.prueba.util.AppConfig;
import org.prueba.util.TestData;
import org.prueba.util.UsuarioDatos;

import java.util.UUID;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class HU005StepDefinitions {

    @Dado("que existen propiedades publicadas en la plataforma y el arrendatario ha iniciado sesión")
    public void queHayPropiedadesYElArrendatarioEstaAutenticado() {
        String uid         = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        String tenantEmail = "tenant_" + uid + "@test.com";
        String tenantDocId = TestData.DOC_TYPE + "T" + uid;

        Actor arrendadorSetup = theActorCalled("ArrendadorSetup");
        arrendadorSetup.attemptsTo(PrepararEscenario.conUid(uid));

        theActorCalled("Arrendatario").attemptsTo(
                new RegistrarUsuario(new UsuarioDatos(
                        TestData.NOMBRE_TENANT, tenantEmail, TestData.TENANT_PASSWORD,
                        TestData.PHONE_TENANT, TestData.DOC_TYPE, tenantDocId, "TENANT"
                ))
        );
    }

    @Cuando("el arrendatario navega a la sección de propiedades disponibles")
    public void elArrendatarioConsultaLaListaDePropiedades() {
        theActorInTheSpotlight().attemptsTo(NavegarA.laUrl(AppConfig.propiedadesUrl()));
    }

    @Entonces("el sistema le muestra el catálogo de propiedades con sus detalles")
    public void seRetornaLaListaDePropiedades() {
        theActorInTheSpotlight().should(
                seeThat("el catálogo de propiedades debe estar visible",
                        ElCatalogo.dePropiedadesEsVisible(), is(true)),
                seeThat("debe haber al menos una propiedad en el catálogo",
                        LasPropiedades.visiblesEnElCatalogo(), is(not(empty()))),
                seeThat("la propiedad publicada debe aparecer",
                        LasPropiedades.visiblesEnElCatalogo(), hasItem(TestData.PROPIEDAD_TITULO))
        );
    }
}

