pipeline {
    agent any

    environment {
        DOCKER_TLS_VERIFY='1'
        DOCKER_HOST='tcp://192.168.99.100:2376'
        DOCKER_CERT_PATH='C:/Users/thoma/.docker/machine/machines/default'
        DOCKER_MACHINE_NAME='default'
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