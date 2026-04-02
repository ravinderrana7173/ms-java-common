pipeline {
    agent any

    environment {
        IMAGE_NAME = "ms-java-common"
        IMAGE_TAG = "local"
        VAULT_ADDR = "http://192.168.80.140:8200"
        VAULT_TOKEN = credentials('vault-token')
    }

    stages {
        
        stage('Maven Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    sh """
                    eval \$(minikube docker-env) || true
                    docker build \
                    --build-arg VAULT_ADDR=${VAULT_ADDR} \
                    --build-arg VAULT_TOKEN=${VAULT_TOKEN} \
                    -t ${IMAGE_NAME}:${IMAGE_TAG} \
                    -f Infra/docker/Dockerfile .
                    """
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh """
                kubectl create namespace dev || true

                kubectl set image deployment/ms-java-common \
                ms-java-common=${IMAGE_NAME}:${IMAGE_TAG} -n dev

                kubectl apply -f Infra/kubernetes/ms-java-common-deployment.yml
                """
            }
        }
    }
}
