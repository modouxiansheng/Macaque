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
 * @create: 2020-07-23 10:57
 **/
@Service
public class OrderServiceTwo {

    @Autowired
    @Qualifier("jdbcTemplatePrimary")
    private JdbcTemplate jdbcTemplatePrimary;

    @Transactional(rollbackFor = RollBackExceptionNoXa.class)
    public void add() throws RollBackExceptionNoXa {
        jdbcTemplatePrimary.execute("update orders_2 set code = 2 ,quantity = 2");
        throw new RollBackExceptionNoXa();
    }
}
