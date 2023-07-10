node {
    stage('Build') {
        docker {
            image 'maven:3.9.0'
            args '-v /root/.m2:/root/.m2'
        }        
    }
    stage('Test') {
        sh 'mvn --version'
        sh 'mvn -B -DskipTests clean package'
        sh 'mvn test'
    }
}