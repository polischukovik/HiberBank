$(document).ready(function(){
  Init();  
  $(FILTER_BUTTON_ID).click(FilterClick);
  $(FILTER_REMOVE_BUTTON_ID).click(FilterRemoveClick);
  $(ADD_BUTTON_ID).click(AddClick);
  $("#name-filter-input,#ipn-filter-input").keyup(filterInputEventHendler);
})
var Init = function(){
  RestGetCustomers('','');
  
}


//static variables
var FILTER_BUTTON_ID="#filter";
var ADD_BUTTON_ID="#btn-add";
var FILTER_REMOVE_BUTTON_ID="#remove-filter";
var INPUT_FILTER_NAME="#name-filter-input";	
var INPUT_FILTER_IPN="#ipn-filter-input";
var BUTTON_CLASS_ENABLED="teal";
var BUTTON_CLASS_DISABLED="grey"; 
//global variables
var filterEnabled=false;
var filterRemoveState=false;

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
var filterInputEventHendler = function (){
  if($(INPUT_FILTER_NAME).val() != "" || $(INPUT_FILTER_IPN).val() != "") {
       styleButtonState(FILTER_BUTTON_ID, true)
       styleButtonState(FILTER_REMOVE_BUTTON_ID, true)
    } else {
       styleButtonState(FILTER_BUTTON_ID, false) 
       styleButtonState(FILTER_REMOVE_BUTTON_ID, false)
    }
}
//event hendlers
var AddClick = function(){
	window.document.location = "cust/-1";
	console.log("Add");
}
var FilterClick = function(){
  if(document.querySelector(FILTER_BUTTON_ID).classList.contains(BUTTON_CLASS_ENABLED)){
    filterEnabled = true;
    console.log("Filter enabled");    
    styleButtonState(FILTER_BUTTON_ID, filterEnabled);
    var nameFilterTxt = $(INPUT_FILTER_NAME).val();
    var ipnFilterTxt = $(INPUT_FILTER_IPN).val();
    RestGetCustomers(nameFilterTxt,ipnFilterTxt);
    styleButtonState(FILTER_BUTTON_ID, false);
  }
}
var FilterRemoveClick = function(){ 
  $("#name-filter-input,#ipn-filter-input").val('');
  styleButtonState(FILTER_BUTTON_ID, false);
  styleButtonState(FILTER_REMOVE_BUTTON_ID, false);
  if(filterEnabled){
    filterEnabled = false;
    console.log("Filter disabled");    
    RestGetCustomers('','');  
  }
}
//service functions
var RestGetCustomers = function(nameStr, ipnStr) {
        var prefix = '/hiberbankMVC/service/customer';
        var request_att_filter_name = 'filter_name';
        var request_att_filter_ipn = 'filter_ipn';
        $.ajax({
            type: 'GET',
            url:  prefix + '/?'+request_att_filter_name + '=' + nameStr + '&' + request_att_filter_ipn + ' ' + ipnStr,
            dataType: 'json',
            async: true,
            success: function(result) {
            	console.log(result);
                fillCustomerTable(result);
                createPaginations(result.length);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
}
//interface functions
var fillCustomerTable = function(result){
  var tableContent = "";
  var array = result.content;
  for(var o in array){
	var i = array[o];
    tableContent += '<tr id="'+ i.id + '" class="clickable-row"> \
                     <td>' + i.lastName + ' \
                     ' + i.firstName + ' \
                     ' + i.familyName + '</td>\
                      <td>' + i.ipn + '</td> \
                      <td>' + i.type + '</td> \
                      <td>' + i.status + '</td> \
                      <td>' + i.createdTs + '</td> \
                      <td>' + i.modifiedTs + '</td> \
                      </tr>'
  }

	//console.log(tableContent);
  tableContent += "\n";
  $("#data-table-customer-body").html(tableContent);
  $(".clickable-row").click(function() {
      window.document.location = "cust/" + $(this).attr('id');
      console.log("listener set");
  });
}
var createPaginations = function(count){
  var pageNum = Math.floor(count/20);
  if(count/20 > pageNum) pageNum++;
  if(pageNum === 0) pageNum++;
  var list = "";
  var index;
  for (index = 0; index < pageNum; index++) {
      list += '<li class="waves-effect"><a href="#!">' + index++ + '</a></li>\n';
  }
  $("#page-selector-list").html(list);
}
/*
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
*/