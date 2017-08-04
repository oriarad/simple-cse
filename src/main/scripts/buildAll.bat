@echo off
set CURRENT_DIR=%CD%
call setEnvVars.bat
cd..
call %CURRENT_DIR%\buildCSharp.bat
call %CURRENT_DIR%\buildJava.bat