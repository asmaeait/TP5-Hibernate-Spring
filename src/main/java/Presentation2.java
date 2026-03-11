import dao.IDao;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;
import java.util.List;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean(IDao.class);

        //  AJOUTER un produit
        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setPrice(999.99);
        productDao.create(p1);
        System.out.println(" Produit créé : " + p1.getName());

        //  AJOUTER un produit
        Product p2 = new Product();
        p2.setName("Tabelette");
        p2.setPrice(1300.50);
        productDao.create(p2);
        System.out.println(" Produit créé : " + p2.getName());



        // AFFICHER TOUS les produits
        System.out.println("\n=== Liste de tous les produits ===");
        List<Product> tous = productDao.findAll();
        for (Product p : tous) {
            System.out.println("ID: " + p.getId() +
                    " | Nom: " + p.getName() +
                    " | Prix: " + p.getPrice() + "€");
        }

        //  CHERCHER par ID — on récupère l'ID du premier produit trouvé
        if (!tous.isEmpty()) {
            int idRecherche = tous.get(0).getId();

            Product trouve = productDao.findById(idRecherche);
            System.out.println("\n=== Recherche produit ID=" + idRecherche + " ===");
            System.out.println("Trouvé : " + trouve.getName() + " - " + trouve.getPrice() + "€");

            //  MODIFIER ce produit
            trouve.setPrice(150.0);
            productDao.update(trouve);
            System.out.println("\n Prix modifié à : " + trouve.getPrice() + "€");

            // 🗑 SUPPRIMER ce produit
            productDao.delete(trouve);
            System.out.println("🗑 Produit supprimé !");
        }

        // LISTE FINALE
        System.out.println("\n=== Liste finale ===");
        productDao.findAll().forEach(p ->
                System.out.println("ID: " + p.getId() +
                        " | Nom: " + p.getName() +
                        " | Prix: " + p.getPrice() + "€")
        );
    }
}
