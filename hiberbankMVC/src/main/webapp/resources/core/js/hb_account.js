$(document).ready(function() {
    Init();
    $(FILTER_BUTTON_ID).click(FilterClick);
    $(FILTER_REMOVE_BUTTON_ID).click(FilterRemoveClick);
    $(ADD_BUTTON_ID).click(AddClick);
    $(INPUT_FILTER).each(function() {
        $("" + this).keyup(filterInputEventHendler);
    });
})
var Init = function() {
    console.log("Init");
    RestGetSummary(['', ''], 1);
}


//static variables
var FILTER_BUTTON_ID = "#filter";
var ADD_BUTTON_ID = "#btn-add";
var FILTER_REMOVE_BUTTON_ID = "#remove-filter";
var INPUT_FILTER = ["#customer-filter-input", "#nbu-filter-input"];
var REST_SUMMARY_PREFIX = '/hiberbankMVC/service/account';
var DATA_SUMMARY_BODY = "#data-table-account-body";
var BUTTON_CLASS_ENABLED = "teal";
var BUTTON_CLASS_DISABLED = "grey";
var ENTITY_PREFIX = "acc";
//global variables
var filterEnabled = false;
var filterRemoveState = false;
var totalPages = 1;
var prev_page = -1;
var cur_page = 1;

//common functions
var styleButtonState = function(id, state) {
    var obj = document.querySelector(id);
    if (state) {
        obj.classList.remove(BUTTON_CLASS_DISABLED);
        obj.classList.add(BUTTON_CLASS_ENABLED);
    } else {
        obj.classList.remove(BUTTON_CLASS_ENABLED);
        obj.classList.add(BUTTON_CLASS_DISABLED);
    }
}
var filterInputEventHendler = function() {
        var flag = false;
        $(INPUT_FILTER).each(function() {
            if ($("" + this).val() != "") flag = true;
        });
        if (flag) {
            styleButtonState(FILTER_BUTTON_ID, true)
            styleButtonState(FILTER_REMOVE_BUTTON_ID, true)
        } else {
            styleButtonState(FILTER_BUTTON_ID, false)
            styleButtonState(FILTER_REMOVE_BUTTON_ID, false)
        }
    }
    //event hendlers
var AddClick = function() {
    window.document.location = ENTITY_PREFIX + "/-1";
    console.log("Add");
}
var FilterClick = function() {
    if (document.querySelector(FILTER_BUTTON_ID).classList.contains(BUTTON_CLASS_ENABLED)) {
        filterEnabled = true;
        console.log("Filter enabled");
        styleButtonState(FILTER_BUTTON_ID, filterEnabled);

        var FILTER_VALUES = [];
        $(INPUT_FILTER).each(function() {
            FILTER_VALUES.push($("" + this).val());
        });

        RestGetSummary(FILTER_VALUES, 1);
        styleButtonState(FILTER_BUTTON_ID, false);
    }
}
var FilterRemoveClick = function() {
    $(INPUT_FILTER).each(function() {
        $("" + this).val("");
    });
    styleButtonState(FILTER_BUTTON_ID, false);
    styleButtonState(FILTER_REMOVE_BUTTON_ID, false);
    if (filterEnabled) {
        filterEnabled = false;
        console.log("Filter disabled");
        var FILTER_VALUES = [];
        $(INPUT_FILTER).each(function() {
            FILTER_VALUES.push($("" + this).val());
        });
        RestGetSummary(FILTER_VALUES, 1);
    }
}

var PageSelected = function(event, page) {
        console.log("PageSelected");
        $('#page-content').text('Page ' + page);
    }
    //service functions
var RestGetSummary = function(filter_val_arr, page) {
        var att_sufix = "";

        $(filter_val_arr).each(function(index, value) {
            if (index == 0) {
                att_sufix += 'filter_' + (index + 1) + '=' + value;
            } else {
                att_sufix += '&filter_' + (index + 1) + '=' + value;
            }
        });
        att_sufix += '&page=' + page;
        console.log(REST_SUMMARY_PREFIX + '?' + att_sufix)
        $.ajax({
            type: 'GET',
            url: REST_SUMMARY_PREFIX + '?' + att_sufix,
            dataType: 'json',
            async: true,
            success: function(result) {
                console.log("RestGetSummary:\n" + result);
                fillCustomerTable(result);
                createPaginations(result.totalPages);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                alert(jqXHR.status + ' ' + jqXHR.responseText);
            }
        });
    }
    //interface functions
var fillCustomerTable = function(result) {
    var tableContent = "";
    var array = result.content;
    totalPages = result.totalPages;
    for (var o in array) {
        var i = array[o];
        tableContent += '<tr id="' + i.id + '" class="clickable-row"> \
                     <td>' + i.accClass + ' \
                     ' + i.accKey + ' \
                     ' + i.accSubacc + '</td>\
                      <td>' + i.customer+ '</td> \
                      <td>' + i.amount+ '</td> \
                      <td>' + i.amountDyn + '</td> \
                      <td>' + i.ccy + '</td> \
                      <td>' + i.status  + '</td> \
                      <td>' + i.createdBy + '</td> \
                      <td>' + i.modifiedBy + '</td> \
                      <td>' + i.modifiedTs + '</td> \
                      <td>' + i.createdTs + '</td> \
                      </tr>'
    }

    //console.log(tableContent);
    tableContent += "\n";
    $(DATA_SUMMARY_BODY).html(tableContent);
    $(".clickable-row").click(function() {
        window.document.location = ENTITY_PREFIX + "/" + $(this).attr('id');
        console.log("listener set");
    });
}
var createPaginations = function(count) {
        //if(!count) count = 1;
        console.log("Creating pagination with page count" + count)
        $('#pagination').empty();
        $('#pagination').removeData("twbs-pagination");
        $('#pagination').unbind("page");

        $('#pagination').twbsPagination({
            startPage: cur_page,
            totalPages: count,
            visiblePages: 5,
            initiateStartPageClick: false,
            onPageClick: function(event, page) {
                var FILTER_VALUES = [];
                $(INPUT_FILTER).each(function() {
                    FILTER_VALUES.push($("" + this).val());
                });
                console.log("PageSelected: " + page);
                cur_page = page;
                RestGetSummary(FILTER_VALUES, page);
            }
        });
    }
  