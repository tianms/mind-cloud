智慧云

项目结构：
mind-api                对外提供的api
mind-app                对app提供的接口
mind-applet             对小程序提供的接口
mind-common             公共的操作方法，公用的方法
mind-dao                持久层，dao和dao.xml
mind-manage             后台管理接口
mind-model              模块层，基础的实体类，包括数据库表结构
mind-service            基础的接口业务逻辑
mind-service-manage     接口业务逻辑管理端，处理复杂的业务逻辑，调用基础的接口逻辑层，防止依赖注入
mind-util               工具类，主要用于第三方接口调用集成模块
。。。。。。。

引用关系
mind-common，公共操作，可以被全部引用
mind-model -> mind-dao -> mind-service -> mind-manage/mind-app/mind-applet
mind-model -> mind-dao -> mind-service -> mind-service-manage -> mind-manage/mind-app/mind-applet

命名规范：
列表查询：query开头，queryXXX
单查询：get开头，getXXX
数量查询：total开头，totalXXX
新增：insert开头，insertXXX
更新：update开头，updateXXX
删除：delete开头，deleteXXX
复杂操作：go开头，goXXX