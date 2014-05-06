SRC=src/*.java
JC=javac
NAME=PhysicsLab
all: 
	$(JC) $(SRC)
	mkdir -p bin/
	mv src/*.class bin/
	mkdir -p res/
clean:
	rm -f src/*.class

run:
	java -classpath bin/ $(NAME)
