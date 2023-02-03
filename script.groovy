def buildApp(){
        echo "building the app....."
        echo "building verion ${NEW_VERSION}"
}

def testApp(){
        echo "testing the app....."
}
 

def deployApp(){
        echo "deploying the app....."
        echo "deploying with ${SEVER_CREDENTIALS}"
        echo "deploying version ${params.VERSION}"
} 

return this
