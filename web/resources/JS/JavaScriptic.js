function show1(){
    document.getElementById('desc').style.display = 'block';
    document.getElementById('descfull').style.display = 'none';
    document.getElementById('reviews').style.display = 'none';
    document.getElementById('sh1').style.borderColor = '#ffe6a9';
    document.getElementById('sh2').style.borderColor = 'gray';
    document.getElementById('sh3').style.borderColor = 'gray';
}

function show2(){
    document.getElementById('desc').style.display = 'none';
    document.getElementById('descfull').style.display = 'block';
    document.getElementById('reviews').style.display = 'none';
    document.getElementById('sh1').style.borderColor = 'gray';
    document.getElementById('sh2').style.borderColor = '#ffe6a9';
    document.getElementById('sh3').style.borderColor = 'gray';
}

function show3(){
    document.getElementById('desc').style.display = 'none';
    document.getElementById('descfull').style.display = 'none';
    document.getElementById('reviews').style.display = 'block';
    document.getElementById('sh1').style.borderColor = 'gray';
    document.getElementById('sh2').style.borderColor = 'gray';
    document.getElementById('sh3').style.borderColor = '#ffe6a9';
}

/*function ChangeFilter(val){


    var value = val;
    var loc = window.location.href.toString();
    var i = loc.indexOf("?filter=");
    if (i == null){
        window.location.href=loc + '?filter='+value;
    }
    else{
        var s1 = loc.substring(0,i+7);
        var s2 = loc.substring(i+8,loc.length);
        window.location.href=s1+value+s2;
    }
}*/

function setAttr(prmName,val){
    var res = '';
    var d = location.href.split("#")[0].split("?");
    var base = d[0];
    var query = d[1];
    if(query) {
        var params = query.split("&");
        for(var i = 0; i < params.length; i++) {
            var keyval = params[i].split("=");
            if(keyval[0] != prmName) {
                res += params[i] + '&';
            }
        }
    }
    res += prmName + '=' + val;
    window.location.href = base + '?' + res;
    return false;
}

function setAttr1(prmName,val){
    var res = '';
    var d = location.href.split("#")[0].split("?");
    var base = d[0];
    var query = d[1];
    if(query) {
        var params = query.split("&");
        for(var i = 0; i < params.length; i++) {
            var keyval = params[i].split("=");
            if(keyval[0] != prmName) {
                res += params[i] + '&';
            }
        }
    }
    res += prmName + '=' + val;
    window.location.href = 'http://localhost:8080/?' + res;
    return false;
}

function goToDescription(id) {
    window.location.href = 'http://localhost:8080/InstrumentDetailsServlet?id='+id.toString();
    return false;
}

function goToBucket(){
    window.location.href = 'http://localhost:8080/resources/JSP/bucket.jsp';
    return false;
}

function changeTheAmountOfInstruments(id) {

    var val = parseInt(document.getElementById("amount"+id).value.toString());
    sessionStorage.setItem("amount"+id,val);

    var temp=sessionStorage.getItem("amount"+id).toString();
    temp=temp;
}

function addToBucket(id) {

    var bucket = sessionStorage.getItem("bucket");
    if ((sessionStorage.getItem("amount" + id) != null) && (sessionStorage.getItem("amount"+id) != 0)){
        if (bucket == null) {
            sessionStorage.setItem("bucket", id.toString() + "," + sessionStorage.getItem("amount" + id).toString() + ";");
        }
        else {
            sessionStorage.setItem("bucket", bucket + id.toString() + "," + sessionStorage.getItem("amount" + id).toString() + ";");
        }

        var amount = sessionStorage.getItem("amount");
        var newAmount;
        if (amount == null) {
            newAmount = parseInt(sessionStorage.getItem("amount" + id).toString());
            sessionStorage.setItem("isEmptyBucket", "notempty");
        }
        else
            newAmount = parseInt(sessionStorage.getItem("amount"))+ parseInt(sessionStorage.getItem("amount" + id).toString());
        amount = amount;
        sessionStorage.setItem("amount",newAmount);
        document.getElementById("amount"+id).value="0";
        document.getElementById('miniAm').style.display='block';
        document.getElementById('miniAm').innerText=newAmount;
    }

    var temp=sessionStorage.getItem("bucket").toString();
    temp=sessionStorage.getItem("amount");
    temp=temp;
}



