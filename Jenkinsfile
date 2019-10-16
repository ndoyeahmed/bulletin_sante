pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
                sh 'mvn validate'
                sh 'mvn compile'
                sh 'mvn test'
            }
        }
        stage('deploy') {
            steps {
                sh 'mvn wildfly:deploy-only -Pstandaone-mode'
            }
        }
    }
}
