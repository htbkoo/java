package online.hackerrank.practice.dataStructures.arrays;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DynamicArrayState {
    private final List<List<Integer>> seqLists;
    private final List<Integer> answers;
    private final Integer lastAnswer;

    private DynamicArrayState(List<List<Integer>> seqLists, List<Integer> answers, Integer lastAnswer) {
        this.seqLists = seqLists;
        this.answers = answers;
        this.lastAnswer = lastAnswer;
    }

    public static DynamicArrayState initialState(int seqListsSize) {
        return new DynamicArrayState(newSeqLists(seqListsSize), new ArrayList<>(), 0);
    }

    private static List<List<Integer>> newSeqLists(int seqListsSize) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < seqListsSize; ++i) {
            lists.add(new ArrayList<>());
        }
        return lists;
    }

    public List<List<Integer>> getSeqLists() {
        return copyOfSeqLists();
    }

    public List<Integer> getAnswers() {
        return copyOfAnswers();
    }

    public Integer getLastAnswer() {
        return lastAnswer;
    }

    public DynamicArrayState withAppendToSeqList(int item, int listIndex) {
        final List<List<Integer>> newSeqLists = copyOfSeqLists();
        newSeqLists.get(listIndex).add(item);
        return new DynamicArrayState(newSeqLists, copyOfAnswers(), lastAnswer);
    }

    private List<List<Integer>> copyOfSeqLists() {
        return seqLists.stream()
                .map(ArrayList::new)
                .collect(toList());
    }

    private ArrayList<Integer> copyOfAnswers() {
        return new ArrayList<>(answers);
    }
}
