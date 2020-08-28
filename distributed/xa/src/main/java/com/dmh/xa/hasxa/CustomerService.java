package com.dmh.xa.hasxa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: guide-dog
 * @description:
 * @author: hu_pf
 * @create: 2020-07-23 10:56
 **/
@Service
@Transactional
public class CustomerService {

    @Autowired
    @Qualifier("jdbcTemplateSecond")
    private JdbcTemplate jdbcTemplateSecond;


    @Transactional(rollbackFor = RollBackExceptionHasXa.class,transactionManager = "xatx")
    public void add() throws RollBackExceptionHasXa {
        jdbcTemplateSecond.execute("insert  into customer (name,age) values (1,1)");
        throw new RollBackExceptionHasXa();
    }
}
