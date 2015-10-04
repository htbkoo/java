package java;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.runner.RunWith;

/**
 * Created by Hey on 27/9/15
 */
@RunWith(ClasspathSuite.class)
@ClasspathSuite.ClassnameFilters({".*IntegrationTest"})
public class IntegrationTestSuite {

}
