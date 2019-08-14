pipeline {
    agent any

    environment {
        DOCKER_MACHINE_NAME='jenkins'
        COMPOSE_CONVERT_WINDOWS_PATHS='true'
    }

    stages {
        stage('Build') {
            steps{
                echo '==Building=='
                bat 'mvn package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying'
                bat 'docker-machine create jenkins'
                bat 'docker-machine env'
                bat 'docker-compose down'
                bat 'docker-compose up --build -d'
            }
        }
        stage('Clean') {
            steps {
                echo 'Cleaning'
                bat 'mvn clean'
            }
        }
    }
}