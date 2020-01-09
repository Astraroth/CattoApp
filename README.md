# Catpplication, the purrfect app for cats lovers !
*By Alexandra RESSE - 34*

## Présentation
Projet démontrant l'utilisation d'une **RecyclerView** et d'un appel à une **API Rest** dans une application Android codée en **Java**.
<br>Cette application utilise l'API **"TheCatApi"**.

## Consignes respectées

Le projet comprend : 
- **4 activités** : SplashScreen, liste des chats, détails des chats, image aléatoire de chats
- Affichage d'une **liste dans un RecyclerView**
- Affichage du **détail d'un item de la liste**
- Appel à une **API Rest**
- Stockage des **données en cache**
- Architecture **MVC** (Modèle - Vue - Controlleur)
- **Notifications Push** : via Firebase
- **GitFlow** : branches master et develop
- Fonctionnalités supplémentaires : 
  - Écran des détails **scrollable**
  - **Barre de recherche** par race
  - Bouton jouant un **son aléatoire**
  - Bouton passant à une **autre activité**, qui affiche des **images aléatoires** de chats
  - **Secouer** le téléphone pour faire **apparaître une animation et lancer du son**
  
## Fonctionnalités et écrans

### Premier écran

**SplashScreen** affichant les 2 chats de la développeuse : Shadow (en haut) et Link (en bas).
<br>Au bout de 3 secondes, l'application passe automatiquement à l'écran Home.

<p align="center">
  <img width="200" height="400" src = "https://zupimages.net/up/20/02/h811.jpg">
</p>

### Écran Home

Affiche la **liste des chats**, triés par race, ainsi que l'origine de chaque race.
<br>Le bouton du haut **joue aléatoirement des sons de chats parmis 4 sons**, dont 2 miaulements, un extrait de "Nyan Cat" et un extrait de "Piano Cat", et affiche un toast disant "Meow ! (Sound on)".
<br>Le bouton du bas permet de **passer à l'activité où les images aléatoires de chats sont affichées**.

<p align="center">
  <img width="200" height="400" src = "https://zupimages.net/up/20/02/k37q.jpg">  <img width="200" height="400" src = "https://zupimages.net/up/20/02/c70g.jpg">
</p>


### Écran du détail des chats

Écran **scrollable** qui affiche le tempérament et la description de chaque chat.
<br>L'affection, l'énergie et l'intelligence sont également notées sur 5 : chaque patte remplie en noir équivaut à un point.

<p align="center">
  <img width="200" height="500" src = "https://zupimages.net/up/20/02/pk3h.jpg"> <img width="200" height="500" src = "https://zupimages.net/up/20/02/orqq.jpg">
</p>

### Image aléatoire de chats

Après avoir cliqué sur le bouton en bas à droite de l'écran home , affiche une **image aléatoire de chat** ainsi qu'un toast disant
"Random Kitty Image !".

<p align="center">
  <img width="200" height="400" src = "https://zupimages.net/up/20/02/r61q.jpg"> <img width="200" height="400" src = "https://zupimages.net/up/20/02/15xs.jpg">
</p>


### Animation

**Secouer** le téléphone pour faire **appraitre une animation et lancer un extrait de "Shooting Stars"** !

<p align="center">
 <img width="200" height="400" src = "https://zupimages.net/up/20/02/stin.gif">
</p>


### Barre de recherche

Saisir partiellement ou en entier le nom du chat recherché dans la **barre de recherche** pour que les résultats correspondants s'affichent à la place de la liste complète.

<p align="center">
  <img width="200" height="400" src = "https://zupimages.net/up/20/02/u6h0.jpg"> 
</p>


### Notifications

Il est aussi possible d'envoyer et de recevoir des **notifications** !

<p align="center">
 <img width="200" height="400" src = "https://zupimages.net/up/20/02/bjtu.jpg">
</p>
