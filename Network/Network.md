# Network

## 네트워킹
* 네트워킹의 정의: 두 대 이상의 컴퓨터를 케이블로 연결하여 네트워크를 구성하는 것
> Java에서는 **java.net 패키지를 사용**하면 네트워크 애플리케이션의 데이터 통신 부분을 쉽게 작성 가능   

### 클라이언트와 서버
* 클라이언트: 서비스를 사용하는 컴퓨터
* 서버: 서비스를 제공하는 컴퓨터

### 네트워킹 모델의 종류
* 서버 기반 모델
    * 안정적인 서비스의 제공이 가능
    * 공유 데이터의 관리와 보안이 용이
    * 서버구축비용과 관리비용이 듦
* P2P 모델
    * 서버구축 및 운용비용을 절감
    * 자원의 활용을 극대화
    * 자원의 관리가 어려움
    * 보안이 취약

### IP주소
IP주소는 네트워크 주소와 호스트 주소로 이루어져 있으며, cmd창에서 ipconfig 명령어로 확인   
* 네트워크 주소: IP주소의 맨 끝을 제외한 주소
* 호스트 주소: IP주소의 맨 끝
> ex) 192.168.10.100이라면 192.168.10은 네트워크 주소, 100은 호스트 주소   

각 자리마다 0~256개를 나타낼 수 있는데, 호스트 주소는 **0은 네트워크 자신**을 나타내고, **255는 브로드캐스트 주소**로 사용되기 때문에    
**호스트 개수는 254개**   

### InetAddress
IP주소를 다루기 위한 클래스   

| 메서드 | 설명 |
| --- | --- |
| byte[] getAddress() | IP주소를 byte배열로 반환 |
| static InetAddress[] getAllByName(String host) | 호스트명에 지정된 모든 호스트의 IP주소를 배열에 담아 반환 |
| static InetAddress getByAddress(byte[] addr) | byte배열을 통해 IP주소를 얻음 |
| static InetAddress getByName(String host) | 호스트명을 통해 IP주소를 얻음 |
| String getCanonicalHostName() | FQDN을 반환 |
| String getHostAddress() | 호스트의 IP주소를 반환 |
| String getHostName() | 호스트의 이름을 반환 |
| static InetAddress getLocalHost() | 로컬호스트의 IP주소를 반환 |
| boolean isMulticastAddress() | IP주소가 멀티캐스트 주소인지 알려줌 |
| boolean isLoopbackAddress() | IP주소가 127.0.0.1인지 알려줌 |
> FQDN: Fully Qualified Domain Name으로 전체 주소 도메인 이름 ex) http://www.naver.com

### URL
"프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링#참조"의 형태   
> Java에서는 **URL 클래스**을 사용하여 URL을 다룸   

| 메서드 | 설명 |
| --- | --- |
| **URL(String spec)** | 지정된 문자열 정보의 URL 객체를 생성 |
| URL(String protocol, String host, String file) | 지정된 값으로 구성된 URL 객체를 생성 |
| URL(String protocol, String host, int port, String file) | 지정된 값으로 구성된 URL 객체를 생성 |
| String getAuthority() | 호스트명과 포트를 문자열로 반환 |
| Object getContent() | URL의 Content 객체를 반환 |
| Object getContent(Class[] classes) | URL의 Content 객체를 반환 |
| int getDefaultPort() | URL의 기본 포트를 반환 |
| String getFile() | 파일명을 반환 |
| String getHost() | 호스트명을 반환 |
| String getPath() | 경로명을 반환 |
| int getPort() | 포트를 반환 |
| String getProtocol() | 프로토콜을 반환 |
| String getQuery() | 쿼리를 반환 |
| String getRef() | 참조를 반환 |
| String getUserInfo() | 사용자 정보를 반환 |
| **URLConnection openConnection()** | URL과 연결된 URLConnection을 얻음 |
| **URLConnection openConnection(Proxy proxy)** | URL과 연결된 URLConnection을 얻음 |
| **InputStream openStream()** | URL과 연결된 URLConnection의 inputStream을 얻음 |
| boolean sameFile(URL other) | URL이 서로 같은 것인지 알려줌 |
| void set(String protocol, String host, int port, String file, String ref) | URL 객체의 속성을 지정된 값으로 설정 |
| void set(String protocol, String host, int port, String authority, String userinfo, String path, String query, String ref) | URL 객체의 속성을 지정된 값으로 설정 |
| String toExternalForm() | URL을 문자열로 변환하여 반환 |
| URI toURI() | URL을 URI로 변환하여 반환 |
> 필요할 때마다 찾아서 사용   

### URLConnection
URL의 자원에 접근하고 읽고 쓰기 위해 사용   

