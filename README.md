# EpistemicMC
Originally a fork from [fraimondi/mccogwed][1]\
Utilising ANTLR for customising parser\
**ANTLR version: 4.7.1**

The project has an IDEA project structure, thus it is preferred to be opened under Intellij IDEA. Importation may be needed if opened from other development environment (such as Eclipse) as a whole project. 

### Modifying the grammar

*In order to modify the grammar and for the modification to take effect on the project, you have to install ANTLR to generate parser files.* 

1. Make sure you have installed ANTLR (preferably 4.7.1 or later). To install ANTLR: http://www.antlr.org

2. Make changes to the grammar files as desired. The two grammar files are located at src/grammars, one for the formula, and the other for model. 

3. In command line, use ANTLR to generate new parser code from the modified grammar files:

   *(you should be in the directory src/grammars in the command line if you are to use the shell commands below, same for the next step)*

   ```shell
   antlr CogwedFormulaGrammar.g
   antlr CogwedModelGrammar.g
   ```

4. Add the generated files into the package. For formula grammar related files, the package is `package cogwedmc.formula.formulareader.antlr`; for model grammar related, `package cogwedmc.model.modelreader.antlr`. Note that this requires not only moving the files into the directory, but also refactoring them, i.e. adding package declaration in each file, as ANTLR does not generate package related code in the java files. 

   In the IDE (at least in Intellij IDEA), copying and pasting into the package in the project view do just that. 

   Alternatively you move the files manually via other file browsers that the operating system provides, or using the command line commands as below. However these do not ensure the package declaration of the generated java files, which means you have to declare the package manually in each file.

   ```shell
   mv CogwedFormulaGrammar.g tmp.g
   mv CogwedFormulaGrammar* ../cogwedmc/formula/formulareader/antlr
   mv tmp.g CogwedFormulaGrammar.g
   mv CogwedModelGrammar.g tmp2.g
   mv CogwedModelGrammar* ../cogwedmc/model/modelreader/antlr
   mv tmp2.g CogwedModelGrammar.g
   ```

5. Rebuild the project. The modification should now take effect on the parser. You can do further work to utilise the parsed elements.




[1]:	https://github.com/fraimondi/mccogwed