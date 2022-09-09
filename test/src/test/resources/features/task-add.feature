Feature: Ajout de tâche
  Scenario: Ajout de tâches
    Given les tache suivante n'est pas présente dans le système
      | id | task | done |
      | 0 | une tache de test | false |
    When je fais appel au endpoint des tâches pour créer les tâches suivantes
      | task | done |
      | une tache de test | false |
    Then les taches suivantes sont présentes dans le système
      | task | done |
      | une tache de test | false |