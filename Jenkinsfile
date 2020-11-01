pipeline {
    agent any

    parameters {
         string(name: 'app_ec2', defaultValue: '13.234.177.90', description: 'AWS Application Server')
         string(name: 'jar_name', defaultValue: 'news-service-1.0.jar', description: 'Application build packet')
    }

   // triggers {
     //    pollSCM('* * * * *')
   //  }

stages{
        stage('Build'){
            steps {
                sh 'mvn clean package -DskipTests=true'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.jar'
                }
            }
        }
        stage ('Deploy to Staging'){
            steps {
                   sh "scp -i /home/ec2-user/ec2keyvalue.pem target/*.jar ec2-user@${params.app_ec2}:/home/ec2-user"
                   sh "ssh -i /home/ec2-user/ec2keyvalue.pem ec2-user@${params.app_ec2} 'sh /home/ec2-user/run1.sh ${params.jar_name} &'"
                   sh "exit"
                   
            }
        }
    }
}