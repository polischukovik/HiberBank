<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>HiberBank</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="../resources/core/css/materialize.min.css">
    <link rel="stylesheet" href="../resources/core/css/hb_customer_summary.css" rel="stylesheet">
    <script type="text/javascript" src="../resources/core/js/jquery-3.0.0.min.js"></script>           
    <script src="../resources/core/js/materialize.min.js"></script>        
    <script src="../resources/core/js/hb_common.js"></script>     
  </head>
  <body>
    <!-- START HEADER -->
    <header id="root-header" class="page-topbar teal container col l4 m4 s12 z-depth-2">
      <!-- start header nav-->
      <nav class="navbar-color">
        <div class="nav-wrapper ">
          <!-- Dropdown Structure -->
          <ul id="dropdown1" class="dropdown-content ">
            <li><a href="#"><i class="mdi-action-face-unlock"></i> Profile</a>
            </li>
            <li><a href="#"><i class="mdi-action-settings"></i> Settings</a>
            </li>
            <li><a href="#"><i class="mdi-communication-live-help"></i> Help</a>
            </li>
            <li class="divider"></li>
            <li><a href="#"><i class="mdi-action-lock-outline"></i> Lock</a>
            </li>
            <li><a href="#"><i class="mdi-hardware-keyboard-tab"></i> Logout</a>
            </li>
          </ul>
          <nav>
            <div class="nav-wrapper teal ">
              <div class="left col l11 m11 s11">
                <a href="#!" class="left brand-logo">HiberBank</a>
              </div>
              <div class="right col l1 m1 s1">
                <div class="center">
                  <!-- Dropdown Trigger -->
                  <a class="btn-floating  dropdown-button lighten-3 circle center" href="#!" data-activates="dropdown1">OP</a>
                </div>
              </div>
            </div>
          </nav>
        </div>
      </nav>
      <!-- end header nav-->
    </header>
    <!-- END HEADER -->
    <main id="root-main">
      <div id="main-containter" class="container row z-depth-1">
        <div id="root-main-left-panel" class="col l3 m3 s3 z-depth-1">
          <ul class="collapsible" data-collapsible="accordion">
            <li>
              <div class="collapsible-header"><i class="material-icons">filter_drama</i>First</div>
              <div class="collapsible-body">
                <p>Lorem ipsum dolor sit amet.</p>
              </div>
            </li>
            <li>
              <div class="collapsible-header"><i class="material-icons">place</i>Second</div>
              <div class="collapsible-body">
                <p>Lorem ipsum dolor sit amet.</p>
              </div>
            </li>
            <li>
              <div class="collapsible-header"><i class="material-icons">whatshot</i>Third</div>
              <div class="collapsible-body">
                <p>Lorem ipsum dolor sit amet.</p>
              </div>
            </li>
          </ul>
        </div>
        <div id="root-main-workspace" class="col l9 m9 s9">
          <div id="main-content" class="ontainer  z-depth-1">
            <!--DataTables example-->
            <div id="table-datatables">
              <h5 class="header">
              Customers</h4>
              <div class="row">
                <div id="data-table-customer" class="col s12 m12 l12">
                  <table class="responsive-table display" cellspacing="0">
                    <thead>
                      <tr>
                        <th>Name</th>
                        <th>IPN</th>
                        <th>Type</th>
                        <th>Status</th>
                        <th>Created</th>
                        <th>Modified</th>
                      </tr>
                    </thead>
                    <tbody id="data-table-customer-body">
                    	<c:forEach items="${customers}" var="customer">
						   <tr id="${customer.id}" class='clickable-row'>
	                        <td>${customer.lastName} ${customer.firstName} ${customer.familyName}</td>
	                        <td>${customer.ipn}</td>
	                        <td>${customer.type}</td>
	                        <td>${customer.status}</td>
	                        <td>${customer.createdTs}</td>
	                        <td>${customer.modifiedTs}</td>
	                      </tr>
						</c:forEach>                      
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
    <!-- START FOOTER -->
    <footer id="root-footer" class="page-footer teal container z-depth-2">
      <div class="footer-copyright">
        <div class="container">
          © 2014 Copyright Oleksii Polishchuk :: Project HiberBank was created as a part of evaluation at Prog.kiev.ua JavaEE programming training
          <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
        </div>
      </div>
    </footer>
    <!-- END FOOTER -->
    </div>
    </div>
  </body>
</html>