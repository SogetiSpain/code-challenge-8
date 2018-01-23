using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeChallenge8.PasswordGenerator.Generator
{
    public interface IPasswordGenerator
    {
        string GetPassword(PasswordGenerationCriteria criteria);
    }
}
