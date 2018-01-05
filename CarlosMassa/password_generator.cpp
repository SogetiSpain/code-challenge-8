#include "password_generator.hpp"
#include "characters.hpp"

void PasswordGenerator::write_password_bt(){
    if(passwords_holder.size() < number_of_passwords) {
        string password = "";
        cout << passwords_holder.size()+1 << ": ";
        For(i, Sz(used_chars))
            if(used_chars[i]) {
                cout << result[i];
                password += result[i];
            }
        cout << endl;
        passwords_holder.push_back(password);
    }
}

void PasswordGenerator::generate_bt(int i) {
    if(passwords_holder.size() == number_of_passwords) return;
    else if(i==password_length) write_password_bt();
    else{
        For(j, password_length) {
            if(!used_chars[j]){
                result[j]=candidate_chars[i];
                used_chars[j]=true;
                generate_bt(i+1);
                used_chars[j]=false;
            }
        }
    }
}

void PasswordGenerator::generate_random_password_chars(){
    int current_letters = 0;
    int current_special = 0;
    int current_numbers = 0;

    // Fill candidate chars with pattern if not empty and count unassigned chars
    int wildcards = 0;
    int threshold = this->password_length; // Maximum chars left to asign
    if(!this->pattern.empty()) {
        For(i, Sz(pattern)) {
            if(pattern[i]!='*') candidate_chars[i] = pattern[i];
            else ++wildcards;
        }
        threshold = wildcards; // Change maximum to the number of wildcards left
    }

    int pos = get_random_number(0, candidate_chars.size()-1);
    For(current_length, threshold) {
        while(candidate_chars[pos]!='*') // Get a position without character assigned
            pos = get_random_number(0, candidate_chars.size()-1);

        if(current_letters != threshold - special_chars - numbers) {
            char letter = get_random_char(password_characters.letters);

            if(get_random_number(0,1))
                letter = toupper(letter);

            // Check if exists a letter substitution by number
            char letter_substitution = substitutions.find(toupper(letter))->second;
            if(letter_substitution && get_random_number(0,1) && current_numbers != numbers) {
                letter = letter_substitution;
                ++current_numbers;
            }
            else {
                ++current_letters;
            }
            candidate_chars[pos] = letter;
        }
        else if(current_special != special_chars) {
            candidate_chars[pos] = get_random_char(password_characters.special);
            ++current_special;
        }
        else if(current_numbers != numbers) {
            candidate_chars[pos] = get_random_char(password_characters.numbers);
            ++current_numbers;
        }
    }
}

PasswordGenerator::PasswordGenerator(int password_length, int special_chars, int numbers, int number_of_passwords, string pattern) {
    if(pattern.empty()) { // Increase lenght of password randomly from the minimum
        password_length += get_random_number(0, PASSWORD_LENGTH_DEVIATION);
    }
    this->password_length = password_length;
    this->special_chars = special_chars;
    this->numbers = numbers;
    this->number_of_passwords = number_of_passwords;
    this->pattern = pattern;
    this->candidate_chars = Vc(password_length,'*');
    this->result = Vc(password_length);
    this->used_chars = Vb(password_length);
}

Vs PasswordGenerator::generate_passwords(bool use_backtracking) {
    this->passwords_holder = Vs(0);
    if(use_backtracking) {
        generate_random_password_chars(); // Generate random password population
        generate_bt(0); // Start backtracking to generate more passwords
    }
    else {
        while(passwords_holder.size() < number_of_passwords) {
            generate_random_password_chars();
            string password = "";
            password = accumulate(begin(candidate_chars), end(candidate_chars), password);
            cout << passwords_holder.size()+1 << ": " << password << endl;
            passwords_holder.push_back(password);
            this->candidate_chars = Vc(this->password_length,'*'); // Reset candidate password
        }
    }
    return this->passwords_holder;
}
