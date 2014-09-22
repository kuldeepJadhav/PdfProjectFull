
angular.module('proto').factory('authInterceptor', function ($q, $rootScope, $location) {

    function showLoadingDialogAndIncrementRequestCounter(config) {
        if(angular.isUndefined(config.showLoading)){
            $rootScope.showLoading = true;
        }else{
            $rootScope.showLoading = config.showLoading;
        }

        if ($rootScope.showLoading) {
            if (angular.isUndefined($rootScope.requestCounter)) {
                $rootScope.requestCounter = 1;
            } else {
                $rootScope.requestCounter++;
            }
        }
    }

    function hideLoadingDialogAndDecrementRequestCounter(config){
        if (config.url.indexOf('pdfproject/') > -1 && (angular.isUndefined(config.showLoading) || config.showLoading) ) {
            $rootScope.requestCounter--;
        }
        if ($rootScope.requestCounter === 0) {
            $rootScope.showLoading = false;
        }
    }
    

    return {
        'request': function (config) {
            if (config.url !== null && config.url.indexOf('pdfproject/') > -1) {
                showLoadingDialogAndIncrementRequestCounter(config);    
            }
            return config || $q.when(config);
        },
        'response': function (response) {
            window.console.log('Request with url ' + response.config.url + ' successful');
            hideLoadingDialogAndDecrementRequestCounter(response.config);
            return response || $q.when(response);
        },
        'requestError': function (rejection) {
            window.console.log('Exception in AuthInterceptor' + rejection + 'for url ' + rejection.config.url);
            hideLoadingDialogAndDecrementRequestCounter(rejection.config);
            return $q.reject(rejection);
        },
        'responseError': function (rejection) {
            window.console.log('Exception in AuthInterceptor' + rejection + 'for url ' + rejection.config.url);
            hideLoadingDialogAndDecrementRequestCounter(rejection.config);
            return $q.reject(rejection);
        }
    };
});