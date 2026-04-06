package org.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.prueba.util.TestData;
import org.prueba.util.UsuarioDatos;

public class PrepararEscenario implements Task {

    private final String uid;

    private PrepararEscenario(String uid) {
        this.uid = uid;
    }

    public static PrepararEscenario conUid(String uid) {
        return new PrepararEscenario(uid);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String email = "landlord_setup_" + uid + "@test.com";
        String docId = "CC" + uid;

        String nombre = "Arrendador_" + uid;

        actor.attemptsTo(
                new RegistrarUsuario(new UsuarioDatos(
                        nombre, email, TestData.LANDLORD_PASSWORD,
                        TestData.PHONE_LANDLORD, TestData.DOC_TYPE, docId, "LANDLORD"
                )),
                PublicarPropiedad.conDatosValidos(),
                new CerrarSesion()
        );
    }
}

