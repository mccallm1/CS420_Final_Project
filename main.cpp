// reading a text file
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

void gen_output(string in_file) {
  string out_name = "outputs/" + in_file + ".route";
  ofstream out_file (out_name);

  if (out_file.is_open()) {
    out_file << "This is a line.\n";
    out_file << "This is another line.\n";
    out_file.close();
  }
  else cout << "Unable to open file";

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
