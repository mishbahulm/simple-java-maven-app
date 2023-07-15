node {
    stage('Build') {
        docker.image('maven:3.9.0').inside {
            sh 'mvn -v /root/.m2:/root/.m2'
            sh 'mvn -B -DskipTests clean package'
        }
    }
    stage('Test') {
        docker.image('maven:3.9.0').inside {
            sh 'mvn test'
            junit 'target/surefire-reports/*.xml'
        }
    }
    stage('Deploy') {
        docker.image('maven:3.9.0').inside {
            input message: 'Deliver? (Klik "Proceed" untuk melanjutkan)'
            sh './jenkins/scripts/deliver.sh'
        }
    }
}