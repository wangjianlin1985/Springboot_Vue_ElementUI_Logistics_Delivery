package com.logistic;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 
 * < web容器中进行部署>
 * <功能详细描述>
 * 
 * @author  姓名 工号
 * @version  [版本号, 2020年4月23日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class LogisticServletInitializer extends SpringBootServletInitializer
{
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(LogisticApplication.class);
    }
}
