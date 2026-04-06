@HU004
Feature: HU004 - Publicar Propiedad
  Como arrendador (propietario)
  Quiero publicar una propiedad en la plataforma con título, dirección, descripción, precio e imágenes
  Para que los arrendatarios puedan visualizarla y aplicar para alquilarla

  @TC-029
  Scenario: TC-029 - El arrendador publica exitosamente una propiedad con todos los datos requeridos
    Given que el arrendador tiene una cuenta activa y ha iniciado sesión en la plataforma
    When el arrendador envía el formulario de publicación con datos válidos
    Then la propiedad queda publicada en la plataforma y el sistema confirma la creación exitosa

  @TC-054
  Scenario: TC-054 - Un visitante sin sesión activa no puede publicar una propiedad
    Given que un visitante no ha iniciado sesión en la plataforma
    When el visitante intenta publicar una propiedad sin tener una sesión activa
    Then la plataforma le deniega el acceso y le solicita que inicie sesión
