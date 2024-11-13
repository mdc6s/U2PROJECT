import java.util.Scanner;


public class LinearEquationLogic {
    private Scanner scanner;


    public LinearEquationLogic() {
        scanner = new Scanner(System.in);
    }


    public void start() {
        welcomeUser();
        boolean continueLoop = true;


        while (continueLoop) {
            LinearEquation equation = getCoordinatesAndCreateEquation();
            printLineInfo(equation);
            System.out.println();
                if (equation.vert() == false) {
                    double xValue = getXValueFromUser();
                    System.out.println("The coordinate at x = " + xValue + " is " + equation.coordinateForX(xValue));
                }
                System.out.println();


            continueLoop = askToRepeat();
        }


        System.out.println("Goodbye!");
    }


    private void welcomeUser() {
        System.out.println("Welcome to the Linear Equation Calculator!");
    }


    private LinearEquation getCoordinatesAndCreateEquation() {
        System.out.print("Enter the first point (x1, y1): ");
        String firstPoint = scanner.nextLine();
        int x1 = parseCoordinateX(firstPoint);
        int y1 = parseCoordinateY(firstPoint);


        System.out.print("Enter the second point (x2, y2): ");
        String secondPoint = scanner.nextLine();
        int x2 = parseCoordinateX(secondPoint);
        int y2 = parseCoordinateY(secondPoint);


        return new LinearEquation(x1, y1, x2, y2);
    }

    private int parseCoordinateX(String point) {
        int i = point.indexOf(",");
        int x = Integer.parseInt(point.substring(1, i));
        return x;
    }

    private int parseCoordinateY(String point) {
        int i = point.indexOf(",");
        int y = Integer.parseInt(point.substring(i + 2, point.length() - 1));
        return y;
    }

    private void printLineInfo(LinearEquation equation) {
        System.out.println(equation.lineInfo());

        /*
        System.out.println("Distance between points: " + equation.distance());
        System.out.println("Slope: " + equation.calculateSlope());
        System.out.println("Y-Intercept: " + equation.calculateYIntercept());
        System.out.println("Linear Equation: " + equation.getLinearEquation());
         */

    }


    private double getXValueFromUser() {
        System.out.print("Enter an x value to solve for y: ");
        return Double.parseDouble(scanner.nextLine());
    }


    private boolean askToRepeat() {
        System.out.print("Would you like to enter another pair of coordinates? (yes/no): ");
        String response = scanner.nextLine();
        return response.equals("yes");
    }
}


