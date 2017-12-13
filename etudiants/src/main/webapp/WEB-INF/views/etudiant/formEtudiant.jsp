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
			<spring:message code="etudiant.title.form" text="etudiant.title.form" />
		</h2>
		<jsp:include page="../menu.jsp" />
		
		<h3>
			<c:choose>
				<c:when test="${edit }">
					<spring:message code="etudiant.title.update" text="etudiant.title.update" />
				</c:when>
				<c:otherwise>
					<spring:message code="etudiant.title.add" text="etudiant.title.add" />
				</c:otherwise>
			</c:choose>
		</h3>
		
		<form:form method="POST" modelAttribute="etudiant">
			<form:hidden path="id"/>
			<table>
				<tr>
					<td><form:label path="numEtd"><spring:message code="etudiant.col.numEtd" text="etudiant.col.numEtd"/>:&nbsp;</form:label></td>
					<td><form:input path="numEtd" readonly="${edit }"/></td>
					<td><form:errors path="numEtd"/></td>
				</tr>
				<tr>
					<td><form:label path="nom"><spring:message code="etudiant.col.nom" text="etudiant.col.nom"/>:&nbsp;</form:label></td>
					<td><form:input path="nom" /></td>
					<td><form:errors path="nom"/></td>
				</tr>
				<tr>
					<td><form:label path="prenom"><spring:message code="etudiant.col.prenom" text="etudiant.col.prenom"/>:&nbsp;</form:label></td>
					<td><form:input path="prenom" /></td>
					<td><form:errors path="prenom" cssClass="error"/></td>
				</tr>
				<tr>
					<td>
						<button type="submit" class="button button1">
							<c:choose>
								<c:when test="${edit }">
									<spring:message code="button.update" text="button.update"/>
								</c:when>
								<c:otherwise>
									<spring:message code="button.save" text="button.save"/>
								</c:otherwise>
							</c:choose>
						</button>
					</td>
				</tr>
			</table>
		
		</form:form>
		
	</body>
</html>