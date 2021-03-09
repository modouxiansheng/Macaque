package com.dmh.mybatis.config;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.Properties;

//@Intercepts({ @Signature(method = "query", type = Executor.class, args = { MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class}) })
//@Component
public class QueryInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        System.out.printf("1");
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
