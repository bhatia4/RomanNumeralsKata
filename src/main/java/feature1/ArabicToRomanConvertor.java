/** 
 * @author Kunal Bhatia
 */
package feature1;

import exceptions.InvalidArabicNumberException;


public class ArabicToRomanConvertor {
	private enum RomanSymbols {
		M, CM, D, CD, C, XC, L, XL, X, IX, V, IV, I 
	}
	
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

		//Dealing with 1000s
		quotient = inputArabicNumber / 1000l;
		remainder = inputArabicNumber % 1000l;
		if (quotient >= 1)
		{
			if (quotient < 4)
				romanNumeral = repeatSymbolsByCount(RomanSymbols.M.toString(), quotient, romanNumeral);
			else
			{
				//throw exception - higher numbers not part of kata
				throw new InvalidArabicNumberException("While roman letters do exist for higher numbers this kata is limited to roman numeral equivalent of 3999. Any higher numbers throw this exception.");
			}
		}

		//Dealing w/ 900s, 500s, 400s & any leftover 100s
		quotient = remainder / 900l;
		remainder = remainder % 900l;
		if (quotient == 1)
			romanNumeral.append(RomanSymbols.CM);
		else
		{
			quotient = remainder / 500l;
			remainder = remainder % 500l;
			if (quotient == 1)
				romanNumeral.append(RomanSymbols.D);
			else
			{
				quotient = remainder / 400l;
				remainder = remainder % 400l;
				if (quotient == 1)
					romanNumeral.append(RomanSymbols.CD);
			}

			//Dealing with 100s
			quotient = remainder / 100l;
			remainder = remainder % 100l;
			if (quotient >= 1)
				romanNumeral = repeatSymbolsByCount(RomanSymbols.C.toString(), quotient, romanNumeral);
		}
		
		//Dealing w/ 90s, 50s, 40s & any leftover 10s
		quotient = remainder / 90l;
		remainder = remainder % 90l;
		if (quotient == 1)
			romanNumeral.append(RomanSymbols.XC);
		else
		{
			quotient = remainder / 50l;
			remainder = remainder % 50l;
			if (quotient == 1)
				romanNumeral.append(RomanSymbols.L);
			else
			{
				quotient = remainder / 40l;
				remainder = remainder % 40l;
				if (quotient == 1)
					romanNumeral.append(RomanSymbols.XL);
			}

			//Dealing w/ 10s
			quotient = remainder / 10l;
			remainder = remainder % 10l;
			if (quotient >= 1)
				romanNumeral = repeatSymbolsByCount(RomanSymbols.X.toString(), quotient, romanNumeral);
		}
		
		//Dealing w/ Units
		quotient = remainder / 9l;
		remainder = remainder % 9l;
		if (quotient == 1)
			romanNumeral.append(RomanSymbols.IX);
		else
		{
			quotient = remainder / 5l;
			remainder = remainder % 5l;
			if (quotient == 1)
				romanNumeral.append(RomanSymbols.V);
			else
			{
				quotient = remainder / 4l;
				remainder = remainder % 4l;
				if (quotient == 1)
					romanNumeral.append(RomanSymbols.IV);
			}
			romanNumeral = repeatSymbolsByCount(RomanSymbols.I.toString(), remainder, romanNumeral);
		}
		
		return romanNumeral.toString();
	}

	private StringBuilder repeatSymbolsByCount(String symbol, long count,	StringBuilder romanStr) {
		for(int i=1; i<=count;i++)
			romanStr.append(symbol);

		return romanStr;	
	}
}
