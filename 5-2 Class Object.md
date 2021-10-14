# Class Object
---
## Inheritance
>모든 Object Oriented Language의 Class 개념에는 Generation(일반화) Class의 Inheritance(상속) 기능이 존재한다.  
<details>
	<summary>SimpleGeometricObject.java</summary>
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
	<summary>Circle.java</summary>
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
    
    System.out.println(circle); // [Circle Properties] Color ...
    System.out.println(rect); // [Object Properties] Color ... ==> Property of toString
    System.out.println(rect.toString()); // [Object Properties] Color ...
  }
}
```
- 우선 상속을 시키기 위해서는 ```Subclass name extends Superclass name``` 과 같이 extends를 시켜주어야 한다.
- 상속받은 하위 Subclass들은 Superclass의 Attributes를 모두 사용할 수 있으나, Superclass Type으로 선언한 객체는 Subclass의 Method를 쓸 수 없다.

### toString()
>위의 코드들을 보면 ```toString()```을 선언해놓은 부분이 있을 것이다.  
```java
public String toString(){
    return "[Circle Properties] Color : " + getColor() + " and Filled : " + isFilled();
  }
```
- 이 ```toString()``` method는 원래 모든 Class의 Superclass인 ```Object Class```의 것이다.
- 하지만, ```SimpleGeometricObject```가 Object를 상속받았으므로 이를 __Overload(재정의)__ 가 가능하다. 이것이 바로 아래에서 설명할 __Polymorphism__ 이다.
- 그리고 이 ```toString()```의 특이한 점은 Python의 ```__str__``` method와 같이 따로 참조하지 않아도 스스로 출력된다는 점이다.

## Polymorphism (다형성)
>Object Oriented Language의 Inheritance를 얘기할 때 Polymorphism은 절대로 빠질 수 없는 이야기이다.  
>서로 상속관계에 있는 두 Class가 있을 때, Superclass에 정의된 method와 같은 이름의 method를 Subclass에서 동작만 바꾸어 선언하는 것이다.  
```java
public String toString(){ // SimpleGeometricObject Class
    return "[Object Properties] Color : " + color + " and Filled : " + filled;
  }
public String toString(){ // Circle Class
    return "[Circle Properties] Color : " + getColor() + " and Filled : " + isFilled();
  }
```
- 위의 코드들에서 따온 두 예시이다.
- Superclass의 toString()과 Subclass의 toString()은 분명히 동작이 다르다.
- 이는 __Polymorphism__ 에 의해  ```Superclass shape = new Superclass();```로 객체를 선언했을 때, Superclass의 ```toString()```이 실행될 것이고
- ```Subclass shape = new Subclass();```로 객체를 선언했을 때, Subclass의 ```toString()```이 실행될 것이다.
- 즉, 객체가 담고 있는 Class의 주소지에 따라서 어느 method를 참조할 것이냐가 결정되는 것이다.
