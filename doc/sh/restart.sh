#!/bin/bash

#jar包文件路径及名称（目录按照各自配置）
APP_NAME=suxia-user-center
KILL_APP_NAME=suxia-user-center-1.0.0.jar
APP_JAR_NAME=/home/suxia/app/user-center/suxia-user-center-1.0.0.jar
#日志文件路径及名称（目录按照各自配置）
LOG_FILE=/home/suxia/app/user-center/start.log

echo "准备启动java项目[$APP_JAR_NAME]..."

#查询进程，并杀掉当前jar/java程序
#shellcheck disable=SC2009
pid=$(ps -ef | grep $KILL_APP_NAME | grep -v grep | grep -v rdc_deploy_command | awk '{print $2}')
kill -9 "$pid"
echo "进程终止成功 pid[$pid]"

sleep 2

#判断jar包文件是否存在，如果存在启动jar包，并时时查看启动日志
if test -e $APP_JAR_NAME
then
echo "文件[$APP_JAR_NAME]存在,开始启动此Java项目..."

#启动jar包，指向日志文件，2>&1 & 表示打开或指向同一个日志文件
nohup java -server -Xms256m -Xmx256m -jar $APP_JAR_NAME > $LOG_FILE 2>&1 &

#实时查看启动日志（需要实时查看启动日志时打开）
# tail -f $LOG_FILE

#输出启动成功（需要输出启动成功时打开）
echo "[$APP_NAME]启动成功..."

else
echo "文件[$APP_JAR_NAME]不存在,请检查..."
fi
