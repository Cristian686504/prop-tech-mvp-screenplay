package org.prueba.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;

public class ImagenDePrueba {

    private ImagenDePrueba() {}

    public static String crearArchivoTemporal() {
        try {
            BufferedImage imagen = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = imagen.createGraphics();
            g2d.setColor(new Color(37, 99, 235)); // Azul PropTech
            g2d.fillRect(0, 0, 100, 100);
            g2d.dispose();

            File archivo = Files.createTempFile("propiedad-test-", ".png").toFile();
            archivo.deleteOnExit();
            ImageIO.write(imagen, "PNG", archivo);
            return archivo.getAbsolutePath();
        } catch (IOException e) {
            throw new UncheckedIOException("No se pudo crear la imagen de prueba", e);
        }
    }
}
