<%@ page import="com.example.dto.TransferStatus" %>
<%@ page import="com.example.entity.Transaction" %>
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
    <div class="col-8">
        <div class="card">
            <div class="card-header">Transactions</div>
            <div class="card-body">
                <table class="table table-bordered table-stripped">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Date</th>
                        <th>Amount</th>
                        <th>Type</th>
                        <th>Account</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        Iterable<Transaction> transactions = (Iterable<Transaction>) request.getAttribute("transactions");
                        for (Transaction transaction : transactions) {
                    %>
                    <tr>
                        <td><%=transaction.getId()%>
                        </td>
                        <td><%=transaction.getDate()%>
                        </td>
                        <td><%=transaction.getAmount()%>
                        </td>
                        <td><%=transaction.getType()%>
                        </td>
                        <td><%=transaction.getAccount().getNumber()%>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
</html>