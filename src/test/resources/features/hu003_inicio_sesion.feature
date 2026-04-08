@HU003
Feature: HU003 - Inicio de Sesión
  Como usuario (arrendador o arrendatario)
  Quiero iniciar sesión en la plataforma con mi correo y contraseña
  Para acceder a las funcionalidades correspondientes a mi rol

  @TC-020
  Scenario: TC-020 - El usuario inicia sesión exitosamente con credenciales válidas
    Given que el usuario tiene una cuenta registrada en la plataforma
    When el usuario inicia sesión con sus credenciales válidas
    Then el sistema le concede el acceso y le muestra la pantalla de propiedades

  @TC-024
  Scenario: TC-024 - El usuario no puede iniciar sesión con un correo no registrado
    Given que el usuario navega a la página de inicio de sesión
    When el usuario intenta iniciar sesión con un correo no registrado en el sistema
    Then el sistema le muestra un mensaje de error de credenciales inválidas

  @TC-025
  Scenario: TC-025 - El usuario no puede iniciar sesión con una contraseña incorrecta
    Given que el usuario tiene una cuenta registrada en la plataforma
    When el usuario intenta iniciar sesión con una contraseña incorrecta
    Then el sistema le muestra un mensaje de error de credenciales inválidas
