package com.dmh.xa.noxa;

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
public class CustomerService {

    @Autowired
    @Qualifier("jdbcTemplateSecond")
    private JdbcTemplate jdbcTemplateSecond;


    @Transactional(rollbackFor = RollBackExceptionNoXa.class,transactionManager = "datasource")
    public void add() throws RollBackExceptionNoXa {
        jdbcTemplateSecond.execute("update customer set name = 2,age = 2");
        throw new RollBackExceptionNoXa();
    }
}
