package cn.johnnyzen.util.request;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/30  00:25:23
 * @Description: ...
 */
 /* @Component:
  *      将本Bean置入Spring容器中，形成绑定
  *      把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
  *      定义Spring管理Bean.
  */
@Component
public class RequestUtil {
    @Autowired //从容器中取值，对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
    private RequestProperties requestProperties;

    public RequestUtil() {

    }

    public Document getDocument(String url) throws IOException {
        Document doc = null;
        doc = Jsoup.connect(url)
                .header("Cache-Control", requestProperties.getCacheControl())
                .header("Connection", requestProperties.getConnection())
                .header("Accept", requestProperties.getAccept())
                .header("Accept-Encoding", requestProperties.getAcceptEncoding())
                .header("Accept-Language", requestProperties.getAcceptLanguage())
                .header("Set-Cookie", requestProperties.getCookie())
                .userAgent(requestProperties.getUserAgent())
                .get();
        return doc;
    }
}

