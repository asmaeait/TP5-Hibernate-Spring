# TP5 — Intégration Spring + Hibernate + MySQL

Application Java de gestion de produits développée avec **Spring**, **Hibernate** et une base de données **MySQL**.

---

## Environnement de développement

| Élément | Version |
|---|---|
| JDK | 1.8 |
| IDE | IntelliJ IDEA 2025 |
| Maven | 3.x |
| Spring | 5.3.22 |
| Hibernate | 5.6.12.Final |
| Base de données | MySQL 8 |

---

## Structure du projet

> *Screenshot de la structure du projet dans IntelliJ*

<img width="290" height="424" alt="structureDeProjet" src="https://github.com/user-attachments/assets/4bb5cddd-f8f4-406b-b511-6e00d2b116d5" />


---

## Vérification de la configuration

> *Screenshot de la console IntelliJ après lancement de `TestHibernate.java`*

<img width="1683" height="449" alt="image" src="https://github.com/user-attachments/assets/161be967-2252-4378-83b6-60fbe141fd2c" />

`TestHibernate.java` vérifie que `SessionFactory` et `HibernateTransactionManager` sont bien créés et injectés par Spring.

---

## Test CRUD complet

###  Ajouter deux produits — `create()`
###  Lister tous les produits — `findAll()`
###  Recherche par ID — `findById()`
###  Modifier un produit — `update()`
###  Supprimer un produit — `delete()`

> **Remarque :** Le premier produit (**Laptop**) est supprimé après le test. C'est pourquoi dans MySQL seul le deuxième produit (**Tablette** à 1300.50€) reste visible — ce qui confirme que `delete()` fonctionne correctement.
 
<img width="1747" height="649" alt="image" src="https://github.com/user-attachments/assets/857065bc-a5df-4834-b2f0-966e6680bf52" />

---

## Données dans MySQL après exécution

> *Screenshot de phpMyAdmin — table `product` après le test CRUD*

<img width="1362" height="542" alt="image" src="https://github.com/user-attachments/assets/59b1c8ee-19ce-4209-a1a6-cc8f26a7be47" />

---


## Problème rencontré et solution

###  `Could not obtain transaction-synchronized Session for current thread`

**Cause :** `@Transactional` placé uniquement au niveau de la classe ne crée pas de transaction pour chaque appel de méthode.

**Solution :** Ajouter `@Transactional` sur **chaque méthode** de `ProductDaoImpl` individuellement — `@Transactional(readOnly = true)` pour `findById` et `findAll`, `@Transactional` pour les autres.

---
