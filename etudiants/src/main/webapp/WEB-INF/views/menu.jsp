<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:if test="${not empty error }">
	<span class="margin error">${error }</span><br><br>
</c:if>
<c:if test="${not empty warning }">
	<span class="margin warning">${warning }</span><br><br>
</c:if>
<c:if test="${not empty message }">
	<span class="margin message">${message }</span><br><br>
</c:if>

<div style="margin-left: 20px; font-weight: bold;">
	<spring:message code="title.menu" text="title.menu"/>&nbsp;&nbsp;>>>&nbsp;&nbsp;
	<a href="<c:url value='/listEtudiant'/>"><spring:message code="etudiant.menu.list.etd" text="etudiant.menu.list.etd"/></a>&nbsp;&nbsp;&nbsp;
	<a href="<c:url value='/addFormEtudiant'/>"><spring:message code="etudiant.menu.form.etd" text="etudiant.menu.form.etd"/></a>&nbsp;&nbsp;&nbsp;
</div>
<br>