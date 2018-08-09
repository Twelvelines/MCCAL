package cogwedmc;

import java.text.*;
import java.util.*;
import java.io.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import cogwedmc.model.*;
import cogwedmc.model.modelreader.*;
import cogwedmc.model.modelreader.antlr.*;

import cogwedmc.formula.formulareader.*;
import cogwedmc.formula.formulareader.antlr.*;


/*
 * Franco 130728: This is the main class to invoke the model checker.
 *
 */

public class CogwedMC {

    // The filename for the model and the formula we want to verify
    private String filename;
    private String formula;

    // The model resulting from parsing filename
    private CogwedModel cwmodel;

    public CogwedMC(String filename, String formula) {
        this.filename = filename;
        this.formula = formula;
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 2 || args.length > 3) {
            // TODO: we should improve error checking (file exists, etc);
            System.err.println("You need to provide a model file and a formula, ");
            System.err.println("\tExample: ");
            System.out.println("\t$ java CogwedMC sample.gwm \"K(1,p1win)\"");
            System.err.println("Or, an extra state, ");
            System.err.println("\tExample: ");
            System.out.println("\t$ java CogwedMC sample.gwm \"K(1,p1win)\" S1");
            System.exit(1);
        }

        CogwedMC mc = new CogwedMC(args[0], args[1]);
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


        // TODO: improve exception handling :-)!
        ANTLRInputStream input;
        try (FileInputStream fi = new FileInputStream(this.filename)) {
            input = new ANTLRInputStream(fi);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }
        // create a lexer that feeds off of input CharStream
        CogwedModelGrammarLexer lexer = new CogwedModelGrammarLexer(input);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // create a parser that feeds off the tokens buffer
        CogwedModelGrammarParser parser = new CogwedModelGrammarParser(tokens);
        // begin parsing at cogwed_model_file rule
        ParseTree tree = parser.cogwed_model_file();
        // Just a standard walker
        ParseTreeWalker walker = new ParseTreeWalker();
        // Now we associate our extractor to the parser.
        ExtractCogwedModelListener extractor =
                new ExtractCogwedModelListener(parser);
        // and we walk the tree with our extractor.
        walker.walk(extractor, tree);
        // End of model parsing
        // We finally get our model:
        this.cwmodel = extractor.getModel();
        cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()) + ": model generated");

        // Creating epistemic relations etc.
        //cwmodel.setupModel();

        // We begin to parse the formula:
        ANTLRInputStream finput = new ANTLRInputStream(formula);
        CogwedFormulaGrammarLexer flexer = new
                CogwedFormulaGrammarLexer(finput);
        // create a buffer of tokens pulled from the lexer
        CommonTokenStream ftokens = new CommonTokenStream(flexer);
        // create a parser that feeds off the tokens buffer
        CogwedFormulaGrammarParser fparser = new CogwedFormulaGrammarParser(ftokens);
        // begin parsing
        ParseTree ftree = fparser.start();
        // Just a standard walker
        ParseTreeWalker fwalker = new ParseTreeWalker();
        // Now we associate our extractor to the parser.
        FormulaEvaluator evaluator = new FormulaEvaluator(fparser);
        evaluator.setModel(cwmodel);
        // and we walk the tree with our extractor.
        fwalker.walk(evaluator, ftree);

        // Et voila, job done
        // Printing output
        Set<String> solution = evaluator.getSolution();
        System.out.println("The formula is true in " + solution.size() + " states");
        if (isStateProvided) {
            System.out.println("Under the provided state " + providedState + " the formula is " +
                    solution.contains(providedState)
            );
        } else {
            System.out.println("These are the states: "+evaluator.getSolution());
        }
        // Model info
        System.out.println("Model size: ");
        int numAgents = cwmodel.getNumberOfAgents();
        System.out.println("  Number of agents: " + numAgents);
        System.out.println("  Number of states: " + cwmodel.getAllStates().size());
        int numRelations = 0;
        for (int i = 0; i < numAgents; i++) {
            numRelations += cwmodel.getRelationsOfAgent(i+1).size();
        }
        System.out.println("  Number of edges: " + numRelations);
        cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()) + ": job done, see you soon!");
    }

}
