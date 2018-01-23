using CodeChallenge8.PasswordGenerator.Generator;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CodeChallenge8.PasswordGenerator
{
    class Program
    {
        static void Main(string[] args)
        {
            var minLength = GetNumericValueFromConsole("What's the minimum length?");
            var numberSpecialCharacters = GetNumericValueFromConsole("How many special characters?");
            var howManyNumbers = GetNumericValueFromConsole("How many numbers?");


            var passwordGenerationCriteria = new PasswordGenerationCriteria()
            {
                MinimumLength = minLength,
                NumbersQuantity = howManyNumbers,
                SpecialCharactersQuantity = numberSpecialCharacters
            };

            IPasswordGenerator generator = new SimplePasswordGenerator();
            var password = generator.GetPassword(passwordGenerationCriteria);

            Console.WriteLine("Your password is:");
            Console.WriteLine(password);

            Clipboard.SetText(password);
            Console.ReadLine();
        }

        private static int GetNumericValueFromConsole(string promptText)
        {
            var numericValueString = String.Empty;
            do
            {
                Console.WriteLine(promptText);
                numericValueString = Console.ReadLine();
            } while (!IsNumericValue(numericValueString));
            return Int32.Parse(numericValueString);
        }

        private static bool IsNumericValue(string numericString)
        {
            if(numericString == String.Empty)
            {
                return true;
            }
            int conversionTarget = 0;
            return Int32.TryParse(numericString, out conversionTarget);
        }
    }
}
