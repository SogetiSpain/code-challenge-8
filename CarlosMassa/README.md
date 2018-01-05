## Execution

```
make
./password_generator
```

Then it will ask you for the following of questions
```
- What's the minimum length?
- How many special characters?
- How many numbers?
- Do you want your password to follow a pattern (y/n)?
    if 'y' you can specify a pattern like **abc** (for a minimum length of 7 chars)
- How many passwords do you want (default: 1)?

(If more than one password)
- Which strategy do you want to follow to generate multiple passwords?
    [0: random per generation (default)]: Generates a different password every time.
    [1: backtracking]: Executes backtracking with the first password generated making permutation for the new passwords.

```

Default values can be changed on 'defaults.hpp'
```
// Default password characteristics
const int DEFAULT_LENGTH = 16;
const int DEFAULT_CHARS = 2;
const int DEFAULT_NUMBERS = 2;
```

Characters used for the generation can be changed on 'characters.hpp'. Also note there is a 'substitutions' map, which is used on execution time to interchange some letters by numbers randomly, here can be added all the possible replacements.
