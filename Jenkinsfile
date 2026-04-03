pipeline {
    agent any

    tools {
        jdk 'JDK17'
    }

    environment {
        IMAGE_NAME = "ms-java-common"
        IMAGE_TAG = "${BUILD_NUMBER}"
        VAULT_ADDR = "http://192.168.80.140:8200"
        KUBECONFIG = "/home/jenkins/.kube/config"   // ✅ important fix
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/ravinderrana7173/ms-java-common.git'
            }
        }

        stage('Maven Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
    steps {
        script {
            withCredentials([string(credentialsId: 'vault-token', variable: 'VAULT_TOKEN')]) {
                sh """
                eval \$(minikube docker-env)

                docker build \
                --build-arg VAULT_ADDR=${VAULT_ADDR} \
                --build-arg VAULT_TOKEN=${VAULT_TOKEN} \
                -t ${IMAGE_NAME}:${IMAGE_TAG} \
                -f Infra/docker/Dockerfile .
                """
            }
        }
    }
}

        stage('Deploy to Kubernetes') {
            steps {
                sh """
                echo "Checking cluster connection..."
                kubectl get nodes   # ✅ validate connection

                kubectl create namespace dev || true

                kubectl apply -f Infra/kubernetes/ms-java-common-deployment.yml

                kubectl set image deployment/ms-java-common \
                ms-java-common=${IMAGE_NAME}:${IMAGE_TAG} -n dev
                """
            }
        }
    }
}
