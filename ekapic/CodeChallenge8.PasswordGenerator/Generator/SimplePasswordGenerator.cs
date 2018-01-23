using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace CodeChallenge8.PasswordGenerator.Generator
{
    public class SimplePasswordGenerator : IPasswordGenerator
    {
        private string characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        private string numbers = "0123456789";
        private string specialCharacters = "*$-+?_&=!%{}/";

        private Random random;

        public SimplePasswordGenerator()
        {
            byte[] randomBytes = new byte[4];
            RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider();
            rng.GetBytes(randomBytes);

            int seed = BitConverter.ToInt32(randomBytes, 0);

            random = new Random(seed);
        } 

        public string GetPassword(PasswordGenerationCriteria criteria)
        {
            var pwd = String.Empty;

            for(var i = 0; i<criteria.MinimumLength;i++)
            {
                pwd = AddRandomCharacter(pwd, characters);
            }
            for (var i = 0; i < criteria.NumbersQuantity; i++)
            {
                pwd = AddRandomCharacter(pwd, numbers);
            }
            for (var i = 0; i < criteria.SpecialCharactersQuantity; i++)
            {
                pwd = AddRandomCharacter(pwd, specialCharacters);
            }

            return pwd;
        }

        private string AddRandomCharacter(string pwd, string characters)
        {
            var password = pwd.Insert(random.Next(pwd.Length + 1), 
                characters[random.Next(characters.Length - 1)].ToString());
            return password;
        }
    }
}
