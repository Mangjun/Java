# Annotation

## Annotation?
주석처럼 프로그래밍 언어에 영향을 미치지 않으며, 유용한 정보를 제공한다.   

## 표준 어노테이션
기본적으로 제공하는 어노테이션은 어노테이션을 정의하는데 사용되는 메타 어노테이션과 그 외의 어노테이션이 있다.   

### 그 외 어노테이션
메타 어노테이션을 제외한 어노테이션의 종류는 다음과 같다.   

| 어노테이션 | 설 명 |
| --- | --- |
| @Override | 컴파일러에게 오버라이딩하는 메서드라는 것을 알린다. |
| @Deprecated | 앞으로 사용하지 않을 것을 권장하는 대상에 붙인다. |
| @SuppressWarnings | 컴파일러의 특정 경고메시지가 나타나지 않게 해준다. |
| @SafeVarargs | 지네릭스 타입의 가변인자에 사용한다. |
| @FunctionalInterface | 함수형 인터페이스라는 것을 알린다. |

#### @SuppressWarnings
@SuppressWarnings()는 괄호 ()안에 억제하고자 하는 경고의 종류를 문자열로 지정하는데 -Xlint 옵션으로 컴파일하면 경고메시지를 확인할 수 있다.   
수정하고 에러가 발생했을 때 구분하기 위해서 사용하므로 좁은 범위로 제한하여 사용한다.   

#### @SafeVarargs
@SafeVarargs는 메서드의 가변 인자 타입이 지네릭스인 경우 unchecked 경고를 억제하려고 사용한다.   
생성자 또는 static이나 final이 붙은 메서드에만 붙일 수 있으며 @SuppressWarnings("varargs")와 함께 사용한다.   

### 메타 어노테이션
메타 어노테이션의 종류는 다음과 같다.   

| 어노테이션 | 설 명 |
| --- | --- |
| @Target | 어노테이션이 적용가능한 대상을 지정하는데 사용한다. |
| @Documented | 어노테이션 정보가 javadoc으로 작성된 문서에 포함되게 한다. |
| @Inherited | 어노테이션이 자손 클래스에 상속되도록 한다. |
| @Retention | 어노테이션이 유지되는 범위를 지정하는데 사용한다. |
| @Repeatable | 어노테이션을 반복해서 적용할 수 있게 한다. |
| @Native | native메서드에서 참조되는 상수 앞에 붙인다. |

#### @Target
@Target()는 괄호 안에 타입을 선언하는데, java.lang.annotation.ElementType이라는 열거형에 정의되어 있다.   

#### @Retention
유지 정책에는 세 가지가 있는데, SOURCE, CLASS, RUNTIME이 있다.   
컴파일러에 의해 사용되는 어노테이션의 유지 정책은 SOURCE로 소스 파일에만 존재한다.   
실행 시에 사용 가능한 어노테이션의 유지 정책은 RUNTIME으로 클래스 파일에 존재한다.   

#### @Repeatable
반복해서 붙일 수 있는 어노테이션을 정의할 때 사용하며, 반복할 어노테이션을 하나로 묶을 컨테이너 어노테이션도 정의해야 한다.   
예를 들어, Todo라는 어노테이션을 정의해서 사용하면   
```
@interface ToDos {   
    ToDo[] value(); // 어노테이션의 배열 타입의 요소를 선언해야 하며, 이름은 반드시 value이여야 한다.   
}   

@Repeatable(ToDos.class)   
@interface Todo {   
    String value(); // 이름이 반드시 value이여야 한다.   
}   
```

## 어노테이션 타입 정의
어노테이션은 다음과 같이 직접 만들 수 있다.   
```
@interface 어노테이션_이름 {   
    타입 요소이름();   
    타입[] 요소이름(); // 배열도 가능하다.   
    타입 요소이름() default 기본값; // 적용 시 값을 지정하지 않으면 기본값을 사용한다.    
}
```

어노테이션의 메서드는 매개변수가 없는 추상 메서드이며, 따로 구현은 하지 않는다.   
요소가 하나일 때는 요소의 이름이 value로 설정한다.   
왜냐하면, 요소의 이름이 value이고 하나일 때는 요소의 이름을 생략할 수 있다.   

### 마커 어노테이션
요소가 하나도 정의되지 않은 어노테이션이다.

### 어노테이션 요소의 규칙
* 요소의 타입은 기본형, String, enum, 어노테이션, Class만 허용된다.
* ()안에 매개변수를 선언할 수 없다.
* 예외를 선언할 수 없다.
* 요소를 타입 매개변수로 정의할 수 없다.
