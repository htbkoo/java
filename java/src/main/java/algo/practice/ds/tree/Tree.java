package algo.practice.ds.tree;

/**
 * Created by Hey on 3 Aug 2016
 */
public interface Tree<T> {
    boolean isExist(T target);

    int size();

    void insert(T target);

    void delete(T target);
}