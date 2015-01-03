if NOT DEFINED MSBUILD_HOME (
  set MSBUILD_HOME=C:\Program Files\MSBuild\12.0
)
if NOT DEFINED JAVA_HOME (
  set JAVA_HOME=C:\Program Files\Java\jdk1.7.0_07
)
if NOT DEFINED ANT_HOME (
  set ANT_HOME=E:\eclipse\plugins\org.apache.ant_1.9.2.v201404171502
)
set path=%PATH%;%MSBUILD_HOME%\bin;%ANT_HOME%\bin
