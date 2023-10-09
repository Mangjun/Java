# I/O

## 자바에서의 입출력
자바에서 입출력을 수행하려면 **스트림**이 필요   
* 스트림의 정의: 데이터를 운반하는데 사용되는 연결통로
> 데이터의 집합체인 Stream과 다르며, 단방향만 가능   

따라서, **입출력을 동시에 수행하려면 입력스트림, 출력스트림 2개의 스트림이 필요**   

간단하게 설명하자면,   
* 바이트기반 스트림: 바이트 단위로 데이터를 전송
* 보조스트림: 스트림의 기능을 보완
* 문자기반 스트림: 바이트기반 스트림은 2 byte인 문자를 처리하기 어려워서 나온 문자 단위로 데이터를 전송
> 추상메서드 read()와 write()는 무조건 구현해야 함   

## 바이트기반 스트림
InputStream과 OutputStream이 있음   

* 바이트기반 스트림 종류
| 입력스트림 | 출력스트림 | 입출력 대상 |
| --- | --- | --- |
| FileInputStream | FileOutputStream | 파일 |
| ByteArrayInputStream | ByteArrayOutputStream | 메모리 |
| PipedInputStream | PipedOutputStream | 프로세스 |
| AudioInputStream | AudioOutputStream | 오디오 장치 |

* InputStream 메서드
    * int available(): 스트림으로부터 읽어 올 수 있는 데이터의 크기를 반환
    * void **close()**: 스트림을 닫음
    * void mark(int readlimit): 현재 위치를 저장
    * void reset(): mark() 위치로 돌아감
    * boolean markSupported(): mark()와 reset()을 지원하는지 여부를 반환
    * abstract int **read()**: 1 byte를 읽음
    * int read(byte[] b): 배열의 크기만큼 읽어서 배열을 채우고 읽어온 데이터 수를 반환
    * long skip(long n): 주어진 길이만큼 건너뜀

* OutputStream 메서드
    * void **close()**: 스트림을 닫음
    * void flush(): 스트림의 버퍼를 출력
    * abstract void write(int b): 주어진 값을 씀
    * void write(byte[] b): 배열에 저장된 모든 내용을 씀

> **모든 스트림은 close()를 호출해서 반드시 닫아줘야 함**   
> **배열을 이용**해서 입출력을하면 작업의 효율을 증가시킴   
> **read()와 write()는 IOException을 발생시키므로 try-catch문 사용**   
> read() 반환 타입이 int인 이유는 정수형 중에서는 가장 효율적이고 빠르기 때문   

### **File**
* FileInputStream 생성자
    * FileInputStream(String name): 지정된 파일 이름을 가진 파일과 스트림 생성
    * FileInputStream(File file): 파일과 스트림 생성
    * FileInputStream(FileDescriptor fdObj): 파일 디스크립터로 스트림 생성

* FileOutputStream 생성자
    * FileOutputStream(String name): 지정된 파일 이름을 가진 파일과 스트림 생성
    * FileOutputStream(String name, boolean append): append가 true면 마지막에 덧붙이고, false면 덮어씀
    * FileOutputStream(File file): 파일과 스트림 생성
    * FileOutputStream(File file, boolean append): 파일과 스트림 생성
    * FileOutputStream(FileDescriptor fdObj): 파일 디스크립터로 스트림 생성

## 바이트기반 보조스트림
FilterInputStream, FilterOutputStream은 모든 보조스트림의 조상   

### Buffered
**스트림의 입출력 효율을 높이기 위해 사용**   

* BufferedInputStream의 생성자
    * BufferedInputStream(InputStream in): 입력스트림을 갖는 보조스트림 생성(Buffer 크기는 8192 byte)
    * BufferedInputStream(InputStream in, int size): 입력스트림을 갖는 보조스트림 생성(Buffer 크기는 size byte)

* BufferedOutputStream의 생성자와 메서드
    * BufferedOutputStream(OutputStream out): 출력스트림을 갖는 보조스트림 생성(Buffer 크기는 8192 byte)
    * BufferedOutputStream(OutputStream out, int size): 출력스트림을 갖는 보조스트림 생성(Buffer 크기는 size byte)
    * flush(): 버퍼의 모든 내용을 출력
    * close(): flush()를 호출하고 스트림을 닫음
    
