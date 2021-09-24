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
