pipeline {
    agent any
    tools {
        maven "MAVEN"
        nodejs "NodeJS"
    }

    stages {
        stage('Verify All Software Version') {
            steps {
                bat "git --version"
                bat "java -version"
                bat "mvn -version"
                bat "docker --version"
                bat "docker-compose --version"
            }
        }
        stage('Build the Eureka Server') {
            steps {
                dir("./backend/eureka-server/eureka-server/"){
                    bat "dir"
                    bat "mvn clean package"
                }
            }
        }
    }
}
