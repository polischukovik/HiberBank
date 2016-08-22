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
	href="../resources/core/css/hb_customer_summary.css">

<script src="../resources/core/js/hb_common.js"></script>
<script src="../resources/core/js/hb_customer.js"></script>
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
				<h5 class="header">Customers</h5>
				<div id="control-panel" class="row">
					<div class="" ng-if="showTabs">
						<div class=" col right">
							<div class="input-field col ">
								<input id="name-filter-input" type="text" class="validate">
								<label>Name</label>
							</div>
							<div class="input-field col ">
								<input id="ipn-filter-input" type="text" class="validate">
								<label>IPN</label>
							</div>
							<div id="filter" class="btn-floating grey"
								ng-click="showTabs = !showTabs">
								<i class="mdi mdi-filter"></i>
							</div>
							<div id="remove-filter" class="btn-floating grey"
								ng-click="showTabs = !showTabs">
								<i class="mdi mdi-filter-remove"></i>
							</div>
							<div class="btn-floating">
								<i class="material-icons">add</i>
							</div>
						</div>
					</div>
				</div>
				<!--DataTables example-->
				<div id="table-datatables" class="row">
					<div class="" id="tabs" ng-init="showTabs=true">

						<div id="data-table-customer" class="">
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

								</tbody>
							</table>
						</div>
						<div id="page-selector">
							<ul id="page-selector-list" class="pagination center">
								<!--<li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
				                      <li class="teal"><a href="#!">1</a></li>
				                      <li class="waves-effect"><a href="#!">2</a></li>
				                      <li class="waves-effect"><a href="#!">3</a></li>
				                      <li class="waves-effect"><a href="#!">4</a></li>
				                      <li class="waves-effect"><a href="#!">5</a></li>
				                      <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>-->
							</ul> 
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