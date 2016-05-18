package online.codewars._5kyu;

/**
 * Created by Hey on 18 May 2016
 *
 * ---
 *
 * Stupid Utility class used by EveryoneHasHisLittleSecrets
 */
public class LittleClass {
    private static String secret = "notVeryWellProtected";

    public static void isMySecret(String s) {
        GuesserTest.guessed = true;
    }
}
