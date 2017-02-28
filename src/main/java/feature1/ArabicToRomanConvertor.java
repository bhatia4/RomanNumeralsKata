package feature1;

import exceptions.InvalidArabicNumberException;


public class ArabicToRomanConvertor {
	
	public String convertArabicNumberToRomanNumeral(String arabicNumberString)
	{
		long inputArabicNumber = 0l;
		try
		{
			inputArabicNumber = Long.parseLong(arabicNumberString.trim());
		} catch (NumberFormatException nfe) {
			throw new InvalidArabicNumberException(nfe.getMessage());
		}
		
		if (inputArabicNumber == 0)
			throw new InvalidArabicNumberException("No Zero value in Roman numerals");
		
		if (inputArabicNumber == 1)
			return "I";
		else
			if (inputArabicNumber%5 == 0)
				return "V";
			else
				if (inputArabicNumber%4 == 0)
					return "IV";
				else
					return 	convertForArabicNumberLessThan4(inputArabicNumber);
	}

	private String convertForArabicNumberLessThan4(long inputArabicNumber) {
		StringBuilder romanStr = new StringBuilder();
		
		for(int i=1; i<=inputArabicNumber;i++)
			romanStr.append("I");

		return romanStr.toString();	
	}
}
