package com.dmh.distributedseata.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @program: distributed
 * @description:
 * @author: hu_pf
 * @create: 2021-03-02 14:12
 **/
@Component
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TestAbstractTwo testAbstractTwo;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

        testAbstractTwo.invoke();
    }
}
