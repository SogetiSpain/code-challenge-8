#ifndef _PASSWORD_GENERATOR_HPP_
#define _PASSWORD_GENERATOR_HPP_

#include <iostream>
#include <vector>
#include <string>
#include <list>
#include <time.h>
#include <climits>
#include "utils.hpp"
using namespace std;

// Maximum deviation from the minimum length specified for a password
const int PASSWORD_LENGTH_DEVIATION = 5;

class PasswordGenerator {
	private:
		int password_length;
		int special_chars;
		int numbers;
		int number_of_passwords;
        string pattern;
	 	Vc candidate_chars;
		Vs passwords_holder;

		// Variables used for backtracking
		Vc result;
		Vb used_chars;

		void write_password_bt();
		void generate_bt(int i);
		void generate_random_password_chars();

	public:
		PasswordGenerator(int password_length, int special_chars, int numbers, int number_of_passwords, string pattern);
		Vs generate_passwords(bool use_backtracking);
};

#endif
