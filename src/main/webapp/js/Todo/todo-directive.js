/**
 * Created by chandrakanth on 3/17/2016.
 */
todoApp.directive('repeatDone', function() {
        return function(scope, element, attrs) {
            if (scope.$last) { // all are rendered
                scope.$eval(attrs.repeatDone);
            }
        }
    })
