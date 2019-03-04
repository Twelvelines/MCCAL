package mccal.model;

import mccal.ModelChecker;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private final String MFP = "test/models/";

    private Set<String> bisumContractPrune(String modelfile) {
        Model ogmodel = ModelChecker.readModel(MFP + modelfile);
        System.out.println("Raw model:");
        System.out.println(ogmodel.toString());
        Model bcmodel = ogmodel.bisumContract();
        System.out.println("Contracted model:");
        System.out.println(bcmodel.toString());
        Set<String> diff = new HashSet<>(ogmodel.getAllStates());
        diff.removeAll(bcmodel.getAllStates());
        return diff;
    }

    @Test
    void bisimContract() {
        Set<String> actual = new HashSet<>();
        actual.add("S2");
        assertEquals(bisumContractPrune("bisimSample"), actual);
    }

    // TODO bucketise n test refactor
    // TODO dename states within the model, using incremental identifier instead? it helps with comparing
    @Test
    void bisimContract1() {
        Set<String> actual = new HashSet<>();
        actual.add("S2");
        assertEquals(bisumContractPrune("bisimSample1"), actual);
    }

    @Test
    void bisimContract2() {
        Set<String> actual = new HashSet<>();
        actual.add("S1");
        actual.add("S2");
        assertEquals(bisumContractPrune("bisimSample2"), actual);
    }

    @Test
    void getStrategies1() {
        //TODO
    }

    @Test
    void getCoStrategies1() {
        //TODO
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