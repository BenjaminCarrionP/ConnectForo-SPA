@echo off
cd /d %~dp0

echo Iniciando el foro...
echo ======================

mvnw.cmd spring-boot:run

pause
