pipeline {
    agent {
        docker {
            image 'gradle:8.5-jdk17'
        }
    }
    stages {
        stage('Ping') {
            steps {
                sh 'echo "Jenkinsfile 파싱 성공!"'
            }
        }
    }
}