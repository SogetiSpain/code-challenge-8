using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeChallenge8.PasswordGenerator
{
   public class PasswordGenerationCriteria
    {
        public int MinimumLength { get; set; }
        public int SpecialCharactersQuantity { get; set; }
        public int NumbersQuantity { get; set; }
    }
}
