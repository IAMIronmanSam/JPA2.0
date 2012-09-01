/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author iarivu
 */
import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
public class Demo {
public static void main(String args[]){
Person p = new Person();
p.setName("Hendro Steven");
p.setAddress("Salatiga, Indonesia");
p.setPhoneno(6281390989669l);

Demo demo = new Demo();
demo.persist(p);
}

public void persist(Object object) {
EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("jpatestPU");
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();
try {
em.persist(object);
em.getTransaction().commit();
} catch (Exception e) {
e.printStackTrace();
em.getTransaction().rollback();
} finally {
em.close();
}
}
}
