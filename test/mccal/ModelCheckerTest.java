package mccal;

import mccal.model.Model;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ModelCheckerTest {
    // Model Filename Prefix
    private final String MFP = "test/models/";
    // Burglar model Filename Prefix
    private final String BFP = "test/models/burglars/burglars";

    private String readFileIntoString(String filename) throws IOException {
        StringBuilder str = new StringBuilder();

        boolean sv = false;
        if (sv) {
            // Scanner version
            try (Scanner s = new Scanner(new BufferedReader(new FileReader(filename)))) {
                while (s.hasNext()) {
                    str.append(s.next()).append(' ');
                }
            }
        } else {
            // BufferedReader version
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                for (String l = br.readLine(); l != null; l = br.readLine()) {
                    str.append(l);
                }
            }
        }
        return str.toString();
    }

    private Set<String> solutionForSample(String sampleFilename, String formula) {
        Model model = ModelChecker.readModel(sampleFilename);
        return ModelChecker.evalFormula(model, formula);
    }

    @Test
    void test1EvalFormulaBurglar1() {
        String atomsS0101 = "!p1 and p2 and !p3 and p4";
        assertTrue(solutionForSample(
                BFP + "1",
                "!(K(1, "+atomsS0101+") or K(2, "+atomsS0101+") or K(3, "+atomsS0101+") or K(4, "+atomsS0101+"))"
        ).contains("S0101"));
    }

    @Test
    void test2EvalFormulaBurglar1() {
        assertTrue(solutionForSample(
                BFP + "1",
                "K(3, !p3) and K(3, p2) and K(3, p4) and !(K(3, !p1) or K(K3, p1))"
        ).contains("S0101"));
    }

    @Test
    void testEvalFormulaBurglar1MisSofa() {
        String mis;
        String sofa;
        try {
            mis = readFileIntoString(BFP + "1_mis");
            sofa = readFileIntoString(BFP + "1_sofa");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        assertTrue(solutionForSample(BFP + "1", "["+mis+"]" + sofa).contains("S0101"));
    }

    @Test
    void test0EvalFormulaSample1S1() {
        assertTrue(solutionForSample(MFP + "sample1.gwm", "(atom1)or(atom2)").contains("S1"));
    }

    @Test
    void test1EvalFormulaSample1S1() {
        assertTrue(solutionForSample(MFP + "sample1.gwm", "<<2>>K(1, atom1)").contains("S1"));
    }

    @Test
    void test2EvalFormulaSample1S1() {
        assertTrue(solutionForSample(MFP + "sample1.gwm", "<<2>>!K(1, atom1)").contains("S1"));
    }

    @Test
    void test3EvalFormulaSample1S1() {
        assertTrue(solutionForSample(MFP + "sample1.gwm", "!<<1>>K(1, atom1)").contains("S1"));
    }

    @Test
    void test4EvalFormulaSample1S1() {
        assertTrue(solutionForSample(MFP + "sample1.gwm", "<<1>>K(2, atom1)").contains("S1"));
    }

    @Test
    void test5EvalFormulaSample1S1() {
        assertTrue(solutionForSample(MFP + "sample1.gwm", "<<1, 2>>K(1, atom1)").contains("S1"));
    }

    @Test
    void test6EvalFormulaSample1S1() {
        assertTrue(solutionForSample(MFP + "sample1.gwm", "<<2>><<1>>K(1, atom1)").contains("S1"));
    }

    @Test
    void test1EvalFormulaSample1S2() {
        assertTrue(solutionForSample(MFP + "sample1.gwm", "!<<2>>K(1, atom1)").contains("S2"));
    }

    @Test
    void test2EvalFormulaSample1S2() {
        assertTrue(solutionForSample(MFP + "sample1.gwm", "<<2>>K(1, !atom1)").contains("S2"));
    }

    @Test
    void test3EvalFormulaSample1S2() {
        assertTrue(solutionForSample(MFP + "sample1.gwm", "!<<1>>K(1, atom1)").contains("S2"));
    }

    @Test
    void test1EvalFormulaSample2S1() {
        assertTrue(solutionForSample(MFP + "sample2.gwm", "<<3>>K(1, atom1)").contains("S1"));
    }

    @Test
    void test2EvalFormulaSample2S1() {
        assertFalse(solutionForSample(MFP + "sample2.gwm", "<<3>>!K(1, atom1)").contains("S1"));
    }

    @Test
    void test3EvalFormulaSample2S1() {
        assertTrue(solutionForSample(MFP + "sample2.gwm", "<<1, 2>>K(1, atom1)").contains("S1"));
    }

    @Test
    void test4EvalFormulaSample2S1() {
        assertTrue(solutionForSample(MFP + "sample2.gwm", "[atom1][atom2][atom3] K(1, atom1)").contains("S1"));
    }

    @Test
    void test5EvalFormulaSample2S1() {
        assertTrue(solutionForSample(MFP + "sample2.gwm", "[atom1][atom2][atom3] K(1, atom3)").contains("S1"));
        // as nonsense announcement always results to return true
    }
}
