package interview.cci.ch1ArraysAndStrings;

public class URLify3 {
    private static final char SPACE = ' ';
    private static final char[] ENCODED_SPACE = "%20".toCharArray();

    public static void urlifyInPlace(char[] chars, int trueLength) {
        int end = chars.length - 1;
        int count = 0;
        for (int i = trueLength - 1; i > 0; --i) {
            count++;
            if (SPACE == chars[i]) {
                end = getNewEndAfterCopyAndReplace(chars, end, count, i);
                count = 0;
            }
        }
    }

    private static int getNewEndAfterCopyAndReplace(char[] chars, int end, int count, int i) {
        final int destPos = end - (count - 1);
        System.arraycopy(chars, i, chars, destPos, count);
        System.arraycopy(ENCODED_SPACE, 0, chars, destPos - (ENCODED_SPACE.length - 1), ENCODED_SPACE.length);
        return end - (count - 1) - ENCODED_SPACE.length;
    }
}
