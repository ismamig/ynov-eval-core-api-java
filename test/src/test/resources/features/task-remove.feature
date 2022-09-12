Feature: Suppression des tâches
  Scenario: Suppression d'une tâche
    Given les taches suivantes sont présente dans le système
      | id | task | done |
      | 0 | TESTREMOVE: une tache de test | false |
    When je fais appel au endpoint des tâches pour supprimer les taches
    Then la tache n'est pas présente dans le système