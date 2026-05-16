@echo off
echo Compiling...
javac *.java

if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b %errorlevel%
)

echo Running Student Management System...
echo ====================================
java Main
