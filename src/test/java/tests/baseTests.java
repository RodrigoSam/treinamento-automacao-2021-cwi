package tests;

import org.junit.After;
import org.junit.Before;
import utils.Browser;
import utils.Utils;

public class baseTests {

    @Before
    public void setup(){
        Browser.loadpage(Utils.getBaseUrl());
    }

    @After
    public void tearDown(){
        Browser.close();
    }
}
