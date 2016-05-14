# UniversalRegistry : Exemples de Clients et Services

_de Chloé Gulielmi & Pierre Massanès_

## Détails de lancement des exemples

Pour lancer les exemples il faut tout d'abord lancer le serveur http de téléchargement dynamique de classes avec 
les paramètres suivants :

    1098 /home/user/IdeaProjects/UniversalRegistryExample/out/production/UniversalRegistryExample
    
Ensuite, chaque main des différents clients et services doivent avoir les arguments de JVM suivants :

    -Djava.rmi.server.useCodebaseOnly=false 
    -Djava.rmi.server.codebase="http://Axxx:1098/" 
    -Djava.security.policy=/home/user/IdeaProjects/UniversalRegistryExample/src/classserver/policy_server
    
