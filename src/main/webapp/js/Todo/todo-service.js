/**
 * Created by chandrakanth on 3/15/2016.
 */

todoApp.service('taskService', ['$resource', '$http', function TaskService($resource, $http) {
  return {
    getAllTodos: getAllTodos,
    addTodo: addTodo,
    deleteTodo: deleteTodo,
    updateTodo: updateTodo
  };

  function getAllTodos() {
    var todoList = $resource('/:controller/:action/name',
      {controller: 'todos', action: 'getAllTodos'},
      {query: {method: 'GET', isArray: true}}
    );
    return todoList.query().$promise.then(getTodoListComplete)
      .catch(getTodoListFailed);

    function getTodoListComplete(response) {
      return response;
    }

    function getTodoListFailed(error) {
      return error;
    }

  }

  function addTodo(todo) {
    var todoList = $resource('/:controller/:action',
      {controller: 'todos', action: 'add','name':todo},
      {query: {method: 'GET', isArray: true}}
    );
    return todoList.query().$promise.then(getTodoListComplete)
      .catch(getTodoListFailed);

    function getTodoListComplete(response) {
      return response;
    }

    function getTodoListFailed(error) {
      return error;
    }
  }

  function updateTodo(todoId) {
    var todoList = $resource('/:controller/:action',
      {controller: 'todos', action: 'update','id':todoId},
      {query: {method: 'GET', isArray: true}}
    );
    return todoList.query().$promise.then(getTodoListComplete)
      .catch(getTodoListFailed);

    function getTodoListComplete(response) {
      return response;
    }

    function getTodoListFailed(error) {
      return error;
    }
  }

  function deleteTodo(todoId) {
    var todoList = $resource('/:controller/:action',
      {controller: 'todos', action: 'delete','todoId':todoId},
      {query: {method: 'GET', isArray: true}}
    );
    return todoList.query().$promise.then(getTodoListComplete)
      .catch(getTodoListFailed);

    function getTodoListComplete(response) {
      return response;
    }

    function getTodoListFailed(error) {
      return error;
    }
  }


}]);
