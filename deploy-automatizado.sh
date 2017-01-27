#!/bin/bash

TOMCAT_HOME=/usr/local/tomcat-homologacao/apache-tomcat-9.0.0.M17
DIST_HOME=/root/workspace/cobrancaEContabilidade/dist
PROJECT_NAME=cobrancaEContabilidade
LOG_FILE=deploy.log
echo "" >> $LOG_FILE
echo $(date '+%d/%m/%Y %H:%M:%S')" - STARTING NEW BUILD." >> $LOG_FILE
echo $(date '+%d/%m/%Y %H:%M:%S')" - Building war." >> $LOG_FILE
ant war

echo $(date '+%d/%m/%Y %H:%M:%S')" - Backup old war." >> $LOG_FILE
cp $TOMCAT_HOME/webapps/$PROJECT_NAME.war $TOMCAT_HOME/webapps/$PROJECT_NAME.war.bkp

echo $(date '+%d/%m/%Y %H:%M:%S')" - Shutdown tomcat." >> $LOG_FILE
$TOMCAT_HOME/bin/./shutdown.sh

echo $(date '+%d/%m/%Y %H:%M:%S')" - Deleting old war." >> $LOG_FILE
rm $TOMCAT_HOME/webapps/$PROJECT_NAME.war

echo $(date '+%d/%m/%Y %H:%M:%S')" - Transfering new war to the webapps directory." >> $LOG_FILE
scp $DIST_HOME/$PROJECT_NAME.war $TOMCAT_HOME/webapps/$PROJECT_NAME.war
sleep 5

echo $(date '+%d/%m/%Y %H:%M:%S')" - Startup tomcat." >> $LOG_FILE
$TOMCAT_HOME/bin/./startup.sh
echo $(date '+%d/%m/%Y %H:%M:%S')" - DEPLOY FINISHED." >> $LOG_FILE
echo "" >> $LOG_FILE



