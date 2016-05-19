package online.codewars._5kyu;

/**
 * Created by Hey on 15 May 2016.
 * <p>
 * ---
 * <p>
 * http://www.codewars.com/kata/everyone-has-his-little-secrets/train/java
 */

/*

Hello,

I'm a little class and I have a secret.

Will you find it ?

* */

public class EveryoneHasHisLittleSecrets {
    public static class Guesser {
        //        public void guess() {
//            LittleClass.isMySecret("thatILoveUnicorns");
//        }
        public void guess() {
            LittleClass.isMySecret("notVeryWellProtected");
        }
    }
}
