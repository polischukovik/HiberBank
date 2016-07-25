$(document).ready(function(){
  Init();
  $("#show-filter").click(FilerClick);
})

var Init = function(){
  RestGetCustomers();
}           

//static variables
var FILTER_BUTTON_ID="#show-filter";
var BUTTON_CLASS_ENABLED="teal";
var BUTTON_CLASS_DISABLED="grey";

//global variables
var filterEnabled=false;

//common functions
var styleButtonState = function(id, state){
  var obj = document.querySelector(id);
  if(state){    
    obj.classList.remove(BUTTON_CLASS_DISABLED);
    obj.classList.add(BUTTON_CLASS_ENABLED);
  }else{
    obj.classList.remove(BUTTON_CLASS_ENABLED);
    obj.classList.add(BUTTON_CLASS_DISABLED);
  }
}

//event hendlers
var FilerClick = function(){
	console.log('click');
  styleButtonState(FILTER_BUTTON_ID, !filterEnabled);
  var nameFilterTxt = $("#name-filter-input").val();
  var ipnFilterTxt = $("#ipn-filter-input").val();
  RestGetCustomersFiltered(nameFilterTxt,ipnFilterTxt);  
}

//service functions
var RestGetCustomersFiltered = function(nameStr, ipnStr) {
        var prefix = '/hiberbankMVC/service/customer';
        var request_att_filter_name = 'filter_name';
        var request_att_filter_ipn = 'filter_ipn';
        $.ajax({
            type: 'GET',
            url:  prefix + '/?'+request_att_filter_name + '=' + nameStr + '&' + request_att_filter_ipn + '=' + ipnStr,
            dataType: 'json',
            async: true,
            success: function(result) {
                fillCustomerTable(result);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });}
var RestGetCustomers = function() {
    var prefix = '/hiberbankMVC/service/customer';
    $.ajax({
        type: 'GET',
        url:  prefix + '/',
        dataType: 'json',
        async: true,
        success: function(result) {
            fillCustomerTable(result);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        }
    });}

//interface functions
var fillCustomerTable = function(array){
	console.log(array);
	var tableContent = '';
	$.each(array, function(i,item){
		tableContent += '<tr id="'+ item.id + '"' + " class='clickable-row'>\n<td>" 
			 + item.lastName + ' ' + item.firstName + ' ' + item.familyName + '</td>\n'
		     + '<td>' + item.ipn + '</td>\n'
		     + '<td>' + item.type + '</td>\n'
		     + '<td>' + item.status + '</td>\n'
		     + '<td>' + item.createdTs + '</td>\n'
		     + '<td>' + item.modifiedTs + '</td>\n'
		     + '</tr>\n\n';
	});
	console.log(tableContent);
	$("#data-table-customer").html(tableContent);
}

    var RestGet = function() {
    	
        $.ajax({
            type: 'GET',
            url:  prefix + '/' + Date.now(),
            dataType: 'json',
            async: true,
            success: function(result) {
                alert('Время: ' + result.time
                        + ', сообщение: ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
 
    var RestPut = function() {
        var JSONObject= {
            'time': Date.now(),
            'message': 'Это пример вызова PUT метода'
        };
 
        $.ajax({
            type: 'PUT',
            url:  prefix,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(JSONObject),
            dataType: 'json',
            async: true,
            success: function(result) {
                alert('Время: ' + result.time
                        + ', сообщенеи: ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
 
    var RestPost = function() {
        $.ajax({
            type: 'POST',
            url:  prefix,
            dataType: 'json',
            async: true,
            success: function(result) {
                alert('Время: ' + result.time
                        + ', сообщение: ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
 
    var RestDelete = function() {
        $.ajax({
            type: 'DELETE',
            url:  prefix + '/' + Date.now(),
            dataType: 'json',
            async: true,
            success: function(result) {
                alert('Время: ' + result.time
                        + ', сообщение: ' + result.message);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }