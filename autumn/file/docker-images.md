#### Docker

##### 1.镜像 

- 是一个特殊的文件系统，除了提供容器运行时所需的程序、库、资源、配置等文件外，
还包含了一些为运行时准备的一些配置参数（如匿名卷、环境变量、用户等）。
镜像 不包含 任何动态数据，其内容在构建之后也不会被改变。

- 应用镜像可以简单理解为是由 代码+依赖+环境变量 的多层文件组装体

##### 2.容器

- 镜像和容器的关系 【镜像可以理解成类定义，容器是实例化的类， Class A/ new A()】
  - 镜像是静态的定义，容器是镜像运行时的载体，容器基于镜像运行，可以被创建、启动、停止、删除、暂停等
  - 容器的实质是进程，有自己独立的命名空间，并不是裸奔在宿主机上

##### 3.仓库

- 镜像的存储 与管理
- 规则 : <repositry name>:<version number> 
  - eg: projectA-api:release-2023-01,如不指定版本号，则默认为最新镜像 projectA-api:latest

##### 4.镜像的生成

- 应当使用docker file定制镜像
- 慎用docker commit定制镜像；
  - 使用docker commit可以保存当前镜像的最新状态，但是除了使用镜像者本人，其他的人员都不知道这个镜像此前经历了
  哪些命令和操作，不利于维护。也被称为黑箱镜像。
  
- 使用docker file定制镜像
  - 什么是docker file?
    - 本质上是一个文本文件，其内包含了多条指令，每个指令构建一层，指令的内容就是描述该层应当如何构建
- 如何写一个docker file?
    1. 使用**From**关键字指定镜像,example:
        ```dockerfile
         FROM nginx
         RUN echo '<h1>Hello, Docker!</h1>' > /usr/share/nginx/html/index.html
    
    2. 特殊镜像：scratch ，使用此镜像意味着 你打包的镜像不会以任何镜像为基础，	
	接下来你所写的指令会作为镜像的第一层开始存在。

    3. **RUN命令** ⭐️⭐️⭐️⭐️⭐️
        - shell格式 ： RUN<命令> ，就像直接在命令行中输入的命令一样
        ```dockerfile
        RUN echo '<h1>Hello, Docker!</h1>' > /usr/share/nginx/html/index.html
        ```
		
        - exec格式：RUN ["可执行文件", "参数1", "参数2"]
		
        - 每一层run命令，都会commit一次镜像
		
    4. 构建镜像
       - docker build