REM Este script inicia los microservicios de la aplicación en diferentes ventanas de consola.

start cmd /k "cd Microservicios\ForumService && mvn clean install && mvn spring-boot:run" 
start cmd /k "cd Microservicios\CommentService && mvn clean install && mvn spring-boot:run"
start cmd /k "cd Microservicios\NotificationService && mvn clean install && mvn spring-boot:run"
start cmd /k "cd Microservicios\AnalyticsService && mvn clean install && mvn spring-boot:run"
