/*
 * JMUnitTest.java
 * JMUnit based test
 *
 * Created on Jun 8, 2012, 4:56:44 PM
 */
package org.manojlovic.testSkockoj2me;

import jmunit.framework.cldc10.*;
import org.manojlovic.skockoj2me.SkockoLogic;

/**
 * @author WinXP - Avg2009
 */
public class JMUnitTest extends TestCase {
    
    private int[] res = new int[]{1,2,2,2};
    private SkockoLogic skocko;
    
    public JMUnitTest() {
        //The first parameter of inherited constructor is the number of test cases
        super(7, "JMUnitTest");
        skocko = new SkockoLogic(res);
    }    
    
    public void test(int testNumber) throws Throwable {
        switch(testNumber){
            case 0: 
                testOne();
                break;
            case 1: 
                testTwo();
                break;
            case 2: 
                testThree();
                break;
            case 3: 
                testFour();
                break;
            case 4: 
                testFive();
                break;
            case 5: 
                testSix();
                break;
            case 6: 
                testSeven();
                break;
        }
    }    
    
    private void testOne() throws Exception{
        // here we run our test, use assertXXX methods to check results
        int[] tmp = skocko.chechResult(new int[]{1,2,2,2});
        String test = "8,8,8,8"; // 4 red circls
        assertEquals(test, arrayToString(tmp));
    }
    
    private void testTwo() throws Exception{
        int[] tmp = skocko.chechResult(new int[]{3,3,3,3});
        String test = "7,7,7,7"; // 4 white circls
        assertEquals(test, arrayToString(tmp));
    }
    
    private void testThree() throws Exception{
        int[] tmp = skocko.chechResult(new int[]{2,2,2,1});
        String test = "8,8,9,9"; // 2 red and 2 yellow circls
        assertEquals(test, arrayToString(tmp));
    }
    
    private void testFour() throws Exception{
        int[] tmp = skocko.chechResult(new int[]{1,2,2,5});
        String test = "8,8,8,7";
        assertEquals(test, arrayToString(tmp));
    }
    
    private void testFive() throws Exception{
        int[] tmp = skocko.chechResult(new int[]{2,1,2,5});
        String test = "8,9,9,7";
        assertEquals(test, arrayToString(tmp));
    }
    
    private void testSix() throws Exception{
        // here we run our test, use assertXXX methods to check results
        int[] tmp = skocko.chechResult(new int[]{4,4,2,2});
        String test = "8,8,7,7";
        assertEquals(test, arrayToString(tmp));
    }
    
    private void testSeven() throws Exception{
        // here we run our test, use assertXXX methods to check results
        int[] tmp = skocko.chechResult(new int[]{2,1,4,5});
        String test = "9,9,7,7";
        assertEquals(test, arrayToString(tmp));
    }
    
    
    public String arrayToString(int[] intarray){
        String str = "";
        for (int i = 0; i < intarray.length; i++) {
            str += intarray[i];
            if(i != intarray.length - 1)
                str += ",";
        }
        return str;
    }
    
}
