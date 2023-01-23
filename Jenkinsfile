 pipeline {
	
	
    agent any 
	
	
    //read the doc: https://www.jenkins.io/doc/book/pipeline/docker/
    stages {
        
        
        stage('Build Image') {
            steps {
                script {
                    dockerapp = docker.build("leozin89/loja_de_moda:${env.BUILD_ID}")
                }
            }
        }
		
		
        //DOCKERHUB** reference a credentials saved in manager credentials in jenkins
        stage('push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'DOCKERHUB'){
                        dockerapp.push("latest")
                        dockerapp.push("${env.BUILD_ID}")
                    }
                }
            }
        }
		
		
        stage('Deploy Container Image on Server') {
            steps {
               sh 'docker run -d -p 8766:8766 --memory 256M --cpus=0.2  --name moda -e DB=your_db -e USER_DB=your_user_db -e PASSWORD_DB=your_password_db leozin89/loja_de_moda:latest'
            }
        }
		
        
    }
}
 
