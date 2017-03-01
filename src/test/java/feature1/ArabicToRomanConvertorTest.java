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
	
	
	@Test
	public void testRomanNumeralsBetween11And40() {
		assertEquals("XL", convertor.convertArabicNumberToRomanNumeral("40"));
		assertEquals("XXX", convertor.convertArabicNumberToRomanNumeral("30"));
		assertEquals("XX", convertor.convertArabicNumberToRomanNumeral("20"));
		
		assertEquals("XXXIX", convertor.convertArabicNumberToRomanNumeral("39"));
		assertEquals("XXXVII", convertor.convertArabicNumberToRomanNumeral("37"));
		assertEquals("XXXV", convertor.convertArabicNumberToRomanNumeral("35"));
		assertEquals("XXXIV", convertor.convertArabicNumberToRomanNumeral("34"));
		assertEquals("XXXI", convertor.convertArabicNumberToRomanNumeral("31"));
		
		assertEquals("XXVIII", convertor.convertArabicNumberToRomanNumeral("28"));
		assertEquals("XXIV", convertor.convertArabicNumberToRomanNumeral("24"));
		assertEquals("XXIII", convertor.convertArabicNumberToRomanNumeral("23"));

		assertEquals("XIX", convertor.convertArabicNumberToRomanNumeral("19"));		
		assertEquals("XVI", convertor.convertArabicNumberToRomanNumeral("16"));
		assertEquals("XV", convertor.convertArabicNumberToRomanNumeral("15"));
		assertEquals("XIV", convertor.convertArabicNumberToRomanNumeral("14"));
		assertEquals("XI", convertor.convertArabicNumberToRomanNumeral("11"));
	}
	
	@Test
	public void testRomanNumeralsBetween41And50() {
		assertEquals("L", convertor.convertArabicNumberToRomanNumeral("50"));
		assertEquals("XLIX", convertor.convertArabicNumberToRomanNumeral("49"));
		assertEquals("XLVIII", convertor.convertArabicNumberToRomanNumeral("48"));
		assertEquals("XLV", convertor.convertArabicNumberToRomanNumeral("45"));
		assertEquals("XLI", convertor.convertArabicNumberToRomanNumeral("41"));
	}
	
	
	@Test
	public void testRomanNumeralsBetween51And99() {
		assertEquals("XCIX", convertor.convertArabicNumberToRomanNumeral("99"));
		assertEquals("XCV", convertor.convertArabicNumberToRomanNumeral("95"));
		assertEquals("XCI", convertor.convertArabicNumberToRomanNumeral("91"));
		assertEquals("XC", convertor.convertArabicNumberToRomanNumeral("90"));
		assertEquals("LXXXVIII", convertor.convertArabicNumberToRomanNumeral("88"));
		assertEquals("LXXXIV", convertor.convertArabicNumberToRomanNumeral("84"));
		assertEquals("LXXX", convertor.convertArabicNumberToRomanNumeral("80"));
		assertEquals("LX", convertor.convertArabicNumberToRomanNumeral("60"));
		assertEquals("LIX", convertor.convertArabicNumberToRomanNumeral("59"));
	}
}
