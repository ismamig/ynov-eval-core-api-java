Feature: Mise à jour d'une tâche
  Scenario: Mise à jour d'une tâche
    Given les taches suivantes existent dans le systeme
      | id | task | done |
      | 0 | une tache de test | false |
    When je passe mes taches à done
    Then toutes mes taches sont done
