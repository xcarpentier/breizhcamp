<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="com.cloudbees.breizhcamp.Schedule" %>
<%@ page import="com.cloudbees.breizhcamp.domain.Talk" %>
<html>
<head>
  <link href='http://fonts.googleapis.com/css?family=Sonsie+One' rel='stylesheet' type='text/css'>
  <style type="text/css">
   html {
     background: url('BreizhCamp.png') no-repeat top center;
   }
   h2 {
     font-family: 'Sonsie One', cursive;
     margin-top:400px;
     text-align: center;
     font-size:60px;
   }
  </style>
  <title>CloudBees au BriezhCamp !</title>
</head>
<body>
<h2>Programme du BreizhCamp !</h2>

<ul>
<% ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
    Schedule schedule = ctx.getBean(Schedule.class);
    for (Talk t : schedule.getSchedule("Amphi")) {
%>
    <li><%= t.getTitle() %></li>
<%
    }
%>
</ul>

<img src="Button-Built-on-CB-1.png" style="position: fixed;bottom:60px">
<img src="Button-Powered-by-CB.png" style="position: fixed;bottom:2px">

</body>
</html>
