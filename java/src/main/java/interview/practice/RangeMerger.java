package interview.practice;

import java.util.Objects;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class RangeMerger {
    private static class Range {
        final long start;
        final long end;

        Range(long start, long end) {
            this.start = start;
            this.end = end;
        }

        static Range fromId(long id) {
            return new Range(id, id);
        }

        public long getStart() {
            return start;
        }

        public long getEnd() {
            return end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Range range = (Range) o;
            return start == range.start &&
                    end == range.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    private TreeSet<Range> ranges;

    public RangeMerger() {
        this.ranges = createRangesTreeSet();
    }

    private TreeSet<Range> createRangesTreeSet() {
        return new TreeSet<>(comparing(Range::getStart));
    }

    public void put(long id) {
        Range idAsRange = Range.fromId(id);
        if (!contains(idAsRange)) {
            ranges.add(idAsRange);
            this.ranges = mergeRanges();
        }
    }

    public int size() {
        return ranges.size();
    }

    public boolean contains(long id) {
        return contains(Range.fromId(id));
    }

    private TreeSet<Range> mergeRanges() {
        final TreeSet<Range> newRanges = createRangesTreeSet();
        if (!this.ranges.isEmpty()) {
            long currentStart = ranges.first().start, currentEnd = ranges.first().end;
            for (Range range : ranges) {
                if (canMerge(currentEnd, range)) {
                    currentEnd = range.end;
                } else {
                    newRanges.add(new Range(currentStart, currentEnd));
                    currentStart = range.start;
                    currentEnd = range.end;
                }
            }
            newRanges.add(new Range(currentStart, currentEnd));
        }
        return newRanges;
    }

    private boolean canMerge(long currentEnd, Range range) {
        return currentEnd >= (range.start - 1);
    }

    private boolean contains(Range idAsRange) {
        Range possiblyPrevRange = ranges.floor(idAsRange);
        if (possiblyPrevRange != null) {
            return possiblyPrevRange.start <= idAsRange.start && idAsRange.end <= possiblyPrevRange.end;
        } else {
            return false;
        }
    }
}
