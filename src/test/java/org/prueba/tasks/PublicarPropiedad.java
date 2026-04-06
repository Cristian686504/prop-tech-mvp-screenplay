package org.prueba.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.annotations.Subject;
import org.prueba.ui.PaginaPublicarPropiedad;
import org.prueba.util.AppConfig;
import org.prueba.util.ImagenDePrueba;
import org.prueba.util.TestData;

public class PublicarPropiedad implements Task {

    private final String titulo;
    private final String descripcion;
    private final String direccion;
    private final String precio;

    private PublicarPropiedad(String titulo, String descripcion,
                               String direccion, String precio) {
        this.titulo      = titulo;
        this.descripcion = descripcion;
        this.direccion   = direccion;
        this.precio      = precio;
    }

    public static PublicarPropiedad conDatosValidos() {
        return new PublicarPropiedad(
                TestData.PROPIEDAD_TITULO,
                TestData.PROPIEDAD_DESCRIPCION,
                TestData.PROPIEDAD_DIRECCION,
                TestData.PROPIEDAD_PRECIO
        );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String rutaImagen = ImagenDePrueba.crearArchivoTemporal();

        actor.attemptsTo(
                Open.url(AppConfig.publicarPropiedadUrl()),
                Enter.theValue(titulo).into(PaginaPublicarPropiedad.CAMPO_TITULO),
                Enter.theValue(descripcion).into(PaginaPublicarPropiedad.CAMPO_DESCRIPCION),
                Enter.theValue(direccion).into(PaginaPublicarPropiedad.CAMPO_DIRECCION),
                Enter.theValue(precio).into(PaginaPublicarPropiedad.CAMPO_PRECIO),
                subirImagen(rutaImagen),
                Click.on(PaginaPublicarPropiedad.BTN_SUBMIT)
        );
    }

    private static Interaction subirImagen(String rutaArchivo) {
        return new SubirImagen(rutaArchivo);
    }

    @Subject("sube la imagen de la propiedad")
    private static class SubirImagen implements Interaction {
        private final String rutaArchivo;

        SubirImagen(String rutaArchivo) {
            this.rutaArchivo = rutaArchivo;
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    SendKeys.of(rutaArchivo).into(PaginaPublicarPropiedad.INPUT_IMAGENES)
            );
        }
    }
}

