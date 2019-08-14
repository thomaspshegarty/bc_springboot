pipeline {
    agent any

    environment {
        SET DOCKER_TLS_VERIFY=1
        SET DOCKER_HOST=tcp://192.168.99.100:2376
        SET DOCKER_CERT_PATH=C:\Users\thoma\.docker\machine\machines\default
        SET DOCKER_MACHINE_NAME=default
        SET COMPOSE_CONVERT_WINDOWS_PATHS=true
    }

    stages {
        stage('Build') {
            steps{
                echo 'Buiilding...'
                bat 'mvn package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                bat 'docker-machine env'
                bat 'docker-compose up --build'
            }
        }
        stage('Clean') {
            steps {
                echo 'Cleaning... '
                bat 'mvn clean'
            }
        }
    }
}