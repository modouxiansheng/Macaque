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
 * @create: 2020-07-23 10:57
 **/
@Service
public class OrderServiceTwo {

    @Autowired
    @Qualifier("jdbcTemplatePrimary")
    private JdbcTemplate jdbcTemplatePrimary;

    @Transactional(rollbackFor = RollBackExceptionHasXa.class)
    public void add() throws RollBackExceptionHasXa {
        jdbcTemplatePrimary.execute("insert  into orders_2 (code,quantity) values (1,1)");
        throw new RollBackExceptionHasXa();
    }
}
