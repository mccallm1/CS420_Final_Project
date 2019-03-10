// reading a text file
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

void gen_output(string in_file) {
  // Vars
  string out_name;
  out_name = "outputs/" + in_file + ".route";
  cout << out_name << "\n";

  // Write to file
    //ofstream out_file (out_name);
    //out_file << "~~ test line ~~" << endl;
    //out_file.close();

  return;
}

int main (int argc, char** argv) {
  // command line args (input file)
  /*
  cout << argc << " arguments:" << "\n";
  for (int i = 0; i < argc; ++i)
        cout << argv[i] << "\n";
  */
  cout << "start\n";
  string input_file = argv[argc];
  cout << "in:\t" + input_file << "\n";

  // file input
  /*
  string line;
  ifstream myfile (input_file);
  if (myfile.is_open()) {
    while ( getline (myfile,line) ) {
      cout << line << '\n';
    }
    myfile.close();
  }
  else cout << "Unable to open file";
  */

  // file output
  gen_output("tsp_example_1.txt");
  cout << "end\n";
  return 0;
}
