package round__3;

//public class Spreadsheet {
//
//}
/*
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Cell {
    private String expression;
    private double value;

    public Cell(String expression) {
        this.expression = expression;
    }

    public void evaluate(Map<String, Cell> cellMap) {
        if (expression.startsWith("=")) {
            String[] tokens = expression.substring(1).split("[+\\-* /]");
             for (int i = 0; i < tokens.length; i++) {
                String token = tokens[i].trim();
                if (cellMap.containsKey(token)) {
                    expression = expression.replace(token, String.valueOf(cellMap.get(token).getValue()));
                } else {
                    try {
                        double num = Double.parseDouble(token);
                        expression = expression.replace(token, String.valueOf(num));
                    } catch (NumberFormatException e) {
                        // Handle invalid expressions
                        expression = "ERROR";
                        return;
                    }
                }
            }

            try {
                value = evaluateExpression(expression);
            } catch (ArithmeticException e) {
                expression = "ERROR";
            }
        } else {
            try {
                value = Double.parseDouble(expression);
            } catch (NumberFormatException e) {
                // Handle invalid expressions
                expression = "ERROR";
            }
        }
    }

    private double evaluateExpression(String expression) {
        // Implement your own expression evaluation logic here
        // This is a simplified example, and you may need to handle more operators and precedence rules.
        String[] tokens = expression.split("[+\\-* /]");
        double result = Double.parseDouble(tokens[0]);

        for (int i = 1; i < tokens.length; i++) {
            char operator = expression.charAt(tokens[0].length() + i);
            double operand = Double.parseDouble(tokens[i]);

            switch (operator) {
                case '+':
                    result += operand;
                    break;
                case '-':
                    result -= operand;
                    break;
                case '*':
                    result *= operand;
                    break;
                case '/':
                    if (operand == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    result /= operand;
                    break;
            }
        }

        return result;
    }

    public double getValue() {
        return value;
    }

    public String getExpression() {
        return expression;
    }
}

public class Spreadsheet {
    private Map<String, Cell> cellMap;

    public Spreadsheet() {
        cellMap = new HashMap<>();
    }

    public void setCell(String cellName, String expression) {
        cellMap.put(cellName, new Cell(expression));
    }

    public void evaluateSpreadsheet() {
        for (Cell cell : cellMap.values()) {
            cell.evaluate(cellMap);
        }
    }

    public void printSpreadsheet() {
        for (Map.Entry<String, Cell> entry : cellMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getExpression() + " = " + entry.getValue().getValue());
        }
    }

    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet();

        spreadsheet.setCell("A1", "5");
        spreadsheet.setCell("A2", "=A1 + 10");
        spreadsheet.setCell("B1", "7");
        spreadsheet.setCell("B2", "=A2 + B1");

        spreadsheet.evaluateSpreadsheet();
        spreadsheet.printSpreadsheet();
    }
}
*/
import java.util.*;

class Cell {
    private String expression;
    private double value;
    
    public Cell(String expression) {
        this.expression = expression;
        this.value = 0; // Default value
    }
    
    public double evaluate(Map<String, Cell> cellMap) {
        if (expression.startsWith("=")) {
            String[] tokens = expression.substring(1).split("\\+");
            double result = 0;
            for (String token : tokens) {
                token = token.trim();
                if (cellMap.containsKey(token)) {
                    result += cellMap.get(token).evaluate(cellMap);
                } else {
                    try {
                        result += Double.parseDouble(token);
                    } catch (NumberFormatException e) {
                        // Handle invalid expressions
                        return 0; // Or throw an exception
                    }
                }
            }
            value = result;
            return result;
        } else {
            try {
                value = Double.parseDouble(expression);
                return value;
            } catch (NumberFormatException e) {
                // Handle invalid expressions
                return 0; // Or throw an exception
            }
        }
    }
    
    public double getValue() {
        return value;
    }
}

public class Spreadsheet {
    private Map<String, Cell> cellMap;

    public Spreadsheet() {
        cellMap = new HashMap<>();
    }

    public void setCell(String cellName, String expression) {
        cellMap.put(cellName, new Cell(expression));
    }

    public void evaluateSpreadsheet() {
        for (Cell cell : cellMap.values()) {
            cell.evaluate(cellMap);
        }
    }

    public void printSpreadsheet() {
        for (Map.Entry<String, Cell> entry : cellMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getValue());
        }
    }

    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet();
        
        spreadsheet.setCell("A1", "5");
        spreadsheet.setCell("A2", "=A1 + 10");
        spreadsheet.setCell("B1", "7");
        spreadsheet.setCell("B2", "=A2 + B1");
        
        spreadsheet.evaluateSpreadsheet();
        spreadsheet.printSpreadsheet();
    }
}