> **버퍼가 가득 찼을 때만 출력** -> 마지막에 close()나 flush()를 호출해야 함(보조스트림)   

### Data
**기본 자료형**을 사용할 때 사용   

* DataInputStream의 생성자와 메서드
    * DataInputStream(InputStream in): 입력스트림을 갖는 보조스트림 생성
    * type readType(type data): 각 자료형에 맞게 값을 읽고 읽을 것이 더 없다면 EOFException 발생
    * void readFully(byte[] b): 배열의 크기만큼 읽고 읽을 것이 더 없다면 EOFException, I/O에러가 발생하면 IOException 발생
    * void readFully(byte[] b, int off, int len): 배열에서 len만큼 읽고 읽을 것이 더 없다면 EOFException, I/O에러가 발생하면 IOException 발생
    * String readUTF(): UTF-8 형식으로 쓰여진 문자를 읽고 읽을 것이 더 없다면 EOFException 발생
    * static String readUTF(DataInput in): 입력스트림에서 UTF-8 형식의 유니코드를 읽음
    * int skipBytes(int n): 현재 읽고 있는 위치에서 n만큼 건너뜀

* DataOutputStream의 생성자와 메서드
    * DataOutputStream(OutputStream out): 출력스트림을 갖는 보조스트림 생성
    * type writeType(type data): 각 자료형에 맞게 값을 출력
    * void writeUTF(String s): UTF형식으로 문자를 출력
    * void writeChars(String s): 문자를 출력
    * int size(): 지금까지 쓰여진 byte의 수를 반환

> **반드시 쓰인 순서대로 읽어야 함**   
> Data 보조스트림은 무한반복문과 catch(EOFException)문으로 데이터를 읽음   
> finally문에서 스트림을 닫아야 하는데 null일 경우 close()를 호출하면 NullPointerException 발생하므로 null인지 체크 후 close() 호출   
> close()는 IOException 발생시킬 수 있으므로 try-catch문 사용   
> JDK 1.7부터는 **try-with-resources문을 이용하여 close()를 자동 호출 가능**   

### SequenceInputStream
큰 파일을 여러 개의 작은 파일로 나누었다가 하나의 파일로 합칠 때 사용   

* SequenceInputStream의 생성자
    * SequenceInputStream(Enumeration e): 열거형에 저장된 순서대로 입력스트림을 하나의 스트림으로 연결
    * SequenceInputStream(InputStream s1, InputStream s2): 두 개의 입력스트림을 하나의 스트림으로 연결

### Print
* 날짜 형식 문자열
    * %tR: 시분(24시간)
    * %tH:%tM: 시분(24시간)
    * %tT: 시분초(24시간)
    * %tH:%tM:%tS: 시분초(24시간)
    * %tD: 월일년
    * %tm/%td/%ty: 월일년
    * %tF: 년월일
    * %tY-%tm-%td: 년월일

## 문자기반 스트림
바이트기반 스트림에서 InputStream 대신 Reader, OutputStream 대신 Writer을 사용하고 byte배열 대신 char배열을 사용   

### File
한글을 사용할 때 사용하고, 나머지는 바이트기반 스트림과 같음   

### Piped
**쓰레드 간에 데이터를 주고받을 때 사용**   
connect()를 호출해서 입력스트림과 출력스트림을 연결하며 **쓰레드 시작전에 연결해야 함**   

### String
**문자열을 처리할 때 사용**   

## 문자기반 보조스트림

### Buffered
바이트기반 보조스트림과 같으며, BufferedReader에서는 readLine()을 사용하면 데이터를 라인 단위로 읽을 수 있고, BufferedWriter에서는 newLine()을 사용하면 줄바꿈 해줌   

### Stream
**바이트기반 스트림의 데이터를 지정된 인코딩의 문자데이터로 변환할 때 사용**   

* InputStreamReader의 생성자와 메서드
    * InputStreamReader(InputStream in): 입력스트림의 데이터를 OS에서 사용하는 기본 인코딩의 문자로 변환하는 보조스트림 생성
    * InputStreamReader(InputStream in, String encoding): 입력스트림의 데이터를 지정된 인코딩의 문자로 변환하는 보조스트림 생성
    * String getEncoding(): 인코딩을 반환