| 메서드 | 설명 |
| --- | --- |
| void addRequestProperty(String key, String value) | 지정된 키와 값을 RequestProperty에 추가 |
| void connect() | URL에 지정된 자원에 대한 통신 연결을 열음 |
| boolean getAllowUserInteraction() | UserInteraction의 허용 여부를 반환 |
| int getConnectTimeout() | 연결 종료 시간을 천분의 일초로 반환 |
| Object getContent() | content 객체를 반환 |
| Object getContent(Class[] classes) | content 객체를 반환 |
| String getContentEncoding() | content의 인코딩을 반환 |
| int getContentLength() | content의 크기를 반환 |
| String getContentType() | content의 type을 반환 |
| long getDate() | 헤더의 data 필드의 값을 반환 |
| boolean getDefaultAllowUserInteraction() | defaultAllowUserInteraction의 값을 반환 |
| String getDefaultRequestProperty(String key) | RequestProperty에서 지정된 키의 default 값을 얻음 |
| boolean getDefaultUseCaches() | useCache의 default 값을 얻음 |
| boolean getDoInput() | doInput 필드 값을 얻음 |
| boolean getDoOutput() | doOutput 필드 값을 얻음 |
| long getExpiration() | 자원(URL)의 만료일자를 얻음(천분의 일초) |
| FileNameMap getFileNameMap() | FileNameMap(MIMEtable)을 반환 |
| String getHeaderField(int n) | 헤더의 n번째 필드를 읽어옴 |
| String getHeaderField(String name) | 헤더의 지정된 이름의 필드를 읽어옴 |
| long getHeaderFieldDate(String name, long Default) | 지정된 필드의 값을 날짜값으로 변환하여 반환(유효하지 않을 경우 default값을 반환) |
| int getHeaderFieldInt(String name, int Default) | 지정된 필드의 값을 정수값으로 변환하여 반환(유효하지 않을 경우 default값을 반환) |
| String getHeaderFieldKey(int n) | 헤더의 n번째 필드를 읽어옴 |
| Map getHeaderFields() | 헤더의 모든 필드와 값이 저장된 Map을 반환 |
| long getIfModifiedSince() | 변경여부 필드의 값을 반환 |
| InputStream getInputStream() | URLConnection에서 InputStream을 반환 |
| long getLastModified() | 최종 변경일 필드의 값을 반환 |
| OutputStream getOutputStream() | URLConnection에서 OutputStream을 반환 |
| Permission getPermission() | 허용 권한을 반환 |
| int getReadTimeout() | 읽기 제한 시간의 값을 반환(천분의 일초) |
| Map getRequestProperties() | RequestProperties에 저장된 키와 값을 Map으로 반환 |
| String getRequestProperty(String key) | RequestProperties에서 지정된 키의 값을 반환 |
| URL getURL() | URLConnection의 URL을 반환 |
| boolean getUseCaches() | 캐시의 사용 여부를 반환 |
| String guessContentTypeFromName(String fname) | 지정된 파일의 content-type을 추축하여 반환 |
| String guessContentTypeFromStream(InputStream is) | 지정된 입력스트림의 content-type을 추축하여 반환 |
| void setAllowUserInteraction(boolean allowuserinteraction) | UserInteraction의 허용 여부를 설정 |
| void setConnectTimeout(int timeout) | 연결 종료 시간을 설정 |
| void setConnectHandlerFactory(ContentHandleFactory fac) | ContentHandlerFactory를 설정 |
| void setDefaultAllowUserInteraction(boolean defaultallowuserinteraction) | Userinteraction 허용 여부의 기본값을 설정 |
| void setDefaultRequestProperty(String key, String value) | RequestProperty의 기본 키쌍을 설정 |
| void setDefaultUseCaches(boolean defaultusecaches) | 캐시 사용 여부의 기본값을 설정 |
| void setDoInput(boolean doinput) | DoInput 필드의 값을 설정 |
| void setDoOutput(boolean dooutput) | DoOutput 필드의 값을 설정 |
| void setFileNameMap(FileNameMap map) | FileNameMap을 설정 |
| void setIfModifiedSince(long ifmodifiedsince) | ModifiedSince 필드의 값을 설정 |
| void setReadTimeout(int timeout) | 읽기 제한 시간을 설정(천분의 일초) |
| void setRequestProperty(String key, String value) | RequestProperty에 키와 값을 저장 |
| void setUseCaches(boolean usecaches) | 캐시의 사용 여부를 설정 |
> 필요할 때마다 찾아서 사용   

## 소켓 프로그래밍
* 소켓의 정의: 프로세스간의 통신에 사용되는 양쪽 끝단

### TCP와 UDP
* TCP
    * 연결 방식
        * 연결기반
        * 1:1 통신방식
    * 특징
        * 데이터의 경계를 구분 안 함
        * 신뢰성 있는 데이터 전송
        * 데이터의 전송 순서가 보장됨
        * 데이터의 수신 여부를 확인
        * 데이터가 손실되면 재전송
        * 패킷을 관리할 필요가 없음
        * UDP보다 전송 속도가 느림
    * 관련 클래스
        * Socket
        * ServerSocket
* UDP
    * 연결 방식
        * 비연결기반
        * 1:1, 1:n, n:n 통신방식
    * 특징
        * 데이터의 경계를 구분함
        * 신뢰성 없는 데이터 전송
        * 데이터의 전송 순서가 바뀔 수 있음
        * 데이터의 수신 여부를 확인 안 함
        * 데이터가 손실되어도 알 수 없ㅇ므
        * 패킷을 관리해줘야 함
        * TCP보다 전송 속도가 빠름
    * 관련 클래스
        * DatagramSocket
        * DatagramPacket
        * MulticastSocket

### TCP 소켓 프로그래밍
* Socket: 프로세스간의 통신을 담당하며, InputStream과 OutputStream을 가지고 있음
* ServerSocket: 포트와 결합되어 포트를 통해 원격 사용자의 연결 요청을 기다리다가 연결 요청이 올 때마다 **새로운 소켓을 생성하여 상대편 소켓과 통신할 수 있도록 연결**

#### 주의사항
여러 개의 소켓은 하나의 포트를 공유해서 사용하지만,  **서버소켓은 포트를 독점**   
따라서, 하나의 포트는 하나의 서버소켓만 사용하도록 하는 것이 바람직   
**서버와의 작업이 끝나면 소켓과 스트림을 닫아야 함**   
**서버에 접속하는 클라이언트의 수가 많을 때는 쓰레드를 이요해서 클라이언트의 요청을 병렬적으로 처리**   

### UDP 소켓 프로그래밍
* DatagramSocket: UDP 통신에서 사용하는 소켓
* DatagramPacket: 헤더 + 데이터