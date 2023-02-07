def gv
pipeline{
  agent any
  environment{
    NEW_VERSION = "1.2.0"
    SEVER_CREDENTIALS = credentials('server-credentials')
  }
  parameters {
    choice(name: "VERSION",choices:["1.10","1.20","1.30"], description: "this is descripion")
    booleanParam(name: "excuteTests", defaultValue : true, description: "not decided yet")
  }
  stages{
    stage("init") {
      steps {
        script {
           gv = load "script.groovy"
        }
       
      }
    }
    stage("build"){
      steps{
        script {
          gv.buildApp()
        }
      }
    }
    
    stage("test"){ 
      when {
        expression {
          params.excuteTests 
        }
      }
      steps{
        script {
          gv.testApp()
        }
      }
    }
    
    stage("deploy"){
      input {
        message "Select the environment to deploy to" 
        ok "Done"
        parameters {
          choice(name: "ENV01",choices:["dev","staging","prod"], description: "this is env selection")
          choice(name: "ENV02",choices:["dev","staging","prod"], description: "this is env selection")
        }
      }
      steps{
        script {
          gv.deployApp()
          echo "Deploying to ${ENV01}"
          echo "Deploying to ${ENV02}"
          def dockerCmd = "docker-compose -f docker-compose.yaml up --detach"
//           def dockerCmd = "docker-compose --version"
          sshagent(['ec2-server-key']) {
            sh "scp docker-compose.yaml ec2-user@18.141.185.27:/home/ec2-user"
            sh "ssh -o StrictHostKeyChecking=no ec2-user@18.141.185.27 ${dockerCmd}"
          }
        }
      }
    }
    
  }
}
