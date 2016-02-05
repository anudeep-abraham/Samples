package com.leetspeak;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LeetSpeakTest {
	private String expectedResult;
	private String inputValue;
	private LeetSpeak leetSpeak;

	public LeetSpeakTest(String inputValue, String expectedResult) {
		this.expectedResult = expectedResult;
		this.inputValue = inputValue;
	}

	@Before
	public void setUp() {
		leetSpeak = new LeetSpeak();
	}

	@Parameters
	public static Collection<Object[]> testData() {
		Object[][] data = new Object[][] { { "Let's have some fun.", "L37'5 h4v3 50m3 fun." },
				{ "C is for cookie, that's good enough for me", "C 15 f0r c00k13, 7h47'5 g00d 3n0ugh f0r m3" },
				{ "By the power of Grayskull!", "By 7h3 p0w3r 0f Gr4y5kull!" } };
		return Arrays.asList(data);
	}

	@Test
	public void test() {
		assertEquals(expectedResult, leetSpeak.generateLeetSpeak(inputValue));
	}
}
