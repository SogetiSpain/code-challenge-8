using GeneratePasswordCommon;
using System;
using System.Windows;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GeneratePasswordConsole
{
    class Program
    {
        [STAThread]
        static void Main(string[] args)
        {
            Dictionary<string, string> arguments = GetArguments(args);

            if (!(arguments.ContainsKey("-Length") && arguments.ContainsKey("-SpecialCharacters") && arguments.ContainsKey("-Numbers")))
            {
                Console.WriteLine("USAGE: GeneratePasswordConsole -Length=<number> -SpecialCharacters=<number> -Numbers=<number> [-TransformVowels=<true/false>] [-NumberOfPasswords=<number>]");
            }
            else
            {
                int length = int.Parse(arguments["-Length"]);
                int specialChars = int.Parse(arguments["-SpecialCharacters"]);
                int numbers = int.Parse(arguments["-Numbers"]);

                bool transform = false;
                if (arguments.ContainsKey("-TransformVowels"))
                    transform = bool.Parse(arguments["-TransformVowels"]);

                int n = 1;
                if (arguments.ContainsKey("-NumberOfPasswords"))
                    n = int.Parse(arguments["-NumberOfPasswords"]);

                Console.WriteLine("These are the passowrd generated:");
                GeneratePassword passGen = new GeneratePassword();
                List<string> generated = new List<string>();
                for (int i = 0; i < n; i++)
                {
                    string pass = passGen.Create(length, specialChars, numbers, transform);
                    generated.Add(pass);
                    Console.WriteLine(i+1 + ": " + pass);
                }

                Console.WriteLine("Please type the number for the password you want to store in your clipboard:");
                string store = Console.ReadLine();
                string passToSave = generated[int.Parse(store) - 1];
                Clipboard.SetText(passToSave);
                Console.WriteLine("Password " + passToSave + " saved to clipboard.");
            }

            Console.ReadLine();


        }

        private static Dictionary<string, string> GetArguments(string[] args)
        {
            var arguments = new Dictionary<string, string>();

            foreach (string argument in args)
            {
                string[] splitted = argument.Split('=');

                if (splitted.Length == 2)
                {
                    arguments[splitted[0]] = splitted[1];
                }
            }

            return arguments;
        }
    }
}
