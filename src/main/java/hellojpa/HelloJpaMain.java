package hellojpa;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

public class HelloJpaMain {

    public static void main(String[] args) {
        // 어플리케이션 당 하나만 생성되는 것
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        // 요청마다 생기는 것 쓰레드간 공유X 엔티티 매니저와 영속성 컨텍스트가 1:1
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("ron2");
              // 이때 insert sql 쿼리를 날리지 않는다. insert sql은 생성해서 쓰기 지연 sql 저장소에 저장 해둔다. flush
//            entityManager.persist(member); // 영속성 컨텍스트에 담는다.

//            Member targetMember = entityManager.find(Member.class, 2L);
//            Member targetMember1 = entityManager.find(Member.class, 2L);
//            System.out.println("같은 트랜잭션 안에서 영속 엔티티의 동일성 보장 -> " + (targetMember1 == targetMember));

            Member targetMember = entityManager.find(Member.class, 2L);
            targetMember.setName("updated"); // update 퀴리를 보냄 dirty checking
            entityManager.remove(targetMember); // 삭제
            entityManager.detach(targetMember); // 영속성 컨텍스트에서 빠진다. -> 준영속 상태(detached)
            entityManager.clear(); // 영속성 컨텍스트 전체를 초기화

            transaction.commit(); // flush 자동 호출
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();

    }
}
