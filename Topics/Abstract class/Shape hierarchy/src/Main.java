

import java.util.*;




abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}


class Triangle extends Shape {

    double a;
    double b;
    double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    double getArea() {
        double s = getPerimeter()/2;
        double num = s * (s-a) * (s-b) * (s-c);
        return Math.sqrt(num);
    }
}

class Rectangle extends Shape {
    double length;
    double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }


    @Override
    double getPerimeter() {
        return (this.length * 2) + (this.width * 2);
    }

    @Override
    double getArea() {
        return this.length * this.width;
    }
}


class Circle extends Shape {
    double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    double getArea() {
        return Math.PI * (this.radius * this.radius);
    }
}






