package com.codegroup.challengecloud.dao;

import com.codegroup.challengecloud.dao.impl.HistoryDaoMySQL;
import com.codegroup.challengecloud.model.History;
import com.codegroup.challengecloud.model.User;
import com.codegroup.challengecloud.services.HistoryService;
import com.codegroup.challengecloud.services.UserService;
import junit.framework.Assert;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Krokhin on 21.04.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class HistoryTest {
    private static final String EXCPECTED_EVENT = "1";
    private static final String FIRST_EXCPECTED_ID = "12";
    private static final String SECOND_EXCPECTED_ID = "123";
    private static final String EXCPECTED_REF_ID = "577231985401290754";
    private static final String USER_ID = "d8fbf948694caf35";

    @Autowired
    public SessionFactory sessionFactory;

    @Autowired
    public HistoryDao historyDao;

    @Resource
    private HistoryService historyService;

    @Resource
    private UserService userService;


    @Test
    public void testFindByRefId() {
        Assert.assertEquals(EXCPECTED_REF_ID, historyService.findByRefId(EXCPECTED_REF_ID).getRefId());
    }

    @Test
    public void testFindById() {
        Assert.assertNotNull(historyService.findById(SECOND_EXCPECTED_ID));
        Assert.assertEquals(SECOND_EXCPECTED_ID, historyService.findById(SECOND_EXCPECTED_ID).getId());
    }

    @Test
    public void testFindHistoryForUser() {
        User user = userService.findById(USER_ID);
        Set<History> allNotes = historyDao.getHistoryForUser(user);
        Assert.assertNotNull(allNotes);
        Iterator<History> iterator = allNotes.iterator();
        int amount = 0;
        while (iterator.hasNext()) {
            if (amount < 2) {
                History tempHistory = iterator.next();
                if (amount == 0) {

                    Assert.assertEquals(tempHistory.getId(), FIRST_EXCPECTED_ID);
                } else {
                    Assert.assertEquals(tempHistory.getId(), SECOND_EXCPECTED_ID);
                }
                amount++;
            } else break;
        }
    }
}
