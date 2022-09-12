Feature: Ajout de tâche
  Scenario: Ajout de tâches
    Given je n'ai aucune tache dans le systeme
    When je fais appel au endpoint des tâches pour créer les tâches suivantes
      | task | done |
      | une tache de test | false |
    Then j'ai une tache dans le systeme