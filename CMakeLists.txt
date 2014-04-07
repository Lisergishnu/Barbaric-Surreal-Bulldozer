#Basado en http://stackoverflow.com/questions/18985726/cmake-to-compile-java-code
cmake_minimum_required (VERSION 2.8)

find_package(Java REQUIRED)
include(UseJava)

project (Tarea1)

set(CMAKE_JAVA_COMPILE_FLAGS  "-source" "1.6" "-target" "1.6")

add_jar(Tarea1 
	src/Ball.java
	src/MyWorld.java
	src/PhysicsElement.java
	src/PhysicsLab.java)

get_target_property(_jarFile Tarea1 JAR_FILE)
get_target_property(_classDir Tarea1 CLASSDIR)

message(STATUS "Jar file ${_jarFile}")
message(STATUS "Class compiled to ${_classDir}")

add_test(NAME TestTarea1 COMMAND ${Java_JAVA_EXECUTABLE} -cp ${_jarFile} Tarea1)