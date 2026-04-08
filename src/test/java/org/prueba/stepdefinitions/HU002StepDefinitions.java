package org.prueba.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import org.prueba.tasks.RegistrarUsuario;
import org.prueba.util.TestData;
import org.prueba.util.UsuarioDatos;

import java.util.UUID;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class HU002StepDefinitions {

    // ─── TC-019 ──────────────────────────────────────────────────────────────
    // El Entonces es compartido con HU001: "el sistema confirma el registro exitoso
    // y lo redirige a la pantalla de propiedades" (definido en HU001StepDefinitions)

    @Dado("que el arrendatario accede al formulario de registro de la plataforma")
    public void queElArrendatarioAccedeAlFormulario() {
        theActorCalled("Arrendatario");
    }

    @Cuando("el arrendatario completa y envía el formulario con sus datos de arrendatario válidos")
    public void elArrendatarioCompletaYEnviaElFormulario() {
        String uid = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        theActorInTheSpotlight().attemptsTo(
                new RegistrarUsuario(new UsuarioDatos(
                        TestData.NOMBRE_TENANT,
                        "tenant_" + uid + "@test.com",
                        TestData.TENANT_PASSWORD,
                        TestData.PHONE_TENANT,
                        TestData.DOC_TYPE,
                        TestData.DOC_TYPE + "T" + uid,
                        "TENANT"))
        );
    }
}
