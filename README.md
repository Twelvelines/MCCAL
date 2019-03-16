# MCCAL

#### *Model Checker with Coalition Announcement Logic*
Utilising [ANTLR][2] for generating customised parsers
(ANTLR version: 4.7.1)

### Before Started...

Any terminal command or directory mentioned below presumes that you are currently in the project's root directory, namely *MCCAL*, unless otherwise specified. 

This project has an IDEA project structure, thus it is preferred to be checked out in Intellij IDEA. Export/import may be needed if opened from other development environment (such as Eclipse) as a whole project. 

It is also advisable to install the [ANTLR v4 Grammar Plugin for Intellij][3] that allows a set of benefits for editing grammar files including syntax highlighting. ANTLR installation on your computer may be needed for this.

## Running MCCAL

After downloading and building (compiling) the project you can run MCCAL either in the IDE or from terminal. For the latter, the main class is the *out/production/MCCAL/mccal/ModelChecker*. 

In order to run it, at least two command line arguments for model and formula must be given. The first command line argument should be specifying the text file containing the information about the model. The second argument provides the formula to be evaluated, which is in the form of a text string and in command line quoted with double quotes (so that it can be recognized as a whole should there be any space in it). An example of providing model and formual parameters, in which `test/model/sample` is the model file and `"K(1, atom1)"` is the formula argument: 

```shell
java out/production/MCCAL/mccal/ModelChecker test/models/sample "K(1, atom1)"
```

An optional third argument can be provided to specify under which state of the model you would like to evaluate the formula, which corresponds to logic expression {Model, state} ⊨ *formula*. An example for providing three arguments running the program, where S1 is the designated state:

```shell
java out/production/MCCAL/mccal/ModelChecker test/models/sample "K(1, atom1)" S1
```

#### Model File

In order for the program to parse and process the model, the content of the model file should provide sufficient information about the model including *Number of Agents*, *States*, *Epistemic Relations* and *Atoms*, in the format specified by `src/mccal/antlr/ModelGrammar.g4`, the model grammar that contains the full specification of the model file format. An example of what the model file should look like:

```
// The number of agents
N = 3;

// The list of states
S1; S2; S3;

// The epistemic relation is a list of triples (agent, state, state)
R = { (3, S1, S2), (2, S2, S3) };

// The atoms and the states where they hold true
atom1 = { S1 };
atom2 = { S2 };
atom3 = { S3 };
```

You can also find a series of sample model files in `test/models`  used for testing purposes. 

#### Formula

A formula is established on the atoms in the model and the logical operations on them (and, when epistemic logic is involved, the agents in the model). The currently supported logical operations are:

| Logical Operation      | Example      |
| ---------------------- | ------------ |
| Parenthesis            | `(p)`        |
| Negation               | `!p`         |
| Conjunction            | `p & q`      |
| Disjunction            | `p \| q`      |
| Implication            | `p -> q`     |
| Knowledge              | `K(1, p)`    |
| Public Announcement    | `[p] q`      |
| Group Announcement     | `<1, 2> p`   |
| Coalition Announcement | `<<1, 2>> p` |

Again you can find some sample formulae in `test/mccal/ModelCheckerTest`  in the testing cases. 

A full definition of the formula grammar can be found in `src/mccal/antlr/FormulaGrammar.g4`, the grammar file of formula, which also lists out the supported operations as above. 

## Modifying Grammars

*(As I have recently found out, producing parsers from grammar file using ANTLR can be done using just the imported library in the project. There is therefore no need to install ANTLR on your computer for that.)*

1. Make changes to the formula and/or model grammar files as desired. The two grammar files are located at `src/mccal/antlr`. 

2. In command line, use ANTLR library tool to generate new parser code from the modified grammar files. If you are in command line currently in the directory `src/mccal/antlr` the command should look like this:

   ```shell
   java -jar ../../../lib/antlr-4.7.1-complete.jar FormulaGrammar.g4
   java -jar ../../../lib/antlr-4.7.1-complete.jar ModelGrammar.g4
   ```
   
   *You may want to run the two lines above separately, so that you can move the generated files one line at a time, and thus prevent dragging the wrong file into the directory.*

3. Add the generated files into the corresponding working packages, which are just under current directory, namely`formula` and `model`. 
   Note that this requires not only moving the files into the directory, but also refactoring them, i.e. adding package declaration in each file, as ANTLR does not generate package related code in the java files.
   For formula grammar related files, the declaration should be `package mccal.antlr.formula;`; for model grammar related, `package mccal.antlr.model;`. 

   In the IDE (at least in Intellij IDEA), copying and pasting into the package in the project view do just that. 

   Alternatively you move the files manually via other file browsers that the operating system provides, or using the command line commands as below. However these do not ensure the package declaration of the generated java files, which means you have to declare the package manually in each file.

   ```shell
   mv FormulaGrammar.g4 tmp.g4
   mv FormulaGrammar* formula/
   mv tmp.g4 FormulaGrammar.g4
   mv ModelGrammar.g4 tmp2.g4
   mv ModelGrammar* model/
   mv tmp2.g4 ModelGrammar.g4
   ```

   If you are working the project under a git environment, be sure to add the files into git.

4. Rebuild the project. The modification should now take effect on the parser. You can do further work to utilise the parsed elements.



###### *Special thanks to Prof. Franco Raimondi ([fraimondi][1]) for his MCCOGWED project which MCCAL was initially forked from and had given me many food for thought when designing the model checker. Also to Dr. Natasha Alechina for the great effort in supervision, and Dr. Brian Logan for advising support.* 

[1]:	https://github.com/fraimondi/mccogwed
[2]:    https://www.antlr.org

[3]: http://plugins.jetbrains.com/plugin/7358-antlr-v4-grammar-plugin
