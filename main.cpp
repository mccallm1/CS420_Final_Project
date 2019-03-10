// reading a text file
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

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

void parse_input(string in_file) {
  cout << "Input file parser...\n";
  // Vars
  string line;
  ifstream file (in_file);

  //Read in file
  if (file.is_open()) {
    while ( getline (file,line) ) {
      cout << line << '\n';
    }
    file.close();
  }
  else cout << "Unable to open file";

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

  // file input
  parse_input(input_file);

  // file output
  gen_output(input_file);

  return 0;
}
