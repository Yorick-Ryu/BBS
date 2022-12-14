# BBS
---

### Java Web 实践项目 ———— 简洁的BBS留言板

使用 [Bootstrap v5](https://v5.bootcss.com/docs/getting-started/introduction/) 美化前端界面，后端为 Servlet + jsp

使用TOMCAT 9.0.0.11部署

数据库采用mysql8.0

### 已实现功能：

- 登录注册（背景为随机图片）
- 增加、删除、修改、查看、搜索（支持模糊搜索）留言
- 管理员查看、删除用户
- 上传头像

### 截图展示：

登录注册界面  

![登录注册界面](https://i.bmp.ovh/imgs/2022/05/20/bd372107902dfc58.png)

留言板主页  

![留言板主页](https://i.bmp.ovh/imgs/2022/05/20/a5db8d3a382d646a.png)  

用户管理界面  

![用户管理界面](https://i.bmp.ovh/imgs/2022/05/20/f81f811e5531d87c.png)

修改留言

![修改留言](https://i.bmp.ovh/imgs/2022/05/20/004a6c5f9fd911c4.png)

写留言

![写留言](https://i.bmp.ovh/imgs/2022/05/20/57f58b355a542f09.png)

响应式布局

![响应式布局](https://i.bmp.ovh/imgs/2022/05/20/6b23fc895d8b9f78.png)

### 各个包中的文件说明如下：

- dao包中的java文件为与数据库进行交互的类。
- filter包中的是过滤器类。
- listener包中的是监听器类。
- service包中的类主要用于编写业务逻辑，并调用dao操作数据库。
- servlet包中的类为项目的servlet类。
- test包中的类为项目的测试类。
- util包中的类为项目中用到的工具类。
- vo包中的java文件为实体类。