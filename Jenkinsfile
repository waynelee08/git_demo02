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
        gv = load "script.groovy"
      }
    }
    stage("build"){
      steps{
        script {
          gv.buildAppp()
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
          gv.testdAppp()
        }
      }
    }
    
    stage("deploy"){
      steps{
        script {
          gv.deploydAppp()
        }
      }
    }
    
  }
}
