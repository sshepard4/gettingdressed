package com.spencershepard.gettingdressed;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the examples for the Getting Dressed application
 * 
 * @author spencer.shepard
 *
 */
public class GettingDressedTest {
    
    private static final String EOL = System.lineSeparator();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    /**
     * Setup system out to print to byte array output stream.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    /**
     * Reset the stream
     */
    @After
    public void cleanupStreams() {
        System.setOut(null);
    }
    
    /**
     * Example of hot success sequence from document.
     */
    @Test
    public void testHotSuccess() {
        final String input = "HOT 8, 6, 4, 2, 1, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, shorts, shirt, sunglasses, sandals, leaving house" + EOL, outContent.toString());
    }

    /**
     * Example of cold success sequence from document.
     */
    @Test
    public void testColdSuccess() {
        final String input = "COLD 8, 6, 3, 4, 2, 5, 1, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house" + EOL, outContent.toString());
    }

    /**
     * Example of failure due to double pants from document.
     */
    @Test
    public void testHotFailDoublePants() {
        final String input = "HOT 8, 6, 6";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, shorts, fail" + EOL, outContent.toString());
    }
    
    /**
     * Example of failure due to putting on socks when it is hot from document.
     */
    @Test
    public void testHotFailSocks() {
        final String input = "HOT 8, 6, 3";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, shorts, fail" + EOL, outContent.toString());
    }
    
    /**
     * Example of failure when cold due to not putting on socks from document.
     */
    @Test
    public void testColdFailNoSocks() {
        final String input = "COLD 8, 6, 3, 4, 2, 5, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, fail" + EOL, outContent.toString());
    }
    
    /**
     * Example of failure when cold due to taking off pajamas first from document.
     */
    @Test
    public void testColdFailNotTakingOffPjs() {
        final String input = "COLD 6";
        GettingDressed.main(input.split(" "));
        assertEquals("fail" + EOL, outContent.toString());
    }
    
    /**
     * Can't happen on command line, but test null array fails
     */
    @Test
    public void testNull() {
        GettingDressed.main(null);
        assertEquals("fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure empty array returns fail
     */
    @Test
    public void testEmpty() {
        final String input = "";
        GettingDressed.main(input.split(" "));
        assertEquals("fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure an unknown temperature results in a fail
     */
    @Test
    public void testUnknownTemperature() {
        final String input = "MILD 8, 6, 4, 2, 1, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure an command that doesn't results in an integer results in a fail
     */
    @Test
    public void testNonparseableCommand() {
        final String input = "HOT 8, 6, 4, 2, zyx, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, shorts, shirt, sunglasses, fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure an unknown command results in a fail
     */
    @Test
    public void testUnknownCommand() {
        final String input = "HOT 8, 6, 4, 23, 2, 1, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, shorts, shirt, fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure there is a failure if PJs are not off first.
     */
    @Test
    public void testPJsNotOffFirstFail() {
        final String input = "HOT 6, 8, 4, 2, 1, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure there is a failure if there is double footwear.
     */
    @Test
    public void testDoubleFootwearFail() {
        final String input = "COLD 8, 6, 3, 4, 2, 5, 1, 1, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure there is a failure if there is double headwear.
     */
    @Test
    public void testDoubleHeadwearFail() {
        final String input = "COLD 8, 6, 3, 4, 2, 5, 1, 2, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure there is a failure if there is double socks.
     */
    @Test
    public void testDoubleSocksFail() {
        final String input = "COLD 8, 6, 3, 4, 2, 5, 1, 3, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure there is a failure if there is double shirt.
     */
    @Test
    public void testDoubleShirtFail() {
        final String input = "COLD 8, 6, 3, 4, 2, 5, 1, 4, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure there is a failure if there is double jacket.
     */
    @Test
    public void testDoubleJacketFail() {
        final String input = "COLD 8, 6, 3, 4, 2, 5, 1, 5, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure there is a failure if there is double pants.
     */
    @Test
    public void testDoublePantsFail() {
        final String input = "COLD 8, 6, 3, 4, 2, 5, 1, 6, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure there is a failure if there is a double leave.
     */
    @Test
    public void testDoubleLeaveFail() {
        final String input = "COLD 8, 6, 3, 4, 2, 5, 1, 7, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house, fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure there is a failure if pajamas are removed twice.
     */
    @Test
    public void testDoublePajamasFail() {
        final String input = "COLD 8, 6, 3, 4, 2, 5, 1, 8, 7";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, fail" + EOL, outContent.toString());        
    }
    
    /**
     * Make sure there is a failure when socks are put on when it is hot
     */
    @Test
    public void testSocksWhenHotFail() {
        final String input = "HOT 8, 3";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, fail" + EOL, outContent.toString());
    }
    
    /**
     * Make sure there is a failure when jacket is put on when it is hot
     */
    @Test
    public void testJacketWhenHotFail() {
        final String input = "HOT 8, 5";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, fail" + EOL, outContent.toString());
    }
    
    /**
     * Make sure there is a failure when foot wear is put on before socks
     */
    @Test
    public void testFailWhenFootwearBeforeSocks() {
        final String input = "COLD 8, 6, 1, 3";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, pants, fail" + EOL, outContent.toString());
    }
    
    /**
     * Make sure there is a failure when foot wear is put on before pants.
     */
    @Test
    public void testFailWhenFootwearBeforePantsWhenCold() {
        final String input = "COLD 8, 3, 1, 6";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, socks, fail" + EOL, outContent.toString());
    }
    
    /**
     * Make sure there is a failure when foot wear is put on before pants.
     */
    @Test
    public void testFailWhenFootwearBeforePantsWhenHot() {
        final String input = "HOT 8, 1, 6";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, fail" + EOL, outContent.toString());
    }
    
    /**
     * Make sure there is a failure when headwear is put on before shirt
     */
    @Test
    public void testFailWhenHeadwearBeforeShirt() {
        final String input = "HOT 8, 2, 4";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, fail" + EOL, outContent.toString());
    }
    
    /**
     * Make sure there is a failure when jacket is put on before shirt.
     */
    @Test
    public void testFailWhenJacketBeforeShirt() {
        final String input = "HOT 8, 5, 4";
        GettingDressed.main(input.split(" "));
        assertEquals("Removing PJs, fail" + EOL, outContent.toString());
    }
    
    // Test when something is missing
}
