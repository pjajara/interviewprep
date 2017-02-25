package edu.sjsu.java.string;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;

public class StringUtilsTest extends TestCase {

	@Ignore
	public void testWordReverse(){
		assertEquals("pawan from world hello ",StringUtils.reverseWords("hello world from pawan"));
	}
	
	@Test
	public void testCharCount(){
		/*assertEquals(2, StringUtils.charCount("Hello, world", 'o'));
		assertEquals(3, StringUtils.charCount("Hello, world", 'l'));
		assertEquals(1, StringUtils.charCount("Hello, world", 'w'));
		assertEquals(1, StringUtils.charCount("Hello, world", 'd'));
		assertEquals(0, StringUtils.charCount(null, 'd'));
		assertEquals(0, StringUtils.charCount("Hello, world", '\0'));*/
		assertEquals(true, StringUtils.checkPalindrome("Malayalam"));
		assertEquals(false, StringUtils.checkPalindrome("Mlam"));
		assertEquals(true, StringUtils.checkPalindrome("Madam"));
		assertEquals(true, StringUtils.checkPalindrome("docod"));
		assertEquals(false, StringUtils.checkPalindrome(null));
		assertEquals(false, StringUtils.checkPalindrome("e"));
	}
}
