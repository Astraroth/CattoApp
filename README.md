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
  <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/13/2/1553613642-screenshot-20190326-160428-catpplication-1-min.jpg">
</p>

### Écran Home

Affiche la **liste des chats**, triés par race, ainsi que l'origine de chaque race.
<br>Le bouton du haut **joue aléatoirement des sons de chats parmis 4 sons**, dont 2 miaulements, un extrait de "Nyan Cat" et un extrait de "Piano Cat", et affiche un toast disant "Meow ! (Sound on)".
<br>Le bouton du bas permet de **passer à l'activité où les images aléatoires de chats sont affichées**.

<p align="center">
  <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/13/2/1553631481-screenshot-20190326-211443-catpplication-min.jpg">  <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/13/2/1553631844-screenshot-20190326-212243-catpplication-min.jpg">
</p>


### Écran du détail des chats

Écran **scrollable** qui affiche le tempérament et la description de chaque chat.
<br>L'affection, l'énergie et l'intelligence sont également notées sur 5 : chaque patte remplie en noir équivaut à un point.

<p align="center">
  <img width="200" height="500" src = "https://image.noelshack.com/fichiers/2019/13/2/1553616363-screenshot-20190326-170116-catpplication-min.jpg"> <img width="200" height="500" src = "https://image.noelshack.com/fichiers/2019/14/5/1554455030-screenshot-20190405-110017-catpplication-min.jpg">
</p>

### Image aléatoire de chats

Après avoir cliqué sur le bouton en bas à droite de l'écran home , affiche une **image aléatoire de chat** ainsi qu'un toast disant
"Random Kitty Image !".

<p align="center">
  <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/13/2/1553617576-screenshot-20190326-172437-catpplication-min.jpg"> <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/13/2/1553617249-screenshot-20190326-171810-catpplication-min.jpg">
</p>


### Animation

**Secouer** le téléphone pour faire **appraitre une animation et lancer un extrait de "Shooting Stars"** !

<p align="center">
 <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/13/2/1553619517-ezgif-com-video-to-gif-4.gif">
</p>


### Barre de recherche

Saisir partiellement ou en entier le nom du chat recherché dans la **barre de recherche** pour que les résultats correspondants s'affichent à la place de la liste complète.

<p align="center">
  <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/13/2/1553631713-screenshot-20190326-211904-catpplication-min.jpg"> 
</p>


### Notifications

Il est possible d'envoyer et de recevoir des **notifications** !

<p align="center">
 <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/14/1/1554144941-screenshot-20190401-205228-samsung-experience-home-min.jpg">
</p>



