# TIMA App Móvil

TIMA es una aplicación Android de alarmas inteligentes orientada al ejercicio. La idea es simple: cuando suena la alarma, el usuario tiene que completar un reto físico antes de poder apagarla. Sin hacer el ejercicio, no hay forma de silenciarla.

El proyecto es el resultado de un proceso de diseño centrado en el usuario dentro del marco de la Maestría en Ingeniería de Software de la Universidad de los Andes. Este repositorio contiene la implementación del prototipo funcional de alta fidelidad basado en los mockups propuestos.

## Diseño

Los mockups y el design system están en Figma:
https://www.figma.com/design/Q9S1zuZBzFoge33RfSjd96/Design-kit---Design-System---TIMA?node-id=60994-1045&p=f&t=dIgwHyfrQOobxGU4-0

## APK

El instalador está disponible en:
https://github.com/JuanJoseRestrepo33/Angular-MockUp/blob/main/apk_v1/TimaApp.apk

Para instalar hay que habilitar "Instalar aplicaciones de fuentes desconocidas" en los ajustes del dispositivo.

## Mockups implementados

Se implementaron las 16 pantallas del flujo completo propuesto en los mockups:

**Onboarding y sincronización de reloj**

Al abrir la app, el usuario puede conectar su smartwatch (Apple Watch, Huawei, Polar, Samsung o Garmin) o continuar sin uno. Se muestra una pantalla de carga durante la sincronización y una confirmación al terminar.

**Configuración de la alarma**

El usuario selecciona la hora con un selector personalizado de hora, minutos y AM/PM. También puede activar o desactivar sonido y vibración.

**Creación del reto**

Aquí se define el desafío que habrá que completar al despertar. Hay tres tipos:

- Ejercicios físicos: el usuario elige entre abdominales, burpees, sentadillas o flexiones, y define la cantidad
- Frecuencia cardíaca: se configura un BPM objetivo y un BPM de ritmo de entrenamiento
- Ubicación y pasos: se define una cantidad de pasos y una zona geográfica con radio de validación

**Confirmación y retroalimentación**

Una vez configurada la alarma, se muestra un resumen con todos los detalles. Al completar el reto, se despliega una pantalla de logro con las estadísticas de la sesión.

**Sincronización en la nube**

El flujo incluye pantallas de inicio de sesión (Google / Apple) y sincronización de datos en la nube para guardar el historial del usuario.

## Stack

- Android nativo con Kotlin
- Activities con layouts XML (View system)
- Material Design 3
- minSdk 24 (Android 7.0)

## Requisitos para correr el proyecto

- Android Studio Hedgehog o superior
- JDK 8
- Android SDK 34
