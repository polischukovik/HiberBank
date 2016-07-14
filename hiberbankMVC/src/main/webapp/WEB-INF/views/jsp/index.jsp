<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
  <head>
    <title>HiberBank</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="../resources/core/css/materialize.min.css">
    <link rel="stylesheet" href="../resources/core/css/hb_customer_summary.css">
    <script src="../resources/core/js/jquery-3.0.0.min.js"></script>           
    <script src="../resources/core/js/materialize.min.js"></script>        
    <script src="../resources/core/js/hb_common.js"></script>     
  </head>
  <body>
    <!-- START HEADER -->
    <header id="root-header" class="page-topbar teal container col l5 m5 s12 z-depth-2">
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
              <div class="collapsible-header"><i class="material-icons">filter_drama</i>Customers</div>
              <div class="collapsible-body">
                <div class="collection">
			        <a href="/hiberbankMVC/cust" class="collection-item">Customer Summary</a>			        
			    </div>
              </div>
            </li>
            <li>
              <div class="collapsible-header"><i class="material-icons">place</i>Accounts</div>
              <div class="collapsible-body">
                <div class="collection">
			        <a href="/hiberbankMVC/acc" class="collection-item">Accounts Summary</a>			        
			    </div>
              </div>
            </li>
            <li>
              <div class="collapsible-header"><i class="material-icons">whatshot</i>Operations</div>
              <div class="collapsible-body">
                <p>Lorem ipsum dolor sit amet.</p>
              </div>
            </li>
          </ul>
        </div>
        <div id="root-main-workspace" class="col l9 m9 s9">
          <div id="main-content" class="ontainer  z-depth-1">
            <h2>
            Welcome to HiberBank!
            </h2>
          </div>
        </div>
      </div>
    </main>
    <!-- START FOOTER -->
    <footer id="root-footer" class="page-footer teal container z-depth-2">
      <div class="footer-copyright">
        <div class="container">
          � 2014 Copyright Oleksii Polishchuk :: Project HiberBank was created as a part of evaluation at Prog.kiev.ua JavaEE programming training
          <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
        </div>
      </div>
    </footer>
    <!-- END FOOTER -->
    </div>
    </div>
  </body>
</html>