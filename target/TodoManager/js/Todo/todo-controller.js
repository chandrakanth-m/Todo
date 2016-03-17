/**
 * Created by chandrakanth on 3/15/2016.
 */
todoApp.controller('taskController', ['taskService', '$timeout', '$scope', '$modal', function TaskController(taskService, $timeout, $scope, $modal) {
  $scope.allTodos = [];

  init();
  function init() {
    $scope.allTodos = taskService.getAllTodos().then(function (data) {
      if (data.length > 0) {
        console.log("data", data);
        $scope.allTodos = data;
      }
    });
    console.log("$scope.allTodos", $scope.allTodos);
  }

  $scope.addTodo = function (todo) {
    $scope.allTodos = taskService.addTodo(todo).then(function (data) {
      if (data.length > 0) {
        $scope.allTodos = data;
      }
    });
    angular.element('#statusId').html('Added Todo Successfully.').show();
    $timeout(function () {
      angular.element('#statusId').html(' ').hide();
    }, 1000);
  }

  $scope.updateTodo = function (todo) {
    taskService.updateTodo(todo).then(function (data) {
      location.reload();
    }).error(function(){
      angular.element('#statusId').html('Updation failed, please try again').show();
    });
    $timeout(function () {
      angular.element('#statusId').html(' ').hide();
    }, 1000);
  };

  $scope.deleteTodo = function (todoId) {
    taskService.deleteTodo(todoId).then(function (data) {
      location.reload();
    }).error(function(){
      angular.element('#statusId').html('Deletion failed, please try again').show();
    });
    $timeout(function () {
      location.reload();
    }, 1000);
  }

  $scope.openModalForDeletingTodo = function (todoId) {
    $scope.deleteTodoId = todoId;
    $scope.modalInstance = $modal.open({
      templateUrl: '../../todoDeleteModalTemplate.html',
      scope: $scope,
      controller: 'taskController',
      size: 'lg',
      backdrop: 'static'
    });

  }

  $scope.closeModalWindow = function () {
    $scope.modalInstance.close();
  }

}]);

