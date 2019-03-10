// reading a text file
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

void gen_output(string in_file) {
  // Vars
  string out_name;
  out_name = "outputs/" + in_file + ".route";

  // Write to file
  ofstream out_file (out_name);
  out_file << "~~ test line ~~" << endl
  out_file.close();

  return;
}

int main (int argc, char** argv) {
  // command line args (input file)
    cout << "You have entered " << argc << " arguments:" << "\n";
    for (int i = 0; i < argc; ++i)
          cout << argv[i] << "\n";

  // file i/o
    string line;
    ifstream myfile ("inputs/example.txt");
    if (myfile.is_open()) {
      while ( getline (myfile,line) ) {
        cout << line << '\n';
      }
      myfile.close();
    }
    else cout << "Unable to open file";

  return 0;
}
