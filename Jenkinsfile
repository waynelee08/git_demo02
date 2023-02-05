pipeine {

    agent any
    tools {
        maven "maven-3.6"
    }
    
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building the app ....."
                    sh "mvn package"
                }
            }
        }
        
        stage("build image") {
            steps {
                script {
                    echo "buidling the docker image...."
                    withCredential([usernamePassword(credentialsID:"docker-hub-repo", passwordVariable: "PASS",usernameVariable: "USER")]){
                        sh "docker build -t wayneleedevops/demo-app:jma-2.0 ."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push wayneleedevops/demo-app:jma-2.0"
                    }
                    
                }
            }
        }
        
        stage("deploy") {
            steps {
                script {
                    echo "deploying the app......"
                }
            }
        }
    }
}
