/** *****************************************************************************
 © 2016 SunGard Higher Education.  All Rights Reserved.

 CONFIDENTIAL BUSINESS INFORMATION

 THIS PROGRAM IS PROPRIETARY INFORMATION OF SUNGARD HIGHER EDUCATION
 AND IS NOT TO BE COPIED, REPRODUCED, LENT, OR DISPOSED OF,
 NOR USED FOR ANY PURPOSE OTHER THAN THAT WHICH IT IS SPECIFICALLY PROVIDED
 WITHOUT THE WRITTEN PERMISSION OF THE SAID COMPANY
 ****************************************************************************** */
package com.todomanager.service;

import com.todomanager.model.Todo;

import java.util.List;

/**
 * TodoService.
 * <p/>
 * Date: 3/13/2016
 * Time: 4:46 PM
 */
public interface TodoService {
    public void addTodo(Todo todo);

     public List<Todo> findAll();

     public Todo getTodo(int id);

     public int deleteTodo(Long todoId);
}
