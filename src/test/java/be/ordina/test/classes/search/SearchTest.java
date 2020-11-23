package be.ordina.test.classes.search;

import be.ordina.test.classes.BaseTest;
import org.junit.After;
import org.junit.Before;

public abstract class SearchTest extends BaseTest {

    @Before
    public void setUpBeforeTestClass() {
        super.setUpBeforeTestClass();
    }

    @Before
    public void signInBeforeTestMethod() {
        super.signInBeforeTestMethod();
    }

    @After
    public void tearDownAfterTestClass() {
        super.tearDownAfterTestClass();
    }
}
