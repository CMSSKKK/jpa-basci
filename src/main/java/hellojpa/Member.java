package hellojpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "membername", nullable = false) // not null
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING) // enum을 사용하고 싶을때 ORDINAL(순서를 저장) 사용x -> enum이 변경 되면 순서 변경이 DB에 영향을 미치지 않음
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)  // 날짜 타입을 사용하고 싶을 때
    private Date createdDate;

    private LocalDateTime lastModifiedDate; // timeStamp
    private LocalDate testDate; // date

    @Lob //문자타입의 필드면 clob(String, char[], java.sql.CLOB) 또는 나머지 필드느 Blob(byte[], java.sql.BLOB)
    private String description;

    @Transient // 테이블과 매핑하지않는 필드는    private int temp;

    public Member() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
