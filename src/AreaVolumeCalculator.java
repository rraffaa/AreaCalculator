package src;

import java.util.Scanner;

public class AreaVolumeCalculator {
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); // Criando Scanner

        System.out.println("Shape Area and Volume Calculator");

        // Main loop for shape and calculation selection
        while (true) {
            System.out.println();
            System.out.println("-=-=-=-=-=-=-=-=-=-");
            System.out.println();
            System.out.println("1) Triangle");
            System.out.println("2) Rectangle");
            System.out.println("3) Circle");
            System.out.println("4) Square");
            System.out.println("5) Diamond");
            System.out.println("6) Trapezoid");
            System.out.println("7) Hexagon");
            System.out.println("8) Pentagon (Regular)");
            System.out.println("9) Octagon");
            System.out.println("10) Quit");
            System.out.println();

            System.out.print("Choose shape (1-10): ");
            int shape = keyboard.nextInt();
            System.out.println();

            System.out.println("Select option:");
            System.out.println("1) Calculate Area");
            System.out.println("2) Calculate Volume");
            System.out.print("Enter your choice: ");
            int choice = keyboard.nextInt();

            // Switch case for handling different shapes and calculations
            switch (shape) {
                case 1:
                    if (choice == 1) {
                        double base = getPositiveInput("Base", keyboard);
                        double height = getPositiveInput("Height", keyboard);
                        System.out.println("The area is " + areaTriangle(base, height) + ".");
                    } else if (choice == 2) {
                        double baseV = getPositiveInput("Base", keyboard);
                        double heightV = getPositiveInput("Height", keyboard);
                        double depth = getPositiveInput("Depth", keyboard);
                        System.out.println("The volume is " + volumePyramid(baseV, heightV, depth) + ".");
                    }
                    break;
                case 2:
                    if (choice == 1) {
                        double length = getPositiveInput("Length", keyboard);
                        double width = getPositiveInput("Width", keyboard);
                        System.out.println("The area is " + areaRectangle(length, width) + ".");
                    } else if (choice == 2) {
                        double lengthV = getPositiveInput("Length", keyboard);
                        double widthV = getPositiveInput("Width", keyboard);
                        double heightV = getPositiveInput("Height", keyboard);
                        System.out.println("The volume is " + volumeRectangularPrism(lengthV, widthV, heightV) + ".");
                    }
                    break;
                case 3:
                    if (choice == 1) {
                        double radius = getPositiveInput("Radius", keyboard);
                        System.out.println("The area is " + areaCircle(radius) + ".");
                    } else if (choice == 2) {
                        double radiusV = getPositiveInput("Radius", keyboard);
                        double heightV = getPositiveInput("Height", keyboard);
                        System.out.println("The volume is " + volumeCylinder(radiusV, heightV) + ".");
                    }
                    break;
                case 4:
                    if (choice == 1) {
                        double side = getPositiveInput("Side", keyboard);
                        System.out.println("The area is " + areaSquare(side) + ".");
                    } else if (choice == 2) {
                        double sideV = getPositiveInput("Side", keyboard);
                        System.out.println("The volume is " + volumeCube(sideV) + ".");
                    }
                    break;
                case 5:
                    if (choice == 1) {
                        double d1 = getPositiveInput("Diagonal 1", keyboard);
                        double d2 = getPositiveInput("Diagonal 2", keyboard);
                        System.out.println("The area is " + areaDiamond(d1, d2) + ".");
                    }
                    break;
                case 6:
                    if (choice == 1) {
                        double b1 = getPositiveInput("Base 1", keyboard);
                        double b2 = getPositiveInput("Base 2", keyboard);
                        double h = getPositiveInput("Height", keyboard);
                        System.out.println("The area is " + areaTrapezoid(b1, b2, h) + ".");
                    }
                    break;
                case 7:
                    if (choice == 1) {
                        double hexSide = getPositiveInput("Side", keyboard);
                        System.out.println("The area is " + areaHexagon(hexSide) + ".");
                    }
                    break;
                case 8:
                    if (choice == 1) {
                        double pentSide = getPositiveInput("Side", keyboard);
                        System.out.println("The area is " + areaPentagon(pentSide) + ".");
                    }
                    break;
                case 9:
                    if (choice == 1) {
                        double octSide = getPositiveInput("Side", keyboard);
                        System.out.println("The area is " + areaOctagon(octSide) + ".");
                    }
                    break;
                case 10:
                    System.out.println("Goodbye!");
                    keyboard.close();  // Close the scanner when the program ends
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Method to ensure the input is positive
    public static double getPositiveInput(String prompt, Scanner keyboard) {
        double value;
        while (true) {
            System.out.print(prompt + ": ");
            value = keyboard.nextDouble();
            if (value > 0) {
                break;
            } else {
                System.out.println("Please enter a positive value.");
            }
        }
        return value;
    }

    // Area methods
    public static double areaTriangle(double base, double height) { return (base * height) / 2; }
    public static double areaRectangle(double length, double width) { return length * width; }
    public static double areaCircle(double radius) { return Math.PI * radius * radius; }
    public static double areaSquare(double side) { return side * side; }
    public static double areaDiamond(double d1, double d2) { return (d1 * d2) / 2; }
    public static double areaTrapezoid(double b1, double b2, double height) { return ((b1 + b2) / 2) * height; }
    public static double areaHexagon(double side) { return (3 * Math.sqrt(3) * side * side) / 2; }
    public static double areaPentagon(double side) { 
        double apothem = side / (2 * Math.tan(Math.PI / 5)); 
        return (5 * side * apothem) / 2; 
    }
    public static double areaOctagon(double side) { return 2 * (1 + Math.sqrt(2)) * side * side; }

    // Volume methods
    public static double volumePyramid(double base, double height, double depth) { return (base * height * depth) / 3; }
    public static double volumeRectangularPrism(double length, double width, double height) { return length * width * height; }
    public static double volumeCylinder(double radius, double height) { return Math.PI * radius * radius * height; }
    public static double volumeCube(double side) { return side * side * side; }
}