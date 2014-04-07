
SRC=src/*.java
JC=javac
NAME=Tarea1

all: 
	$(JC) $(SRC)

clean:
	rm -f src/*.class

run:
	java -classpath src/ $(NAME)
