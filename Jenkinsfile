pipeline {
    agent any
    tools {
        maven 'jenkins-maven'
    }

    stages {
        stage('Git Checkout') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/AdiMunawar31/spring-sonarqube']])
                sh 'mvn clean install'
                echo 'Git Checkout Completed'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'mvn clean package'
                    sh '''mvn clean verify sonar:sonar \
                            -Dsonar.projectKey=spring-sonarqube \
                            -Dsonar.host.url=http://localhost:9000 \
                            -Dsonar.login=sqp_7e59bd0ffe27f4e5f3250f8382984aba554f22c0'''
                    echo 'SonarQube Analysis Completed'
                }
            }
        }

        stage('Quality Gate') {
            steps {
                waitForQualityGate abortPipeline: true
                echo 'Quality Gate Completed'
            }
        }
    }


}