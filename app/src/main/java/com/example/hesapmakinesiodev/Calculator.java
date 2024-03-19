package com.example.hesapmakinesiodev;

import java.util.Stack;

public class Calculator {
    public static double evaluateExpression(String expression) {
        // Split the expression into tokens
        String[] tokens = expression.split("\\s+");

        // Stack to store operands
        Stack<Double> operands = new Stack<>();

        // Stack to store operators
        Stack<Character> operators = new Stack<>();

        // Iterate through the tokens
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            char c = token.charAt(0);

            // If token is a number, push it to the operands stack
            if (Character.isDigit(c)) {
                operands.push(Double.parseDouble(token));
            } else {
                // If token is an operator, evaluate the expression
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(c)) {
                    evaluate(operands, operators);
                }
                operators.push(c);
            }
        }

        // Evaluate remaining operators in the stack
        while (!operators.isEmpty()) {
            evaluate(operands, operators);
        }

        // The final result is at the top of the operands stack
        return operands.peek();
    }

    // Method to evaluate the expression based on the operator
    private static void evaluate(Stack<Double> operands, Stack<Character> operators) {
        char operator = operators.pop();
        double operand2 = operands.pop();
        double operand1 = operands.pop();

        switch (operator) {
            case '+':
                operands.push(operand1 + operand2);
                break;
            case '-':
                operands.push(operand1 - operand2);
                break;
            case '*':
                operands.push(operand1 * operand2);
                break;
            case '/':
                operands.push(operand1 / operand2);
                break;
            case '%':
                operands.push(operand1 % operand2);
                break;
        }
    }

    // Method to determine operator precedence
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
        }
        return -1;
    }


}
