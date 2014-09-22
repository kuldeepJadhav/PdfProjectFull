'use strict';

angular.module('proto').factory('dataFactory', function($http, $q) {
	var dataFactory = {
		getMachineList : function() {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : 'pdfproject/getmachinenamelist'
			}).success(function(data) {
				if (data != null) {
					deferred.resolve(data);
				} else {
					deferred.reject('Error getting the machine list.....Null was returned');
				}
			}).error(function(data, status, headers, config) {
				deferred.reject('Error getting the machine list');
			});
			return deferred.promise;
		},
		getMachineCategoryListForMachine : function(machineId) {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : 'pdfproject/getmachinecategorylist?machineId='+machineId
			}).success(function(data) {
				if (data != null) {
					deferred.resolve(data);
				} else {
					deferred.reject('Error getting the machine Category list.....Null was returned');
				}
			}).error(function(data, status, headers, config) {
				deferred.reject('Error getting the machine category list');
			});
			return deferred.promise;
		},
		getPartsListForMachineCategory : function(machineCategoryId) {
			var deferred = $q.defer();
			$http({
				method : 'GET',
				url : 'pdfproject/getpartslist?machineCategoryId='+machineCategoryId
			}).success(function(data) {
				if (data != null) {
					deferred.resolve(data);
				} else {
					deferred.reject('Error getting the parts list.....Null was returned');
				}
			}).error(function(data, status, headers, config) {
				deferred.reject('Error getting the parts list');
			});
			return deferred.promise;
		},
		generatePdf : function(pdfDetailsObj) {
			var deferred = $q.defer();
			$http({
				method : 'POST',
				url : 'pdfproject/generatePdf',
				data : angular.toJson(pdfDetailsObj)
			}).success(function(data) {
				deferred.resolve(data);
			}).error(function(data, status, headers, config) {
				deferred.reject('Error generating pdf');
			});
			return deferred.promise;
		}
		
		
	};
	return dataFactory;
});
