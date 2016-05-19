package text;

import com.google.common.base.CaseFormat;

/**
 * Created by Hey on 19 May 2016
 */
public class TextConverter {

    public static void main(String[] args) {
        System.out.println(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, "shouldCreateTestUserAndTestExample"));
    }

}
