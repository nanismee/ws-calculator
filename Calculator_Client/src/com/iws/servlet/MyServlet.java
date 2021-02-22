package com.iws.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iws.service.CalculatorStub;
import com.iws.service.CalculatorStub.Add;
import com.iws.service.CalculatorStub.AddResponse;
import com.iws.service.CalculatorStub.Divide;
import com.iws.service.CalculatorStub.DivideResponse;
import com.iws.service.CalculatorStub.Multiply;
import com.iws.service.CalculatorStub.MultiplyResponse;
import com.iws.service.CalculatorStub.Subtract;
import com.iws.service.CalculatorStub.SubtractResponse;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String first = request.getParameter("firstNum");
		String second = request.getParameter("secondNum");
		
		String operator = request.getParameter("operator");
		
		double num1 = 0;
		double num2 = 0;
		double result = 0;
		
		try {
			 num1 = Double.parseDouble(first);
			 num2 = Double.parseDouble(second);
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		CalculatorStub stub = new CalculatorStub();
		
			if (operator.equals("+")) {
			Add add = new Add();
			add.setNum1(num1);
			add.setNum2(num2);
			AddResponse addResponse = stub.add(add);
			result = addResponse.get_return();
		} else if (operator.equals("-")) {
			Subtract sub = new Subtract();
			sub.setNum1(num1);
			sub.setNum2(num2);
			SubtractResponse subResponse = stub.subtract(sub);
			result = subResponse.get_return();
		} else if (operator.equals("*")) {
			Multiply mul = new Multiply();
			mul.setNum1(num1);
			mul.setNum2(num2);
			MultiplyResponse mulResponse = stub.multiply(mul);
			result = mulResponse.get_return();
		} else{
			Divide divide = new Divide();
			divide.setNum1(num1);
			divide.setNum2(num2);
			DivideResponse divResponse = stub.divide(divide);
			result = divResponse.get_return();
		}
		request.setAttribute("rs",result);
		request.setAttribute("fs",first);
		request.setAttribute("sc",second);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
