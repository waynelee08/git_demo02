
pipeline{
  agent any
  environment{
    NEW_VERSION = "1.2.0"
    SEVER_CREDENTIALS = credentials('server-credentials')
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
        expression{
          BRANCH_NAME == "jenkins-job" 
        }
      }
      steps{
        echo "testing the app....."
      }
    }
    
    stage("deploy"){
      steps{
        echo "deploying the app....."
        echo "deploying with ${server-credentials}"
      }
    }
    
    post{
      always{
        // sending email notifications
      }
      success{
        
      }
    }
  }
}
