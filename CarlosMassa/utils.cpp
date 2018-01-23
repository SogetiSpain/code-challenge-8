#include "utils.hpp"

void copy_to_clipboard(const string &s){
	#ifdef _WIN32
		HWND hwnd = GetDesktopWindow();
		OpenClipboard(hwnd);
		EmptyClipboard();
		HGLOBAL hg=GlobalAlloc(GMEM_MOVEABLE,s.size()+1);
		if (!hg){
			CloseClipboard();
			return;
		}
		memcpy(GlobalLock(hg),s.c_str(),s.size()+1);
		GlobalUnlock(hg);
		SetClipboardData(CF_TEXT,hg);
		CloseClipboard();
		GlobalFree(hg);
	#elif __APPLE__ || __linux__
		stringstream cmd;
		cmd << "echo \"" << s.c_str() << "\" | pbcopy";
		system(cmd.str().c_str());
	#else
		// Unknown
	#endif

}

int get_random_number(int min, int max) {
    random_device rd;
    mt19937 eng(rd());
    uniform_int_distribution<> distr(min, max);
    return distr(eng);
}

char get_random_char(list<char const*> char_list) {
    auto it = char_list.begin();
    std::advance(it, get_random_number(0, char_list.size()-1));
    return **it;
}

ULL factorial(ULL n) {
    if(n==0) return 1;
	return n * factorial(n - 1);
}
