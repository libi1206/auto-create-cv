# 项目说明及部署

### 1、使用技术
为了快速从Html页面里生成Pdf文档，本项目使用里使用了WkHtmlToPdf的相关组件，因此在使用前要进行服务的安装
* 关于WkHtmlToPdf <br>
    WkHmlToPdf是一个快速的把网页转换成pdf的工具。相对于Itext等其他的pdf生成工具，它的相关代码几乎是开箱即用，学习成本极低。但是它只能做html和pdf的转换，不能修改一个PDF，并且需要在服务器上安装相关的服务才能使用。
* 关于WkHtmlToPdf的服务 <br>
    HkHtml2Pdf的服务就行在linux上使用apt或yum安装的命令行开启的行命令一样。只有在服务器上安装了这个服务，才可以使用WKHtmlToPdf的服务
    
### 2、如何部署
> 在开始之前，你需要知道这个项目需要的前导服务：[java](https://www.java.com/zh_CN/)、 [maven](https://maven.apache.org/)、[WkHtmlToPdf](https://wkhtmltopdf.org)<br>
> 关于如何安装WkHtmToPdf，[这里有我之前写过的安装说明](https://github.com/libi1206/itextDemo/blob/master/ReadMe.md)

#### 配置文件
配置文件很简单，找到**src/main/resources/application.properties**，里面只有一个配置可以更改，就是端口
```properties
server.port=9090

#========固定参数，勿动===========
cv-file-path-key=java.io.tmpdir
cv-url-path=/download/
```
后续可能会实现一个自定义文件存储路径吧。。现在文件直接存在System类提供的临时路径上了

#### 启动
```
git clone https://github.com/libi1206/auto-create-cv.git
cd auto-create-cv/
mvn package             
java -jar target/demo-0.0.1-SNAPSHOT.jar  
```
如果需要后台启动就使用nohup(下面的)的方式启动吧，这种方式会忽略输入并且吧输出重定向到当前路径下的nohup.out文件下
```
nohup java -jar target/demo-0.0.1-SNAPSHOT.jar &
```

#### 访问Swagger
本项目集成了swagger，在项目启动后访问`/swagger-ui.html`就可以看到swagger提供的接口文档了