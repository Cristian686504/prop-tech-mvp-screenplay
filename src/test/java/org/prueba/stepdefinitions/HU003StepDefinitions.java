package org.prueba.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.prueba.questions.ElCatalogo;
import org.prueba.questions.ElMensajeDeError;
import org.prueba.questions.LaUrlActual;
import org.prueba.tasks.IniciarSesion;
import org.prueba.tasks.RegistrarUsuario;
import org.prueba.util.TestData;
import org.prueba.util.UsuarioDatos;

import java.util.UUID;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class HU003StepDefinitions {

    /** Almacena el correo del usuario registrado en el Given para reutilizarlo en el When. */
    private String emailRegistrado;

    // ─── TC-020 / TC-025 — Given compartido ──────────────────────────────────

    @Dado("que el usuario tiene una cuenta registrada en la plataforma")
    public void queElUsuarioTieneCuentaRegistrada() {
        String uid = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        emailRegistrado = "user_" + uid + "@test.com";

        theActorCalled("Usuario").attemptsTo(
                new RegistrarUsuario(new UsuarioDatos(
                        TestData.NOMBRE_TENANT,
                        emailRegistrado,
                        TestData.TENANT_PASSWORD,
                        TestData.PHONE_TENANT,
                        TestData.DOC_TYPE,
                        TestData.DOC_TYPE + "U" + uid,
                        "TENANT"))
        );
    }

    // ─── TC-024 — Given ──────────────────────────────────────────────────────

    @Dado("que el usuario navega a la página de inicio de sesión")
    public void queElUsuarioNavegaAlLogin() {
        theActorCalled("Visitante");
    }

    // ─── TC-020 — When ───────────────────────────────────────────────────────

    @Cuando("el usuario inicia sesión con sus credenciales válidas")
    public void elUsuarioIniciaSesionConCredencialesValidas() {
        theActorInTheSpotlight().attemptsTo(
                new IniciarSesion(emailRegistrado, TestData.TENANT_PASSWORD)
        );
    }

    // ─── TC-020 — Then ───────────────────────────────────────────────────────

    @Entonces("el sistema le concede el acceso y le muestra la pantalla de propiedades")
    public void elSistemaLeConceneAcceso() {
        theActorInTheSpotlight().should(
                seeThat("la URL debe contener /properties tras el login",
                        LaUrlActual.delNavegador(), containsString("/properties")),
                seeThat("el catálogo de propiedades debe estar visible",
                        ElCatalogo.dePropiedadesEsVisible(), is(true))
        );
    }

    // ─── TC-024 — When ───────────────────────────────────────────────────────

    @Cuando("el usuario intenta iniciar sesión con un correo no registrado en el sistema")
    public void elUsuarioIntentaConCorreoNoRegistrado() {
        String ts = String.valueOf(System.currentTimeMillis());
        theActorInTheSpotlight().attemptsTo(
                new IniciarSesion("noexiste_" + ts + "@test.com", "Pass1234!")
        );
    }

    // ─── TC-025 — When ───────────────────────────────────────────────────────

    @Cuando("el usuario intenta iniciar sesión con una contraseña incorrecta")
    public void elUsuarioIntentaConContrasenaIncorrecta() {
        theActorInTheSpotlight().attemptsTo(
                new IniciarSesion(emailRegistrado, "WrongPass!")
        );
    }

    // ─── TC-024 / TC-025 — Then compartido ───────────────────────────────────

    @Entonces("el sistema le muestra un mensaje de error de credenciales inválidas")
    public void elSistemaMuestraErrorDeCredenciales() {
        theActorInTheSpotlight().should(
                seeThat("debe aparecer un mensaje de error en el formulario de login",
                        ElMensajeDeError.estaVisible(), is(true))
        );
    }
}
