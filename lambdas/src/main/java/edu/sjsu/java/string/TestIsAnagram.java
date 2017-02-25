package edu.sjsu.java.string;

import org.junit.Assert;
import org.junit.Test;


public class TestIsAnagram{

	@Test
	public void testIsAnagram(){
		Assert.assertEquals(true, Anagram.checkAnagram("PKPKPK", "KPKPKP"));
		Assert.assertEquals(false, Anagram.checkAnagram(null, "KPKPKP"));
		Assert.assertEquals(false, Anagram.checkAnagram(null, null));
		Assert.assertEquals(false, Anagram.checkAnagram("kjjlksjdfljlsd", "lklkjjljljljjljl"));
		Assert.assertEquals(false, Anagram.checkAnagram("ABC", "abc"));
		Assert.assertEquals(true, Anagram.checkAnagram("des", "sed"));
		Assert.assertEquals(true, Anagram.checkAnagram("boyboy", "yoyobb"));
		Assert.assertEquals(true, Anagram.checkAnagram("", ""));
	}

}
