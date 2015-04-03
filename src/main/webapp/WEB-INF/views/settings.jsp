<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <!--Created by Andrey on 01.03.20115-->
  <head>
    <title>Settings</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/settings.css" />">
  </head>

  <body>
    <div class="nav">
      <c:url var="home" value="/home" />
      <c:url var="welcome" value="/welcome" />
      <c:url var="about" value="#" />
      <c:url var="ourteam" value="#" />
      <c:url var="user" value="#" />
      <c:url var="general" value="#" />
      <c:url var="socialnetworks" value="#" />
      <c:url var="security" value="#" />
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <a href="${welcome}">
              <i class="fa fa-cloud"></i>ChallengeCloud
            </a>
          </div>

          <div class="col-md-9">
            <ul class="pull-left">
              <li><a href="${home}">Home</a></li>
              <li><a href="${about}">About</a></li>
              <li><a href="${ourteam}">Our Team</a></li>
            </ul>
          </div>
        </div>
      </div>
    </div>

    <div class="heading">
      <h1>Settings</h1>
    </div>

    <div class="row">
      <div class="col-md-3">
        <div class="menu">
          <ul>
            <li role="presentation"><a href="${user}">User</a></li>
            <li role="presentation"><a href="${general}">General</a></li>
            <li role="presentation"><a href="${socialnetworks}">Social Networks</a></li>
            <li role="presentation" class="active"><a href="${security}">Security</a></li>
          </ul>
        </div>
      </div>
      <div class="col-md-9">
        <div class="settings">
          <form action="<c:url value="/connect/twitter" />" method="POST" class="submitForm">
            <button type="submit"><i class="fa fa-twitter fa-3x"></i></button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
          </form>
        </div>
      </div>
    <div>
  </body>
</html>