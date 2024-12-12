-- Insertion des données dans la table "Outil"
INSERT INTO Outil (titre, domaine, simpleDesc, detailledDesc, lienURL, acces) VALUES
('GitHub Global Campus (GitHub Education)', 'Bouquet de services', NULL, 'Sélection d\'outils et de services pour booster votre productivité en tant qu\'élève-ingénieur du numérique. Le GitHub Student Developer Pack vous donne un accès gratuit à un impressionnant catalogue de services et d\'outils. Ex: GitHub pro, GitHub Copilot, DigitalOcean, Outils JetBrains (IntelliJ IDEA Ultimate, PyCharm,...), Azure, Heroku, etc... Une courte vidéo de présentation est disponible ici  :https://www.youtube.com/watch?v=HIVFdN9VGgw', 'https://education.github.com/discount_requests/application', 'a) Aller sur le lien indiqué\nb) Remplir les différents champs sur la page\nc) Choisir "French School of Electronics and Computer Science" pour l\'école\nd) Envoyer un justificatif (idéalement la carte d\'étudiant)\ne) Attendre la validation par l\'équipe de GitHub\nf) Profiter des différentes offres incluses dans le programme'),
('Coding Rooms', 'Codage / Développement', NULL, 'Exercices pratiques de programmation, en ligne', 'https://www.codingrooms.com/', 'L\'enseignant partage un lien d\'invitation unique pour rejoindre son espace de cours sur la plateforme Coding Rooms.\nOn peut ensuite accéder aux exercices et aux ressources du cours.'),
('Nowledgeable', 'Codage / Développement', NULL, 'Exercices pratiques de programmation, en ligne', 'https://nowledgeable.com/', 'a) Allez sur : https://nowledgeable.com/login\nb) Saisissez votre adresse mail EFREI\nc) Un lien vous sera envoyé pour créer et activer un compte'),
('Jupyter notebook', 'Codage / Développement', NULL, 'Jupyter Notebook est une application web qui vous permet de stocker des lignes de code Python, les résultats de l’exécution de ces dernières (graphiques, tableaux, etc.) et du texte formaté. Il permet donc de combiner code, visualisations et explications dans un même document, ce qui facilite l\'exploration et le partage de données.', 'https://jupyter.org/', 'OPTION A\na) Installer PyCharm Pro\nb) Ouvrir le notebook à partir de l\'IDE.\n\nOPTION B\nInitialiser un notebook depuis Google Colab\n\nOPTION C\na) Installer Anaconda (gratuit)\nb) Lancer le notebook Jupyter via le lien présent dans le navigateur Anaconda'),
('repl.it', 'Codage / Développement', NULL, 'Exercices pratiques de programmation (notamment de programmation fonctionnelle) en ligne ou via une app', 'https://replit.com/', 'a) Créer un compte (option gratuite)\nb) Vous aurez alors accès à la plateforme et à l\'ensemble de ses services'),
('Google Colaboratory (Colab)', 'Codage / Développement', NULL, 'Colab est une plateforme très pratique pour exécuter du code Python sans avoir besoin d\'installer Python localement. Elle est souvent utilisée pour les démonstrations, les TP et les projets en Machine Learning car elle donne accès à des ressources de calcul gratuites (CPU, GPU, TPU).', 'https://colab.research.google.com/?hl=fr', 'a) Se connecter à Colab avec son compte Google\nb) Créer un nouveau notebook\nc) Commencer à coder en Python directement dans le navigateur.'),
('Environnements virtuels', 'Hyperviseurs', NULL, 'Machines virtuelles', '???', 'OPTION I : Utilisation d\'un hyperviseur\na) Installer VirtualBox ou VMWare\nb) Télécharger un fichier image *.iso\nc) L\'ouvrir dans l\'hyperviseur\n\nOPTION II : Utilisation de Vagrant\na) Installer Vagrant (gratuit)\nb) Créer sa VM en passant par une box de Vagrant'),
('Environnements virtuels1', 'Containers', NULL, 'Containers Docker', 'https://www.docker.com/', 'a) Installer Docker\nb) Aller sur le Docker Hub pour récupérer une ou des image(s) Docker correspondant au(x) besoin(s)\nc) Créer un ou des container(s) à partir de cette/ces image(s)'),
('TryHackme', 'Cyber sécurité', NULL, 'TryHackMe est une excellente ressource pour se former à la cybersécurité de manière pratique. Les exercices, souvent présentés sous forme de scénarios réalistes, permettent d\'apprendre en s\'amusant. Des challenges concrets permettent de pratiquer de façon ludique.  #cyber #hacking', 'https://tryhackme.com/', 'a) Aller sur le site https://tryhackme.com/\nb) Cliquer sur connexion\nc) Entrer vos identifiants\nd) Commencer à travailler\n\nRemarque : Il y a 3 plans correspondant à 3 tarifs différents. Le plan gratuit devrait convenir pour la plupart des cours.'),
('Hack The Box', 'Cyber sécurité', NULL, 'Hack The Box est une plateforme de cybersécurité réputée pour ses challenges de type "capture de drapeaux" (CTF). Elle propose des machines virtuelles à attaquer légalement pour s\'entraîner au hacking éthique.', 'https://www.hackthebox.com/', 'Créer un compte standard sur le site via le lien indiqué'),
('AWS', 'Cloud provider', NULL, 'Fournisseur Cloud', 'https://signin.aws.amazon.com/signup?request_type=register', '?'),
('AWS Academy', 'Formations en ligne', NULL, 'Plateforme d\'AWS de formations en ligne', 'https://aws.amazon.com/fr/training/awsacademy/', '?'),
('Azure', 'Cloud provider', NULL, 'Fournisseur Cloud', 'https://azure.microsoft.com/en-us', '?'),
('Integral Calculator', 'Mathématiques', NULL, 'Calcul d\'intégrales en ligne', 'https://www.integral-calculator.com/', '?'),
('eMathHelp', 'Mathématiques', NULL, 'Résolution de problèmes mathématiques, étape par étape', 'https://www.emathhelp.net/en/', '?'),
('MultisimLive', 'Electronique', NULL, 'Simulation de programmation de cartes electroniques', 'https://www.multisim.com/', '?'),
('MATLAB & Simulink (MathWorks)', 'Mathématiques', NULL, 'Calcul numérique / Analyse de données', 'https://fr.mathworks.com/products/matlab/student.html', 'Un accompagnement clair et détaillé est proposé dans les cours utilsant l\'outil'),
('Patchwork3D & AccelVR (Lumiscaphe)', 'Réalité virtuelle / augmentée', NULL, 'Modélisation 3D / Rendu RV', 'https://resources.lumiscaphe.com/Software_Suite/2023/en/accel-vr.html <br>https://resources.lumiscaphe.com/Software_Suite/2023/en/patchwork-3d.html', 'S\'informer auprès de l\'enseignant'),
('Kaggle', 'Data Science', NULL, 'Kaggle est une plateforme web qui fournit des outils et des ressources puissants pour aider à progresser en Data Science. Vous trouverez plus de 50 000 jeux de données publics et 400 000 notebooks publics disponibles pour tous.', 'https://www.kaggle.com/', 'S\'informer auprès de l\'enseignant'),
('Notion', 'Gestion de projets et collaboration', NULL, 'Notion est une application/plateforme de prise de notes, de gestion de projet et de collaboration. Notion est conçu pour permettre aux utilisateurs d\'organiser leurs informations de manière flexible, en utilisant une variété de formats tels que des notes, des bases de données relationnelles, des listes de tâches, des calendriers et des tableaux, le tout dans un seul espace de travail intégré.', 'https://www.notion.so/fr-fr', 'S\'informer auprès de l\'enseignant'),
('Trello', 'Gestion de projets et collaboration', NULL, 'Trello est une plateforme de gestion de projet très visuelle et intuitive. Elle est idéale pour les travaux de groupe, car elle permet de suivre facilement l\'avancement des tâches et de communiquer efficacement entre les membres de l\'équipe.', 'https://trello.com/home', 'a) Créer un compte (version gratuite)\nb) Créer un espace puis un premier tableau\nc) Commencer à utiliser la plateforme'),
('Code Ocean', 'Data Science', NULL, 'Code Ocean une plateforme centralisée pour la création, le partage, la publication, la préservation et la réutilisation de code et de données exécutables. Avec Code Ocean, les chercheurs peuvent facilement analyser, organiser et exécuter des travaux de recherche et les publier dans des dépôts et des revues.', 'https://codeocean.com/', 'S\'informer auprès de l\'enseignant'),
('Marp', 'Génération de documents', NULL, 'Création de slides à prtir de documents Markdown', 'https://marp.app/', 'La documentation sur le site officiel est très détaillée et suffisamment précise pour permettre une prise en main autonome'),
('LaTeX', 'Génération de documents', NULL, 'LaTeX est un langage et un système de composition de documents', 'https://www.latex-project.org/', 'La documentation sur le site officiel est très détaillée et suffisamment précise pour permettre une prise en main autonome'),
('Material for mkdocs', 'Génération de documents', NULL, 'Création de documentation (de code)', 'https://squidfunk.github.io/mkdocs-material/', 'La documentation sur le site officiel est très détaillée et suffisamment précise pour permettre une prise en main autonome'),
('Looping', 'Bases de données', NULL, 'Modélisation conceptuelle de données', 'https://www.looping-mcd.fr/', 'Télécharger et installer'),
('MongoDB Compass', 'Bases de données', NULL, 'GUI pour MongoDB', 'https://www.mongodb.com/products/tools/compass', 'Télécharger et installer'),
('Wireshark', 'Réseaux', NULL, 'Wireshark est un analyseur de paquets libre et gratuit. Il est notamment utilisé dans le dépannage et l’analyse de réseaux informatiques et le développement de protocoles.', 'https://www.wireshark.org/', 'Télécharger et installer');