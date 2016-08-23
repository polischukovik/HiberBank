<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>HiberBank</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Compiled and minified JQuery -->
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>

<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.5.7/angular.min.js"></script>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/MaterialDesign-Webfont/1.6.50/css/materialdesignicons.min.css">
<!-- Compiled and minified ICON support -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/angular-materialize/0.1.9/angular-materialize.min.js"></script>
<link rel="stylesheet"
	href="../../resources/core/css/hb_customer_summary.css">

<script src="../../resources/core/js/hb_customer_d.js"></script>
<script>window.customerId = ${customerId}</script>
</head>
<body ng-app="">
	<!-- START HEADER -->
	<header id="root-header"
		class="page-topbar teal container col l5 m5 s12 z-depth-2">
		<!-- start header nav-->
		<nav class="navbar-color">
			<div class="nav-wrapper ">
				<!-- Dropdown Structure -->
				<ul id="dropdown1" class="dropdown-content ">
					<li><a href="#"><i class="mdi-action-face-unlock"></i>
							Profile</a></li>
					<li><a href="#"><i class="mdi-action-settings"></i>
							Settings</a></li>
					<li><a href="#"><i class="mdi-communication-live-help"></i>
							Help</a></li>
					<li class="divider"></li>
					<li><a href="#"><i class="mdi-action-lock-outline"></i>
							Lock</a></li>
					<li><a href="#"><i class="mdi-hardware-keyboard-tab"></i>
							Logout</a></li>
				</ul>
				<nav>
					<div class="nav-wrapper teal ">
						<div class="left col l11 m11 s11">
							<a href="#!" class="left brand-logo">HiberBank</a>
						</div>
						<div class="right col l1 m1 s1">
							<div class="center">
								<!-- Dropdown Trigger -->
								<a class="btn-floating  dropdown-button lighten-3 circle center"
									href="#!" data-activates="dropdown1">OP</a>
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
					<div class="collapsible-header">
						<i class="material-icons">filter_drama</i>Customers
					</div>
					<div class="collapsible-body">
						<div class="collection">
							<a href="/hiberbankMVC/cust" class="collection-item">Customer
								Summary</a>
						</div>
					</div>
				</li>
				<li>
					<div class="collapsible-header">
						<i class="material-icons">place</i>Accounts
					</div>
					<div class="collapsible-body">
						<div class="collection">
							<a href="/hiberbankMVC/acc" class="collection-item">Accounts
								Summary</a>
						</div>
					</div>
				</li>
				<li>
					<div class="collapsible-header">
						<i class="material-icons">whatshot</i>Third
					</div>
					<div class="collapsible-body">
						<p>Lorem ipsum dolor sit amet.</p>
					</div>
				</li>
			</ul>
		</div>
		<div id="root-main-workspace" class="col l9 m9 s9">
			<div id="main-content" class="">
        <div class="row">
				<div id="control-panel" class="col left">					
					<h5 class="header">Edit Customer</h5>
				</div>				
					<div class="col right">						
						<div id="okBtn" class="btn teal">
							<i class="">Save</i>
						</div>
						<div id="okBtn" class="btn teal">
							<i class="">Cancel</i>
						</div>
					</div>
				</div>
				</div>
				<!--DataTables example-->
				<div id="customer-details">
					<div class="row">
        <div class="col s3 m3 l3">
          <div class="card">
            <div class="card-image">
              <img  src="/resources/core/images/profile.png">
            </div>           
          </div>
        </div>
        <div class="row">
          <div class="input-field col s3 m3 l3">
            <input id="last_name" type="text" class="validate">
            <label for="last_name">Last Name</label>
          </div>
          <div class="input-field col s3 m3 l3">
            <input id="first_name" type="text" class="validate">
            <label for="first_name">First Name</label>
          </div>
          <div class="input-field col s3 m3 l3">
            <input id="family_name" type="text" class="validate">
            <label for="family_name">Family Name</label>
          </div>
        </div>
        <div class="row">
          <div class="input-field col s6">
            <input id="ipn" type="text" class="validate">
            <label for="ipn">IPN</label>
          </div>
            <div id="cust-status"class="input-field col s12 m6">
                <select>
                  <option value="" disabled selected>Status</option>
                  <option value="1">ACTIVE</option>
                  <option value="2">DELETED</option>
                  <option value="3">ENTERED</option>
                </select>
                <label>Status</label>
            </div>
            <div id="cust-type" class="input-field col s12 m6">
                <select>
                  <option value="" disabled selected>Type</option>
                  <option value="1">REGULAR</option>
                  <option value="2">BUSSINES</option>
                  <option value="3">PLATINUM</option>
                  <option value="4">EMPL</option>
                </select>
                <label>Type</label>
            </div>
          <div class="row">
            <div class="input-field col s6">
              <input disabled id="created-by" type="text" class="validate">
              <label for="created-by">Created by</label>
            </div>
            <div class="input-field col s6">
              <input disabled id="created-time" type="text" class="validate">
              <label for="created-time">Created Time</label>
            </div>
            <div class="input-field col s6">
              <input disabled id="modified-by" type="text" class="validate">
              <label for="modified-by">Modified by</label>
            </div>            
            <div class="input-field col s6">
              <input disabled id="modified-time" type="text" class="validate">
              <label for="modified-time">Modified Time</label>
            </div>
          </div>
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
				© 2016 Copyright Oleksii Polishchuk :: Project HiberBank was created
				as a part of evaluation at Prog.kiev.ua JavaEE programming training
				<a class="grey-text text-lighten-4 right" href="#!">More Links</a>
			</div>
		</div>
	</footer>
	<!-- END FOOTER -->
</body>
</html>