using System;
using CodeChallenge8.PasswordGenerator;
using CodeChallenge8.PasswordGenerator.Generator;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace CodeChallenge8.Tests
{
    [TestClass]
    public class PasswordGeneratorTests
    {
        PasswordGenerationCriteria criteria;
        IPasswordGenerator generator;

        [TestInitialize]
        public void SetupTestObjects()
        {
            criteria = new PasswordGenerationCriteria();
            generator = new SimplePasswordGenerator();
        }
    

        [TestMethod]
        public void PasswordGeneratorReturnsNonemptyString()
        {
            var result = generator.GetPassword(criteria);

            Assert.IsTrue(result != null);
        }

        [TestMethod]
        public void PasswordGeneratorReturnsAtLeastMinimumLengthPassword()
        {
            criteria.MinimumLength = 5;
            var result = generator.GetPassword(criteria);

            Assert.IsTrue(result.Length >= criteria.MinimumLength);
        }


    }
}
