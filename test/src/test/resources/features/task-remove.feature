Feature: Suppression des tâches
  Scenario: Suppression d'une tâche
    Given les taches suivantes sont présentes dans le système
      | id | task | done |
      | 0 | une tache de test | false |
      | 1 | une autre tache de test | true |
    When je fais appel au endpoint des tâches pour supprimer la tâche d'id 0
    Then les taches suivantes sont présentes dans le système
      | id | task | done |
      | 1 | une autre tache de test | true |