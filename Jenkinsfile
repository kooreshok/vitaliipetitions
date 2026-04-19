pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // This pulls code from the GitHub
                git branch: 'main', url: 'https://github.com/kooreshok/vitaliipetitions.git'
            }
        }

        stage('Build') {
            steps {
                // Compiles the code
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Runs the unit tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Creates the .war file
                sh 'mvn package -DskipTests'
                archiveArtifacts artifacts: 'target/*.war'
            }
        }
    }
}