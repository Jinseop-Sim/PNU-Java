# Class Object
---
## Inheritance
>모든 Object Oriented Language의 Class 개념에는 Generation(일반화) Class의 Inheritance(상속) 기능이 존재한다.  
<details>
	<summary>TV.java</summary>
	<div markdown="1">
		
- SimpleGeometricObject.java
```java
import java.util.date;

public class SimpleGeometricObject extends Object{
  private String color = "White";
  private boolean filled;
  
  public SimpleGeometricObject() {}
  public SimpleGeometricObject(String color, boolean filled){
    this.color = color;
    this.filled = filled;
  }
  
  public String getColor(){
    return color;
  }
  public void setColor(String color){
    this.color = color;
  }
  public boolean isFilled(){
    return filled;
  }
  public void setFilled(boolean filled){
    this.filled = filled;
  }
  public String toString(){
    return "[Object Properties] Color : " + color + " and Filled : " + filled;
  }
}
```
  </div>
  </details>
  <details>
	<summary>TV.java</summary>
	<div markdown="1">
		
- Circle.java
```java
public class Circle extends SimpleGeometricObject{
  private double radius;
  public Circle(){}
  public Circle(double radius){
    this.radius = radius;
  }
  
  public Circle(double radius, String color, boolean filled){
    this.radius = radius;
    setColor(color);
    setFilled(filled);
  }
  
  public String toString(){
    return "[Circle Properties] Color : " + getColor() + " and Filled : " + isFilled();
  }
}
```
  </div>
  </details>
- TestCircle.java
```java
public Class TestCircle{
  public static void main(String args[]){
    Circle circle = new Circle();
    SimpleGeometricObject rect = new SimpleGeometricObject();
    
    System.out.println(circle);
    System.out.println(rect);
    System.out.println(rect.toString());
  }
}
```
## Polymorphism (다형성)
>Object Oriented Language의 Inheritance를 얘기할 때 Polymorphism은 절대로 빠질 수 없는 이야기이다.  

