node {
    stage('Build') {
        docker.image('maven:3.9.3-eclipse-temurin-11').inside {
            sh 'mvn --version'
        }
    }
    stage('Test') {
        sh '/usr/share/maven/bin/mvn test'
    }
}