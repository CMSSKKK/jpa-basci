package hellojpa;

import javax.persistence.*;
import java.util.List;

public class HelloJpaMain {

    public static void main(String[] args) {
        // 어플리케이션 당 하나만 생성되는 것
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
        // 요청마다 생기는 것 쓰레드간 공유X
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("ron2");
//            entityManager.persist(member);

//            Member targetMember = entityManager.find(Member.class, 1L);
//            targetMember.setName("ron3");

            // JPQL 엔티티 대상으로 쿼리 객체 지향 SQL
            List<Member> resultList = entityManager.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(5)
                    .getResultList();

            for (Member member : resultList) {
                System.out.println("member.name = " + member.getName());
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();

    }
}
