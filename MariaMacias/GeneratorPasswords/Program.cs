using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GeneratorPasswords
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("What's the minimum length? ");
            int minLength = Int32.Parse(Console.ReadLine());

            Console.WriteLine("How many special characters? ");
            int specialCharacters = Int32.Parse(Console.ReadLine());

            Console.WriteLine("How many numbers ? ");
            int numbers = Int32.Parse(Console.ReadLine());

            string password = "";

            password = generatorSecurePassword(minLength, specialCharacters, numbers);

            password = password.Replace('a', '4');
            password = password.Replace('A', '4');
            password = password.Replace('e', '3');
            password = password.Replace('E', '3');

            Console.WriteLine("Your password is: ");
            Console.WriteLine(password);

            Console.WriteLine("Press any key to continue... ");
            Console.ReadLine();
        }

        public static string generatorSecurePassword(int minLength, int specialCharacters, int numbers)
        {
            const string LETTERS_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            const string NUMERIC_CHARACTERS = "0123456789";
            const string SPECIAL_CHARACTERS = @"!#$%&*@\";

            string characterSet = LETTERS_CHARACTERS;
            string characterNumbersSet = NUMERIC_CHARACTERS;
            string specialCharacterSet = SPECIAL_CHARACTERS;

            List<char> password = new List<char>();
            System.Random random = new System.Random();
            int maxLength = minLength + 3;
            for (int i = 0; i < maxLength-numbers-specialCharacters; i++)
            {
                password.Insert(i, characterSet[random.Next(0, (characterSet.Length - 1))]);
            }
            if (numbers > 0)
            {
                for (int i = numbers; i > 0; i--)
                {
                    password.Insert(i, characterNumbersSet[random.Next(0, characterNumbersSet.Length - 1)]);
                }
                
            }
            if (specialCharacters > 0)
            {
                for (int i = specialCharacters; i > 0; i--)
                {
                    password.Insert(i, specialCharacterSet[random.Next(0, specialCharacterSet.Length - 1)]);
                }
            }            
            return new string(password.ToArray());
        }
    }
}
