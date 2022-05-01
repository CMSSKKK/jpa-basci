### 데이터 베이스 스키마 자동 생성 속성 
`<property name="hibernate.hbm2ddl.auto" value="create" />`

|옵션|설명|
|----|-----|
|create| 기존 테이블 삭제 후 다시 생성|
|create-drop| create와 같으나 종료시점에 테이블 drop|
|update | 변경 내용만 반영|
|validate | 엔티티와 테이블이 정상 매핑되었는지만 확인|
|none| 사용하지 않음|

운영 장비에는 사용하지않는 것을 권장!

#### 권장하는 식별자 전략

- 기본 키 제약 조건 : not null, unique, 변하면 안된다!

- 미래까지 이 조건을 만족하는 자연키를 찾기 어렵다. 대리키(대체키)를 사용하는 것을 권장한다.
- 주민등록번호도 기본 키로 적절하지 않다.
- 주민등록번호를 저장하면 안된다는 지침이 내려온다면?   
-> PK인 주민등록번호를 foreign key로 가지고 있는 다른 테이블 까지 모두 수정해야하는 참사가 벌어진다.


- 권장 Long형(auto increment or sequence) + 대체키(예시로 UUID) + 키 생성전략 사용
- 비지니스를 키로 가져오는 것은 절대 금지 !
> 프로젝트를 몇 번 진행하면서 Long 타입의 아이디가 필요한 건지 의문이 들었었다.   
> 이 때 검색해서 나온 결과로는 숫자타입의 id를 가지는 것이 DB 성능에 좋다라는 답변도 있었지만, 문자타입의 id를 사용해도 크게 문제는 없다라는 답변을 얻었었다.    
> 타입의 문제가 아니라 자연키와 대체키의 문제였다. 핵심을 완전히 놓치고 있었다.

#### GenerateValue를 사용해서 id를 auto_increment로 했을 때 새로운 객체를 DB애 저장할 때, 영속성 컨텍스트에서 관리할 수 있을까??
- 기존 트랜잭션 commit 시점에 insert query를 날리는 것과 차이가 있다.
- 영속성 컨텍스트를 저장하는 시점에 insert query를 날린다. (값을 넣고 키를 return을 받아서 저장) 
> sequence의 경우 next value를 먼저 DB에서 얻어옴
> sequence를 사용할 때, allocationSize를 50(default)으로 설정해서 DB와의 네트워크 횟수를 줄이고 memory에 sequence를 가지고 있도록 하는 방법도 있다.
> allocationSize를 10000과 같이 크게 해둬도 되긴 하지만 서버가 다운되면, memory에 저장된 sequnce들을 잊어버려서 빈 공간이 생기는 경우가 생긴다. (큰 문제는 아니다.)
