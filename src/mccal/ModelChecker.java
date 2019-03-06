package mccal;

import mccal.formula.FormulaEvaluator;
import mccal.antlr.formula.FormulaGrammarLexer;
import mccal.antlr.formula.FormulaGrammarParser;
import mccal.model.Model;
import mccal.model.ModelExtractor;
import mccal.antlr.model.ModelGrammarLexer;
import mccal.antlr.model.ModelGrammarParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;

public class ModelChecker {
    public static void main(String[] args) {
        if (args.length < 2 || args.length > 3) {
            System.err.println("You need to provide a model file and a formula, ");
            System.err.println("\tExample: ");
            System.err.println("\t$ java ModelChecker sample.gwm \"K(1,p1win)\"");
            System.err.println("Or, an extra state, ");
            System.err.println("\tExample: ");
            System.err.println("\t$ java ModelChecker sample.gwm \"K(1,p1win)\" S1");
            System.exit(1);
        }

        // TODO improve error checking e.g. file exists
        String filename = args[0];
        String formula = args[1];

        System.out.println("-- Model file: " + filename + " --");
        Model model = readModel(filename);
        if (model == null) {
            System.exit(2);
        }
        System.out.println("-- Model successfully generated, proceeding to evaluation --");
        Set<String> solution = evalFormula(model, formula);
        System.out.println("-- Evaluation complete --");

        // printing solution
        if (args.length == 3) {
            // TODO validate if provided state is in model
            System.out.println("Under the provided state " + args[2] + " the formula is " +
                    solution.contains(args[2])
            );
        } else {
            System.out.println("The formula is true in " + solution.size() + " states");
            System.out.println("These are the states: "+ solution);
        }

        System.out.println("\nModel info:");
        System.out.println(model.toString());
        System.out.println("-- Model checking finished --");
    }

    public static Set<String> evalFormula(Model model, String formula) {
        return evalFormula(model, formula, false);
    }

    public static Set<String> evalFormula(Model model, String formula, boolean verbose) {
        ANTLRInputStream finput = new ANTLRInputStream(formula);
        FormulaGrammarLexer flexer = new
                FormulaGrammarLexer(finput);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream ftokens = new CommonTokenStream(flexer);
        // create a parser that feeds off the tokens buffer
        FormulaGrammarParser fparser = new FormulaGrammarParser(ftokens);
        // begin parsing from formula rule;
        ParseTree ftree = fparser.formula();
        // Just a standard walker
        ParseTreeWalker fwalker = new ParseTreeWalker();
        // Now we associate our extractor to the parser.
        FormulaEvaluator evaluator = new FormulaEvaluator(model, verbose);
        // and we walk the tree with our extractor.
        fwalker.walk(evaluator, ftree);
        return evaluator.getSolution();
    }

    public static Model readModel(String filename) {
        // read formula
        ANTLRInputStream input;
        try (FileInputStream fi = new FileInputStream(filename)) {
            input = new ANTLRInputStream(fi);
        } catch (IOException e) {
            System.err.println(e.toString());
            return null;
        }
        // create a lexer that feeds off of input CharStream
        ModelGrammarLexer lexer = new ModelGrammarLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        ModelGrammarParser parser = new ModelGrammarParser(tokens);
        // begin parsing at modelfile rule
        ParseTree tree = parser.modelfile();
        // Just a standard walker
        ParseTreeWalker walker = new ParseTreeWalker();
        // Now we associate our extractor to the parser.
        ModelExtractor extractor = new ModelExtractor();
        // and we walk the tree with our extractor.
        walker.walk(extractor, tree);
        // End of model parsing
        // We finally get our model:
        return extractor.getModel();
    }

}
