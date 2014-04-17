SRC=src/*.java
JC=javac
NAME=PhysicsLab
all: 
	$(JC) $(SRC)

clean:
	rm -f src/*.class

run:
	java -classpath src/ $(NAME)
