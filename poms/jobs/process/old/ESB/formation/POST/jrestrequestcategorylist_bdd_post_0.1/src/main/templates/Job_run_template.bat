%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository="%cd%/../lib" -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp ${talend.job.bat.classpath} salesforce.jrestrequestcategorylist_bdd_post_0_1.jRestRequestCategoryList_BDD_POST %*
