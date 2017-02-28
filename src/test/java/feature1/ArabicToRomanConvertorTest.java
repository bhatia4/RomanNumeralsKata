package feature1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.InvalidArabicNumberException;

public class ArabicToRomanConvertorTest {

	ArabicToRomanConvertor convertor;
	
	@Before
	public void setUp() throws Exception {
		convertor = new ArabicToRomanConvertor();
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test(expected=InvalidArabicNumberException.class)
	public void test1ForInvalidNumber() {
		convertor.convertArabicNumberToRomanNumeral("");
	}

	@Test(expected=InvalidArabicNumberException.class)
	public void test2ForInvalidNumber() {
		convertor.convertArabicNumberToRomanNumeral(" ");
	}
	
	@Test(expected=InvalidArabicNumberException.class)
	public void test3ForInvalidNumber() {
		convertor.convertArabicNumberToRomanNumeral("blah blah");
	}
	
	@Test(expected=InvalidArabicNumberException.class)
	public void test4ForInvalidNumber() {
		convertor.convertArabicNumberToRomanNumeral("10 00");
	}
	
	@Test(expected=InvalidArabicNumberException.class)
	public void test5ForInvalidNumber() {
		convertor.convertArabicNumberToRomanNumeral("0");
	}
	
	@Test
	public void testForNumberSurroundedBySpaces() {
		assertEquals("I", convertor.convertArabicNumberToRomanNumeral(" 1 "));
	}
	
	@Test
	public void testRomanNumeralForOne() {
		assertEquals("I", convertor.convertArabicNumberToRomanNumeral("1"));
	}
	
	@Test
	public void testRomanNumeralForTwo() {
		assertEquals("II", convertor.convertArabicNumberToRomanNumeral("2"));
	}
	
	@Test
	public void testRomanNumeralslessThanEqualToFive() {
		assertEquals("III", convertor.convertArabicNumberToRomanNumeral("3"));
		assertEquals("IV", convertor.convertArabicNumberToRomanNumeral("4"));
		assertEquals("V", convertor.convertArabicNumberToRomanNumeral("5"));
	}
	
	@Test
	public void testRomanNumeralsBetweenSixAndTen() {
		assertEquals("VI", convertor.convertArabicNumberToRomanNumeral("6"));
		assertEquals("VII", convertor.convertArabicNumberToRomanNumeral("7"));
		assertEquals("VIII", convertor.convertArabicNumberToRomanNumeral("8"));
		assertEquals("IX", convertor.convertArabicNumberToRomanNumeral("9"));
		assertEquals("X", convertor.convertArabicNumberToRomanNumeral("10"));
	}
}
