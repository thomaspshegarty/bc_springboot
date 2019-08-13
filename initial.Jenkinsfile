pipeline {
    agent any

    stages {
        stage('Build') {
            steps{
                bat 'mvn clean'
                bat 'mvn package'
            }
        }
        stage('Link') {
            steps {
                echo 'Linking...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}