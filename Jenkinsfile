pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M398" and add it to the path.
        maven "M391"
    }

    stages {
        stage('Echo Version') {
            steps {
                sh "echo Print Maven Version"
                sh "mvn -version"
            }
        }
        stage('Build') {
            steps {
                // No explicit Git checkout required since SCM performs the checkout automatically
                sh "mvn clean package -DskipTests=true"
            }
        }
        
        stage('Unit Test') {
          steps {
            script {
              for (int i = 0; i < 60; i++) {
                echo "${i + 1}"
                sleep 1
              }
              sh "mvn test"
            }
          }  
        }




    }
}
