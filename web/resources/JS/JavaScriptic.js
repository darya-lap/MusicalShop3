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

function setAttr2(prmName,val){
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
    return false;
}

function goToDescription(id) {
    window.location.href = 'http://localhost:8080/InstrumentDetailsServlet?id='+id.toString();
    return false;
}

function addToBucket(id) {
    if ((document.getElementById("amount"+id).value != null) && (document.getElementById("amount"+id).value != "0")) {
        var s = getCookies();
        document.getElementById('miniAm').style.display = 'block';
        setCookie("displaying", "block");
        var amount = getCookie("amount");
        var a = parseInt(document.getElementById("amount"+id).value);
        if (amount != null){
            a = a + parseInt(amount);
        }
        document.getElementById("miniAm").innerText = a.toString();
        setCookie("amount",a.toString());
        var am = getCookie("amount"+id);
        a = parseInt(document.getElementById("amount"+id).value);
        if (am != null){
            a = a + parseInt(am);
        }
        document.getElementById("amount"+id).value = "0";
        setCookie("amount"+id,a.toString());
        s = getCookies();
    }
}

function getCookie (name) {
    var cookies = getCookies();
    return cookies[name] || null;
}

function setCookie(name, value) {
    document.cookie = name + "=" + value;
}

function getCookies() {
    var cookies = {}; // Возвращаемый объект
    var all = document.cookie; // Получить все cookies в одной строке
    if (all === "") // Если получена пустая строка,
        return cookies; // вернуть пустой объект
    var list = all.split("; "); // Разбить на пары имя/значение
    for(var i = 0; i < list.length; i++) { // Для каждого cookie
        var cookie = list[i];
        var p = cookie.indexOf("="); // Отыскать первый знак =
        var name = cookie.substring(0,p); // Получить имя cookie
        var value = cookie.substring(p+1); // Получить значение cookie
        value = decodeURIComponent(value); // Декодировать значение
        cookies[name] = value; // Сохранить имя и значение в объекте
    }
    return cookies;
}


