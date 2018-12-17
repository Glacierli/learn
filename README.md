# learn

### task1: 基本的web项目，无框架
两个页面：登录页面，登录成功页面
1. 完成一个表单的提交
    表单包括：
        1. username
        2. password
        3. 提交按钮
        4. 取消按钮
2. 使用jsp+servlet+javaBean
3. 不要求使用数据库，但是，登录的用户名和密码需要回显到页面上。
4. 提交成功之后，页面显示注销。点击之后，重新跳转到登录页面。
5. 页面使用bootstrap进行布局和显示

### task2: 项目中嵌入springMVC框架，拆分出controller和service
并进行如下修改:
1. 增加一个新的登录页，使用GET方法提交数据，并且也可以回显到登录成功页面。
2. 添加编辑页面，可以对登录用户进行信息信息修改。
3. 编辑页面的信息修改使用ajax进行提交，回显。
4. 熟悉 Controller, RestController, Service, RequestMapping, RequestMethod, RequestParam, RequestBody, ResponseBody的使用。
5. 熟悉springMVC的基本原理，比较和jsp+servlet+javaBean 进行了哪些封装，优势和劣势。（如果感觉吃力，可以略过，但是需要了解大概）

参考文档：
1. https://blog.csdn.net/yanweihpu/article/details/80366218  
2. https://www.cnblogs.com/leskang/p/5445698.html
3. https://www.cnblogs.com/younggun/p/3184808.html
4. https://www.cnblogs.com/xuanlanbinfen/p/5766129.html

### task3: 将上述项目使用jdbc封装，将username和password存入数据库，并将每次修改的动作都进行记录。
并思考以下问题：
1. 我如果要进行密码回滚，怎么实现。
2. 如果同时有两个人进行修改密码，会出现什么情况？为什么？
3. 了解事务的原理，并将jdbc中加入事务控制代码。
