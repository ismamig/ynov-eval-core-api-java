Feature: Mise à jour d'une tâche
  Scenario: Mise à jour d'une tâche
    Given les taches suivantes sont présentes dans le système
      | id | task | done |
      | 0 | une tache de test | false |
    When je fais appel au endpoint des tâches pour mettre à jour la tâche d'id 0
    Then les taches suivantes sont présentes dans le système
      | id | task | done |
      | 0 | une tache de test mise à jour | true |