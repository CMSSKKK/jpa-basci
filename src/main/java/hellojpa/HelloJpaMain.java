package hellojpa;

import javax.persistence.*;

public class HelloJpaMain {

    public static void main(String[] args) {
//        // 어플리케이션 당 하나만 생성되는 것
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");
//        // 요청마다 생기는 것 쓰레드간 공유X 엔티티 매니저와 영속성 컨텍스트가 1:1
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        // JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
//
//        try {
//
//            Mbr member = new Mbr();
//            member.setMemberName("ronor");
//
//            entityManager.persist(member);
//
//            transaction.commit();
//        } catch (Exception e) {
//            transaction.rollback();
//        } finally {
//            entityManager.close();
//        }
//
//        entityManagerFactory.close();

    }
}
