# CF

## Collection Framework
다수의 데이터를 다루기 위한 표준화된 프로그래밍 방식이다.   
핵심 인터페이스로는 List와 Set, Map이 있고 List와 Set의 공통적인 부분을 모아놓은 인터페이스인 Collection이 있다.   

## Collection
List와 Set의 조상으로 다음의 메서드들이 정의되어 있다.   

| 메서드 | 설명 |
| :---: | --- |
| boolean add(Object o)<br>boolean add(Collection c) | Collection에 지정된 객체를 추가하는 메서드 |
| void clear() | Collection에 모든 객체를 삭제하는 메서드 |
| boolean contains(Object o)<br>boolean containAll(Collection c) | Collection에 지정된 객체가 포함되어 있는지 확인하는 메서드 |
| boolean equals(Object o) | 동일한 Collection인지 비교하는 메서드 |
| boolean isEmpty() | Collection이 비어있는지 확인하는 메서드 |
| Iterator iterator() | Iterator를 반환하는 메서드 |
| boolean remove(Object o)<br>boolean removeAll(Collection c) | 지정된 객체를 삭제하는 메서드 |
| boolean retainAll(Collection c) | 지정된 Collection에 포함된 객체만 남기고 나머지는 삭제하는 메서드 |
| int size() | Collection에 저장된 객체의 수를 반환하는 메서드 |
| Object[] toArray() | Collection에 저장된 객체를 객체배열로 반환하는 메서드 |

## List
순서가 있고 데이터의 중복을 허용하는 인터페이스이다.   
Collection의 메서드와 다음의 메서드들이 정의되어 있다.   

| 메서드 | 설명 |
| :---: | --- |
| void add(int index, Object element)<br>boolean addAll(int index, Collection c) | 지정된 위치에 객체를 추가하는 메서드 |
| Object get(int index) | 지정된 위치에 있는 객체를 반환하는 메서드 |
| int indexOf(Object o) | 지정된 객체의 위치를 첫 번째 요소부터 찾아서 반환하는 메서드 |
| int lastIndexOf(Object o) | 지정된 객체의 위치를 마지막 요소부터 찾아서 반환하는 메서드 |
| Object remove(int index) | 지정된 위치에 있는 객체를 삭제하고 반환하는 메서드 |
| Object set(int index, Object element) | 지정된 위치에 객체를 저장하는 메서드 |
| void sort(Comparator c) | 지정된 비교자로 List를 정렬하는 메서드 |
| List subList(int fromIndex, int toIndex) | 지정된 범위에 있는 객체를 반환하는 메서드 |

### ArrayList
Object 배열을 이용해서 데이터를 순차적으로 저장한다.   
기존의 Vector를 개선한 것이며, Vector는 자체적으로 동기화 처리가 되어 있으나, ArrayList는 그렇지 않다.   
배열에 순서대로 저장되며, 배열에 더 이상 저장할 공간이 없으면 보다 큰 새로운 배열을 생성해서 기존의 배열에 저장된 내용을 새로운 배열로 복사한 다음에 저장한다.   
다음의 메서드들이 정의되어 있다.   

| 메서드 | 설명 |
| :---: | --- |
| ArrayList() | 크기가 0인 ArrayList를 생성하는 생성자 |
| ArrayList(Collection c) | 주어진 Collection이 저장된 ArrayList를 생성하는 생성자 |
| ArrayList(int initalCapacity) | 지정된 초기용량을 갖는 ArrayList를 생성하는 생성자 |
| ArrayList(int initalCapacity, int capacityIncrement) | 지정된 초기용량과 용량의 증분을 갖는 ArrayList를 생성하는 생성자 |
| boolean add(Object o)<br>boolean addAll(Collection c) | ArrayList의 마지막에 객체를 추가하는 메서드 |
| void add(int index, Object element)<br>boolean addAll(int index, Collection c) | 지정된 위치에 객체를 저장하는 메서드 |
| void clear() | ArrayList를 비우는 메서드 |
| Object clone() | ArrayList를 복제하는 메서드 |
| boolean contains(Object o) | 지정된 객체가 ArrayList에 포함되어 있는지 확인하는 메서드 |
| void ensureCapacity(int minCapacity) | ArrayList의 용량이 최소한 minCapacity가 되도록 하는 메서드 |
| void trimToSize() | ArrayList의 빈 공간을 없애는 메서드 |

