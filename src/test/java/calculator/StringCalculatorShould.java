package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

	class StringCalculatorShould {

		private StringCalculator stringCalculator;
		
		@BeforeEach
	    public void init()
		{
			stringCalculator = new StringCalculator();
		}
		
		@Test
	    public void empty_string_should_return_0() 
		{
	        assertEquals(0, stringCalculator.add(""));
	    }
		 @Test
	    public void string_with_single_number_should_return_number_as_int() 
	    {
	        assertEquals(1, stringCalculator.add("1"));
	    }
		  @Test
	    public void stringHavingNumbers()
	    {
	        assertEquals(stringCalculator.add("50,60"),50+60);
	    }
	    
	    @Test
	    public void StringUnknownNumbers()
	    {
	    	assertEquals(11+22+33+44+55, stringCalculator.add("11,22,33,44,55"));
	    }
	    @Test
	    public void stringWithTwoLinesBetNumbers()
	    {
	        assertEquals(13, stringCalculator.add("8\n5"));
	    }
	    
	    @Test
	    public void stringWithDifferentDelimeter()
	    {
	    	assertEquals(14+55+2, stringCalculator.add("//;\n14;55;2") );
	    }
		 @Test
	    public void stringWithSingleNegativeNoThrowsException()
	    {
	    	assertThrows(RuntimeException.class, ()->
	    		
	    		stringCalculator.add("2,-6,4")
	    	);
	    }
	    
	    @Test
	    public void stringWithMultipleNegativeNoThrowsException()
	    {
	    		RuntimeException rexe= null;
	    		try{
	    			stringCalculator.add("4,2,-9,-7,4,5");
	    		}catch(RuntimeException e)
	    		{
	    			rexe=e;
	    		}
	    	
	    	assertNotNull(rexe);
	    	assertEquals("negatives not allowed: [-9, -7]", rexe.getMessage());	    	
	    }
	    
}
