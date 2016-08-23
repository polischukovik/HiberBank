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


//static variables
var BUTTON_CLASS_ENABLED="teal";
var BUTTON_CLASS_DISABLED="grey"; 
//global variables
var l_custId ="";
var l_new_customer = true;

//common functions

//event hendlers

//service functions
var RestGetCustomerDetails = function(v_custId) {
        var prefix = '/hiberbankREST/customers';
        console.log(prefix + '/'+ v_custId);
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
  Materialize.updateTextFields();
  //$("#customer-details").text(JSON.stringify(result));
  
}
