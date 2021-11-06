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
- 하지만, ```SimpleGeometricObject```가 Object를 상속받았으므로 이를 __Override(재정의)__ 가 가능하다. 이것이 바로 아래에서 설명할 __Polymorphism__ 이다.
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

## 'Super' Keyword
> 두 Class가 상속 관계에 있을 때, Super Class의 method나 constructor을 호출할 때 이용되는 Keyword이다.  
> Compiler은 Sub Class의 생성자가 호출될 때, 자동으로 Super() 기본 Class를 호출하도록 되어있다.  
> 물론 Overload된 Super Class의 constructor을 실행하고 싶으면 Super(arg1, arg2)를 직접 적어 넣도록 한다.  

```java
public class Faculty extends Employee { // Employee's Subclass
	public static void main(String[] args) {
		new Faculty();
	}
	public Faculty() {
		System.out.println("(4) Performs Faculty's tasks.");
	}
}
class Employee extends Person{ // Person's Subclass
	public Employee() {
		this("(2) Invoke Employee's overloaded constructor.");
		System.out.println("(3) Performs Employee's tasks.");
	}
	public Employee(String s) {
		System.out.println(s);
	}
}
class Person{ // Object's Subclass
	public Person() {
		System.out.println("(1) Performs Person's tasks.");
	}
}
```
- 위의 예시 코드를 보면, 출력이 (1) => (2) => (3) => (4) 순서대로 나온다.
- 그 이유는 제일 하위 Class인 Faculty()의 Constructor이 호출이 되었으면,
  - Super class인 Employee()의 기본 생성자가 자동 호출 되고,
  - Employee()의 Super class인 Person()의 기본 생성자가 또 자동으로 호출되고,
  - 다시 아래로 내려가며 출력코드들이 실행되기 때문이다.
- super.method()로 Super Class내에 존재하는 Methods에 접근할 수도 있다.

## Override & Overload
- Overriding : 상위 클래스의 함수와 함수의 이름과 매개변수까지 같으나, 하위클래스에서 그 동작이 다른 것.
- Overloading : 함수이 이름은 같으나, 매개변수와 동작이 다른 것. 상속 관계가 아니어도 사용한다.
```java
@Override
public String toString(){
    return super.toString() + "\nradius is " + radius;
}
```
- 이는 특수한 경우로, Overriding한 함수의 위에 @Override라고 명시를 해주면 상위 클래스의 함수와 이름이 다르면 오류가 발생한다.
- 개발자의 함수 이름 실수를 방지하기 위해 제공된다.

## Dynamic Binding(동적 바인딩)
> 상속 관계에서, Overriding된 함수들이 여러개 존재할 때에 어떤 것을 실행할지는 Compile time이 아닌 Runtime에 결정된다.  
> 즉, 타입에 따라서 함수의 실행이 달라진다. 이게 바로 Dynamic Binding!  
```java
public class DynamicBindingDemo {
	public static void main(String[] args) {
		m(new GraduateStudent());
		m(new Student());
		m(new Person());
		m(new Object());
	}
	public static void m(Object x) {
		System.out.println(x.toString());
	}
}
class GraduateStudent extends Student{
}
class Student extends Person{
	public String toString() {
		return "Student";
	}
}
class Person extends Object{
	public String toString() {
		return "Person";
	}
}
```
- 위의 코드를 보면, 출력결과가 순서대로 Student Student Person java.lang.Object@24d46ca6이 나온다.
- 이는 함수의 매개변수로 들어온 객체의 Type이 무엇이냐에 따라 Overriding된 toString() method에 대한 선택이 동적으로 달라졌음을 보여준다.

### Casting Object & instanceof
- Casting Object
  - Implicit Casting
  ```java
  Object o = new Student();
  m(o);
  ```
    - 위의 Dynamic binding의 예시를 기반으로 이 Code를 실행해보면 Student라고 결과가 나온다.
    - Object Type이었던 객체 o에 Student() 의 주소를 넘겨주어 묵시적 형변환을 시킨 것이다.
  - Explicit Casting
  ```java
  Object o = new Student();
  Student s = o; // It doesn't work.
  Student s = (Student) o; // It work!
  ```
    - 위의 예제와 유사한 Type Casting 예제이다.
    - 위의 코드와 같이 명시적 형변환을 하지 않고 그냥 ```Student s = o;```라고 해버리면, 컴파일러는 오류를 반환한다.
    - o가 가지고 있는 것은 Student의 주소가 맞지만, 컴파일러는 o의 Type이 Object라고 생각을 하고 있기 때문이다.
    - 따라서 o의 Type을 명시적으로 Student로 바꿔주어야만 오류가 발생하지 않고 Type이 맞게 된다.
    - Primitive Type일 때, ```int age = 45;```라고 선언하고 ```byte newAge = age;```라고 선언하면 오류가 나는 것과 같은 이유.
- Instanceof Operator
```java
public class CastingDemo {
	public static void main(String[] args) {
		Object o1 = new subA1();
		Object o2 = new subA2();
		displayObject(o1); // Area : 2, Diameter : -1
		displayObject(o2); // Area : 3, Diameter : -2
	}
	public static void displayObject(Object o) {
		if (o instanceof subA1) System.out.println("subA1 : " + "Area : " + ((subA1) o).getArea() + " " + 
				"Diameter : " + ((subA1) o).getDiameter());
		
		else if(o instanceof subA2) System.out.println("subA2 : " + "Area : " + ((subA2) o).getArea() + " " + 
				"Diameter : " + ((subA2)o).getDiameter());
	}
}
```
   - instanceof 연산자는, Object instanceof Class 즉, 생성된 Object가 해당 Class의 Instance가 맞으면 True를 반환하는 연산자다.
   - 위의 예시를 보면 o1과 o2는 서로 다른 subA1와 subA2의 주소를 갖고 있기 때문에, 서로 다른 Class의 instance가 된다.
   - 하지만 Display 함수를 보면, ```((subA1)o).getArea();``` 와 같이 명시적 Casting을 해주고 있음을 알 수 있다.
   - 이는 아까 말했듯이, o1과 o2가 subA1, subA2의 Instance인 것은 맞지만 Type이 Object이기 때문에 그냥은 ```getArea()```를 사용할 수 없다.  

### Bonus : override equals() method.
```java
subA1 o3 = (subA1)o1;
subA1 o4 = new subA1();
System.out.println(((subA1)o1).equals(o3));
System.out.println(((subA1)o1).equals(o4));
public boolean equals(Object o) {
		if (o instanceof A) return radius == ((subA1)o).radius;
		else return this == o;
	}
```
- 위와 같이 ```equals()``` method를 override 하게 되면, o3과 o4 모두 True가 나오게 된다.
- Override 하지 않으면? o3은 true가 맞지만, o4는 false를 반환한다. 왜 그럴까?  
![stack](https://user-images.githubusercontent.com/71700079/139842419-196e862f-83bc-4902-847e-65f4281a9532.jpg)  
- 위의 그림을 살펴보면 o3은 o1과 같은 subA1의 Address를 가리키고, radius = 100이다.
- 하지만 o4는 새로 만들어진 subA1의 Address를 가지며, radius = 100이다.
- 새로 Override된 Equals는 radius를 비교해서 boolean 값을 return 하기 때문에 radius가 100으로 같으면, 이는 True를 반환한다.
- 하지만 Override를 하지 않으면, 원래의 Equals는 객체 자체를 비교하여 return하기 때문에 서로 다른 객체인 o1과 o4는 False를 반환하게 된다.

