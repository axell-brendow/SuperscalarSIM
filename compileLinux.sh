javac_exe=$(sed '1!d' path_to_JDK_executables.txt)

$javac_exe -classpath src -d bin src/SuperscalarSIM/pkg1/*.java
