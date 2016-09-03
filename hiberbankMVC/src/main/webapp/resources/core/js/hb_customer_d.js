$(document).ready(function(){
  
  l_custId=window.customerId;
  if(l_custId == -1){
	  l_new_customer = true;
  }else{
	  l_new_customer = false;
  }
	  
  $('select').material_select();
  
  Init();
 
})


var Init = function(){
	if(!l_new_customer){
		RestGetCustomerDetails(l_custId);
	}  
	$(OK_BUTTON_ID).click(OkClick);
	$(BACK_BUTTON_ID).click(BackClick);
}

var Redraw = function(){
	console.log("Redraw");	
	Materialize.updateTextFields();   
}

//static variables
var BUTTON_CLASS_ENABLED="teal";
var BUTTON_CLASS_DISABLED="grey"; 

var OK_BUTTON_ID="#btn-ok";
var BACK_BUTTON_ID="#btn-back";
//global variables
var l_custId ="";
var l_new_customer = true;

//common functions
function Customer(id, firstName, lastName, familyName, ipn, status, type){
	if(id){
		this.id = id;
	}else{
		this.id=-1;
	}	
	this.firstName = firstName;
	this.lastName = lastName;
	this.familyName = familyName;
	this.ipn = ipn;
	this.status = status;
	this.type = type,
	this.getName = function(){
		return lastName + ' ' + firstName + ' ' + familyName;
	}
}
//event hendlers
var OkClick = function(){
	console.log("OkClick");
	
	var cust = new Customer(
			l_custId,
			$("#first_name").val(),
			$("#last_name").val(),
			$("#family_name").val(),
			$("#ipn").val(),
			$("#cust-status input").val(),
			$("#cust-type input").val()	  
		);
	console.log(cust);
	RestPostCustomer(cust);
}
var BackClick = function(){
	window.location.href = "/hiberbankMVC/cust";
}
//service functions
var RestGetCustomerDetails = function(v_custId) {
        var prefix = '/hiberbankREST/customers';
        $.ajax({
            type: 'GET',
            url:  prefix + '/'+ v_custId,
            dataType: 'json',
            async: true,
            success: function(result) {
            	fillCustomerDetails(result);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
}
var RestPostCustomer = function(cust) {
	var prefix = '/hiberbankMVC/cust/add';
    $.ajax({
        type: 'POST',
        url:  prefix,
        data: cust,
        dataType: 'json',
        async: true,
        success: function(result) {
        	Materialize.toast("Customer " + cust.getName() + " saved", 3000, 'rounded')
        	console.log(result);
        },
        error: function(jqXHR, textStatus, errorThrown, result) {
        	Materialize.toast("Failed to save customer " + jqXHR.status + ' ' + jqXHR.responseText, 3000, 'rounded')
        	console.log(jqXHR.status + ' ' + jqXHR.responseText + ' ' + errorThrown + ' ' + result);
        }
    });
}
//interface functions
var fillCustomerDetails = function(result){
  console.log(result)
  l_custId = result.id;
  $("#first_name").val(result.firstName);
  $("#last_name").val(result.lastName);
  $("#family_name").val(result.familyName);
  $("#ipn").val(result.ipn);
  
  $("#cust-type input").val(result.type);
  $("#cust-status input").val(result.status);
  
  $("#created-by").val(result.createdBy);
  $("#created-time").val(result.createdTs);
  $("#modified-by").val(result.modifiedBy);
  $("#modified-time").val(result.modifiedTs);
  
  Redraw();
  
}
