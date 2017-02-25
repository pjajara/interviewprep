package edu.sjsu.java.todelete;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeleteTest {

	@Before
	public void setUp() throws Exception {
		Delete1 d = new Delete1();
	}
	
	@Test
	public void testReverse(){
		Assert.assertEquals("abc",Delete1.reverse("cba"));
		Assert.assertEquals("a", Delete1.reverse("a"));
		Assert.assertTrue(Delete1.reverse(null) == null);
		Assert.assertNotSame("dfdsklj", Delete1.reverse("abcdefg"));
		Assert.assertFalse(Delete1.reverse("") == "");
	}

}
