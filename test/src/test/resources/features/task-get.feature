Feature: Récupération des tâches
  Scenario: On récupère les tâches
    Given les taches suivantes sont présentes dans le système
      | id | task | done |
      | 0 | une tache de test | false |
    When je fais appel au endpoint des tâches pour récupérer les tâches
    Then je recupère les taches suivantes
      | id | task | done |
      | 0 | une tache de test | false |