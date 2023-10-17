import java.util.Scanner;

// Abstract Shape class
abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

// Rectangle class
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

// Circle class
class Circle extends Shape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Triangle class
class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;

    public Triangle(String name, double side1, double side2, double side3) {
        super(name);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}

// Square class
class Square extends Rectangle {
    public Square(String name, double sideLength) {
        super(name, sideLength, sideLength);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select a shape type:");
            System.out.println("1. Rectangle");
            System.out.println("2. Circle");
            System.out.println("3. Triangle");
            System.out.println("4. Square");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the name for the rectangle: ");
                    String rectName = scanner.nextLine();
                    System.out.print("Enter the width of the rectangle: ");
                    double rectWidth = scanner.nextDouble();
                    System.out.print("Enter the height of the rectangle: ");
                    double rectHeight = scanner.nextDouble();
                    Rectangle rectangle = new Rectangle(rectName, rectWidth, rectHeight);
                    System.out.println("Area: " + rectangle.getArea());
                    System.out.println("Perimeter: " + rectangle.getPerimeter());
                    break;

                case 2:
                    System.out.print("Enter the name for the circle: ");
                    String circleName = scanner.nextLine();
                    System.out.print("Enter the radius of the circle: ");
                    double circleRadius = scanner.nextDouble();
                    Circle circle = new Circle(circleName, circleRadius);
                    System.out.println("Area: " + circle.getArea());
                    System.out.println("Perimeter: " + circle.getPerimeter());
                    break;

                case 3:
                    System.out.print("Enter the name for the triangle: ");
                    String triangleName = scanner.nextLine();
                    System.out.print("Enter the length of the first side: ");
                    double side1 = scanner.nextDouble();
                    System.out.print("Enter the length of the second side: ");
                    double side2 = scanner.nextDouble();
                    System.out.print("Enter the length of the third side: ");
                    double side3 = scanner.nextDouble();
                    Triangle triangle = new Triangle(triangleName, side1, side2, side3);
                    System.out.println("Area: " + triangle.getArea());
                    System.out.println("Perimeter: " + triangle.getPerimeter());
                    break;

                case 4:
                    System.out.print("Enter the name for the square: ");
                    String squareName = scanner.nextLine();
                    System.out.print("Enter the length of the side: ");
                    double sideLength = scanner.nextDouble();
                    Square square = new Square(squareName, sideLength);
                    System.out.println("Area: " + square.getArea());
                    System.out.println("Perimeter: " + square.getPerimeter());
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
