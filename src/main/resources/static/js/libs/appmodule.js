
                
var app = angular.module('mainAPP', []);

app.controller('MoneyCtrl', ['$scope', '$http', function($scope, $http) {
 
  this.searchChange = function() {
    $http.get('http://data.fixer.io/api/latest?access_key=9f94b41d7cab577ef7ef3d68ffe0664e&base=EUR&symbols=USD').
    then(function(response) {

        var dol = response.data.rates.USD;
        var eur = document.getElementById("euros").value ;

        $http.get('changes/getPrice', {
                    params: {
                        dolar: dol,
                        eur: eur
                    }
                }).success(function (response) {
                        document.getElementById("dolar").value = response.formato;
                    }).
                       error(function(data, status, headers, config) {

                           alert(data);

                        });
      }),
      function(response) {
        $scope.data = response.data || 'Request failed';
        $scope.status = response.status;
      };
  };
}]);
app.controller('refresh_control',function($scope,$interval,$http){
				  var c=0;
				  var timer=$interval(function(){
					c++;
                                        convertir();
				  },100000);

				  function convertir(){
					if(angular.isDefined(timer))
					{
                                            var eur = document.getElementById("euros").value ;                                            
                                            if(dol !== null && dol !== ""){
						$http.get('http://data.fixer.io/api/latest?access_key=9f94b41d7cab577ef7ef3d68ffe0664e&base=EUR&symbols=USD').
                                                        then(function(response) {

                                                        var dol = response.data.rates.USD;
                                                $http.get('changes/getPrice', {
                                                            params: {
                                                                dolar: dol,
                                                                eur: eur
                                                            }
                                                }).success(function (response) {
                                                        document.getElementById("dolar").value = response.formato;
                                                    }).error(function(data, status, headers, config) {
                                                                alert(data);
                                                             });
                                                        }),
                                                        function(response) {
                                                          $scope.data = response.data || 'Request failed';
                                                          $scope.status = response.status;
                                                        };
                                            }      
					}
				  };
});