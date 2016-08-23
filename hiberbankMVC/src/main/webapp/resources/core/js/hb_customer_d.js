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
}

var Redraw = function(){
	$(OK_BUTTON_ID).click(OkClick);
	$(BACK_BUTTON_ID).click(BackClick);
	
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

//event hendlers
var OkClick = function(){
	RestPostCustomer();
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
var RestPostCustomer = function() {
	var prefix = '/hiberbankMVC/cust/add';
    $.ajax({
        type: 'POST',
        url:  prefix,
        dataType: 'json',
        async: true,
        success: function(result) {
        	
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });
}
//interface functions
var fillCustomerDetails = function(result){
  console.log(result)
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
