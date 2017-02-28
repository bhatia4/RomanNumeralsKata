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
		
		if (inputArabicNumber%10 == 0)
			return "X";
		else
			if (inputArabicNumber%9 == 0)
				return "IX";
			else
			{
				quotient = inputArabicNumber / 5l;
				remainder = inputArabicNumber % 5l;
				if (quotient == 1)
					romanNumeral.append("V");
				else
				{
					quotient = inputArabicNumber / 4l;
					remainder = inputArabicNumber % 4l;
					if (quotient == 1)
						romanNumeral.append("IV");
				}

				return convertForArabicNumberLessThan4(remainder, romanNumeral);
			}
				
/*		if (inputArabicNumber%5 == 0)
				return "V";
			else
				if (inputArabicNumber%4 == 0)
					return "IV";
				else
					return convertForArabicNumberLessThan4(inputArabicNumber);*/
	}

	private String convertForArabicNumberLessThan4(long inputArabicNumber, StringBuilder romanStr) {
		for(int i=1; i<=inputArabicNumber;i++)
			romanStr.append("I");

		return romanStr.toString();	
	}
}
