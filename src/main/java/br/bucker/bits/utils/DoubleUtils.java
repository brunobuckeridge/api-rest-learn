package br.bucker.bits.utils;

import br.bucker.bits.exceptions.ResourceNotFoundException;

public class DoubleUtils {
	
	public static Double validaNumero(String strNumber) throws Exception {
		if (strNumber == null)
			return 0D;
		
		strNumber = strNumber.replaceAll(",", ".");
		if (!isNumber(strNumber)) {
			throw new ResourceNotFoundException("Precisam ser numeros para a operação!");
		}
		
		return converteDouble(strNumber);
	}

	public static Double converteDouble(String strNumber) {		
		return Double.parseDouble(strNumber);
	}

	public static boolean isNumber(String strNumber) {
		return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
