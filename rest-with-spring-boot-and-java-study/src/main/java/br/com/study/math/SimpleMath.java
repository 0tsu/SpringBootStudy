package br.com.study.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import br.com.study.exception.UnsupportedMathOperationException;

public class SimpleMath {

	public Double sum(Double n1, Double n2){
		return n1 + n2;
	}
	
	public Double sub(Double n1, Double n2){
		return n1 - n2;
	}
	
	public Double mult(Double n1, Double n2){
		return n1 * n2;
	}
	
	public Double div(Double n1, Double n2){
		return n1 / n2;
	}
	
	public Double mean(Double n1, Double n2){
		return (n1 + n2) / 2;
	}
	
	public Double sqrt(Double n1){
		return Math.sqrt((n1));
	}
}
