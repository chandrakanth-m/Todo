package com.todomanager.controller;

import com.todomanager.dao.TodoDao;
import com.todomanager.model.Todo;
import com.todomanager.service.TodoService;
import org.codehaus.jackson.annotate.JsonCreator;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.rmi.JndiRmiServiceExporter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    // to display all todos
    @RequestMapping(value = "getAllTodos/{name}", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    List<Todo> getAllTodos(@PathVariable String name) {
        return todoService.findAll();
    }

    // For Delete
    @RequestMapping(value = "delete", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    List<Todo> dropTodo(@RequestParam(value = "todoId", required = false) String todoId) {
        List<Todo> todos = new ArrayList<Todo>();
        try {
            todoService.deleteTodo(Long.valueOf(todoId));
            //todos =  todoService.findAll();
        } catch (Exception e) {
            System.out.println("Exception occured while deleteing "+e.getMessage());
        }
        return todos;
    }

    // For Add
    @RequestMapping(value = "add", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Todo> addTodo(@RequestParam(value = "name", required = false) String name) {
        Todo todo = new Todo();
        todo.setName(name);
        todo.setActive(false);
        List<Todo> todos = new ArrayList<Todo>();
        try {
            todoService.addTodo(todo);
            todos =  todoService.findAll();
        } catch (Exception e) {
            System.out.println("Exception occured while adding "+e.getMessage());
        }
        return todos;
    }

    // For Update
    @RequestMapping(value = "update", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Todo> updateTodo(@RequestParam(value = "id", required = false) int id) {
        Todo todo = todoService.getTodo(id);
        if(todo.isActive()){
            todo.setActive(false);
        } else {
            todo.setActive(true);
        }
        List<Todo> todos = new ArrayList<Todo>();
        try {
            todoService.addTodo(todo);
        } catch (Exception e) {
            System.out.println("Exception occured while adding "+e.getMessage());
        }
        return todos;
    }

}
