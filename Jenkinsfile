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
          choice(name: "ENV",choices:["dev","staging","prod"], description: "this is env selection")
        }
      }
      steps{
        script {
          gv.deployApp()
          echo "Deploying to ${ENV}"
        }
      }
    }
    
  }
}
