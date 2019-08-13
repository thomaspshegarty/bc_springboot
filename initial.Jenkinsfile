pipeline {
    agent any

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