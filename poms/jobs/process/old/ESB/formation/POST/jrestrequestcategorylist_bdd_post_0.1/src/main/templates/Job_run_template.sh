#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp ${talend.job.sh.classpath} salesforce.jrestrequestcategorylist_bdd_post_0_1.jRestRequestCategoryList_BDD_POST "$@"
