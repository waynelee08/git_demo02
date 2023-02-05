//def buildJar(){
//    echo "building the app ....."
//    sh "mvn package"
//}
//
//def buildImange(){
//    echo "buidling the docker image...."
//    withCredentials([usernamePassword(credentialsId:"docker-hub-repo", passwordVariable: "PASS",usernameVariable: "USER")]){
//        sh "docker build -t wayneleedevops/demo-app:jma-2.0 ."
//        sh "echo $PASS | docker login -u $USER --password-stdin"
//        sh "docker push wayneleedevops/demo-app:jma-2.0"
//    }
//}

def deploypAppp(){
    echo "deploying the app......"
}

