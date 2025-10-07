<div align="center">

# 🧩 Proyecto: Procesamiento de Ficheros con Procesos en Java

![Java](https://img.shields.io/badge/Java-17+-red?style=flat-square&logo=openjdk)
![Status](https://img.shields.io/badge/Estado-Completado-blue?style=flat-square)
![Author](https://img.shields.io/badge/Autor-Omar%20Torres-lightgrey?style=flat-square)

</div>

---

Este proyecto implementa un sistema de procesamiento de ficheros mediante **procesos independientes en Java**, simulando un modelo **padre-hijo**.  
Cada fichero se procesa en un proceso hijo que genera salidas y resultados individuales.

---

## ⚙️ Estructura del proyecto

- **App.java** → Programa main, lanza el proceso padre (`PadreProcesos`).
- **PadreProcesos.java** → Gestiona los ficheros de entrada, crea un proceso hijo por cada fichero válido y recopila los resultados.
- **Hijo.java** → Procesa un fichero concreto, generando versiones en minúsculas y contando el número total de vocales.
- **Ficheros.java** → Clase auxiliar para operaciones de lectura, escritura y borrado de ficheros.
- **Vocales.java** → Contiene el método para contar el total de vocales dentro de un conjunto de palabras.

---

## 🧠 Funcionamiento general

1. **App** ejecuta el proceso padre (`PadreProcesos`), que llamará a la clase hijos para ejecutar un proceso por cada fichero.
2. **PadreProcesos**:
   - Elimina ficheros `.res` o `.txt` antiguos para evitar errores.
   - Busca ficheros con nombre `datosX.txt` en la carpeta `/ficheros`.
   - Lanza un proceso (`Hijo`) por cada fichero válido.
3. **Hijo**:
   - Lee el contenido del fichero recibido.
   - Crea un archivo `minusculasX.res` con todas las palabras en minúsculas.
   - Calcula el número total de vocales y lo guarda en `vocalesX.res`.
4. **Vocales**:
   - Tiene el método de conteo de vocales, y en un futuro se pueden añadir más funciones sobre las que trabajar.
5. **Ficheros**:
   - Contiene métodos para leer y almacenar palabras, escribir en un archivo, pasar las letras a minúsculas, borrar ficheros antiguos, etc.
6. Al finalizar todos los hijos, **PadreProcesos** suma todos los resultados y guarda el total global de vocales en `totalVocales.res`.

---

## 🧾 Notas adicionales

📂 Los ficheros `.res` y `.txt` antiguos se eliminan automáticamente al iniciar el programa.  
🧱 La estructura del proyecto está diseñada para permitir añadir fácilmente nuevos tipos de análisis o funciones.  
💡 Ideal para practicar la gestión de procesos, E/S de ficheros y modularidad en Java.

---

## ♿ Documentación:  
- La documentación generada con **Javadoc** se encuentra en la carpeta `/javadoc/index.html`.  
- Ahí se puede consultar toda la documentación de clases, métodos y atributos del programa.

- La documentación tecnica esta dentro de  `/Documentacion/DocumentacionPrograma.pdf` en formato pdf.
---

<div align="center">

**© 2025 - Omar Torres**  
_Proyecto académico en Java_

</div>


<!-- ![Status](https://img.shields.io/badge/Estado-En%20Desarrollo-blue?style=flat-square) -->
