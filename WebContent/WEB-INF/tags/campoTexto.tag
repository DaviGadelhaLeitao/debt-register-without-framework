<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="campoName" required="true" %>

<label for="${id}"></label>
<input type="text" name="${campoName}" id="${id}">