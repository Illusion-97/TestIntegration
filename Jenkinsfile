pipeline {
    agent any

    tools {
        maven "Maven 3.9.2"
    }

    stages {
        stage('Maven Build') {
            steps {
                bat 'mvn clean package'
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                // Build Docker Image
                    dockerImage = docker.build('test-integration:latest')
                }
            }
        }
        stage('Deploy Docker Image') {
            steps {
                script {
                    try {
                        bat "docker stop test-integration"
                        bat "docker rm test-integration"
                    } catch (Exception e) {
                        echo '404 Not Found : test-integration'
                    }
                    bat "docker run --name test-integration -d -p 8075:8080 test-integration:latest TestIntegration.jar"
                }
            }
        }
    }
}
