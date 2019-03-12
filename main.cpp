//==================================================================
// File			: main.cpp
// Author		: Miles McCall, Sultan Alanazi
// Date			: March 15, 2019
// Description	: TSP Algorithm
//==================================================================

#include <iostream>
#include <fstream>
#include <string>
#include <stdlib.h> // exit, EXIT_FAILURE
using namespace std;

// Class Creation
class TSP_obj {
  public:
  // Data Members
  Struct City {
    int x, y;
  };
  vector <City> cities; // vector containing city structs for each line
  int city_count // total nodes

  //Default Constructor
  TSP_obj() {
      cout << "Default Constructor called" << endl;
  }

  // Member Functions()
  void print_count() {
     cout << "total nodes: " << city_count << endl;
  }
};


// Function Creation

string check_cmd_line(int argc, char** argv) {
  // The last command line arg will be the input file

  // Error check for input file included in cmd line
  if (argc < 2) {
    cout << "Too few command line args present, "
         << "please include input file name after \'tsp\'\n";
    exit(-1);
  }

  // Return the last argument, input file name
  return argv[argc-1];
}

/* parse_input reads the input file,
  counts total number of cities,
  and inputs easy row as a city struct

*/
void parse_input(string in_file, TSP_obj& tsp) {
  cout << "Input file parser...\n";
  // Vars
  int count = 0;
  string line;
  ifstream file (in_file.c_str());

  //Read in file
  if (file.is_open()) {
    while ( getline (file,line) ) {
      cout << line << '\n';

      tsp.push_back(other_numbers);
      count++;
    }
    file.close();
  }
  else cout << "Unable to open file";

  // Process values


  return;
}

void gen_output(string in_file) {
  cout << "Output file writer...\n";
  // Vars
  string out_name;
  out_name = "outputs/" + in_file + ".route";
  cout << out_name << "\n";

  // Write to file
  ofstream out_file(out_name.c_str());
    out_file << "~~ test line ~~" << endl;
    out_file.close();

  return;
}

int main (int argc, char** argv) {
  // Command line args
  string input_file = check_cmd_line(argc, argv);

  // Create TSP objct to collect values
  TSP_obj tsp = tsp();

  // file input
  parse_input(input_file, &tsp);

  // file output
  gen_output(input_file);

  return 0;
}
