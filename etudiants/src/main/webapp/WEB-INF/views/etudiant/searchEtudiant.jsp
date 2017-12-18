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
		<!-- <link rel="icon" type="image/png" href="resources/images/logo.png" /> -->
		<title><spring:message code="etudiant.app.header" text="etudiant.app.header"/></title>
		<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
	</head>
	<body>
		<h2>
			<spring:message code="etudiant.title.search" text="etudiant.title.search" />
		</h2>
		<jsp:include page="../menu.jsp" />
		
		<form:form method="POST" modelAttribute="etudiant" action="${pageContext.request.contextPath }${action }">
			<form:hidden path="id"/>
			<table>
				<tr>
					<td><form:label path="searchField"><spring:message code="etudiant.field.searchField" text="etudiant.field.searchField"/>:&nbsp;</form:label></td>
					<td><form:input path="searchField" cssClass="search"/></td>
					<td><form:errors path="searchField" cssClass="error"/></td>
				</tr>
				<tr>
					<td><form:label path="criteriaSearch"><spring:message code="etudiant.field.criteriaSearch" text="etudiant.field.criteriaSearch"/>:&nbsp;</form:label></td>
					<td>
						<form:select path="criteriaSearch">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${criteriaSearch }" />
						</form:select>
					</td>
					<td><form:errors path="criteriaSearch" cssClass="error"/></td>
				</tr>
				<tr>
					<td>
						<button type="submit" class="button button3">
							<spring:message code="button.search" text="button.search"/>
						</button>
					</td>
				</tr>
			</table>
			<br>
			<c:if test="${not empty listEtudiant }">
				<table id="tabID">
					<tr>
						<th><spring:message code="etudiant.col.numEtd" text="etudiant.col.numEtd"/></th>
						<th><spring:message code="etudiant.col.nom" text="etudiant.col.nom"/></th>
						<th><spring:message code="etudiant.col.prenom" text="etudiant.col.prenom"/></th>
						<th><spring:message code="etudiant.col.createdDate" text="etudiant.col.createdDate"/></th>
						<th><spring:message code="etudiant.col.updatedDate" text="etudiant.col.updatedDate"/></th>
					</tr>
					<c:forEach items="${listEtudiant }" var="etudiant">
						<tr id="${etudiant.id }">
							<td><c:out value="${etudiant.numEtd }" /></td>
							<td><c:out value="${etudiant.nom }" /></td>
							<td><c:out value="${etudiant.prenom }" /></td>
							<td><c:out value="${etudiant.updatedDateString }" /></td>
							<td><c:out value="${etudiant.updatedDateString }" /></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		
		</form:form>
		
	</body>
</html>