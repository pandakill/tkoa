package com.tk.util;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestMD5 {

	private String plainText;	//原文
	private String encryptionString;	//密文
	private String expected;	//预期结果
	private String actual;	//实际结果
	
	@Parameters
    public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
				{ "", "d41d8cd98f00b204e9800998ecf8427e" },
				{ " ", "7215ee9c7d9dc229d2921a40e899ec5f" }, 
				{ "0123456789abcdef", "4032af8d61035123906e58e067140cc5" } });
    }
	
	 public TestMD5(String plainText, String encryptionString) {
		this.plainText = plainText;
		this.encryptionString = encryptionString;
	}
	
	@Test
	public void testMD5() {
		actual = MD5.md5(plainText);
		expected = encryptionString;
		assertEquals("加密结果不正确",expected, actual);
		assertEquals("加密后字符串长度不为32", 32, actual.length());
	}

}
