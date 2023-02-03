
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
    stage("build"){
      steps{
        echo "building the app....."
        echo "building verion ${NEW_VERSION}"
      }
    }
    
    stage("test"){ 
      when {
        expression {
          params.excuteTests 
        }
      }
      steps{
        echo "testing the app....."
      }
    }
    
    stage("deploy"){
      steps{
        echo "deploying the app....."
        echo "deploying with ${SEVER_CREDENTIALS}"
        echo "deploying version ${params.VERSION}"
      }
    }
    
  }
}
