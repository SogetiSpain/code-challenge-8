#ifndef _UTILS_HPP_
#define _UTILS_HPP_

#include <list>
#include <algorithm>
#include <random>
#ifdef _WIN32
	#include <Windows.h>
	#include <winuser.h>
#endif
#include <sstream>
using namespace std;

// Functions
#define Sz(x) ((int) (x).size())
#define For(i,n) for (int i = 0; i < int(n); ++i)

// Type definitions
typedef vector<string> Vs;
typedef vector<bool> Vb;
typedef vector<char> Vc;
typedef unsigned long long ULL;

void copy_to_clipboard(const string &s);
int get_random_number(int min, int max);
char get_random_char(list<char const*> char_list);
ULL factorial(ULL n);

#endif
