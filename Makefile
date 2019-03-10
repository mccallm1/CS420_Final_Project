make all: 
	g++ -c main.cpp
	#g++ -c multiply.cpp
	g++ -o tsp main.o #multiply.o
