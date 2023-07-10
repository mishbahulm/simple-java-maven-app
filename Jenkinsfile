node {
    stage('Build') {
        docker {
            image 'maven:3.9.0'
            args '-v /root/.m2:/root/.m2'
        }
        sh 'mvn -B -DskipTests clean package'
        sh 'mvn --version'
    }
    stage('Test') {
        sh 'mvn test'
    }
}