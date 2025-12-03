pipeline {
    agent any

    tools {
    jdk 'jdk17'
    maven 'Maven 3.9.3'
    }

    environment {
        REGISTRY = "docker.io"
        IMAGE_NAME = "eyaezdine/maven"
        IMAGE_TAG = "latest"
    }


    stages {

        stage('GIT') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/eyaezdine/maven.git'
            }
        }

        stage('Clean & Build Project') {
            steps {
                sh "mvn clean install -DskipTests"
            }
        }

        stage('Build Docker Image') {
            steps {
                sh """
                    docker build -t eyaezdine/maven:latest .
                """
            }
        }

      stage('Login to Docker Hub') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'DOCKERHUB_USERNAME',
                    passwordVariable: 'DOCKERHUB_PASSWORD'

                )]) {
                    sh """
                        echo "${DOCKERHUB_PASSWORD}" | docker login -u "${DOCKERHUB_USERNAME}" --password-stdin
                    """
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                sh """
                    docker push ${IMAGE_NAME}:${IMAGE_TAG}
                """
            }
        }//

}//
