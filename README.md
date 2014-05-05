Barbaric Surreal Bulldozer
==========================

Introducción
------------

Esta es la primera tarea del ramo Programación Orientada a Objetos 2014-1. 

Observaciones
-------------

- La aplicación genera una tabla separada por *tabs*. A pesar de ésto, se usa por convención la descripción CSV para ésta.
- El programa tiene un modo interactivo: para acceder a él basta con ejecutar el programa sin argumentos.
	- En este modo el programa entrega la simulacion por pantalla pero también la escribe a un archivo CSV (por defecto, 'res/output.csv').
	- La motivación es que hacer una redireción directa de la salida desde este modo trae inconsistencias con el formato CSV por la información desplegada en la consola previa a la simulación.
	- Este es el modo por defecto cuando se corre desde el Makefile
- Cuando la aplicación se ejecuta directamente por la consola con argumentos, ésta muestra en pantalla directamente la simulación, con el proposito de facilitar la redirección de esta información hacia un archivo CSV.

Compilando y corriendo
--------------------

	$ make && make run

#Alternativamente

	$ make
	$ cd bin/
	$ java PhysicsLab [Argumentos]