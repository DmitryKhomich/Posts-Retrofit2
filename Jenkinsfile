pipeline {
    agent any

    stages {
        stage('Clone Git') {
            steps {
                // Склонируйте ваш репозиторий
                git 'https://github.com/DmitryKhomich/Posts-Retrofit2.git'
            }
        }

        stage('Build') {
            steps {
                // Соберите ваш проект с помощью Maven
                sh 'mvn clean package'
            }
        }
 stage('Deploy') {
            steps {
                // Запустите ваше приложение
                sshagent(credentials: ['credsToDmytroServPrivate']) {
                    sh """
                    scp /var/lib/jenkins/workspace/retro2/target/Posts-Retrofit2-0.0.2-jar-with-dependencies.jar root@188.166.146.75:~/javaApps
                    ssh root@188.166.146.75 "nohup java -jar /root/javaApps/Posts-Retrofit2-0.0.2-jar-with-dependencies.jar &"
                    """
                }
            }
        }
    }
}
