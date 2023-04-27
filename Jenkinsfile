pipeline {
  agent any
  
  stages {
    stage('Compilation') {
      steps {
        sh 'chmod +x gradlew'
        sh './gradlew clean build'
      }
    }
    stage('Lint via Spotless') {
      steps {
        sh './gradlew spotlessApply'
      }
    }
    stage('Lancement des tests') {
      steps {
        sh './gradlew test'
      }
    }
    stage('Push sur Nexus') { 
      steps {
        sh './gradlew publish'
      }
    }
  }
}