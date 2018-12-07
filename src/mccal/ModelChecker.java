package mccal;


/*
 * Franco 130728: This is the main class to invoke the model checker.
 *
 */

import mccal.formula.formulareader.FormulaEvaluator;
import mccal.formula.formulareader.antlr.FormulaGrammarLexer;
import mccal.formula.formulareader.antlr.FormulaGrammarParser;
import mccal.model.Model;
import mccal.model.modelreader.ModelExtractor;
import mccal.model.modelreader.antlr.ModelGrammarLexer;
import mccal.model.modelreader.antlr.ModelGrammarParser;
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

public class ModelChecker {

    // The filename for the model and the formula we want to verify
    private String filename;
    private String formula;

    // The model resulting from parsing filename
    private Model cwmodel;

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
        this.cwmodel = readModel(this.filename);
        if (cwmodel == null) {
            return;
        }
        cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()) + ": model generated");

        // We begin to parse the formula:
        Set<String> solution = evalFormula(cwmodel, formula);

        // Et voila, job done
        // Printing output
        System.out.println("The formula is true in " + solution.size() + " states");
        if (isStateProvided) {
            System.out.println("Under the provided state " + providedState + " the formula is " +
                    solution.contains(providedState)
            );
        } else {
            System.out.println("These are the states: "+ solution);
        }
        // Model info
        System.out.println("Model size: ");
        int numAgents = cwmodel.getNumberOfAgents();
        System.out.println("  Number of agents: " + numAgents);
        System.out.println("  Number of states: " + cwmodel.getAllStates().size());
        int numEquivSets = 0;
        for (int i = 0; i < numAgents; i++) {
            numEquivSets += cwmodel.getEquivClasses(i+1).size();
        }
        System.out.println("  Number of equivalence sets: " + numEquivSets);
        cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()) + ": job done, see you soon!");
    }

    public static Set<String> evalFormula(Model model, String formula) {
        ANTLRInputStream finput = new ANTLRInputStream(formula);
        FormulaGrammarLexer flexer = new
                FormulaGrammarLexer(finput);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream ftokens = new CommonTokenStream(flexer);
        // create a parser that feeds off the tokens buffer
        FormulaGrammarParser fparser = new FormulaGrammarParser(ftokens);
        // begin parsing
        ParseTree ftree = fparser.start();
        // Just a standard walker
        ParseTreeWalker fwalker = new ParseTreeWalker();
        // Now we associate our extractor to the parser.
        FormulaEvaluator evaluator = new FormulaEvaluator(fparser);
        evaluator.setModel(model);
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
        // begin parsing at cogwed_model_file rule
        ParseTree tree = parser.cogwed_model_file();
        // Just a standard walker
        ParseTreeWalker walker = new ParseTreeWalker();
        // Now we associate our extractor to the parser.
        ModelExtractor extractor =
                new ModelExtractor(parser);
        // and we walk the tree with our extractor.
        walker.walk(extractor, tree);
        // End of model parsing
        // We finally get our model:
        return extractor.getModel();
    }

}
