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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TodoDao.
 * <p/>
 * Date: 3/13/2016
 * Time: 7:45 PM
 */
@Transactional
public interface TodoDao {
    public void createOrUpdate(Todo todo);

    public List<Todo> findAll();

    public Todo findById(int id);

    public int delete(Long todoId);
}
