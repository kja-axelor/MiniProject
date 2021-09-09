<%@page import="javax.persistence.Query"%>
<%@page import="com.google.inject.persist.Transactional"%>
<%@page import="Database.Student"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="com.google.inject.Provider"%>
<%@page import="com.google.inject.Inject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  
  
  <%
class Show{
	
	@Inject
	Provider<EntityManager> emp;
	
	@Transactional
	public void showStudent() {
		
		EntityManager em = emp.get();
		Query q = em.createQuery("from Student");
		@SuppressWarnings("unchecked")
		List<Student> list = q.getResultList();


%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Records</title>
</head>
<body>
<table>
<tr>
<th>ID </th>
<th>Name </th>
</tr>
<%  
for(Student s: list ){
	

%>
<tr>
<td>out.print(s.getId());</td>
<td>out.print(s.getName())</td>
</tr>
<%}%>

</table>
</body>
</html>
<%}} %>
