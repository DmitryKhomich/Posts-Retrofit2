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
                sh 'mvn clean install'
            }
        }

        stage('Deploy') {
            steps {
                // Запуск агента SSH
                sshagent(credentials: ['credsToDmytroServPrivate']) {
                    sh """
                    # Копирование JAR-файла на удаленный сервер
                    scp /var/lib/jenkins/workspace/retrofit/target/Posts-Retrofit2-0.0.1.jar root@188.166.146.75:~/javaApps

                    # Запуск JAR-файла на удаленном сервере
                    ssh root@188.166.146.75 "nohup java -jar /root/javaApps/Posts-Retrofit2-0.0.1.jar > /root/javaApps/app.log 2>&1 &"
                    """
                }

                // Проверка статуса выполнения приложения
                script {
                    def appOutput = sh(script: 'java -jar /root/javaApps/Posts-Retrofit2-0.0.1.jar', returnStatus: true)
                    if (appOutput == 0) {
                        currentBuild.result = 'SUCCESS'
                    } else {
                        currentBuild.result = 'FAILURE'
                    }
                }
            }
        }
        }
        }
