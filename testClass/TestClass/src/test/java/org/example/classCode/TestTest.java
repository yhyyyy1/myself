package org.example.classCode;
import org.junit.Test;

import static org.example.classCode.Test.patternIndex;
import static org.junit.Assert.assertEquals;
public class TestTest {
    @Test
    public void testPatternIndex() {
        assertEquals(-1, patternIndex("x", "xxx"));
        assertEquals(-1, patternIndex("xy", "xz"));
        assertEquals(0, patternIndex("xy", "xy"));
        assertEquals(1, patternIndex("xyy", "y"));
        assertEquals(1, patternIndex("xyz", "yz"));
        assertEquals(-1, patternIndex("qwer", "qq"));
        assertEquals(2, patternIndex("asdf", "df"));
        assertEquals(1, patternIndex("yui", "ui"));
        assertEquals(0, patternIndex("abcde", "a"));
        assertEquals(2, patternIndex("aabbcc", "bb"));
    }
}
