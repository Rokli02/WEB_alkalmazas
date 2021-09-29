package szamologepszervlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name="szamologep", urlPatterns="/szamologep.do")
public class Servlet2 extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResultDto resultDto = new ResultDto();
		List<String> errorList = new ArrayList<>();
		
		String aString = req.getParameter("a");
		Double a = 0.0;
		if(aString == null) {
			errorList.add("Az 'a' paraméter nem lehet üres!");
			resultDto.setError(true);
		} else {
			try {
				a = Double.parseDouble(aString);
			} catch(NumberFormatException nfe) {
				errorList.add("Az 'a' paraméter szám kell, hogy legyen!");
				resultDto.setError(true);
			}
		}
		resultDto.setA(aString);
		
		String bString = req.getParameter("b");
		Double b = 0.0;
		if(bString == null) {
			errorList.add("Az 'b' paraméter nem lehet üres!");
			resultDto.setError(true);
		} else {
			try {
				b = Double.parseDouble(bString);
			} catch(NumberFormatException nfe) {
				errorList.add("Az 'b' paraméter szám kell, hogy legyen!");
				resultDto.setError(true);
			}
		}
		resultDto.setB(bString);
		
		String operator = req.getParameter("operator");
		resultDto.setOperator(operator);
		if (operator==null) {
			errorList.add("Az operátornak létezni kell, nem lehet üres!");
			resultDto.setError(true);
		}
		switch (operator) {
		case "+": ;
		break;
		case "-": ;
		break;
		case "*": ;
		break;
		case "/": ;
		break;
		default:
			errorList.add("Nem támogatott művelet!");
			resultDto.setError(true);
		}
		
		Double result = 0.0;
		if(errorList.isEmpty()) {
			if ("+".equals(operator)) {
				result = a + b;
			}
			if ("*".equals(operator)) {
				result = a * b;
			}
			if ("-".equals(operator)) {
				result = a - b;
			}
			if ("/".equals(operator)) {
				if(b == 0.0) {
					errorList.add("A nevező nem lehet nulla!");
					resultDto.setError(true);
				}
				else
					result = a / b;
			}	
		}
		
		resultDto.setResult(result);
		resultDto.setErrorList(errorList);
		
		//eltarolja a keres attributumba az összes infót,
		//hogy a jsp is elerje
		req.setAttribute("result", resultDto);
		
		RequestDispatcher rd = req.getSession()
								.getServletContext()
								.getRequestDispatcher("/");
		
		rd.forward(req, resp);
	}
	
}
