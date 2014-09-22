/**
 * 
 */

angular.module('proto').controller('LandingPageController',
		function($scope, dataFactory) {

			
			$scope.getMachineList = function() {
				var promise = dataFactory.getMachineList();
				promise.then(function(machines) {
					$scope.dataModel.machines = machines;
				}, function(reason) {
					window.console.log('Failure: ' + reason);
					$scope.errorMessage = reason;
				});
			};
			
			$scope.getCategoryNames = function() {
				if($scope.dataModel.selectedMachineId === 'select') {
					alert('Please select a valid machine name from the machine drop-down list');
					return;
				}
				var promise = dataFactory.getMachineCategoryListForMachine($scope.dataModel.selectedMachineId);
				promise.then(function(machineCategories) {
					$scope.dataModel.machineCategories = machineCategories;
				}, function(reason) {
					window.console.log('Failure: ' + reason);
					$scope.errorMessage = reason;
				});
			};
			
			$scope.getPartsListForMachineCategory = function() {
				if($scope.dataModel.selectedMachineCategoryId === 'select') {
					alert('Please select a valid machine category name from the machine category drop-down list');
					return;
				}
				var promise = dataFactory.getPartsListForMachineCategory($scope.dataModel.selectedMachineCategoryId);
				promise.then(function(parts) {
					$scope.dataModel.parts = parts;
				}, function(reason) {
					window.console.log('Failure: ' + reason);
					$scope.errorMessage = reason;
				});
			};
			
			$scope.showSelectedParts = function() {
				$scope.dataModel.selectedMachineParts = [];   
				$scope.dataModel.totalCost = 0;
	              for(var i=0;i<$scope.dataModel.parts.length;i++){
	            	  for(var j=0;j<$scope.dataModel.parts[i].subComponenets.length;j++) {
	            		  if($scope.dataModel.parts[i].subComponenets[j].checked){
		                        var obj = angular.copy($scope.dataModel.parts[i].subComponenets[j]);
		                        delete obj.checked;
		                        $scope.dataModel.selectedMachineParts.push(obj);
		                        $scope.dataModel.totalCost = $scope.dataModel.totalCost + obj.rate;
		                    } 
	            	  }
	                    
	              }
			};
			
			$scope.removeSelectedParts = function() {
				$scope.dataModel.totalCost = 0;
				var tempSelectedParts = [];
				for(var i=0;i<$scope.dataModel.selectedMachineParts.length;i++) {
                    if(!$scope.dataModel.selectedMachineParts[i].checked){
                        var obj = angular.copy($scope.dataModel.selectedMachineParts[i]);
                        tempSelectedParts.push(obj);
                        $scope.dataModel.totalCost = $scope.dataModel.totalCost + obj.rate;
                    }
                }
				$scope.dataModel.selectedMachineParts = tempSelectedParts;
			};
			
			$scope.generatePdf = function() {
				if($scope.dataModel.selectedMachineId.length === 0) {
					alert('Please select parts you want.....');
					return;
				}
				var machineId = $scope.dataModel.selectedMachineId;
				var machineCategoryId = $scope.dataModel.selectedMachineCategoryId ;
				var selectedPartIds = getSelectedPartsIds();
				var pdfDetailsObj = {};
				pdfDetailsObj.machineId = machineId;
				pdfDetailsObj.machineCategoryId = machineCategoryId;
				pdfDetailsObj.selectedPartIds = selectedPartIds;
				var promise = dataFactory.generatePdf(pdfDetailsObj);
				promise.then(function(data) {
					if(!angular.isUndefined(data) && data.result ) {
						alert('Pdf generated successfully!!!!!!!!');
					}
				}, function(reason) {
					window.console.log('Failure: ' + reason);
					$scope.errorMessage = reason;
				});
				
			};
			
			$scope.loadActualPartsForPart = function(partId) {
				var collapseSectionFlag = "isCollapsed"+partId;
				$scope[collapseSectionFlag] = true;
			};
			
		
			
			function getSelectedPartsIds() {
				var selectedPartIds = [];
				for(var i=0;i<$scope.dataModel.selectedMachineParts.length;i++) {
					selectedPartIds.push($scope.dataModel.selectedMachineParts[i].id);
				}
				return selectedPartIds;
			}
			
			(function reset(){
				$scope.dataModel = {};
				$scope.getMachineList(); 
				$scope.dataModel.selectedMachineId = "select";
				$scope.dataModel.selectedMachineCategoryId = "select";
				$scope.dataModel.parts = [];
				$scope.dataModel.selectedMachineParts = [];
				$scope.dataModel.totalCost = 0;
			})();

		});