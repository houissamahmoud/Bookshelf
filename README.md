# Bookshelf (Kotlin + Jetpack Compose)

Application basée sur le codelab « Project: Create a Bookshelf App ».
Affiche une grille de couvertures de livres via l'API Google Books, avec recherche.

## Ouvrir le projet
1. Dézipper, puis Android Studio → File → Open → dossier `Bookshelf`.
2. Laisser Gradle synchroniser (Android Studio propose de créer le wrapper si besoin).
3. Lancer sur émulateur ou appareil (minSdk 24).

## Structure
- data/ : modèles, repository, conteneur d'injection
- network/ : interface Retrofit
- ui/ : ViewModel + écrans Compose
