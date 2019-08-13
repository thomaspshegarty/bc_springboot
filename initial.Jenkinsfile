pipeline {
    agent any

    stages {
        stage('Build') {
            steps{
                echo 'Buiilding...'
                bat 'mvn clean'
                bat 'mvn package'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deplying...'
                bat 'docker-compose up --build'
            }
        }
    }
}