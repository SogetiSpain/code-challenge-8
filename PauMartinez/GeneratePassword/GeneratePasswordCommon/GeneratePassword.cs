using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GeneratePasswordCommon
{
    public class GeneratePassword
    {
        private const string SPECIAL_CHARACTERS = "!@#$%^&*()_-+=[{]};:<>|./?";
        private const string NUMBERS = "0123456789";
        private const string LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        private const string LETTERS_TRANSFORM = "4BCD3FGH1JKLMN0PQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        //This number makes it every call of the create function an entirelly new rnd seed
        private int k = 1;

        public string Create(int length, int specialChars, int numbers, bool transformVowels = false)
        {
            string letters = LETTERS;
            if (transformVowels) letters = LETTERS_TRANSFORM;

            string ret = "";

            int chars = length - specialChars - numbers;
            while (chars + specialChars + numbers > 0)
            {
                Random rng = new Random((int) ((length*k+chars*k*100+specialChars*k*1000+numbers*10000)*DateTime.Now.Ticks));
                int n = rng.Next(1, 4);
                while ((chars == 0 && n == 1) || (numbers == 0 && n == 2) || (specialChars == 0 && n == 3))
                {
                    n = rng.Next(1, 4);
                }
                int m;
                switch(n)
                {
                    case (1):
                        m = rng.Next(0, letters.Length);
                        ret += letters[m];
                        chars--;
                        break;
                    case (2):
                        m = rng.Next(0, NUMBERS.Length);
                        ret += NUMBERS[m];
                        numbers--;
                        break;
                    case (3):
                        m = rng.Next(0, SPECIAL_CHARACTERS.Length);
                        ret += SPECIAL_CHARACTERS[m];
                        specialChars--;
                        break;
                    default:
                        break;
                }
            }

            k++;
            return ret;
        }
    }
}