* OutputStreamWriter의 생성자와 메서드
    * OutputStreamWriter(OutputStream out): 출력스트림의 데이터를 OS에서 사용하는 기본 인코딩의 문자로 변환하는 보조스트림 생성
    * OutputStreamWriter(OutputStream out, String encoding): 출력스트림의 데이터를 지정된 인코딩의 문자로 변환하는 보조스트림 생성
    * String getEncoding(): 인코딩을 반환

## 표준 입출력과 File

### RandomAccessFile
파일 포인터를 사용해서 입력과 출력을 모두 할 수 있으며, **파일의 어느 위치에나 읽기/쓰기가 가능**   

* RandomAccessFile의 생성자와 메서드
    * RandomAccessFile(File file, String mode): 파일에 읽기/쓰기를 하기 위한 파일 객체 생성(r - 읽기만, rw - 읽기/쓰기, rwd - 출력이 지연 없이 바로 쓰임, rws - 파일의 메타정보도 포함)
    * RandomAccessFile(String fileName, String mode): 파일에 읽기/쓰기를 하기 위한 파일 객체 생성(r - 읽기만, rw - 읽기/쓰기, rwd - 출력이 지연 없이 바로 쓰임, rws - 파일의 메타정보도 포함)
    * FileChannel getChannel(): 파일 채널을 반환
    * FileDescriptor getFD(): 파일 디스크립터를 반환
    * long getFilePointer(): 파일 포인터의 위치를 반환
    * long length(): 파일의 크기를 반환(단위: byte)
    * void seek(long pos): 파일 포인터의 위치를 변경(단위: byte)
    * void setLength(long newLength): 파일의 크기를 지정된 길이로 변경(단위: byte)
    * int skipBytes(int n): 지정된 수만큼 byte를 건너뜀

> mode 값이 rw일 때 seek(long pos)을 이용해서 파일 포인터의 위치를 처음으로 이동시킨 후 read()를 호출해야 함   

### File
**자바에서 파일과 디렉터리를 다룰 때 사용**   

* File의 생성자와 메서드
    * File(String fileName): 주어진 문자열을 이름으로 갖는 파일 객체 생성
    * File(String pathName, String fileName): 파일의 경로와 주어진 문자열을 이름으로 갖는 파일 객체 생성
    * File(File pathName, String fileName): 파일의 경로와 주어진 문자열을 이름으로 갖는 파일 객체 생성
    * File(URI uri): 지정된 uri로 파일을 생성
    * String getName(): 파일 이름을 반환
    * String getPath(): 파일의 경로를 반환
    * String getAbsolutePath(): 파일의 절대 경로를 문자열로 반환
    * File getAbsoluteFile(): 파일의 절대 경로를 파일 객체로 반환
    * String getParent(): 파일의 조상 디렉터리를 문자열로 반환
    * File getParentFile(): 파일의 조상 디렉터리를 파일 객체로 반환
    * String getCanonicalPath(): 파일의 정규 경로를 문자열로 반환
    * File getCanonicalFile(): 파일의 정규 경로를 파일 객체로 반환
    * boolean canRead(): 읽을 수 있는 파일인지 검사
    * boolean canWrite(): 쓸 수 있는 파일인지 검사
    * boolean canExecute(): 실행할 수 있는 파일인지 검사
    * int compareTo(File pathname): 지정된 파일과 비교
    * boolean exists(): 파일이 존재하는지 검사
    * boolean isAbsolute(): 파일 또는 디렉터리가 절대 경로명인지 확인
    * boolean isDirectory(): 디렉터리인지 확인
    * boolean isFile(): 파일인지 확인
    * boolean isHidden(): 파일의 속성이 숨김인지 확인
    * boolean createNewFile(): 새로운 파일 생성
    * static File createTempFile(String prefix, String suffix): 임시 파일을 임시 디렉터리에 생성
    * static File createTempFile(String prefix, String suffix, File directory): 임시 파일을 임시 디렉터리에 생성
    * boolean delete(): 파일 삭제
    * void deleteOnExit(): 응용 프로그램 종료 시 파일 삭제
    * boolean equals(Object obj): 주어진 객체가 같은 파일인지 비교
    * long lastModified(): 파일의 마지막 수정 시간을 반환
    * long length(): 파일의 크기를 반환
    * String[] list(): 디렉터리의 파일 목록을 반환
    * String[] list(FilenameFilter filter): 조건에 맞는 파일을 반환
    * File[] list(FilenameFilter filter): 조건에 맞는 파일을 반환
    * File[] listFiles(): 디렉터리의 파일 목록을 반환
    * File[] listFiles(FileFilter filter): 조건에 맞는 디렉터리의 파일 목록을 반환
    * File[] listFiles(FilenameFilter f): 조건에 맞는 디렉터리의 파일 목록을 반환
    * static File[] listRoots(): root의 목록을 반환
    * long getFreeSpace(): root의 비어있는 공간을 반환
    * long getTotalSpace(): root의 전체 공간을 반환
    * long getUsableSpace(): root의 사용가능한 공간을 반환
    * boolean mkdir(): 디렉터리 생성
    * boolean mkdirs(): 디렉터리 생성(부모 디렉터리도 생성)
    * boolean renameTo(File dest): 파일의 이름을 변경
    * boolean setExecutable(boolean executable): 파일의 실행 가능하게 변경
    * boolean setExecutable(boolean executable, boolean ownerOnly): 파일의 소유자만 파일의 실행 가능하게 변경
    * boolean setReadable(boolean readalbe): 파일을 읽을 수 있게 변경
    * boolean setReadable(boolean readalbe, boolean ownerOnly): 파일의 소유자만 파일을 읽을 수 있게 변경
    * boolean setReadOnly(): 파일을 오직 읽을 수만 있게 변경
    * boolean setWritable(boolean writable): 파일을 쓸 수 있게 변경
    * boolean setWritable(boolean writable, boolean ownerOnly): 파일의 소유자만 파일을 쓸 수 있게 변경
    * boolean setLastModified(long t): 파일의 마지막으로 수정된 시간을 t로 변경
    * Path toPath(): 파일을 Path로 변환해서 반환
    * URI toURI(): 파일을 URI로 변환해서 반환
    
    
