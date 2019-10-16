pipeline {
    agent { docker { 
               image 'maven:3.3.3' 
            } 
          }
    stages {
        stage('build') {
            steps {
                sh 'mvn mvn -B -DskipTests clean package'
            }
        }
        stage('deploy') {
            steps {
                sh 'mvn wildfly:deploy-only -Pstandaone-mode'
            }
        }
    }
}
