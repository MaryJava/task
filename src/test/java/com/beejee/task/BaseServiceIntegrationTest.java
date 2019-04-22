package com.beejee.task;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest(classes = TaskAppApplicationTests.class)
@TestPropertySource(locations = "classpath:application_test.properties")
public class BaseServiceIntegrationTest extends AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext
    private EntityManager entityManager;

    protected void flush() {
        entityManager.flush();
    }

    protected void clear() {
        entityManager.clear();
    }

    protected void flushAndClear() {
        flush();
        clear();
    }
}
