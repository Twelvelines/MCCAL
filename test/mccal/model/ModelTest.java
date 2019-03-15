package mccal.model;

import mccal.ModelChecker;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    private final String MFP = "test/models/";
    private final String BMFP = "test/models/bisims/";

    private final Set<String> EMPTY_SET_OF_STRING = new HashSet<>();

    @Test
    void bisimContract1Full() {
        Model bs1ctdActual = ModelChecker.readModel(BMFP+"bisimSample1").bisimContract();
        Model bs1ctd = ModelChecker.readModel(BMFP+"bisimSample1Ctd");
        Model bs1ctd1 = ModelChecker.readModel(BMFP+"bisimSample1Ctd1");
        assertTrue(bs1ctdActual.equals(bs1ctd) || bs1ctdActual.equals(bs1ctd1));
    }

    @Test
    void bisimContract() {
        Set<String> c = new HashSet<>();
        c.add("S1");
        c.add("S2");
        assertTrue(ModelChecker.readModel(BMFP+"bisimSample").bisimContract().bisimEquals(
                ModelChecker.readModel(BMFP+"bisimSampleCtd"), c
        ));
    }

    @Test
    void bisimContract1() {
        Set<String> c = new HashSet<>();
        c.add("S2");
        c.add("S3");
        assertTrue(ModelChecker.readModel(BMFP+"bisimSample1").bisimContract().bisimEquals(
                ModelChecker.readModel(BMFP+"bisimSample1Ctd"), c
        ));
    }

    @Test
    void bisimContract2() {
        Set<String> c1 = new HashSet<>();
        c1.add("S1");
        c1.add("S4");
        Set<String> c2 = new HashSet<>();
        c2.add("S2");
        c2.add("S3");
        assertTrue(ModelChecker.readModel(BMFP+"bisimSample2").bisimContract().bisimEquals(
                ModelChecker.readModel(BMFP+"bisimSample2Ctd"), c1, c2
        ));
    }

    @Test
    void modelBisimEquals() {
        Set<String> c = new HashSet<>();
        c.add("S3");
        c.add("S2");
        assertTrue(ModelChecker.readModel(BMFP+"bisimSample1Ctd").bisimEquals(ModelChecker.readModel(BMFP+"bisimSample1Ctd1"), c));
    }

    @Test
    void modelBisimEqualsReflexive() {
        assertTrue(ModelChecker.readModel(MFP+"sample1").bisimEquals(ModelChecker.readModel(MFP+"sample1"), EMPTY_SET_OF_STRING));
    }

    @Test
    void bisimEqualsReflexive() {
        Set<String> s1 = new HashSet<>();
        s1.add("1");
        s1.add("2");
        Set<String> s2 = new HashSet<>();
        s2.add("1");
        s2.add("2");
        assertTrue(Model.bisimEquals(s1, s2, EMPTY_SET_OF_STRING));
    }

    @Test
    void bisimEquals2() {
        Set<String> s1 = new HashSet<>();
        s1.add("1");
        s1.add("2");
        Set<String> s2 = new HashSet<>();
        s2.add("3");
        s2.add("4");
        Set<String> c1 = new HashSet<>();
        c1.add("1");
        c1.add("4");
        Set<String> c2 = new HashSet<>();
        c2.add("2");
        c2.add("3");
        assertTrue(Model.bisimEquals(s1, s2, c1, c2));
    }

    @Test
    void bisimEquals1Error() {
        Set<String> s1 = new HashSet<>();
        s1.add("1");
        s1.add("2");
        s1.add("3");
        s1.add("4");
        Set<String> s2 = new HashSet<>();
        s2.add("1");
        s2.add("5");
        s2.add("3");
        s2.add("6");
        Set<String> c1 = new HashSet<>();
        c1.add("2");
        c1.add("4");
        Set<String> c2 = new HashSet<>();
        c2.add("4");
        c2.add("6");
        assertFalse(Model.bisimEquals(s1, s2, c1, c2));
    }

    @Test
    void bisimEquals1False() {
        Set<String> s1 = new HashSet<>();
        s1.add("1");
        s1.add("2");
        s1.add("3");
        s1.add("4");
        Set<String> s2 = new HashSet<>();
        s2.add("1");
        s2.add("5");
        s2.add("3");
        s2.add("6");
        Set<String> c1 = new HashSet<>();
        c1.add("2");
        c1.add("4");
        Set<String> c2 = new HashSet<>();
        c2.add("3");
        c2.add("6");
        assertFalse(Model.bisimEquals(s1, s2, c1, c2));
    }

    @Test
    void bisimEquals1() {
        Set<String> s1 = new HashSet<>();
        s1.add("1");
        s1.add("2");
        s1.add("3");
        s1.add("4");
        Set<String> s2 = new HashSet<>();
        s2.add("1");
        s2.add("5");
        s2.add("3");
        s2.add("6");
        Set<String> c1 = new HashSet<>();
        c1.add("2");
        c1.add("5");
        Set<String> c2 = new HashSet<>();
        c2.add("4");
        c2.add("6");
        assertTrue(Model.bisimEquals(s1, s2, c1, c2));
    }

    @Test
    void bisimEqualsFalse() {
        Set<String> s1 = new HashSet<>();
        s1.add("1");
        s1.add("2");
        Set<String> s2 = new HashSet<>();
        s2.add("1");
        s2.add("3");
        Set<String> c = new HashSet<>();
        c.add("1");
        c.add("3");
        assertFalse(Model.bisimEquals(s1, s2, c));
    }

    @Test
    void bisimEquals() {
        Set<String> s1 = new HashSet<>();
        s1.add("1");
        s1.add("2");
        Set<String> s2 = new HashSet<>();
        s2.add("1");
        s2.add("3");
        Set<String> c = new HashSet<>();
        c.add("2");
        c.add("3");
        assertTrue(Model.bisimEquals(s1, s2, c));
    }

    @Test
    void equalsReflexive() {
        assertTrue(ModelChecker.readModel(MFP + "sample2").equals(ModelChecker.readModel(MFP + "sample2")));
    }

    @Test
    void equalsReflexiveFalse() {
        assertFalse(ModelChecker.readModel(MFP + "sample2").equals(ModelChecker.readModel(MFP + "sample2.5")));
    }

    @Test
    void modelToStringSmall() {
        Model m = ModelChecker.readModel(BMFP+"bisimSample1");
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