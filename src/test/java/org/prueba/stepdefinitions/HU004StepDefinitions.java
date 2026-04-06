package org.prueba.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.prueba.questions.LaUrlActual;
import org.prueba.questions.LasPropiedades;
import org.prueba.tasks.PublicarPropiedad;
import org.prueba.tasks.RegistrarUsuario;
import org.prueba.util.TestData;
import org.prueba.util.UsuarioDatos;

import java.util.UUID;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class HU004StepDefinitions {

    @Dado("que el arrendador tiene una cuenta activa y ha iniciado sesión en la plataforma")
    public void queElArrendadorEstaRegistradoYAutenticado() {
        String uid   = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        String email = "landlord_" + uid + "@test.com";
        String docId = TestData.DOC_TYPE + uid;

        theActorCalled("Arrendador").attemptsTo(
                new RegistrarUsuario(new UsuarioDatos(
                        TestData.NOMBRE_LANDLORD, email, TestData.LANDLORD_PASSWORD,
                        TestData.PHONE_LANDLORD, TestData.DOC_TYPE, docId, "LANDLORD"
                ))
        );
    }

    @Cuando("el arrendador envía el formulario de publicación con datos válidos")
    public void elArrendadorEnviaElFormularioDePublicacion() {
        theActorInTheSpotlight().attemptsTo(PublicarPropiedad.conDatosValidos());
    }

    @Entonces("la propiedad queda publicada en la plataforma y el sistema confirma la creación exitosa")
    public void laPropiedadEsCreadaExitosamente() {
        theActorInTheSpotlight().should(
                seeThat("la URL debe mostrar el catálogo de propiedades",
                        LaUrlActual.delNavegador(), containsString("/properties")),
                seeThat("la propiedad publicada debe aparecer en el catálogo",
                        LasPropiedades.visiblesEnElCatalogo(), hasItem(TestData.PROPIEDAD_TITULO))
        );
    }
}
