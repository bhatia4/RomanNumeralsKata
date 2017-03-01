package feature1;

import exceptions.InvalidArabicNumberException;


public class ArabicToRomanConvertor {
	
	public String convertArabicNumberToRomanNumeral(String arabicNumberString)
	{
		long inputArabicNumber = 0l;
		long quotient = 0l;
		long remainder = 0l;
		StringBuilder romanNumeral = new StringBuilder();
		
		try
		{
			inputArabicNumber = Long.parseLong(arabicNumberString.trim());
		} catch (NumberFormatException nfe) {
			throw new InvalidArabicNumberException(nfe.getMessage());
		}
		
		if (inputArabicNumber == 0)
			throw new InvalidArabicNumberException("No Zero value in Roman numerals");
		
		//Dealing w/ Tens
		quotient = inputArabicNumber / 40l;
		remainder = inputArabicNumber % 40l;
		if (quotient == 1)
			romanNumeral.append("XL");
		else
		{
			quotient = remainder / 10l;
			remainder = remainder % 10l;
			if (quotient >= 1)
				romanNumeral = convertForArabicNumberinTens(quotient, romanNumeral);
		}		
		
		//Dealing w/ Units
		quotient = remainder / 9l;
		remainder = remainder % 9l;
		if (quotient == 1)
			romanNumeral.append("IX");
		else
		{
			quotient = remainder / 5l;
			remainder = remainder % 5l;
			if (quotient == 1)
				romanNumeral.append("V");
			else
			{
				quotient = remainder / 4l;
				remainder = remainder % 4l;
				if (quotient == 1)
					romanNumeral.append("IV");
			}
			romanNumeral = convertForArabicNumberLessThan4(remainder, romanNumeral);
		}
		
		return romanNumeral.toString();
	}

	private StringBuilder convertForArabicNumberinTens(long inputArabicNumber, StringBuilder romanStr) {
		for(int i=1; i<=inputArabicNumber;i++)
			romanStr.append("X");

		return romanStr;	
	}
		
	private StringBuilder convertForArabicNumberLessThan4(long inputArabicNumber, StringBuilder romanStr) {
		for(int i=1; i<=inputArabicNumber;i++)
			romanStr.append("I");

		return romanStr;	
	}
}
