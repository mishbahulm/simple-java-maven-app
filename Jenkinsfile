node {
    stage('Build') {
        docker {
            image 'maven:3.9.0'
            args '-v /root/.m2:/root/.m2'
        }        
    }
    stage('Build') {
        docker.image('maven:3.9.0').inside {
            sh 'mvn -B -DskipTests clean package'
        }
    }
    stage('Test') {
        sh 'mvn test'
    }
}