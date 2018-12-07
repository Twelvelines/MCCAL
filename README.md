# MCCAL
#### *Model Checker for Coalition Announcement Logic*
Utilising [ANTLR][2] for generating customised parsers
(ANTLR version: 4.7.1)

*This project has an IDEA project structure, thus it is preferred to be checked out in Intellij IDEA. Export/import may be needed if opened from other development environment (such as Eclipse) as a whole project. It is also advisable to install the [ANTLR v4 Grammar Plugin for Intellij][3] that allows a set of benefits for editing grammar files including syntax highlighting.*

### Modifying the grammar

*In order to modify the grammar and for the modification to take effect on the project, you have to download and install ANTLR from https://antlr.org to generate parser files.* 

1. Make sure you have installed ANTLR (preferably 4.7.1 or later).

2. Make changes to the formula and/or model grammar files as desired. The two grammar files are located at src/grammars. 

3. In command line, use ANTLR to generate new parser code from the modified grammar files:

   ```shell
   antlr FormulaGrammar.g
   antlr ModelGrammar.g
   ```

4. Add the generated files into the package. For formula grammar related files, the package is 
  `package mccal.formula.formulareader.antlr`; for model grammar related, 
  `package mccal.model.modelreader.antlr`. Note that this requires not only moving the files into the directory, but also refactoring them, i.e. adding package declaration in each file, as ANTLR does not generate package related code in the java files. 

  In the IDE (at least in Intellij IDEA), copying and pasting into the package in the project view do just that. 

  Alternatively you move the files manually via other file browsers that the operating system provides, or using the command line commands as below. However these do not ensure the package declaration of the generated java files, which means you have to declare the package manually in each file.

   ```shell
   mv FormulaGrammar.g tmp.g
   mv FormulaGrammar* ../mccal/formula/formulareader/antlr
   mv tmp.g FormulaGrammar.g
   mv ModelGrammar.g tmp2.g
   mv ModelGrammar* ../mccal/model/modelreader/antlr
   mv tmp2.g ModelGrammar.g
   ```

5. Rebuild the project. The modification should now take effect on the parser. You can do further work to utilise the parsed elements.



###### *Special thanks go to Prof. Franco Raimondi ([fraimondi][1]) for his MCCOGWED project which MCCAL was initially forked from and had given me many food for thought when designing the model checker. Also to Dr. Natasha Alechina for the great effort in supervision, and Dr. Brian Logan for advising support.* 

[1]:	https://github.com/fraimondi/mccogwed
[2]:    https://www.antlr.org

[3]: http://plugins.jetbrains.com/plugin/7358-antlr-v4-grammar-plugin
