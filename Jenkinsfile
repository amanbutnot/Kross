pipeline {
    agent any

    stages {
        stage('lint') {
            steps {
                sh './gradlew lint'
            }
        }
    }
}