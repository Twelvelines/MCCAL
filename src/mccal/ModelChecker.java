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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;

// TODO tidy up the imports
// TODO modifiers/access

public class ModelChecker {
    // The filename for the model and the formula we want to verify
    private String filename;
    private String formula;

    // The model resulting from parsing filename
    private Model model;

    public ModelChecker(String filename, String formula) {
        this.filename = filename;
        this.formula = formula;
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 2 || args.length > 3) {
            // TODO: we should improve error checking (file exists, etc);
            System.err.println("You need to provide a model file and a formula, ");
            System.err.println("\tExample: ");
            System.out.println("\t$ java ModelChecker sample.gwm \"K(1,p1win)\"");
            System.err.println("Or, an extra state, ");
            System.err.println("\tExample: ");
            System.out.println("\t$ java ModelChecker sample.gwm \"K(1,p1win)\" S1");
            System.exit(1);
        }

        ModelChecker mc = new ModelChecker(args[0], args[1]);
        boolean isStateProvided = false;
        String providedState = null;
        if (args.length == 3) {
            isStateProvided = true;
            providedState = args[2];
        }
        mc.start(isStateProvided, providedState);
    }

    public void start(boolean isStateProvided, String providedState) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()) + ": job started");
        // Begin model parsing procedure:
        // create a CharStream that reads from in (either a file or
        // standard input, see above)
        System.out.println("FRANCO: Filename is: " + this.filename);

        // Read in model
        this.model = readModel(this.filename);
        if (model == null) {
            return;
        }
        cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()) + ": model generated");

        // We begin to parse the formula:
        Set<String> solution = evalFormula(model, formula);

        // Printing output
        if (isStateProvided) {
            System.out.println("Under the provided state " + providedState + " the formula is " +
                    solution.contains(providedState)
            );
        } else {
            System.out.println("The formula is true in " + solution.size() + " states");
            System.out.println("These are the states: "+ solution);
        }
        // Model info
        System.out.println("Model info: ");
        System.out.println(model.toString());
        cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()) + ": job done, see you soon!");
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
        // TODO: improve exception handling :-)!
        ANTLRInputStream input;
        try (FileInputStream fi = new FileInputStream(filename)) {
            input = new ANTLRInputStream(fi);
        } catch (IOException e) {
            System.err.println(e.getMessage());
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
