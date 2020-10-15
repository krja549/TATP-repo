pipeline {
    agent any
    tools {
            maven 'maven_3.6.3_1'
            jdk 'jdk'
        }
    stages {
        stage ('Compile stage'){
            steps {
                    sh 'mvn clean compile'
            }
        }
        stage ('Testing stage'){
            steps {
                    sh 'mvn test'
            }
        }
        stage ('Reporting Stage'){
            steps {
                 script {
                       allure([
                            includeProperties: false,
                                jdk: '',
                                properties: [],
                                reportBuildPolicy: 'ALWAYS',
                                results: [[path: 'target/allure-results']]
                       ])
                 }
            }
        }
    }
}