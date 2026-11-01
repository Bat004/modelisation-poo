# Glossaire 

## Objets
- **Salle** — Espace du cinéma où se déroule une séance. Elle a une capacité et ne peut accueillir qu’une séance à la fois.
- **Projecteur** — Equipement d'une salle, il permet de lire les supports compatibles avec sa technologie.
- **Film** — Oeuvre, elle est projeté par un projecteur (son support).
- **Support** — Copie d'un film, il est lu par un projecteur.
- **Séance** — Objet d'une salle, elle est projetée par un projecteur et un billet est vendu pour pouvoir la voir. Se déroule dans une salle.
- **Billet** — Associé à une sceance, il est vendu lors d'une séance.

## États
- **Libre** — État d’une salle qui n’est ni en séance ni en nettoyage et qui peut accueillir une séance.
- **En séance** — État d’une salle où se déroule une séance.
- **En nettoyage** — État d’une salle où se déroule le nettoyage.

## Règles métier
- **Compatibilité support/projecteur** — Un projecteur ne peut lire que les supports compatibles avec sa technologie.
- **Expiration de la clé numérique** — Une clé numérique est valable jusqu'à sa date d'expiration.
- **Usure d’une copie 35 mm** — Une copie 35 mm est expirée apres avoir été utilisée 50 fois.
- **Capacité et vente des billets** — La capacité d'une salle est limitée par le nombre de places disponibles. La vente des billets est limitée par la capacité de la salle.

## Actions
- **Programmer une séance** — Une séance est programmée lorsqu'elle est ajoutée à la liste des séances du cinéma.
- **Démarrer une séance** — Une séance est démarrée lorsqu'elle commence à être projetée.
- **Terminer une séance** — Une salle passe en nettoyage quand une scéance est terminée.
- **Terminer le nettoyage** — Une salle devient libre quand le nettoyage est terminé.
- **Vendre un billet** — Un billet est vendu lorsqu'il est acheté.