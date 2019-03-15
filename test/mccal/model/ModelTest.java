package mccal.model;

import mccal.ModelChecker;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private final String MFP = "test/models/";

    private Set<String> bisimContractPrune(String modelfile) {
        Model ogmodel = ModelChecker.readModel(MFP + modelfile);
        System.out.println("Raw model:");
        System.out.println(ogmodel.toString());
        Model bcmodel = ogmodel.bisimContract();
        System.out.println("Contracted model:");
        System.out.println(bcmodel.toString());
        Set<String> diff = new HashSet<>(ogmodel.getAllStates());
        diff.removeAll(bcmodel.getAllStates());
        return diff;
    }

    @Test
    void equalsReflexive() {
        assertTrue(ModelChecker.readModel(MFP + "sample2").equals(ModelChecker.readModel(MFP + "sample2")));
    }

    @Test
    void equalsReflexive1() {
        assertFalse(ModelChecker.readModel(MFP + "sample2").equals(ModelChecker.readModel(MFP + "sample2.5")));
    }

    @Test
    void bisimContract() {
        Set<String> actual = new HashSet<>();
        actual.add("S2");
        assertEquals(bisimContractPrune("bisimSample"), actual);
    }

    // TODO bucketise n test refactor
    // TODO dename states within the model, using incremental identifier instead? it helps with comparing
    @Test
    void bisimContract1() {
        Set<String> actual = new HashSet<>();
        actual.add("S2");
        assertEquals(bisimContractPrune("bisimSample1"), actual);
    }

    @Test
    void bisimContract2() {
        Set<String> actual = new HashSet<>();
        actual.add("S1");
        actual.add("S2");
        assertEquals(bisimContractPrune("bisimSample2"), actual);
    }

    @Test
    void modelToStringSmall() {
        Model m = ModelChecker.readModel(MFP+"bisimSample1");
        assert m != null;
        System.out.println(m.toString());
    }

    @Test
    void modelToStringBig() {
        Model m = ModelChecker.readModel(MFP+"burglars/burglars1");
        assert m != null;
        System.out.println(m.toString());
    }
}