//==================================================================
// File			: main.cpp
// Author		: Miles McCall, Sultan Alanazi, Austin Sanders
// Date			: March 15, 2019
// Description	: TSP Algorithm
//==================================================================

#include <iostream>
#include <fstream>
#include <string>
#include <stdlib.h> // exit, EXIT_FAILURE
// String parsing
#include <boost/algorithm/string.hpp>

using namespace std;

// Class Creation
class TSP_obj {
  private:
    // Data Members
    /* One method of storing city coords
      Struct City {
        int x, y;
      };
      vector <City> cities; // vector containing city structs for each line
    */
    vector<int> city_x;
    vector<int> city_y;
    int city_count // total nodes

  public:
    //Default Constructor
    TSP_default() {
        cout << "Default Constructor called" << endl;
    }

    // Member Functions()
      // Gets and Sets
        void set_city_count(int val){
          city_count = val;
        }

        void inc_city_count(){
          city_count++;
        }


        void append_x(int val) {
          city_x.push_back(val);
        }

        void append_y(int val) {
          city_y.push_back(val);
        }

        void append_city(int val_x, int val_y) {
          city_x.push_back(val_x);
          city_y.push_back(val_y);
        }

        void print_count() {
          cout << "total nodes: " << city_count << endl;
        }

        void print_cities() {
          cout << "|node\t|x\t|y|"
          for (int i = 0; i < city_count; i++) {
            cout << "|" << i << "\t|" << city_x << "\t|" << city_y << "|\n";
          }
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
      // print input
        cout << line << '\n';

      // separate string into values
        vector<string> values;
        boost::split(values, line, boost::is_any_of("\t "));

      // append values to city vectors
        tsp.append_city(values[1],values[2]);

      // increment city count
        tsp.inc_city_count();
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
    TSP_obj tsp = TSP_obj(); //TSP_default();

  // file input
    parse_input(input_file, tsp);

  // verify input
    tsp.print_count();
    tsp.print_cities();

  // file output
    //gen_output(input_file);

  return 0;
}
