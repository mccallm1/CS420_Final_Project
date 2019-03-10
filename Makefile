tsp:
	tsp inputs/example.txt

clean:
	rm -rf *.o
	rm -rf tsp

all:
	g++ -c main.cpp
	#g++ -c multiply.cpp
	g++ -o tsp main.o #multiply.o
