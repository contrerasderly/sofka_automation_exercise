## Proyecto de Automatización Serenity BDD (Web & API)

Este proyecto implementa un framework de automatización de pruebas robusto y escalable, utilizando el patrón Screenplay con Serenity BDD, Cucumber y Java/Gradle. El framework está diseñado para validar tanto la interfaz de usuario (Web) como los servicios de backend (API RESTful) de la Petstore y otros endpoints.
 
## Tecnologías Utilizadas
Framework Base	          = Serenity BDD	                      = Generación de informes detallados y trazabilidad BDD.
Lenguaje	                = Java 17+	                          = Lógica de negocio y programación de tests.
Patrón	                  = Screenplay	                        = Diseño centrado en actores, tareas e interacciones para alta reusabilidad.
Pruebas UI/Web	          = Selenium WebDriver	                = Interacción con el navegador para pruebas de interfaz.
Pruebas API	              = Serenity REST / Rest Assured	      = Ejecución de peticiones HTTP (POST, GET) y validación de JSON.
Ejecución y Builds	      = Gradle	                            = Gestión de dependencias y orquestación de tareas de prueba.
CI/CD	                    = GitHub Actions	                    = Automatización del pipeline para ejecuciones Web y API.
Cross-Browser	            = BrowserStack	                      = Ejecución remota y paralela en múltiples navegadores y dispositivos (Web/UI).


## Estructura del ProyectoEl código sigue la estructura estándar de Serenity Screenplay para asegurar la separación de responsabilidades:src/
├── main/java/
│   ├── models/           # POJOs para serialización/deserialización de API (Pet, Category)
│   ├── tasks/            # La capa del QUÉ: Tareas de alto nivel (Ej: CreatePet, NavigateToPage)
│   ├── interactions/     # La capa del CÓMO: Interacciones de bajo nivel (Ej: Post.to, Click.on)
│   └── questions/        # Capa de preguntas para validación (Ej: TheResponse.statusCode)
└── test/java/
    └── stepdefinitions/  # Clases de unión entre Gherkin y el código Java (Steps)
└── test/resources/
    └── features/         # Archivos .feature con la descripción de los escenarios (Gherkin)
 
## Configuración del Entorno (Local)Clonar el Repositorio:Bash

git clone https://github.com/contrerasderly/sofka_automation_exercise.git
cd sofka_automation_exercise

Instalar Dependencias: Gradle se encarga de esto automáticamente. Asegúrate de tener Java 17 o superior instalado.

## Ejecución de Pruebas
Todas las pruebas se ejecutan utilizando el Gradle Wrapper (./gradlew). Usamos Tags de Cucumber para filtrar las suites.

## Ejecución Local (Web o API)

API Suite       =    ./gradlew clean test -Ptags="@api"
Web Suite       =    ./gradlew clean test -Ptags="@ui"
Todas           =    ./gradlew clean test -Denvironment=dev

## Abrir el reporte de Serenity

open target/site/Serenity/index.html