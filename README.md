# Mars Rover Image Links Viewer

Este proyecto es una aplicación Java Swing que permite a los usuarios buscar y ver enlaces a las imágenes
capturadas por el rover Curiosity en Marte utilizando la API de fotos de Mars Rover de la NASA.

## Requisitos

- JDK 21 o superior
- Apache Maven
- Conexión a Internet para acceder a la API de la NASA

## Instalación

1. Clona el repositorio:
    ```bash
    git clone https://github.com/tuusuario/mars-rover-viewer.git
    cd mars-rover-viewer
    ```

2. Compila el proyecto usando Maven:
    ```bash
    mvn clean install
    ```

3. Ejecuta la aplicación:
    ```bash
    java -cp target/classes:target/dependency/* main.Main
    ```

## Estructura del Proyecto

- `main.Main`: Clase principal que inicializa la vista.
- `view.MarsRoverView`: Clase que maneja la interfaz gráfica de usuario (GUI).
- `service.MarsRoverService`: Clase que maneja la lógica para llamar a la API de Mars Rover.
- `models.Photo`: Modelo que representa una foto obtenida de la API.
- `models.ApiResponse`: Esta clase es un modelo que representa la respuesta de la API de Mars Rover. Contiene una lista de objetos `Photo` que representan las fotos devueltas por la API.
- `models.Camera`: Esta clase es un modelo que representa una cámara específica del rover. Incluye propiedades como el ID de la cámara, el nombre, el ID del rover y el nombre completo de la cámara.
- `models.Photo`: Esta clase es un modelo que representa una foto obtenida de la API de Mars Rover. Contiene propiedades como la URL de la imagen, el identificador de la cámara, y otros metadatos.
- `models.Rover`: Esta clase es un modelo que representa un rover. Incluye propiedades como el ID del rover, el nombre, la fecha de aterrizaje, la fecha de lanzamiento, el estado, el máximo sol (día marciano), la fecha máxima, el total de fotos y una lista de cámaras asociadas al rover.

- ## Uso

1. Introduce el nombre de la cámara, el sol (día marciano), y/o la fecha terrestre en los campos de entrada.
2. Haz clic en el botón "Generate".
3. Los enlaces a las imágenes se mostrarán en el área de texto.

## Ejemplo

Introduce los siguientes valores en los campos de entrada:

- **Camera**: FHAZ
- **Sol**: 1000
- **Earth Date**: 2015-05-30

Luego, haz clic en "Generate". Los enlaces de las imágenes capturadas por la cámara Front Hazard Avoidance Camera (FHAZ) del rover Curiosity en el sol 1000 o en la fecha terrestre 2015-05-30 se mostrarán en el área de texto.

## Notas

- El API_KEY utilizado es `DEMO_KEY`. Para un uso más intensivo, se recomienda obtener tu propia clave API de la NASA [aquí](https://api.nasa.gov/).
- En caso de recibir un error 429 (Too Many Requests), es posible que hayas alcanzado el límite de tasa de la API. Intenta nuevamente después de un tiempo o usa una clave API diferente.

## Contribuir

Las contribuciones son bienvenidas. Por favor, sigue los pasos a continuación para contribuir:

1. Haz un fork del repositorio.
2. Crea una rama nueva (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva funcionalidad'`).
4. Envía tus cambios (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.




