sap.ui.define(["sap/ui/core/mvc/Controller", "sap/m/MessageBox"], function (Controller) {
	"use strict";
	return Controller.extend("simple-app.controller.View1", {
		/**
		 *@memberOf simple-app.controller.View1
		 */
		calculateResult: function (oEvent) {
			var debugEvent = oEvent;
			//getNumbers
			//var num1 = this.getView().byId("input0").getValue();
			//var num2 = this.getView().byId("input1").getValue();
			var model = this.getView().getModel("restJsonModel");
			var num1 = this.getView().getModel("restJsonModel").getProperty("/num1");
			var num2 = this.getView().getModel("restJsonModel").getProperty("/num2");
	
			// get selected radio button
			var addSelected = this.getView().byId("button_add").getSelected();
			var subSelected = this.getView().byId("button_sub").getSelected();
			var mulSelected = this.getView().byId("button_mul").getSelected();
			var divSelected = this.getView().byId("button_div").getSelected();
			var operator = "";
			if (addSelected) {operator = "plus";}
			if (subSelected) {operator = "minus";}
			if (mulSelected) {operator = "mal";}
			if (divSelected) {operator = "geteilt";}
			
			var jsonUrl = "http://localhost:8080/calcrest?a=" + num1 + "&b=" + num2 + "&operant=" + operator;
			
			//test get model data
			//var tempData = this.getView().getModel("restJsonModel").getData();
			//console.log("Result: " + tempData.num1 + " " + tempData.operant + " " + tempData.num2 + " = " + tempData.result);
			
			//json from string
			/*			var str = '{"num1":"4","num2":"3","result":"12.0","operator":"*"}';
						var parsedObject = JSON.parse(str);
						var jsonModel = new sap.ui.model.json.JSONModel(parsedObject);*/

			//get json text from rest service
			var restJsonString = JSON.parse($.ajax({
				'url': jsonUrl,
				'async': false
			}).responseText);
			
			//
			// lambda function klappt nicht?
			//	console.log("before pause");
			//	setTimeout( () => {console.log("after pause"); console.log(json.toString());}, 5000); 
			
			console.log("json object to string:");
			console.log(restJsonString);

			var jsonModel = new sap.ui.model.json.JSONModel(restJsonString);

/*			//jsonResultModel.loadData(parsedObject,false);
			var jsonLoaded = jsonModel.dataLoaded();
			jsonLoaded.then(
				console.log(jsonModel.getJSON())
			);*/

			/* // wait for data to be loaded
			oModel.loadData(jsonFilePath);
			oModel.attachRequestCompleted(function(oEventModel){
			    //console.log(oModel.getData());
			    //This is called after data is loading
			});*/
			
			this.getView().setModel(jsonModel, "restJsonModel");
		},

		onInit: function () {
			var jsonUrl = "http://localhost:8080/calcrest?a=4&b=3&operant=*";
			var restJson = JSON.parse($.ajax({
				'url': jsonUrl,
				'async': false
			}).responseText);
			
			var oData = {
				"topElement": {
					"attribute1": "Test! Top element first attribute",
					"attribute2": "test attribute2"
				}
			};

			var oModel = new sap.ui.model.json.JSONModel(oData);
			var jsonModel = new sap.ui.model.json.JSONModel(restJson);
			this.getView().setModel(oModel, "myMODEL");
			this.getView().setModel(jsonModel, "restJsonModel");
			console.log("on init called");

		}
	});
});


// JSON.stringify(jsonObject)


/*sap.m.MessageBox.alert(
	//jsonResultModel.getJSON(),
	{
		title: "Alert", // default
		onClose: null, // default
		styleClass: "", // default
		initialFocus: null, // default
		textDirection: sap.ui.core.TextDirection.Inherit // default
	})*/