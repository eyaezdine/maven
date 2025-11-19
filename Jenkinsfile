pipeline {
    agent any

    tools {
    jdk 'jdk17'
    maven 'Maven 3.9.3'
    }


    stages {

        stage('GIT') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/hwafa/timesheetproject.git'
            }
        }

        stage('Compile Stage') {
            steps {
                sh 'mvn clean compile'
            }
        }

    }
}
