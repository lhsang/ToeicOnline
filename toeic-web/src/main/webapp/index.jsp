<a href="simple-servlet"></a>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Java server page</title>
</head>
<body>

<label>Number A</label>
<input type="text" aria-label="A" id="txtA"><br>
<label>Number B</label>
<input type="text" aria-label="B" id="txtB"> <br>
<button id="btnCal" onclick="func();">Calculate</button><br>
<label>Result</label>
<h4 id="ans"></h4>


<script>
    function func() {
        var a=document.getElementById("txtA").value;
        var b=document.getElementById("txtB").value;
        var ans=parseInt(a)+parseInt(b);
        if(isNaN(b)||isNaN(a))
            alert("Input is incorrect");
        else{
            document.getElementById("ans").innerHTML=ans;
        }
    }
</script>
</body>
</html>