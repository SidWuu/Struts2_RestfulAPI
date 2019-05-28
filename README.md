# RestfulAPI
  项目需要以REST形式调用接口, 从项目中剥离出上传.
  因为项目使用struts2, 所以最初引入struts2-convention, struts2-rest. 使用过程中觉得不如springMVC方便, 就在项目中再引入springMVC, 使用注解.
现在将两种方式都上传, 记录一下使用学习的过程. 
  目前两种方式都支持REST调用, 可以根据请求后缀返回xml或json格式的数据. 

## Struts2
 web.xml及struts.xml配置需要注意一下. 
 controller中约定*index, show, edit, editNew, deleteConfirm, destroy, create, update* 分别对应*查询, 查看, 修改窗口, 新增窗口, 删除确认, 删除, 新增, 修改* 按需使用
 Struts2 restful调用没有过多研究, 能用就行.
## SpringMVC
 
 返回xml格式数据曾两次出现406的报错信息, 实际上后端已查询出结果.
 重现一下问题:
  一: 方法返回List\<T\>提示406, 返回单个bean的信息正常. 后通过封装成bean的List\<T\>返回, 可以正常显示.
  二: 这次是直接返回bean改为返回ModelMap, 提示406. 跟踪后发现返回到前端的请求头变为text/html, 而不是application/xml. 于是修改了dispatch-servlet.xml中的注解驱动. 如下: 
  ``
  <mvc:annotation-driven>
        <mvc:message-converters>
            <bean id="mappingJacksonHttpMessageConverter"
                  class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                <property name="supportedMediaTypes">
                    <list>
                        <value>text/html;charset=UTF-8</value>
                        <value>application/json;charset=UTF-8</value>
                        <value>application/xml;charset=UTF-8</value>
                    </list>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
    ``
  目前返回xml格式仍存在格式问题, 待下次更新解决吧.
  
**目前例子struts2及Spring均已可调用, 后续改进另看**
