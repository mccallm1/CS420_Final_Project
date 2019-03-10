make tsp_input:
	tsp inputs/example.txt

make clean:
	rm -rf *.o
	rm -rf tsp

make all:
	g++ -c main.cpp
	#g++ -c multiply.cpp
	g++ -o tsp main.o #multiply.o
