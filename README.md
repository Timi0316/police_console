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
      
  5 浏览器中输入localhost：8082/police-web,进入登录页，输入用户账户如admin（密码：admin）
 
 
  
项目描述：

  police-web：用于web端
  
  police-service：用于service
  
  police-repository：用于持久层，使用的mybatis
  
  police-config：配置文件
  
  police-common：domain和util类等
