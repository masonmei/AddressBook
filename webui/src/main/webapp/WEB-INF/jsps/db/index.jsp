<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<p>These are the database queries you can perform:</p>
<ul>
    <li><a href="${ctx}/db/events">All Events</a></li>
    <li><a href="${ctx}/db/claimed">Claimed Names</a></li>
</ul>