
  var app = angular.module('myApp', ['ui.bootstrap']);

  app.controller('MyController', function($scope, $http){
  
  $scope.curPage = 1,
  $scope.itemsPerPage = 10,
  $scope.totalItems = 0;
  $scope.maxSize = 20;
  $scope.filteredItems = [];
  $scope.doClick = function(phone, event) {
	  if(($scope.phone.length === 7 ||  $scope.phone.length === 10) && !isNaN($scope.phone)){
	      
		  var responsePromise = $http.get("/phone/numbers?phone="+$scope.phone);
	      responsePromise.success(function(data, status, headers, config) {
	    	  itemsDetails = data;
	    	  $scope.totalItems = itemsDetails.length;
	    	  $scope.filteredItems = itemsDetails.slice(0, $scope.itemsPerPage);
	      });
	      responsePromise.error(function(data, status, headers, config) {
	          alert("Call to Server failed!");
	      });
		  
	  }else if(isNaN($scope.phone)){
		  alert("Phone Number should be Numeric");
	  }
		  else{
	  
		  alert("Invalid Phone Number. Phone Number should be 7 or 10 digits");
	  }
	 
  };
    this.items = itemsDetails;
       
  $scope.numOfPages = function () {
    return Math.ceil(itemsDetails.length / $scope.itemsPerPage);    
  };
  
    $scope.$watch('curPage + numPerPage', function() {
    var begin = (($scope.curPage - 1) * $scope.itemsPerPage),
    end = begin + $scope.itemsPerPage;
    $scope.filteredItems = itemsDetails.slice(begin, end);
    });
  });

  var itemsDetails = [];
