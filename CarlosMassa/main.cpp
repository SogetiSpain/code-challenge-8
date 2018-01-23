#include "password_generator.hpp"
#include<vector>
#include<string>
#include "defaults.hpp"
using namespace std;

void check_password_details(int &password_length, int &special_chars, int &numbers) {
	if(password_length <= 0) {
		cout << "password length must be higher than 0, changing it to " << DEFAULT_LENGTH << endl;
		password_length = DEFAULT_LENGTH;
	}
	if(special_chars < 0) {
		cout << "special characters number must be equal or higher than 0, changing it to " << DEFAULT_CHARS << endl;
		special_chars = DEFAULT_CHARS;
	}
	if(numbers < 0) {
		cout << "quantity of numbers must be equal or higher than 0, changing it to " << DEFAULT_NUMBERS << endl;
		numbers = DEFAULT_NUMBERS;
	}
}

int main(int argc, char* argv[]) {

	// Get password details
	int password_length, special_chars, numbers;
	cout << "What's the minimum length? "; 	 cin >> password_length;
 	cout << "How many special characters? "; cin >> special_chars;
	cout << "How many numbers? "; 			 cin >> numbers;
	check_password_details(password_length, special_chars, numbers);

	// Increase password minimum size if special chars + numbers are higher than the maximum size
	if(special_chars + numbers > password_length) {
		cout << "[Info] Special characters and/or numbers higher than the specified minimum length ";
		password_length += (special_chars + numbers) - password_length;
		cout << "changing minimum length to " << password_length << endl;
	}

	// Pattern matching
	char has_pattern = 'n';
	cout << "Do you want your password to follow a pattern (y/n)? "; cin >> has_pattern;
	has_pattern = tolower(has_pattern);

	// Guarantee that pattern matches password size
	string pattern = "";
	if(has_pattern == 'y') {
		while(pattern.size()!=password_length) {
			cout << "Specify the pattern (f.ex **ab**): ";
			cin >> pattern;
		}
	}

	// Get minimum passwords
	int number_of_passwords;
	int minimum = factorial(password_length);
	cout << "With the details provided a minimum of ";
	if (minimum <= 0)
		cout << ">" << ULLONG_MAX;
	else
		cout << minimum;
	cout << " can be generated." << endl;
	cout << "How many passwords do you want (default: 1)? " ; cin >> number_of_passwords;

	// Select multiple password generation strategy
	bool use_backtracking = 0;
	if(number_of_passwords <= 0) number_of_passwords = 1;
	else if(number_of_passwords > 1) {
		cout << "Which strategy do you want to follow to generate multiple passwords?" << endl;
		cout << "[0: random per generation (default)/ 1: backtracking]: "; cin >> use_backtracking;
	}

	// Print password generation characteristics
	cout << endl;
	cout << "Generating " << number_of_passwords << " password/s with the following characteristics:" << endl;
	cout << "\t- Minimum length: " << password_length << endl;
	cout << "\t- Special chars: " << special_chars << endl;
	cout << "\t- Numbers: " << numbers << endl << endl;

	// Generate passwords
	clock_t start = clock();
	cout << "Your password/s is/are:" << endl;
	PasswordGenerator generator(password_length, special_chars, numbers, number_of_passwords, pattern);
	vector<string> passwords = generator.generate_passwords(use_backtracking);
	printf("Time taken generating (%i passwords): %.2fs\n", (int) passwords.size(), (double)(clock() - start)/CLOCKS_PER_SEC);

	// Copy to clipboard first generated password
	if(passwords.size() > 0 && !passwords[0].empty()) {
		copy_to_clipboard(passwords[0]);
		cout << "Password copied to clipboard!" << endl;
	}

}
