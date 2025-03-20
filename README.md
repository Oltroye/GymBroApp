 Application de Sport - Musculation Android

Ce projet consiste à développer une application Android de musculation en utilisant Kotlin. L'objectif est de fournir aux utilisateurs une solution complète pour gérer leurs entraînements et suivre leur progression, tout en intégrant une balance connectée pour le suivi du poids.

## Table des Matières

- [Introduction](#introduction)
- [Fonctionnalités](#fonctionnalités)
- [Architecture du Projet](#architecture-du-projet)
- [Utilisation](#utilisation)
- [Contribuer](#contribuer)
- [Licence](#licence)

## Introduction

L'application a été conçue pour aider les amateurs de musculation et de fitness à structurer leurs séances d'entraînement et à suivre leurs progrès. Les utilisateurs peuvent créer un compte, se connecter et choisir parmi plusieurs programmes prédéfinis (force, hypertrophie, HIIT, cardio) ou créer leur propre programme personnalisé. Une fonctionnalité innovante inclut la connexion d'une balance (via Raspberry Pi ou Arduino) pour transmettre les mesures de poids directement dans l'application.

## Fonctionnalités

- **Authentification Utilisateur :**
  - Création de compte
  - Connexion sécurisée

- **Programmes d'Entraînement :**
  - Sélection parmi 4 programmes prédéfinis :
    - Force
    - Hypertrophie
    - HIIT
    - Option de création et de personnalisation d’un programme d'entraînement
   

- **Intégration de la Balance Connectée :**
  - Construction d'une balance connectée utilisant Raspberry Pi ou Arduino
  - Transmission en temps réel des données de poids vers l'application

## Architecture du Projet

Le projet est structuré autour des composants suivants :

- **Frontend Android (Kotlin) :**
  - Interfaces utilisateur modernes et intuitives
  - Gestion des interactions et navigation entre les écrans (inscription, connexion, sélection de programme, suivi de poids)

- **Backend (optionnel / API) :**
  - Gestion des comptes utilisateurs et des données d'entraînement
  - Communication sécurisée avec la balance connectée

- **Module Balance Connectée :**
  - Développement sur Raspberry Pi ou Arduino pour récupérer les données de poids
  - Transmission des données via Bluetooth ou Wi-Fi vers l’application Android

### Prérequis

- **Pour l'application Android :**
  - Android Studio installé
  - JDK (Java Development Kit)
  - Kotlin configuré

- **Pour la balance connectée :**
  - Raspberry Pi ou Arduino
  - Capteurs de poids appropriés (load cells)
  - Module de communication (Bluetooth ou Wi-Fi)
 
  Stanislas IBRAHIM et Cléo Deroo
