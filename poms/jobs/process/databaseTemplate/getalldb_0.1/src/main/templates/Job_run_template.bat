%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp ${talend.job.bat.classpath} salesforce.getalldb_0_1.GetAllDb %*
