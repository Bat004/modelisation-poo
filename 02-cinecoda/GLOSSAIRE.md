# Glossaire métier — CinéCoda

## Entités

- **Cinéma** — Organisation qui possède ses salles et programme les séances qui s’y déroulent.
- **Salle** — Espace identifié par un numéro, doté d’une capacité et d’un projecteur. Elle suit un cycle d’états : libre, en séance, puis en nettoyage.
- **Projecteur** — Équipement identifié par un numéro de série. Il est numérique ou argentique et ne lit que les supports compatibles.
- **Film** — Oeuvre identifiée par un titre et une durée en minutes.
- **Support** — Copie matérielle ou numérique d’un film, destinée à être projetée. Chaque exemplaire a ses propres conditions de lecture et d’usure.
- **Support numérique** — Support lu par un projecteur numérique, dont la clé de lecture est valable jusqu’à une date d’expiration incluse.
- **Copie 35 mm** — Support lu par un projecteur argentique. Chaque projection l’use ; à partir de 50 projections, elle n’est plus projetable.
- **Séance** — Projection programmée d’un support dans une salle, à une date donnée et avec un tarif de base. Elle peut être programmée sans pouvoir démarrer.
- **Billet** — Place vendue pour une séance. Son prix dépend de son type et du tarif de base de la séance.
- **Billet plein tarif** — Billet dont le prix est égal au tarif de base.
- **Billet étudiant** — Billet dont le prix correspond au tarif de base diminué de 25 %.
- **Billet enfant** — Billet vendu au prix fixe de 5 €.

## États

- **Libre** — Salle prête à accueillir une séance.
- **En séance** — Salle dans laquelle une séance est en cours.
- **En nettoyage** — Salle qui doit être nettoyée après une séance et avant de redevenir libre.
- **Capacité** — Nombre maximal de places d’une salle.
- **Places restantes** — Capacité de la salle moins le nombre de billets vendus pour la séance.
- **Taux de remplissage** — Nombre de billets vendus divisé par la capacité de la salle, exprimé en pourcentage.
- **Recette d’une séance** — Somme des prix de tous les billets vendus pour cette séance.
- **Recette du jour** — Somme des recettes des séances programmées à une date donnée.

## Actions et comportements

- **Programmer une séance** — Le cinéma crée une séance pour une de ses salles, avec un support, une date et un tarif de base. Une salle étrangère au cinéma est refusée.
- **Vendre un billet** — La séance vend un billet et calcule son prix selon le type de billet. La vente est refusée si la capacité de la salle est atteinte.
- **Démarrer une séance** — La séance démarre uniquement si sa salle est libre et si le projecteur peut lire le support à la date de la séance.
- **Terminer une séance** — La séance en cours se termine et la salle passe obligatoirement en nettoyage. Une projection supplémentaire est comptée pour la copie 35 mm.
- **Terminer le nettoyage** — Une salle en nettoyage redevient libre. Cette action est refusée dans tout autre état.
- **Consulter les places restantes** — La séance indique les places encore disponibles, sans permettre de modifier ce nombre directement.
- **Consulter le taux de remplissage** — La séance calcule le rapport entre les billets vendus et la capacité de sa salle.
- **Consulter la recette** — La séance totalise le prix des billets vendus.
- **Consulter l’état d’une saelle** — Le cinéma fournit ses salles actuellement libres.
- **Lister les séances d’une date** — Le cinéma fournit les séances programmées pour cette date, qu’elles aient démarré ou non.
- **Calculer la recette du jour** — Le cinéma additionne les recettes de ses séances à la date demandée.
- **Consulter le nombre de projections** — La copie 35 mm indique combien de fois elle a été projetée.

## Règles 

- Une salle ne peut démarrer une séance que lorsqu’elle est libre.
- Terminer une séance place toujours sa salle en nettoyage, seule la fin du nettoyage la rend libre.
- Un fichier numérique ne peut être projeté que sur un projecteur numérique et à une date qui ne dépasse pas l’expiration de sa clé.
- Une copie 35 mm ne peut être projetée que sur un projecteur argentique et tant qu’elle a été projetée moins de 50 fois.
- Une séance ne peut pas vendre plus de billets que la capacité de sa salle.
- Une action qui enfreint une règle est refusée avec une explication.
- Les consultations ne modifient jamais l’état.
