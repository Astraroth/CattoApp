# Catpplication, the purrfect app for cats lovers !

## Présentation

Simple projet démontrant l'utilisation de RecyclerView et d'un appel à une API Rest dans une application Android codée en Java.
Cette application utilise l'API "TheCatApi".

## Consignes respectées :

- 4 activités : SplashScreen, liste des chats, détails des chats, image aléatoire de chats
- Affichage d'une liste dans un RecyclerView
- Affichage du détail d'un item de la liste
- Appel à une API Rest
- Stockage des donées en cache
- Architecture MVC
- Notifications Push via Firebase
- GitFlow : branches master et develop
- Fonctionnalités supplémentaires : 
  - Ecran des détails scrollable
  - Bouton jouant un son de chat aléatoire
  - Bouton passant à une autre activité, qui affiche des images aléatoires de chats
  - Secouer le téléphone pour faire apparaître une animation et du son
  
## Fonctionnalités  

### Premier écran

SplashScreen affichant les 2 chats de la développeuse : Shadow (en haut) et Link (en bas).

<p align="center">
  <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/13/2/1553613642-screenshot-20190326-160428-catpplication-1-min.jpg">
</p>

### Ecran Home

Affiche la liste des chats, triés par race, ainsi que l'origine de chaque race.
<br>Le bouton du haut joue des sons de chats aléatoirement dont 2 miaulements, un extrait de "Nyan Cat"et un extrait de "Piano Cat",et affiche un toast disant "Meow ! (Sound on)", 

<p align="center">
  <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/13/2/1553615480-screenshot-20190326-164444-catpplication-min.jpg">  <img width="200" height="400" src = "https://image.noelshack.com/fichiers/2019/13/2/1553617250-screenshot-20190326-171859-catpplication-min.jpg">
</p>


### Ecran du détail des chats

Ecran scrollable qui affiche le tempérament et la description de chaque chat.
L'affection, l'énergie et l'intelligence sont également notées sur 5 : chaque patte remplie en noire équivaut à un point.

<p align="center">
  <img width="200" height="500" src = "https://image.noelshack.com/fichiers/2019/13/2/1553616363-screenshot-20190326-170116-catpplication-min.jpg">
</p>

### Image aléatoire de chats

Après avoir cliqué sur le bouton de l'écran home en bas à droite, affiche une image aléatoire de chat ainsi qu'un toast disant
"Random Kitty Image !".

<p align="center">
  <img width="150" height="300" src = "https://image.noelshack.com/fichiers/2019/13/2/1553617576-screenshot-20190326-172437-catpplication-min.jpg"> <img width="150" height="300" src = "https://image.noelshack.com/fichiers/2019/13/2/1553617249-screenshot-20190326-171810-catpplication-min.jpg">
</p>

### Animation

Secouer le téléphone pour faire appraitre une animation ainsi qu'un extrait de "Shooting Stars".
<p align="center">
  <img width="150" height="300" src = "https://image.noelshack.com/fichiers/2019/13/2/1553619001-ezgif-com-video-to-gif-3-1-1.gif"> 
</p>










