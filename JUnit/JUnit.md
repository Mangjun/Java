# JUnit

## JUnit?
Java용 Unit Test 프레임워크이다.   
단정(assert)메서드로 테스트 케이스의 수행 결과를 판별한다.   
JUnit4부터는 Test를 지원하는 어노테이션을 제공한다.   

## Unit Test?
모든 함수와 메서드에 대한 Test case를 작성하는 절차를 말하며, 의도된 대로 정확히 작동하는지 검증하는 절차이다.   

## assert method
| 메서드 | 설명 |
| --- | --- |
| assertEquals(a, b) | 객체 a, b의 값이 일치함을 확인한다. |
| assertArrayEquals(a, b) | 배열 a, b의 값이 일치함을 확인한다. |
| assertSame(a, b) | 객체 a, b가 같은 객체임을 확인한다. |
| assertTrue(a) | 조건 a가 참인지를 확인한다. |
| assertNotNull(a) | 객체 a가 null이 아님을 확인한다. |

## Annotation
JUnit에서 지원하는 어노테이션은 다음과 같다.   

| 어노테이션 | 설 명 |
| :---: | --- |
| @Test | 테스트를 수행하는 메서드가 된다.<br>각각의 테스트는 서로 영향을 주지 않고 독립적으로 실행된다. |
| @Ignore | 테스트를 실행하지 않게 한다. |
| @Before | @Test 메서드가 실행되기 전에 반드시 실행되어진다.<br>@Test 메서드에서 공통으로 사용되는 코드를 선언하여 사용하면 된다. |
| @After | @Test 메서드가 실행된 후 실행된다. |
| @BeforeClass | @Test 메서드보다 먼저 한번만 수행되어야 할 경우에 사용한다. |
| @AfterClass | @Test 메서드보다 나중에 한번만 수행되어야 할 경우에 사용한다. |