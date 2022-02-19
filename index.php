<?php

include_once("config.php");
$sql = mysqli_query($mysqli, "SELECT * FROM trxhistory");
?>
 
<html>
<head>    
    <title>Transaction History</title>
    <style type="text/css">
        .success-title{
            text-align: center;
            font-size: 30px;
        }
        .trx-id-table{
            text-align: center;
            margin-left: auto;
            margin-right: auto;
            width: 30%;
            height: 10%;
        }
        .receipt{

            display: inline-block;
            text-align: left;

        }
        .trxhistory-table{
            margin-left: auto;
            margin-right: auto;
            margin-top: 50px;
        }
    </style>
</head>
 
<body>

    <p class="success-title">Transaction Successful!<p>
    <table class="trx-id-table" border="1">
        <tr>
            <td>Transaction ID : 01023A9AC</td>
        </tr>
    </table>
    <div style="text-align: center;">
        <div class="receipt">
            <p class="seller-name">Seller: Furhan</p>
            <p class="delivery_service">Delivery Service: TIKI</p>
            <p class="date-order">Date Order: 21/08/2016</p>
            <p class="address-shipment">Address Shipment: KAMPUNG DATOK KERAMAT</p>    
        </div>
    </div>
    <table class="trxhistory-table" width='80%' border=1>
    <tr>
        <th>TRX_ID</th>
        <th>ADDRESS_SHIP</th>
        <th>DATE_ORDER</th>
        <th>SELLER_NAME</th>
        <th>DELIVERY_SERVICE</th>
    </tr>
    <?php  
    while($user_data = mysqli_fetch_array($sql)) {         
        echo "<tr>";
        echo "<td>".$user_data['trx_id']."</td>";
        echo "<td>".$user_data['address_ship']."</td>";
        echo "<td>".$user_data['date_order']."</td>"; 
        echo "<td>".$user_data['seller_name']."</td>"; 
        echo "<td>".$user_data['delivery_service']."</td>";    
    }
    ?>
    </table>
</body>
</html>
 