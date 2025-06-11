package br.com.study.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.study.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {
	
	@RequestMapping("/sum/{n1}/{n2}")
	public Double sum(
			@PathVariable("n1") String n1, 
			@PathVariable("n2") String n2) throws IllegalArgumentException {
		if(!isNumeric(n1) || !isNumeric(n2)) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		return convertToDouble(n1) + convertToDouble(n2);
	}
	
	@RequestMapping("/sub/{n1}/{n2}")
	public Double sub(
			@PathVariable("n1") String n1,
			@PathVariable("n2") String n2) throws IllegalArgumentException {
		if(!isNumeric(n1) || !isNumeric(n2))
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		return convertToDouble(n1) - convertToDouble(n2);
	}
	
	@RequestMapping("/mult/{n1}/{n2}")
	public Double mult(
			@PathVariable("n1") String n1,
			@PathVariable("n2") String n2) throws IllegalArgumentException {
		if(!isNumeric(n1) || !isNumeric(n2))
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		return convertToDouble(n1) * convertToDouble(n2);
	}
	
	@RequestMapping("/div/{n1}/{n2}")
	public Double div(
			@PathVariable("n1") String n1,
			@PathVariable("n2") String n2) throws IllegalArgumentException {
		if(!isNumeric(n1) || !isNumeric(n2))
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		if(convertToDouble(n2) == 0)
			throw new UnsupportedMathOperationException("It is not possible to divide by zero!");
		return convertToDouble(n1) / convertToDouble(n2);
	}
	
	@RequestMapping("/sqrt/{n1}")
	public Double sqrt(@PathVariable("n1") String n1) throws IllegalArgumentException {
		if(!isNumeric(n1))
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		return Math.sqrt(convertToDouble(n1));
	}

	private Double convertToDouble(String strNumber) throws IllegalArgumentException {
		if(strNumber == null || strNumber.isEmpty()) 
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		String number = strNumber.replace(",", ".");
		return Double.parseDouble(number);
	}
	
	private boolean isNumeric(String strNumber) {
		if(strNumber == null || strNumber.isEmpty()) return false;
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
