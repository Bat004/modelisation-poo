# Glossaire 

## Objets
- **Salle** — Espace du cinéma où se déroule une séance. Elle a une capacité et ne peut accueillir qu’une séance à la fois.
- **Projecteur** — Objet d'une salle, il permet de lire les supports compatibles avec sa technologie.
- **Film** — Objet d'une salle, il est projeté par un projecteur.
- **Support** — Objet d'une salle, il est lu par un projecteur.
- **Séance** — Objet d'une salle, elle est projetée par un projecteur et vendue par un billet.
- **Billet** — Objet d'une salle, il est vendu lors d'une séance.

## États
- **Libre** — État d’une salle qui n’est ni en séance ni en nettoyage et qui peut accueillir une séance.
- **En séance** — État d’une salle où se déroule une séance.
- **En nettoyage** — État d’une salle où se déroule le nettoyage.

## Règles métier
- **Compatibilité support/projecteur** — Un projecteur ne peut lire que les supports compatibles avec sa technologie.
- **Expiration de la clé numérique** — Une clé numérique ne peut être utilisée qu'une seule fois.
- **Usure d’une copie 35 mm** — Une copie 35 mm est usée lorsqu'elle est projetée.
- **Capacité et vente des billets** — La capacité d'une salle est limitée par le nombre de places disponibles. La vente des billets est limitée par la capacité de la salle.

## Actions
- **Programmer une séance** —  
- **Démarrer une séance** — …
- **Terminer une séance** — …
- **Terminer le nettoyage** — …
- **Vendre un billet** — …