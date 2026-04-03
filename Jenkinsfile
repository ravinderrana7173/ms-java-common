pipeline {
    agent any

    tools {
        jdk 'JDK17'
    }

    environment {
        IMAGE_NAME = "ms-java-common"
        IMAGE_TAG = "${BUILD_NUMBER}"
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
                    sh """
                    eval \$(minikube docker-env)

                    docker build \
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

                kubectl apply -f Infra/kubernetes/ms-java-common-deployment.yml

                kubectl set image deployment/ms-java-common \
                ms-java-common=${IMAGE_NAME}:${IMAGE_TAG} -n dev
                """
            }
        }
    }
}
