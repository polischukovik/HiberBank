$(document).ready(function(){
  l_custId=window.customerId;
  Init();
 
})
var Init = function(){
	RestGetCustomerDetails(l_custId);
  
}


//static variables
var BUTTON_CLASS_ENABLED="teal";
var BUTTON_CLASS_DISABLED="grey"; 
//global variables
var l_custId ="";

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
            	console.log(result);
            	fillCustomerDetails(result);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
}
//interface functions
var fillCustomerDetails = function(result){
  console.log("filling")
  $("#customer-details").text(JSON.stringify(result));
  
}

