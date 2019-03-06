package mccal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intersection {

    public static <T> Set<T> intersect(Collection<Set<T>> sets) {
        Iterator<Set<T>> it = sets.iterator();
        if (!it.hasNext()) {
            return new HashSet<>();
        }
        Set<T> result = new HashSet<>(it.next());
        while (it.hasNext()) {
            result.retainAll(it.next());
        }
        return result;
    }

    public static <T> Set<T> intersect(Set<T> a, Set<T> b) {
        Set<T> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        return intersection;
    }

}
