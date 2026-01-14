@echo off
setlocal
set GRADLE_VERSION=8.2.1
set GRADLE_BASE_DIR=%USERPROFILE%\.gradle
set GRADLE_DIST_DIR=%GRADLE_BASE_DIR%\wrapper\dists\gradle-%GRADLE_VERSION%-bin
set GRADLE_DIST_ZIP=%GRADLE_DIST_DIR%\gradle-%GRADLE_VERSION%-bin.zip
set GRADLE_UNPACK_DIR=%GRADLE_DIST_DIR%\gradle-%GRADLE_VERSION%
set GRADLE_BIN=%GRADLE_UNPACK_DIR%\bin\gradle.bat

if not exist "%GRADLE_BIN%" (
  if not exist "%GRADLE_DIST_DIR%" mkdir "%GRADLE_DIST_DIR%"
  if not exist "%GRADLE_DIST_ZIP%" (
    echo Downloading Gradle %GRADLE_VERSION%...
    powershell -Command "Invoke-WebRequest -Uri https://services.gradle.org/distributions/gradle-%GRADLE_VERSION%-bin.zip -OutFile '%GRADLE_DIST_ZIP%'"
  )
  echo Extracting Gradle %GRADLE_VERSION%...
  powershell -Command "Expand-Archive -Path '%GRADLE_DIST_ZIP%' -DestinationPath '%GRADLE_DIST_DIR%' -Force"
)

call "%GRADLE_BIN%" %*
endlocal
