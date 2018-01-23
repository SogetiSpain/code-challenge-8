#include<iostream>
#include <assert.h>
#include<regex>
#include<string>
#include "../password_generator.hpp"
using namespace std;

void test_simple_generation() {
    PasswordGenerator generator(10, 0, 0, 2, "");
    vector<string> passwords = generator.generate_passwords(0);
    assert(passwords.size()==2);
}

void test_simple_generation_backtracking() {
    PasswordGenerator generator(10, 0, 0, 2, "");
    vector<string> passwords = generator.generate_passwords(1);
    assert(passwords.size()==2);
}

void test_password_length_deviation() {
    int deviation = 5; // Max deviation from the minimum length
    int password_length = 10;
    PasswordGenerator generator(password_length, 0, 0, 1, "");
    vector<string> passwords = generator.generate_passwords(1);
    assert(passwords[0].size() >= password_length && passwords[0].size() <= password_length + deviation );
}

void test_generation_with_pattern_and_numbers() {
    string pattern = "test******";
    PasswordGenerator generator(10, 0, 3, 10, pattern);
    vector<string> passwords = generator.generate_passwords(0);
    regex e("test[a-zA-Z0-9]{6}");
    for(int i=0;i<passwords.size();++i){
        assert(regex_match(passwords[i],e));
    }
}

int main(int argc, char* argv[]) {
    cout << "======= test_simple_generation =======" << endl;
    test_simple_generation();
    cout << endl;

    cout << "======= test_simple_generation_backtracking =======" << endl;
    test_simple_generation_backtracking();
    cout << endl;

    cout << "======= test_password_length_deviation =======" << endl;
    test_password_length_deviation();
    cout << endl;

    cout << "======= test_generation_with_pattern_and_numbers =======" << endl;
    test_generation_with_pattern_and_numbers();
    cout << endl;
}
