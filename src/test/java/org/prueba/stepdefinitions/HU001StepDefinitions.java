package org.prueba.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.prueba.questions.ElMensajeDeError;
import org.prueba.questions.LaUrlActual;
import org.prueba.tasks.RegistrarUsuario;
import org.prueba.util.TestData;
import org.prueba.util.UsuarioDatos;

import java.util.UUID;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class HU001StepDefinitions {

    private String emailExistente;

    // ─── TC-001 ──────────────────────────────────────────────────────────────

    @Dado("que el arrendador accede al formulario de registro de la plataforma")
    public void queElArrendadorAccedeAlFormulario() {
        theActorCalled("Arrendador");
    }

    @Cuando("el arrendador completa y envía el formulario con sus datos de arrendador válidos")
    public void elArrendadorCompletaYEnviaElFormulario() {
        String uid = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        theActorInTheSpotlight().attemptsTo(
                new RegistrarUsuario(new UsuarioDatos(
                        TestData.NOMBRE_LANDLORD,
                        "landlord_" + uid + "@test.com",
                        TestData.LANDLORD_PASSWORD,
                        TestData.PHONE_LANDLORD,
                        TestData.DOC_TYPE,
                        TestData.DOC_TYPE + uid,
                        "LANDLORD"))
        );
    }

    @Entonces("el sistema confirma el registro exitoso y lo redirige a la pantalla de propiedades")
    public void elSistemaConfirmaElRegistroYRedirige() {
        theActorInTheSpotlight().should(
                seeThat("la URL debe contener /properties tras el registro",
                        LaUrlActual.delNavegador(), containsString("/properties"))
        );
    }

    // ─── TC-002 ──────────────────────────────────────────────────────────────

    @Dado("que ya existe una cuenta registrada en la plataforma con un correo en uso")
    public void queYaExisteUnaCuentaConEseCorreo() {
        String uid = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        emailExistente = "existing_" + uid + "@test.com";

        theActorCalled("SetupArrendador").attemptsTo(
                new RegistrarUsuario(new UsuarioDatos(
                        "Arrendador Setup",
                        emailExistente,
                        TestData.LANDLORD_PASSWORD,
                        TestData.PHONE_LANDLORD,
                        TestData.DOC_TYPE,
                        "SETUP" + uid,
                        "LANDLORD"))
        );
    }

    @Cuando("el arrendador intenta registrarse con ese mismo correo")
    public void elArrendadorIntentaRegistrarseConElMismoCorreo() {
        String uid = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        theActorCalled("Arrendador").attemptsTo(
                new RegistrarUsuario(new UsuarioDatos(
                        TestData.NOMBRE_LANDLORD,
                        emailExistente,
                        TestData.LANDLORD_PASSWORD,
                        TestData.PHONE_LANDLORD,
                        TestData.DOC_TYPE,
                        "DUP" + uid,
                        "LANDLORD"))
        );
    }

    @Entonces("el sistema muestra un error indicando que el correo ya está en uso")
    public void elSistemaMuestraErrorCorreoEnUso() {
        theActorInTheSpotlight().should(
                seeThat("debe aparecer un mensaje de error en el formulario de registro",
                        ElMensajeDeError.estaVisible(), is(true))
        );
    }
}