ArrayList는 배열을 이용해 데이터를 저장하기 때문에 크기를 변경할 수 없으므로 새로운 배열을 생성해서 데이터를 복사하는 작업과   
비순차적인 데이터의 추가 또는 삭제에서는 데이터를 복사하고 이동해야 해서 시간이 많이 걸린다.

### LinkedList
linked list는 ArrayList의 단점을 보완하기 위해서 나온 자료구조이다.   
배열과 달리 불연속적으로 존재하는 데이터를 연결해서 저장한다.   
linked list는 데이터의 추가, 삭제할 때 처리속도가 매우 빠르지만 이동방향이 단반향이여서 이전 요소에 대한 접근은 어렵다.   
이 점을 보완한 것이 doubly linked list이다. 기존 linked List에서 이전 요소에 대한 참조가 가능하도록 하였다.   
여기서 접근성을 보다 향상시킨 것이 doubly circular linked list인데 doubly linked list에서 첫 번째 요소와 마지막 요소를 연결시켜준 것이다.   
LinkedList는 이 doubly circular linked list를 구현했는데, 접근성을 높이기 위해서이다.   
다음의 메서드들이 정의되어 있다.   

| 메서드 | 설명 |
| :---: | --- |
| LinkedList() | LinkedList를 생성하는 생성자 |
| LinkedList(Collection c) | 주어진 Collection이 저장된 LinkedList를 생성하는 생성자 |
| boolean add(Object o)<br>boolean addAll(Collection c)<br>boolean offer(Object o) | LinkedList의 마지막에 객체를 추가하는 메서드 |
| void add(int index, Object element)<br>boolean addAll(int index, Collection c) | 지정한 위치에 객체를 저장하는 메서드 |
| void clear() | LinkedList를 비우는 메서드 |
| boolean contains(Object o)<br>boolean containsAll(Collection c) | 지정된 객체가 LinkedList에 포함되어 있는지 확인하는 메서드 |
| Object get(int index) | 지정된 위치의 객체를 반환하는 메서드 |
| int indexOf(Object o) | 지정된 객체의 위치를 반환하는 메서드 |
| Object element()<br>Object peek()<br>Object getFirst()<br>Object peekFirst() | LinkedList의 첫 번째 요소를 반환하는 메서드 |
| Object getLast()<br>Object peekLast() | LinkedList의 마지막 요소를 반환하는 메서드 |
| Object poll()<br>Object pollFirst() | LinkedList의 첫 번째 요소를 제거하고 반환하는 메서드 |
| Object pollLast() | LinkedList의 마지막 요소를 제거하고 반환하는 메서드 |
| Object remove()<br>Object pop()<br>Object removeFirst() | LinkedList의 첫 번째 요소를 제거하는 메서드 |
| Object removeLast() | LinkedList의 마지막 요소를 제거하는 메서드 |
| Object addFirst(Object o)<br>boolean offerFirst(Object o) | LinkedList의 맨 앞에 객체를 추가하는 메서드 |
| Object addLast(Object o)<br>boolean offerLast(Object o) | LinkedList의 마지막에 객체를 추가하는 메서드 |
| Iterator descendingIterator() | 역순으로 조회하기 위한 DescendingIterator를 반환하는 메서드 |
| boolean removeFirstOccurrence(Object o) | LinkedList에서 첫 번째로 일치하는 객체를 제거하는 메서드 |
| boolean removeLastOccurrence(Object o) | LinkedList에서 마지막으로 일치하는 객체를 제거하는 메서드 |

### ArrayList와 LinkedList 비교
| Collection | 데이터에 접근시간 | 추가 / 삭제 | 비 고 |
| :---: | :---: | :---: | --- |
| ArrayList | 빠르다 | 느리다 | 순차적인 추가 및 삭제는 더 빠르다.<br>비효율적인 메모리를 사용한다. |
| LinkedList | 느리다 | 빠르다 | 데이터가 많을수록 접근성이 떨어진다. |

따라서 데이터의 개수가 변하지 않는 경우라면 ArrayList를 사용하고, 데이터의 개수의 변경이 잦다면 LinkedList를 사용하자.   
아니면 데이터를 저장할 때는 ArrayList를 사용한 다음, 작업할 때는 LinkedList로 데이터를 옮겨서 작업하자.   

### Stack
LIFO구조로 마지막에 저장된 것을 제일 먼저 꺼내게 되는 클래스이다.   
ArrayList로 구현하며, 수식 계산이나 수식 괄호 검사, undo/redo, 뒤로 가기/앞으로 가기를 구현할 때 사용한다.   
다음의 메서드들이 정의되어 있다.   

