@HU005
Feature: HU005 - Visualizar Propiedades Disponibles
  Como arrendatario (inquilino)
  Quiero visualizar las propiedades disponibles para alquilar con título, dirección, descripción, precio e imágenes
  Para poder elegir una propiedad que se ajuste a mis necesidades y aplicar para alquilarla

  @TC-057
  Scenario: TC-057 - El arrendatario visualiza el catálogo de propiedades disponibles
    Given que existen propiedades publicadas en la plataforma y el arrendatario ha iniciado sesión
    When el arrendatario navega a la sección de propiedades disponibles
    Then el sistema le muestra el catálogo de propiedades con sus detalles

  @TC-058
  Scenario: TC-058 - Un visitante sin sesión activa no puede ver el catálogo de propiedades
    Given que un visitante no ha iniciado sesión en la plataforma
    When el visitante intenta acceder al catálogo de propiedades sin tener una sesión activa
    Then la plataforma le deniega el acceso y le solicita que inicie sesión
