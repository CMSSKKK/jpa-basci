package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@TableGenerator(
        name = "member_seq_generator",
        table = "my_sequences",
        pkColumnValue = "member_seq", allocationSize = 100)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
                    generator = "meber_seq_generator")
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // mysql AUTO_INCREMENT
    private Long id;

    @Column(name = "name", nullable = false) // not null
    private String memberName;

    private Integer age;

    @Enumerated(EnumType.STRING) // enum을 사용하고 싶을때 ORDINAL(순서를 저장) 사용x -> enum이 변경 되면 순서 변경이 DB에 영향을 미치지 않음
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)  // 날짜 타입을 사용하고 싶을 때
    private Date createdDate;

    private LocalDateTime lastModifiedDate; // timeStamp
    private LocalDate testDate; // date

    @Lob //문자타입의 필드면 clob(String, char[], java.sql.CLOB) 또는 나머지 필드느 Blob(byte[], java.sql.BLOB)
    private String description;

    @Transient // 테이블과 매핑하지않는 필드는
    private int temp;

    public Member() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
