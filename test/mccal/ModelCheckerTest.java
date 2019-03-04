package mccal;

import mccal.model.Model;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ModelCheckerTest {
    private boolean READ_SV = false;
    // Model Filename Prefix
    private final String MFP = "test/models/";
    // Burglar model Filename Prefix
    private final String BFP = "test/models/burglars/";
    // Chain model Filename Prefix
    private final String CFP = "test/models/chains/";

    private String readFileIntoString(String filename) throws IOException {
        StringBuilder str = new StringBuilder();

        if (READ_SV) {
            // Scanner version
            Scanner s = new Scanner(new BufferedReader(new FileReader(filename)));
            while (s.hasNext()) {
                str.append(s.next()).append(' ');
            }
            s.close();
        } else {
            // BufferedReader version
            BufferedReader br = new BufferedReader(new FileReader(filename));
            for (String l = br.readLine(); l != null; l = br.readLine()) {
                str.append(l);
            }
            br.close();
        }
        return str.toString();
    }

    private Set<String> eval(String sampleFilename, String formula) {
        return eval(sampleFilename, formula, false);
    }

    private Set<String> evalVerbose(String sampleFilename, String formula) {
        return eval(sampleFilename, formula, true);
    }

    private Set<String> eval(String sampleFilename, String formula, boolean verbose) {
        Model model = ModelChecker.readModel(sampleFilename);
        return ModelChecker.evalFormula(model, formula, verbose);
    }

    @Test
    void evalBurglars1MisHex() {
        String mis;
        try {
            mis = readFileIntoString(BFP + "burglars1_mis");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        Set<String> hex = new HashSet<>();
        hex.add("S1100");
        hex.add("S1010");
        hex.add("S0101");
        hex.add("S0110");
        hex.add("S0011");
        hex.add("S1001");
        assertEquals(eval(BFP+"burglars1", mis), hex);
    }

    @Test
    void evalBurglars1MisabKite() {
        String misab;
        try {
            misab = readFileIntoString(BFP + "burglars1_misab");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        Set<String> kite = new HashSet<>();
        kite.add("S1100");
        kite.add("S1010");
        kite.add("S0101");
        kite.add("S0011");
        assertEquals(eval(BFP+"burglars1", misab), kite);
    }

    @Test
    void evalBurglars1MisaElliphex() {
        String misa;
        try {
            misa = readFileIntoString(BFP + "burglars1_misa");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        Set<String> elliphex = new HashSet<>();
        elliphex.add("S1100");
        elliphex.add("S0111");
        elliphex.add("S0101");
        elliphex.add("S1101");
        elliphex.add("S1110");
        elliphex.add("S1111");
        elliphex.add("S1011");
        elliphex.add("S1001");
        assertEquals(eval(BFP+"burglars1", misa), elliphex);
    }

    @Test
    void evalBurglars1Kand() {
        Set<String> kand = eval(BFP+"burglars1",
                "K(1, (!p1 -> (p2 or p4)) and (p1 -> !(p2 or p4)))"
        );
        Set<String> kandk = eval(BFP+"burglars1",
                "K(1, !p1 -> (p2 or p4)) and K(1, p1 -> !(p2 or p4))"
        );
        Set<String> mandm = Model.intersect(
                eval(BFP+"burglars1", "K(1, !p1 -> (p2 or p4))"),
                eval(BFP+"burglars1", "K(1, p1 -> !(p2 or p4))")
        );
        assertEquals(kand, kandk);
        assertTrue(kand.contains("S0101"));
        assertEquals(kand, mandm);
    }

    @Test
    void evalBurglars1Mandm() {
        Set<String> kppand = eval(BFP+"burglars1",
                "K(1, !p1 -> (p2 or p4)) and (p1) and (p2) and (!p3) and (!p4)"
        );
        Set<String> mandm = Model.intersect(
                eval(BFP+"burglars1", "K(1, !p1 -> (p2 or p4))"),
                eval(BFP+"burglars1", "(p1) and (p2) and (!p3) and (!p4)")
        );
        assertEquals(kppand, mandm);
        assertTrue(kppand.contains("S1100"));
        assertEquals(kppand, mandm);
    }

    @Test
    void evalBurglars1KandMisIndiA() {
        Set<String> kand = eval(BFP+"burglars1",
                "K(1, (!p1 -> (p2 | p4)) & (p1 -> !(p2 & p4)))"
        );
        Set<String> kandk = eval(BFP+"burglars1",
                "K(1, !p1 -> (p2 | p4)) & K(1, p1 -> !(p2 & p4))"
        );
        Set<String> m1 = eval(BFP+"burglars1", "K(1, !p1 -> (p2 | p4))");
        Set<String> m2 = eval(BFP+"burglars1", "K(1, p1 -> !(p2 & p4))");
        Set<String> mandm = Model.intersect(m1, m2);
        assertEquals(kand, kandk);
        assertTrue(kand.contains("S0101"));
        assertTrue(kand.contains("S1100"));
        assertEquals(kand.size(), 12);
        assertEquals(kand, mandm);
    }

    @Test
    void evalBurglars1MisIndi() {
        assertEquals(eval(BFP + "burglars1",
                "K(2, (!p2 -> (p1 or p3)) and (p2 -> !(p1 and p3)))"
        ).size(), 12);
        assertEquals(eval(BFP + "burglars1",
                "K(3, (!p3 -> (p2 or p4)) and (p3 -> !(p2 and p4)))"
        ).size(), 12);
        assertEquals(eval(BFP + "burglars1",
                "K(4, (!p4 -> (p3 or p1)) and (p4 -> !(p3 and p1)))"
        ).size(), 12);
    }

    @Test
    void evalBurglars1Unsolved() {
        String atomsS0101 = "!p1 and p2 and !p3 and p4";
        assertTrue(eval(
                BFP + "burglars1",
                "!(K(1, "+atomsS0101+") or K(2, "+atomsS0101+") or K(3, "+atomsS0101+") or K(4, "+atomsS0101+"))"
        ).contains("S0101"));
    }

    @Test
    void evalBurglars1Shortsight() {
        assertTrue(eval(
                BFP + "burglars1",
                "K(3, !p3) and K(3, p2) and K(3, p4) and !(K(3, !p1) or K(K3, p1))"
        ).contains("S0101"));
    }

    @Test
    void evalBurglars1MisSofa() {
        String mis;
        String sofa;
        try {
            mis = readFileIntoString(BFP + "burglars1_mis");
            sofa = readFileIntoString(BFP + "burglars1_sofa");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        assertTrue(eval(BFP + "burglars1", "["+mis+"]" + sofa).contains("S0101"));
    }

    @Test
    void evalBurglars1GalSofa() {
        String sofa;
        try {
            sofa = readFileIntoString(BFP + "burglars1_sofa");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        assertTrue(eval(BFP + "burglars1", "<1,2,3,4>("+sofa+")").contains("S0101"));
    }

    @Test
    void evalBurglars1CalSofa() {
        String sofa;
        try {
            sofa = readFileIntoString(BFP + "burglars1_sofa");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        assertTrue(eval(BFP + "burglars1", "<<1,2,3,4>>("+sofa+")").contains("S0101"));
    }

    @Test
    void evalBurglars1GalSofaAb() {
        String sofa;
        try {
            sofa = readFileIntoString(BFP + "burglars1_sofa");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        assertTrue(eval(BFP + "burglars1", "<1,2>("+sofa+")").contains("S0101"));
    }

    @Test
    void evalBurglars1CalSofaAb() {
        String sofa;
        try {
            sofa = readFileIntoString(BFP + "burglars1_sofa");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        assertFalse(eval(BFP + "burglars1", "<<1,2>>("+sofa+")").contains("S0101"));
    }

    @Test
    void evalBurglars1GalSofaA() {
        String sofa1;
        try {
            sofa1 = readFileIntoString(BFP + "burglars1_sofa1");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        assertTrue(eval(BFP + "burglars1", "<1>("+sofa1+")").contains("S0101"));
    }

    @Test
    void evalBurglars1CalSofaA() {
        String sofa1;
        try {
            sofa1 = readFileIntoString(BFP + "burglars1_sofa1");
        } catch (IOException e) {
            System.err.println(e.toString());
            fail();
            return;
        }
        assertFalse(eval(BFP + "burglars1", "<<1>>("+sofa1+")").contains("S0101"));
    }

    @Test
    void evalSample1S1t0() {
        assertTrue(eval(MFP + "sample1", "atom1|atom2").contains("S1"));
    }

    @Test
    void evalSample1S1t1() {
        assertTrue(eval(MFP + "sample1", "<<2>>K(1, atom1)").contains("S1"));
    }

    @Test
    void evalSample1S1t2() {
        assertTrue(eval(MFP + "sample1", "<<2>>!K(1, atom1)").contains("S1"));
    }

    @Test
    void evalSample1S1t3() {
        assertTrue(eval(MFP + "sample1", "!<<1>>K(1, atom1)").contains("S1"));
    }

    @Test
    void evalSample1S1t4() {
        assertTrue(eval(MFP + "sample1", "<<1>>K(2, atom1)").contains("S1"));
    }

    @Test
    void evalSample1S1t5() {
        assertTrue(eval(MFP + "sample1", "<<1, 2>>K(1, atom1)").contains("S1"));
    }

    @Test
    void evalSample1S1t6() {
        assertTrue(eval(MFP + "sample1", "<<2>><<1>>K(1, atom1)").contains("S1"));
    }

    @Test
    void evalSample1S2t1() {
        assertTrue(eval(MFP + "sample1", "!<<2>>K(1, atom1)").contains("S2"));
    }

    @Test
    void evalSample1S2t2() {
        assertTrue(eval(MFP + "sample1", "<<2>>K(1, !atom1)").contains("S2"));
    }

    @Test
    void evalSample1S2t3() {
        assertTrue(eval(MFP + "sample1", "!<<1>>K(1, atom1)").contains("S2"));
    }

    @Test
    void evalSample2S1t1() {
        assertTrue(eval(MFP + "sample2", "<<3>>K(1, atom1)").contains("S1"));
    }

    @Test
    void evalSample2S1t2() {
        assertFalse(eval(MFP + "sample2", "<<3>>!K(1, atom1)").contains("S1"));
    }

    @Test
    void evalSample2S1t3() {
        assertTrue(eval(MFP + "sample2", "<<1, 2>>K(1, atom1)").contains("S1"));
    }

    @Test
    void evalSample2S1t4() {
        assertTrue(eval(MFP + "sample2", "[atom1][atom2][atom3] K(1, atom1)").contains("S1"));
    }

    @Test
    void evalSample2S1t5() {
        assertTrue(eval(MFP + "sample2", "[atom1][atom2][atom3] K(1, atom3)").contains("S1"));
        // as nonsense announcement always results to return true
    }
}
