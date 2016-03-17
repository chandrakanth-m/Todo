/** *****************************************************************************
 © 2016 SunGard Higher Education.  All Rights Reserved.

 CONFIDENTIAL BUSINESS INFORMATION

 THIS PROGRAM IS PROPRIETARY INFORMATION OF SUNGARD HIGHER EDUCATION
 AND IS NOT TO BE COPIED, REPRODUCED, LENT, OR DISPOSED OF,
 NOR USED FOR ANY PURPOSE OTHER THAN THAT WHICH IT IS SPECIFICALLY PROVIDED
 WITHOUT THE WRITTEN PERMISSION OF THE SAID COMPANY
 ****************************************************************************** */
package com.todomanager.service;

import com.todomanager.dao.TodoDao;
import com.todomanager.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TodoServiceImpl.
 * <p/>
 * Date: 3/13/2016
 * Time: 7:42 PM
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TodoServiceImpl implements TodoService {


     @Autowired
     private TodoDao todoDao;

     public void addTodo(Todo todo) {
      todoDao.createOrUpdate(todo);
     }

     public List<Todo> findAll() {
      return todoDao.findAll();
     }

     public Todo getTodo(int empid) {
      return todoDao.findById(empid);
     }

     public int deleteTodo(Long todoId) {
      return todoDao.delete(todoId);
     }
}
