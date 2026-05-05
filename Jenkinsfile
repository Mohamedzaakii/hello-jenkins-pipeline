pipeline {
    agent any
    stages {
        stage('Test') {
            steps {
                sh 'mvn test'
                junit(testResults: 'target/surefire-reports/TEST-*.xml', keepProperties: true, keepTestNames: true)
            }
        }
        stage('Containerization') {
            steps {
                sh 'echo Docker Build Image..'
                sh 'echo Docker Tag Image....'
                sh 'echo Docker Push Image......'
            }
        }
        stage('Kubernetes Deployment') {
            steps {
                sh 'echo Deploy to Kubernetes using [GitOps with ArgoCD](https://learn.kodekloud.com/user/courses/gitops-with-argocd)'
            }
        }
        stage('Integration Testing') {
            steps {
                sh "sleep ${params.SLEEP_TIME}"
                sh 'echo Testing using CURL commands......'
            }
        }
    }
    tools {
        maven 'M398'
    }
}
