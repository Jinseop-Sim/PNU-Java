# Class Object
---
## Package
- Java에는 Package라는 개념이 존재하는데, 이는 Class의 Set이라고 생각하면 된다.
```java
package p1;
class C1 {
	public int x;
	int y;
	private int z;
	
	public void m1() {
	}
	void m2() {}
	private void m3(){}
}
//-----------------------
package p1;
public class C2 {
	void aMethod(){
		C1 o = new C1();
		o.x = 10; // Can access
		o.y = 10; // Can access
		o.z = 100; // Cannot access
		
		o.m1(); // Can access
		o.m2(); // Can access
		o.m3(); // Cannot access
	}
}
//----------------------
package p3;
import p1.C1;

public class C3 {
	void aMethod(){
		C1 o = new C1();
		o.x = 10; // Can access
		o.y = 10; // Cannot access
		o.z = 100; // Cannot access
		
		o.m1(); // Can access
		o.m2(); // Cannot access
		o.m3(); // Cannot access
		}
}
```
- 위의 예시를 살펴보면, Package p1내에 Class c1과 c2가 선언되어있고, 다른 Package p3 내에 Class c3이 선언되어있다.
- C2는 같은 Package 내에 존재하므로, public으로 선언된 x와 그냥 선언된 y에 접근이 가능하다. 하지만 Private으로 선언된 z는 접근할 수 없다!
  - Private으로 선언된 z는 같은 class내에서만 접근 및 변경이 가능한 변수이다. 물론 method 여도 마찬가지.
- C3은 다른 Package 내에 존재하므로, import p1.C1; 명령어를 통해서 먼저 Package p1을 끌어와야한다.
  - 이 때, Class C1이 public으로 선언되어있지 않는 경우에는, 다른 Package에서 import 할 수 없다.
  - 물론 import 해와도, 변수나 method가 public으로 선언되어있지 않는 경우에는 접근 및 변경이 불가능하다.

## Encapsulation
- Encapsulation, 즉 캡슐화는 Object Oriented Language에서 매우 중요하다고 볼 수 있는 구현 방식이다.
```java
public class EncapsulatedCircle {
	private double radius = 1; // 여기가 Encapsulation 부분이다. 중요한 내부 멤버 변수들을 직접 못건들게 한다.
	private static int numberOfObjects = 0;
	
	public EncapsulatedCircle(){  // 여기는 Behavior을 담당하는 methods. 그 내부는 알 수 없이 그냥 기능만 사용할 수 있도록 public으로.
		numberOfObjects++;
	}
	public EncapsulatedCircle(double newRadius) {
		radius = newRadius;
		numberOfObjects++;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double newRadius) {
		radius = (newRadius >= 0) ? newRadius : 0;
	}
	public static int getNumberOfObjects() { // 여기를 static으로 선언하는 이유는, 필드의 멤버변수가 static이기 때문에!
		return numberOfObjects;
	}
	public double getArea() {
		return radius * radius * Math.PI;
	}
}

public class TestEncapsulation {
	public static void main(String[] args) {
		EncapsulatedCircle myCircle = new EncapsulatedCircle(5.0);
		System.out.println("The area of the circle of radius " + myCircle.getRadius() + " is " + myCircle.getArea());
		
		myCircle.setRadius(myCircle.getRadius() * 1.1);
		System.out.println("The area of the circle of radius " + myCircle.getRadius() + " is " + myCircle.getArea());
		System.out.println("The number of objects created is " + EncapsulatedCircle.getNumberOfObjects());
	}
}
```
- 위의 예시가 Encapsulation의 예시이다.
- Encapsulation은 Data Field에 존재하는 변수들을 외부에서 접근할 수 없도록 private으로 선언을 해버린다.
- 따라서 사용자는 그 Class에 선언된 Methods들만 동작원리나 내부 부품을 알 필요 없이 사용할 수가 있다.
- 그래서 Methods들은 Public으로 선언된다.

## Passing Object(Class)
>앞서 java에서 Call by reference를 구현하는 방법이 2가지가 있다고 말했었다.  
>첫 번째는 Passing Array, 이번엔 두 번째인 Passing Object(Class)이다.  
- Circle.java
```java
public class Circle{ // Instance(Object)를 생성해서 Pass 해주기 위해서 만든 Class
    private double radius = 1;
    private double area;
    public Circle(){
        area = 3.14 * radius * radius;
    }
    public Circle(double newRadius){
        radius = newRadius;
	area = 3.14 * radius * radius; 
    }
    public void setRadius(double newRadius){
        radius = newRadius;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        area = 3.14 * radius * radius;
	return area;
    }
}
```
- TestPass.java
```java
public class Test{
  public static void main(String[] args){ // main은 반드시 static으로 선언되어야한다.
  	Circle myc = new Circle();
	myc.setRadius(10.0);
	System.out.println("Area : " + myc.getArea()); // setRadius로 radius가 10.0이 되었으므로, 넓이 314.0이 출력된다.
	changeCircle(myc);
	System.out.println("Changed Area : " + myc.getArea()); // changeCircle에서 radius가 1로 바뀌었기 때문에, 넓이 3.14가 출력된다.
  }
  
  public static void changeCircle(Circle c){ // static으로 선언하지 않으면, main 함수 내에서 사용할 수가 없게 된다.
  	c.setRadius(1); // Argument로 Object C의 주소를 넘겨받아 와서 class Circle의 method인 setRadius에 Access해서 값을 바꾸는 동작이다.
  }
}
```

## Array of Objects
>앞에서 배웠던 array는 Primitive Type에 대한 array였다. (double[] a = new double[10];)  
>이번에 배운 것은 Object type에 대한 array이다.  
- Class로는 위의 예제에서 사용했던 Circle class를 그대로 사용한다.
- AreaArray.java
```java
public class AreaArray{
    public static void main(String[] args){
    	Circle[] cArr; // 객체의 배열을 선언한다.
	cArr = createCircleArray();
	printCircleArray(cArr); // 5개의 Radius와 Area가 출력된다.
    }
    public static Circle[] createCircleArray(){ // 함수의 Type이 Circle[] 이어야 하는 이유는, return 값이 객체의 배열이기 때문이다.
    	Circle[] cArr = new Circle[5];
	for(int i = 0; i < cArr.length; i++){
	    cArr[i] = new Circle(Math.random() * 1000); // Class에 Overloading된 Constructor을 통해 Radius를 랜덤 값으로 set하고 Area까지 계산해서 배열에 넣는다.
	}
	return cArr;
    }
    public static void printCircleArray(Circle[] cArr){
    	for(int i = 0; i < arr.length; i++) System.out.println("Radius is : " + arr[i].getRadius() + " Area is : " + arr[i].getArea());
    }
}
```
