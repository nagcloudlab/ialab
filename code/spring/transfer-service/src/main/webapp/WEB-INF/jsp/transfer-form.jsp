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
            <div class="card-header">Transfer Form</div>
            <div class="card-body">
                <form action="transfer" method="post">
                    <div class="form-group">
                        <label class="form-control-label" for="amount">Amount</label>
                        <input type="text" class="form-control" id="amount" placeholder="Amount" name="amount"/>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" for="source">Source</label>
                        <input type="text" class="form-control" id="source" placeholder="Source" name="source"/>
                    </div>
                    <div class="form-group">
                        <label class="form-control-label" for="destination">Destination</label>
                        <input type="text" class="form-control" id="destination" placeholder="Destination" name="destination"/>
                    </div>
                    <hr/>
                    <button type="submit" class="btn btn-primary">Transfer</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>