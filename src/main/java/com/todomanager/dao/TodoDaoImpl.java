/** *****************************************************************************
 © 2016 SunGard Higher Education.  All Rights Reserved.

 CONFIDENTIAL BUSINESS INFORMATION

 THIS PROGRAM IS PROPRIETARY INFORMATION OF SUNGARD HIGHER EDUCATION
 AND IS NOT TO BE COPIED, REPRODUCED, LENT, OR DISPOSED OF,
 NOR USED FOR ANY PURPOSE OTHER THAN THAT WHICH IT IS SPECIFICALLY PROVIDED
 WITHOUT THE WRITTEN PERMISSION OF THE SAID COMPANY
 ****************************************************************************** */
package com.todomanager.dao;

import com.todomanager.model.Todo;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TodoDaoImpl.
 * <p/>
 * Date: 3/13/2016
 * Time: 7:46 PM
 */
@Repository("todoDao") @Transactional
public class TodoDaoImpl implements TodoDao {
    @Autowired
    private SessionFactory sessionFactory;

    /*ApplicationContext context = new ClassPathXmlApplicationContext("servlet-config.xml");
    private SessionFactory sessionFactory =(SessionFactory) context.getBean("sessionFactory");


    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    } */

    public void createOrUpdate(Todo todo) {
        sessionFactory.getCurrentSession().saveOrUpdate(todo);
    }

    public List<Todo> findAll() {
        return (List<Todo>) sessionFactory.getCurrentSession().createCriteria(Todo.class).list();
    }

    public Todo findById(int id) {
        return (Todo) sessionFactory.getCurrentSession().get(Todo.class, id);
    }


    public int delete(Long todoId) {
        return sessionFactory.getCurrentSession().createQuery("DELETE FROM Todo WHERE id = " + todoId).executeUpdate();
    }
}
