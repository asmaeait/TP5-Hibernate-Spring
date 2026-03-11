import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import util.HibernateConfig;

public class TestHibernate {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        if (sessionFactory != null)
            System.out.println(" SessionFactory configurée correctement !");
        else
            System.out.println(" SessionFactory non trouvée.");

        HibernateTransactionManager txManager =
                context.getBean(HibernateTransactionManager.class);
        if (txManager != null)
            System.out.println(" Transaction Manager configuré correctement !");
        else
            System.out.println(" Transaction Manager non trouvé.");
    }
}
