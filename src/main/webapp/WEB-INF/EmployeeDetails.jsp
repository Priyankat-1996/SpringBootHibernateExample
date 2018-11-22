
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>           
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
h1.h
{
	background: #C0C0C0;
	color: black;
	
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
table.center {
    margin-left:auto; 
    margin-right:auto;
  }
  tr:hover {background-color: #f5f5f5;}
</style>
</head>
<body>
<h1 class="h" align="center">Employee Management System</h1>
<form:form method="post" modelAttribute="employee" action="${pageContext.request.contextPath}/addEmployee">
<table class="center">
		<tr>
			<th colspan="2">Add Employee</th>
		</tr>
		<tr>
	<form:hidden path="id" />
          <td><form:label path="empName">Employee Name:</form:label></td>
          <td><form:input path="empName" size="30" maxlength="30"></form:input></td>
        </tr>
		<tr>
		  <td><form:label path="salary">Salary:</form:label></td>
          <td><form:input path="salary" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
		  <td><form:label path="empDept">Department:</form:label></td>
          <td><form:input path="empDept" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
		  <td><form:label path="age">Age:</form:label></td>
          <td><form:input path="age" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3 align="center">Employee Details</h3>
<c:if test="${!empty listOfEmployees}">
	<table class="center">
	<tr>
		<th width="80">ID</th>
		<th width="120">Employee Name</th>
		<th width="120">Salary</th>
		<th width="120">Department</th>
		<th width="120">Age</th>
		<th width="60">Update</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfEmployees}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.empName}</td>
			<td>${employee.salary}</td>
			<td>${employee.empDept}</td>
			<td>${employee.age}</td>
			<td><a href="<c:url value='/updateEmployee/${employee.id}' />" >Update</a></td>
			<td><a href="<c:url value='/deleteEmployee/${employee.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</br>
<hr>
<form:form method="post" modelAttribute="employee" action="${pageContext.request.contextPath}/getById">
	<table class="center">	
	<tr>
			<th colspan="2">Search Employee</th>
		</tr>
	<tr>
		<td><form:label path="id">Enter ID to be Search:</form:label></td>
          <td><form:input path="id" size="30" maxlength="30" ></form:input></td>
    </tr>
    <tr>
    <td colspan="2" align="center">
		<input type="submit" value="View" class="blue-button"/>
		</td>
	</tr>
   </table>	
</form:form>

<h3 align="center">Employee Details</h3>
<c:if test="${!empty list}">
	<table class="center">
	<tr>
		<th width="80">ID</th>
		<th width="120">Employee Name</th>
		<th width="120">Salary</th>
		<th width="120">Department</th>
		<th width="120">Age</th>
	</tr>
	<c:forEach items="${list}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.empName}</td>
			<td>${employee.salary}</td>
			<td>${employee.empDept}</td>
			<td>${employee.age}</td>
			</tr>
	</c:forEach>
	</table>
</c:if>
<c:if test="${!empty error}"></c:if>

</body>
</html>
