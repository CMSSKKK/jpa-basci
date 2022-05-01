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