| 메서드 | 설명 |
| :---: | --- |
| boolean empty() | Stack이 비어있는 지 확인하는 메서드 |
| Object peek() | Stack의 맨 위에 저장된 객체를 반환하는 메서드(pop()과 달리 Stack에서 꺼내지는 않는다.) |
| Object pop() | Stack의 맨 위에 저장된 객체를 꺼내서 반환하는 메서드 |
| Object push(Object item) | Stack에 객체를 저장하는 메서드 |
| int search(Object o) | Stack에서 지정된 객체를 찾아 그 위치를 반환하는 메서드(배열과 달리 위치는 1부터 시작하고 못찾으면 -1을 반환한다.) |

### Queue
FIFO구조로 제일 먼저 저장한 것을 제일 먼저 꺼내게 되는 인터페이스이다.   
LinkedList로 구현하며, 최근 사용 문서나 인쇄 작업 대기목록, 버퍼를 구현할 때 사용한다.   
다음의 메서드들이 정의되어 있다.   

| 메서드 | 설명 |
| :---: | --- |
| boolean add(Object o) | 지정된 객체를 Queue에 저장하는 메서드 |
| Object remove() | Queue에서 객체를 꺼내 반환하는 메서드 |
| Object element() | 삭제없이 요소를 읽어오는 메서드 |
| boolean offer(Object o) | Queue에 객체를 저장하는 메서드 |
| Object poll() | Queue에서 객체를 꺼내서 반환하는 메서드 |
| Object peek() | 삭제없이 요소를 읽어오는 메서드(Queue가 비어있다면 null을 반환) |

add()와 remove(), element()는 예외가 발생할 수 있으므로 try-catch문을 이용하고,   
poll과 peek는 null을 반환하기 때문에 if(obj == null)로 확인한다.   

Queue의 종류로는 Deque, PriorityQueue, BlockingQueue가 있다.   
Deque는 stack과 Queue의 결합으로 양 끝에서 저장(offer)과 삭제(poll)가 가능하다.   
구현한 클래스로는 ArrayDeque와 LinkedList가 있다.   

PriorityQueue는 우선 순위가 높은 것부터 꺼내는 Queue이며 null은 저장할 수 없다.   
저장공간으로 배열을 사용하며, 각 요소를 힙이라는 자료구조의 형태로 저장한다.   
힙은 이진 트리의 한 종륧 가장 큰 값이나 가장 작은 값을 빠르게 찾을 수 있다는 특징이 있다.   

BlockingQueue는 멀티쓰레드에서 사용하며, 비어있을 때 꺼내기와 가득 차 있을 때 넣기를 지정된 시간동안 지연시키는 Queue이다.   

## Set
순서가 없고 데이터의 중복을 허용하지 않는 인터페이스이다.   
Collection의 메서드와 동일하다.   

## Map
key와 value의 쌍으로 이루어져 있으며, 순서는 없고 키는 중복을 허용하지 않고, 값은 중복을 허용하는 인터페이스이다.   
다음의 메서드들이 정의되어 있다.   

| 메서드 | 설명 |
| :---: | --- |
| void clear() | Map의 모든 객체를 삭제하는 메서드 |
| boolean containsKey(Object key) | 지정된 key와 일치하는 Map의 key가 있는지 확인하는 메서드 |
| boolean containsValue(Object value) | 지정된 value와 일치하는 Map의 value가 있는지 확인하는 메서드 |
| Set entrySet() | Map에 저장되어 있는 key와 value의 쌍을 Map.Entry타입의 객체로 저장한 Set으로 반환하는 메서드 |
| boolean equals(Object o) | 동일한 Map인지 비교하는 메서드 |
| Object get(object key) | 지정된 key에 대응하는 value를 반환하는 메서드 |
| boolean isEmpty() | Map이 비어있는지 확인하는 메서드 |
| Set keySet() | Map에 저장된 key를 Set으로 반환하는 메서드 |
| Object put(Object key, Object value)<br>void putAll(Map t) | Map에 key와 value의 쌍을 추가하는 메서드 |
| Object remove(Object key) | 지정한 key에 일치하는 key와 value의 쌍을 삭제하는 메서드 |
| int size() | Map에 저장된 key와 value의 쌍의 개수를 반환하는 메서드 |
| Collection values() | Map에 저장된 value를 반환하는 메서드 |

Map.Entry 인터페이스는 Map 인터페이스의 내부 인터페이스로 Map 인터페이스를 구현하는 클래스에서는 Map.Entry 인터페이스도 함께 구현해야 한다.   
