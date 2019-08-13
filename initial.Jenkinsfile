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
                bat 'docker build -t test_image - < sql.Dockerfile'
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