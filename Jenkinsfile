pipeline {
    agent any

    environment {
        JAVA_HOME = '/usr/lib/jvm/java-17-openjdk-amd64'
        MAVEN_HOME = '/usr/share/maven'
    }

    parameters {
        choice(
            name: 'PROJECT',
            choices: ['DemoQAwinter24'],
            description: 'Choose project'
        )
        choice(
            name: 'TEST_SUITE',
            choices: ['Smoke', 'Regression', 'E2E_Test'],
            description: 'Test Suite'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out the code...'
                git 'https://github.com/davletbekovv/DemoQAWinter2024.git' // замените на URL вашего репозитория
            }
        }

        stage('Build') {
            steps {
                echo 'Building the application...'
                sh "${MAVEN_HOME}/bin/mvn clean package"
            }
        }

        stage('Test') {
            steps {
                script {
                    def project = params.PROJECT ?: 'DemoQAwinter24'
                    def testSuite = params.TEST_SUITE ?: 'Smoke'

                    echo "Running tests for project: ${project}, test suite: ${testSuite}"
                    sh "${MAVEN_HOME}/bin/mvn clean test -P${testSuite} -DtestCaseId=${project} -DfailIfNoTests=false"
                }
            }

            post {
                always {
                    echo 'Publishing Allure results...'
                    allure([
                        includeProperties: false,
                        jdk: '17.0.3',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/allure-results']]
                    ])
                }
            }
        }}}