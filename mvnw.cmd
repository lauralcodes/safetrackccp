@echo off
setlocal

where mvn >NUL 2>&1
if %ERRORLEVEL% EQU 0 (
  mvn %*
  exit /b %ERRORLEVEL%
)

echo Error: Maven (mvn) is not installed or not on PATH. 1>&2
echo Install Maven or add the Maven Wrapper files, then retry. 1>&2
exit /b 127

