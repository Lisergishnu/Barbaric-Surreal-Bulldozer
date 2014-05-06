Barbaric Surreal Bulldozer (Tarea 1)
====================================

Introducción
------------

Esta es la primera tarea del ramo Programación Orientada a Objetos 2014-1. En *documentacion.pdf* se pueden encontrar los gráficos de los resultados de las etapas y en cada una de las carpetas de etapa hay un Makefile para generar la aplicación correspondiente.

Observaciones
-------------

- La aplicación genera una tabla separada por *tabs*. A pesar de ésto, se usa por convención la descripción CSV para ésta.
- Para la versión por etapas, se debe correr el programa desde la carpeta bin/. Esto es por que hacia el final del desarrollo de la tarea se implementó mejor la canalización de los *PrintStream* en la aplicación.
- El programa tiene un modo interactivo: para acceder a él basta con ejecutar el programa sin argumentos.
	- En este modo el programa entrega la simulación por pantalla, pero también la escribe a un archivo CSV (por defecto, 'res/output.csv').
	- La motivación es que hacer una redireción directa de la salida desde este modo trae inconsistencias con el formato CSV por la información desplegada en la consola previa a la simulación.
	- Este es el modo por defecto cuando se corre desde el Makefile mediante *run*.
- Cuando la aplicación se ejecuta directamente por la consola con argumentos, ésta muestra en pantalla directamente la simulación, con el proposito de facilitar la redirección de esta información hacia un archivo CSV.

Compilando y corriendo
--------------------

**(Metodo necesario para las etapas)**

	$ make
	$ cd bin/
	$ java PhysicsLab 0.0001 20 0.1 > ../res/output.csv

Alternativamente:  

	$ make && make run
