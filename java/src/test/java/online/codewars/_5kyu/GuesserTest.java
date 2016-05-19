package online.codewars._5kyu;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by Hey on 18 May 2016
 */
public class GuesserTest {
    static boolean guessed;

    @Test
    public void shouldRevealAnswer() throws Exception {
        new EveryoneHasHisLittleSecrets.Guesser().guess();
        final String declaredMethods = Arrays.toString(LittleClass.class.getDeclaredMethods());
        final String declaredFields = Arrays.toString(LittleClass.class.getDeclaredFields());
        final String declaredConstructors = Arrays.toString(LittleClass.class.getDeclaredConstructors());
        final Field secret = LittleClass.class.getDeclaredField("secret");
        secret.setAccessible(true);
        final String secretString = (String) secret.get(null);
    }
}