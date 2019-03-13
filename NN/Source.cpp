#include "city.h"
#include "algorithms.h"
#include <iostream>
#include <deque>
#include <cstdlib>
#include <ctime> 
using namespace std;

int main(int argc, char * argv[])
{
	srand(time(0));

	tsp test("example.tex");              // read in command line input argv[1]
	test.nearest_neighbor();        // run nearest neighbor function
	return 0;
}