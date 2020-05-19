<%@ tag pageEncoding="UTF-8" %>
<%@ attribute name="title" required="true" %>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${title}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mediq.css" />
    <jsp:doBody/>
</head>