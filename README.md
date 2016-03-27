# police_console

武警支队后台运营管理项目



执行步骤：

  1 执行sql脚本（mysql初始化-武警支队.sql[我的小团队的群文件中])
  
  2 git clone https://github.com/pein000/police_console.git （如果需要输入用户名：pein000 密码qw6016662）
  
  3 导入maven项目console
  
  4 执行maven命令。
  
      4.1 mvn install
      
      4.2 mvn jetty:run
      
    或者使用intellj idea的maven工具
    
      4.1 双击console选项下面的lifecycle下的install
      
      4.2 双击police-web下的plugins的jetty：run
    
    TODO  
    
    ellipse暂时没有使用，大概要在Goals中配置clean jetty:run，具体没实验过，使用过的同学补充完善。
      
  5 浏览器中输入localhost：8082/police-web,进入登录页，输入用户账户如admin（密码：admin）
 
 
  
    项目描述：
    
      police-web：用于web端
      
      police-service：用于service
      
      police-repository：用于持久层，使用的mybatis
      
      police-config：配置文件
      
      police-common：domain和util类等
  
  

  6 git分支管理
    
    
      6.1 从远程下载成功，即git clone
      
      6.2 创建本地新分支，如：git checkout -b police_dev
      
      6.3 开发时切换到分支开发，如：git checkout police_dev
      
      6.4 开发完成之后，保存到本地，如：git add .  git commit -m 'the submit descrpition'
      
      6.5 切换到master分支 ，如：git checkout master 。 
      
      6.6 从远程pull代码， 保持master分支，是最新代码，如：git pull 
      
      6.7 将开发分支的内容merge到master， 如：git merge police_dev
    
      6.8 提交到远程github上，如：git push origin master
  
