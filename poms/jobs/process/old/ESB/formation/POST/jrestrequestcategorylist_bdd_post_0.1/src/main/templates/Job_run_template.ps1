$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' -cp 'null' salesforce.jrestrequestcategorylist_bdd_post_0_1.jRestRequestCategoryList_BDD_POST $args
