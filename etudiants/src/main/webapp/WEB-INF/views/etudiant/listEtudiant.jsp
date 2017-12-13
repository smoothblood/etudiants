<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
		<!-- <link rel="icon" type="image/png" href="logo.png" /> -->
		<title><spring:message code="etudiant.app.header" text="etudiant.app.header"/></title>
		<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
		
	</head>
	<body>
		<h2>
			<spring:message code="etudiant.title.list" text="etudiant.title.list" />
		</h2>
		<jsp:include page="../menu.jsp" />
		
		<table id="tabID">
			<tr>
				<th><spring:message code="etudiant.col.numEtd" text="etudiant.col.numEtd"/></th>
				<th><spring:message code="etudiant.col.nom" text="etudiant.col.nom"/></th>
				<th><spring:message code="etudiant.col.prenom" text="etudiant.col.prenom"/></th>
				<th><spring:message code="etudiant.col.createdDate" text="etudiant.col.createdDate"/></th>
				<th><spring:message code="etudiant.col.updatedDate" text="etudiant.col.updatedDate"/></th>
				<th><spring:message code="etudiant.col.action" text="etudiant.col.action"/></th>
			</tr>
			<c:forEach items="${listEtudiant }" var="etudiant">
				<tr id="${etudiant.id }">
					<td><c:out value="${etudiant.numEtd }" /></td>
					<td><c:out value="${etudiant.nom }" /></td>
					<td><c:out value="${etudiant.prenom }" /></td>
					<td><c:out value="${etudiant.updatedDateString }" /></td>
					<td><c:out value="${etudiant.updatedDateString }" /></td>
					<td>
						<a class="update" href="<c:url value='/updateEtudiant/${etudiant.numEtd }'/>">EDIT</a>&nbsp;&nbsp;
						<a class="delete" href="<c:url value='/deleteEtudiant/${etudiant.numEtd }'/>">SUPP</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>