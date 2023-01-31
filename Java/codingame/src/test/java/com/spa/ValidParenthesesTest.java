package com.spa;

import com.spa.codewars.ValidParentheses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidParenthesesTest {

    @Test
    public void sampleTest() {
        // assertEquals("expected", "actual");
        assertEquals(true, ValidParentheses.validParentheses( "()" ));
        assertEquals(false,ValidParentheses.validParentheses( "())" ));
        assertEquals(true,ValidParentheses.validParentheses( "32423(sgsdg)" ));
        assertEquals(false,ValidParentheses.validParentheses( "(dsgdsg))2432" ));
        assertEquals(true,ValidParentheses.validParentheses( "adasdasfa" ));
    }
}
