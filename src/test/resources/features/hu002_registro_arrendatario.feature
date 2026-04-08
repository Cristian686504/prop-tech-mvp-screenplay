@HU002
Feature: HU002 - Registro de Arrendatario
  Como arrendatario (inquilino)
  Quiero registrarme en la plataforma con mis datos personales
  Para poder buscar y alquilar propiedades disponibles en la plataforma

  @TC-019
  Scenario: TC-019 - El arrendatario se registra exitosamente con datos válidos
    Given que el arrendatario accede al formulario de registro de la plataforma
    When el arrendatario completa y envía el formulario con sus datos de arrendatario válidos
    Then el sistema confirma el registro exitoso y lo redirige a la pantalla de propiedades
