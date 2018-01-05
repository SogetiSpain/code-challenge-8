#include<list>
#include<map>
using namespace std;

#ifndef _CHARACTERS_HPP_
#define _CHARACTERS_HPP_

struct characters {
	list<const char*> letters = { "a","b","c","d","e","f","g","h","i","j","l","k","m","n","o","p","q","r","s","t","v","w","x","y","z" };
	list<const char*> special = { "!","#","$","&","\'","(",")","*","+",",","-",".","/",":",";","<","=",">","?","@","[","]","^","_","`","{","|","}","~"};
	list<const char*> numbers = { "0","1","2","3","4","5","6","7","8","9" };
} password_characters;

map<char, char> substitutions = {
    {'A', '4'},
    {'E', '3'},
    {'I', '1'},
    {'O', '0'},
};

#endif
