package be.ordina.test.classes.streaming;

import be.ordina.test.classes.BaseTest;
import org.junit.After;
import org.junit.Before;

public abstract class StreamingTest extends BaseTest {

    @Before
    public void setUpBeforeTestClass() {
        super.setUpBeforeTestClass();
    }

    @Before
    public void signUpBeforeTestMethod() {
        super.signUpBeforeTestMethod();
    }

    @After
    public void signOutAfterTestMethod() {
        super.signOutAfterTestMethod();
    }

    @After
    public void tearDownAfterTestClass() {
        super.tearDownAfterTestClass();
    }
}