* File의 멤버 변수
    * static String pathSeparator: OS에서 사용하는 경로 구분자(윈도우: ';', 유닉스: ':')
    * static char pathSeparatorChar: OS에서 사용하는 경로 구분자(윈도우: ';', 유닉스: ':')
    * static String separator: OS에서 사용하는 이름 구분자(윈도우: '\', 유닉스: '/')
    * static char separatorchar: OS에서 사용하는 이름 구분자(윈도우: '\', 유닉스: '/')

> **OS 독립적으로 프로그램 작성하기 위해서는 반드시 멤버 변수 이용**   
> 정규 경로: 기호나 링크 등을 포함하지 않는 유일한 경로   
> 새로운 파일을 생성: **1. 출력스트림 생성** **2. createNewFile() 호출**   

## 직렬화
**객체를 스트림으로 만드는 것**   
스트림으로부터 객체를 만드는 것은 역직렬화   
> **객체에는 클래스 변수나 메서드가 포함되지 않음**   

* ObjectInputStream: **직렬화할 때 사용하는 보조스트림**
    * 메서드
        * void defaultReadObject(): 자동 직렬화
        * type readType(): 자료형을 직렬화
        * Object readObject(): 객체를 직렬화
        * String readUTF(): 문자열을 직렬화
> **반환타입이 자료형이므로 객체 원래의 타입으로 형변환해줘야 함**   

* ObjectOutputStream: **역직렬화할 때 사용하는 보조스트림**
    * 메서드
        * void defaultWriteObject(): 자동 역직렬화
        * void writeType(Type data): 자료형을 역직렬화
        * void writeObject(Object obj): 객체를 역직렬화
        * void writeUTF(String str): 문자열을 역직렬화

### 직렬화가 가능한 클래스 생성
**Serializable 인터페이스를 구현하면 됨**   
> 조상 클래스가 Serializable을 구현했다면 자손 클래스도 직렬화 가능   
> **조상 클래스는 Serializable을 구현하지 않고 자손 클래스만 구현했다면 조상 클래스의 인스턴스 변수는 직렬화 대상에서 제외**   
> **인스턴스 변수의 타입이 아닌 실제로 연결된 객체의 종류에 의해서 결정**   
> **transient가 붙은 인스턴스 변수의 값은 그 타입의 기본값으로 직렬화**   
> 직렬화할 객체가 많다면 컬렉션에 저장해서 직렬화하는 것이 좋음   
