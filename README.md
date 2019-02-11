# MCCAL
#### *Model Checker with Coalition Announcement Logic*
Utilising [ANTLR][2] for generating customised parsers
(ANTLR version: 4.7.1)

*(This project has an IDEA project structure, thus it is preferred to be checked out in Intellij IDEA. Export/import may be needed if opened from other development environment (such as Eclipse) as a whole project. It is also advisable to install the [ANTLR v4 Grammar Plugin for Intellij][3] that allows a set of benefits for editing grammar files including syntax highlighting.)*

### Modifying the grammar

*In order to modify the grammar and for the modification to take effect on the project, you have to download and install ANTLR from https://antlr.org to generate parser files.* 

1. Make sure you have installed ANTLR (preferably 4.7.1 or later).

2. Make changes to the formula and/or model grammar files as desired. The two grammar files are located at `src/mccal/antlr`. 

3. In command line, use ANTLR to generate new parser code from the modified grammar files:

   ```shell
   antlr FormulaGrammar.g
   antlr ModelGrammar.g
   ```
   
   *You may want to run the two lines above separately, so that you can move the generated files one line at a time, and thus prevent dragging the wrong file into the directory.*

4. Add the generated files into the corresponding working packages, which are just under current directory, namely`formula` and `model`. 
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

5. Rebuild the project. The modification should now take effect on the parser. You can do further work to utilise the parsed elements.



###### *Special thanks to Prof. Franco Raimondi ([fraimondi][1]) for his MCCOGWED project which MCCAL was initially forked from and had given me many food for thought when designing the model checker. Also to Dr. Natasha Alechina for the great effort in supervision, and Dr. Brian Logan for advising support.* 

[1]:	https://github.com/fraimondi/mccogwed
[2]:    https://www.antlr.org

[3]: http://plugins.jetbrains.com/plugin/7358-antlr-v4-grammar-plugin
