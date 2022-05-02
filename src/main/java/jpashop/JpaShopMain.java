package jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaShopMain {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hello");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            Member member = new Member();
            member.setName("ron2");
            entityManager.persist(member);

            Item item = new Item();
            item.setName("toy");
            entityManager.persist(item);

            Order order = new Order();
            order.setMember(member);
            order.setOrderDate(LocalDateTime.now());
            entityManager.persist(order);

            OrderItem orderItem = new OrderItem();
            orderItem.setItem(item);
            orderItem.setOrder(order);
            entityManager.persist(orderItem);

            OrderItem targetOrderItem = entityManager.find(OrderItem.class, 1L);
            System.out.println("targetOrderItem.getOrder() = " + targetOrderItem.getOrder());
            System.out.println("targetOrderItem.getItem() = " + targetOrderItem.getItem());

            Order targetOrder = entityManager.find(Order.class, 1L);
            System.out.println("targetOrder.getMember() = " + targetOrder.getMember());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
