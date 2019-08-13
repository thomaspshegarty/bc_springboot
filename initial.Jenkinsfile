pipeline {
    agent any

    stages {
        stage('Build') {
            steps{
                bat 'mvn clean'
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