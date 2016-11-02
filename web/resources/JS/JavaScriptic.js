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
    setCookie(prmName,val);
    sessionStorage.setItem(prmName,val);
    window.location.href = base + '?' + res;
    return false;
}

function setAttr1(prmName,val){
    var res = '';
    var d = location.href.split("#")[0].split("?");
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
    setCookie(prmName,val);
    sessionStorage.setItem(prmName,val);
    res += prmName + '=' + val;
    window.location.href = 'http://localhost:8080/?' + res;
    return false;
}


function goToDescription(id,l) {
    window.location.href = 'http://localhost:8080/InstrumentDetailsServlet?id='+id.toString()+'&lang='+l;
    return false;
}

function goToBucket(l) {
    window.location.href = 'http://localhost:8080/resources/JSP/bucket.jsp?lang='+l;
}

function goToAuth(l) {
    window.location.href = 'http://localhost:8080/resources/JSP/myAccount.jsp?lang='+l;
}

/*function addToBucket(id) {
    if ((document.getElementById("amount"+id).value != null) && (document.getElementById("amount"+id).value != "0")) {
        var s = getCookies();
        document.getElementById('miniAm').style.display = 'block';
        setCookie("displaying", "block",{expires:120});
        var amount = getCookie("amount");
        var a = parseInt(document.getElementById("amount"+id).value);
        if (amount != null){
            a = a + parseInt(amount);
        }
        document.getElementById("miniAm").innerText = a.toString();
        setCookie("amount",a.toString(),{expires:120});
        var am = getCookie("amount"+id);
        a = parseInt(document.getElementById("amount"+id).value);
        if (am != null){
            a = a + parseInt(am);
        }
        document.getElementById("amount"+id).value = "0";
        setCookie("amount"+id,a.toString(),{expires:120});
        s = getCookies();
    }
}

function deleteFromBucket(id) {
        var s = getCookies();
        setCookie("displaying", "block");
        var amount = getCookie("amount");
        var a = getCookie("amount"+id);
        if (amount != null){
            amount = parseInt(amount) - a;
        }
        document.getElementById("miniAm").innerText = amount.toString();
        setCookie("amount",amount.toString());
        setCookie("amount"+id,"",{expires:-1})
        document.getElementById("amount"+id).value = "0";
        setCookie("amount"+id,a.toString());
        s = getCookies();
}

function addToBucket1(id) {
        var s = getCookies();
        document.getElementById('miniAm').style.display = 'block';
        setCookie("displaying", "block",{expires:120});
        var amount = getCookie("amount");
        var a = 1;
        if (amount != null){
            a = a + parseInt(amount);
        }
        document.getElementById("miniAm").innerText = a.toString();
        setCookie("amount",a.toString(),{expires:120});
        var am = getCookie("amount"+id);
        a = 1;
        if (am != null){
            a = a + parseInt(am);
        }
        setCookie("amount"+id,a.toString(),{expires:120});
        s = getCookies();

}
*/
function getCookie (name) {
    var cookies = getCookies();
    return cookies[name] || null;
}

/*function setCookie(name, value) {
    document.cookie = name + "=" + value;
}*/



function setCookie(name, value, options) {
    options = options || {};

    var expires = options.expires;

    if (typeof expires == "number" && expires) {
        var d = new Date();
        d.setTime(d.getTime() + expires * 1000);
        expires = options.expires = d;
    }
    if (expires && expires.toUTCString) {
        options.expires = expires.toUTCString();
    }

    value = encodeURIComponent(value);

    var updatedCookie = name + "=" + value;

    for (var propName in options) {
        updatedCookie += "; " + propName;
        var propValue = options[propName];
        if (propValue !== true) {
            updatedCookie += "=" + propValue;
        }
    }

    document.cookie = updatedCookie;
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


