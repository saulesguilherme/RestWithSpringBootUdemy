package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationExecption;

@RestController
public class MathController {

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationExecption("Please Set a numeric valeu!");	
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
		
	}
	
	private Double convertToDouble(String strnumber) {
		if (strnumber == null) return 0D;
		String number = strnumber.replaceAll(",", ".");
		if (isNumeric(strnumber)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strnumber) {
		if (strnumber == null) return false;
		String number = strnumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+") ;
	}
	
	
}
