<%@ page import="com.example.dto.TransferStatus" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">

</head>
<body class="container">

<div class="display-1"> transfer service</div>
<hr/>
<div class="row">
    <div class="col-6">
        <div class="card">
            <div class="card-header">Transfer Status</div>
            <div class="card-body">
                <%
                    TransferStatus status = (TransferStatus) request.getAttribute("status");
                %>
                <div class="display-3"><%=status.getStatus()%>
                </div>
                <hr/>
                <div><%=status.getTxnId()%>
                </div>
            </div>
        </div>


</body>
</html>