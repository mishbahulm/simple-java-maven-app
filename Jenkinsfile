node {
    stage('Build') {
        docker.image('maven:3.9.0').inside {
            sh 'git pull origin master'
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
    stage('Manual Approval') {
        input message: 'Lanjutkan ke tahap Deploy?'
    }
    stage('Deploy') {
        docker.image('maven:3.9.0').inside {            
            sh './jenkins/scripts/deliver.sh'
            sleep(time: 1, unit: 'MINUTES')
        }
    }
}