# Getting Started

### 项目原由
要做一个简单的管理系统，没有专职的UI和前端开发人员，为了不花时间在编写JavaScript和CSS上（调界面样式对非专业人员业说，太花时间），决定引入一个前端框架。

现在流行用VUE做前后端分隔，但考虑到后续维护没合适的VUE人员，就选传统的方式吧。

搜索比较后，选择AdminLTE，比较的理由就不细说了。

AdminLTE的效果演示页面，所有内容都在一个html文件中，而管理系统经典的 ”T“ 形结构，顶部导航和左边的菜单在每个页面都copy一遍，实在不太优雅。需要服务端显示层支持界面布局，把导航和菜单剥离出来。

服务端准备用Springboot，显示层推荐用thymeleaf，查了一下资料，没布局功能，想到用tiles，搜索一下，还真有thymeleaf和tiles组合，惊喜过后，出现的却是无奈，只支持到tiles2+spring4，没后续，感慨：传统显示层技术真是......

本想参照thymeleaf的扩展插件 tiles2+spring4的源码，改成tiles3+spring5的，结果发现 nz.net.ultraq.thymeleaf : thymeleaf-layout-dialect，不在spring-boot-starter-thymeleaf中强依赖，需要单独导入，这才有了这个项目。

### 使用方法
1. pom.xml配置

   加spring-boot-starter-thymeleaf和spring-boot-starter-web外，需要加 nz.net.ultraq.thymeleaf : thymeleaf-layout-dialect，否则没布局支持。

2. Springboot的注解和配置全默认

3. 添加AdminLTE

   直接把需要的文件，拷贝到 src\main\resources\static\ 目录，（本项目中使用的是 AdminLTE-2.4.3，只部分JS、CSS 文件）。 

4. 添加thymeleaf模板

   默认模板目录是：src\main\resources\templates\ 

   添加layout子目录，存放布局模板文件

   **注意点**：

   - html标签中，添加 命名空间申明。

     ```
     <html xmlns:th="http://www.thymeleaf.org">
     <!-- 需要定义  thymeleaf 的 xml命名空间申明，命名为 th（文件中使用该名称，标明是thymeleaf属性） -->
     ```

   - 布局模板文件中，添加 代码片段插入标记（可多个插入标记）

     ```
     <div layout:fragment="content"></div>
     ```

   - View 模板文件配置
   
        
     01. 指定 使用的布局模板
     
        ```
      <html xmlns:th="http://www.thymeleaf.org"
        	xmlns:layout="http://www.thymeleaf.org" layout:decorator="layout/base">
        ```
        
     02. 添加 代码片段获取标记（可多个获取标记）
     
        ```
        <div class="content-wrapper" layout:fragment="content">
        ```
     
       


### 广告
欢迎到斗鱼直播间交流互动, 房间号：[5262279](https://www.douyu.com/room/share/5262279)。



