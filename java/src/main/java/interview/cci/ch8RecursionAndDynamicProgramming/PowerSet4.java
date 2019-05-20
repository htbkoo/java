package interview.cci.ch8RecursionAndDynamicProgramming;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PowerSet4 {

    public Set<Set<Integer>> findAllSubsets(Set<Integer> set) {
        return subsets(new HashSet<>(), set);
    }

    private Set<Set<Integer>> subsets(Set<Integer> current, Set<Integer> candidates) {
        if (candidates.isEmpty()) {
            return new HashSet<>(Collections.singletonList(current));
        } else {
            Set<Set<Integer>> answers = new HashSet<>();
            answers.add(current);
            candidates.forEach(candidate -> {
                Set<Integer> newCurrent = new HashSet<>(current);
                newCurrent.add(candidate);
                Set<Integer> newCandidates = new HashSet<>(candidates);
                newCandidates.remove(candidate);
                answers.addAll(subsets(newCurrent, newCandidates));
            });
            return answers;
        }
    }
}