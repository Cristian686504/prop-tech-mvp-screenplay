@HU001
Feature: HU001 - Registro de Arrendador
  Como arrendador (propietario)
  Quiero registrarme en la plataforma con mis datos personales
  Para poder publicar mis propiedades y gestionar el flujo de alquiler

  @TC-001
  Scenario: TC-001 - El arrendador se registra exitosamente con datos válidos
    Given que el arrendador accede al formulario de registro de la plataforma
    When el arrendador completa y envía el formulario con sus datos de arrendador válidos
    Then el sistema confirma el registro exitoso y lo redirige a la pantalla de propiedades

  @TC-002
  Scenario: TC-002 - El arrendador no puede registrarse con un correo ya registrado
    Given que ya existe una cuenta registrada en la plataforma con un correo en uso
    When el arrendador intenta registrarse con ese mismo correo
    Then el sistema muestra un error indicando que el correo ya está en uso
