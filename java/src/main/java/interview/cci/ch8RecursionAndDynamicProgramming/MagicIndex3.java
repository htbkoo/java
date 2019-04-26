package interview.cci.ch8RecursionAndDynamicProgramming;

import java.util.Optional;

public class MagicIndex3 {

    public Optional<Integer> findMagicIndex(int[] A) {
        int length = A.length;
        int first = A[0], last = A[length - 1];
        if ((first > 0 && last > length - 1) || (first < 0 && last < length - 1)) {
            return Optional.empty();
        } else {
            int lo = 0, hi = length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                int target = A[mid];
                if (mid == target) {
                    return Optional.of(mid);
                } else if (mid < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
// TODO: to confirm
            return Optional.of((lo + hi) / 2);
        }

    }
}