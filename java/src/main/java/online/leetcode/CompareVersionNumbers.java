package online.leetcode;

/**
 * Created by Hey on 6/12/15
 */

/*

https://leetcode.com/problems/compare-version-numbers/

Compare two version numbers version1 and version2.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

Subscribe to see which companies asked this question

*/

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        try {
            StringBuilder sbVersion1 = new StringBuilder(version1);
            StringBuilder sbVersion2 = new StringBuilder(version2);

            while ((sbVersion1.length() > 0) && (sbVersion2.length() > 0)) {
                int sb1Dot = getSbDot(sbVersion1);
                long sb1Cur = Long.parseLong(sbVersion1.substring(0, sb1Dot));

                int sb2Dot = getSbDot(sbVersion2);
                long sb2Cur = Long.parseLong(sbVersion2.substring(0, sb2Dot));

                if (sb1Cur != sb2Cur) {
                    return Long.compare(sb1Cur, sb2Cur);
                }
                updateVersionStringBuilder(sbVersion1, sb1Dot);
                updateVersionStringBuilder(sbVersion2, sb2Dot);
            }

            if (sbVersion1.length() > 0) {
                while (sbVersion1.length() > 0) {
                    int sb1Dot = getSbDot(sbVersion1);
                    long sb1Cur = Long.parseLong(sbVersion1.substring(0, sb1Dot));
                    if (sb1Cur != 0) {
                        return 1;
                    }
                    updateVersionStringBuilder(sbVersion1, sb1Dot);
                }
            } else if (sbVersion2.length() > 0) {
                while (sbVersion2.length() > 0) {
                    int sb2Dot = getSbDot(sbVersion2);
                    long sb2Cur = Long.parseLong(sbVersion2.substring(0, sb2Dot));
                    if (sb2Cur != 0) {
                        return -1;
                    }
                    updateVersionStringBuilder(sbVersion2, sb2Dot);
                }
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }

    private int getSbDot(StringBuilder sbVersion) {
        final int sbDot = sbVersion.indexOf(".");
        return (sbDot == -1) ? sbVersion.length() : sbDot;
    }

    private void updateVersionStringBuilder(StringBuilder sbVersion, int sbDot) {
        if (sbDot == sbVersion.length()) {
            sbVersion.setLength(0);
        } else {
            sbVersion.delete(0, sbDot + 1);
        }
    }
}
