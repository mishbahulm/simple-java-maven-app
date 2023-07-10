node {
    stage('Build') {
        docker.image('maven:3.9.0').inside {
            sh 'mvn -B -DskipTests clean package'
        }
    }
    stage('Test') {
        docker.image('maven:3.9.0').inside {
            sh 'mvn test'
            junit 'target/surefire-reports/*.xml'
        }
    }
}