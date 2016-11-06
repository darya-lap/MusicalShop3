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
    window.location.href = 'http://localhost:8080/LoginServlet?lang='+l;
}

function goToOrder(l) {
    window.location.href = 'http://localhost:8080/OrderServlet?lang='+l;
}

function goToRecord(l) {
    var a = 'http://localhost:8080/RecordToDBServlet?lang='+l;
    a = a + '&shop=';
    a = a + document.getElementById("selector").value;
    a = a + '&courier=';
    a = a + document.getElementById("ololo").value;
    window.location.href = a;
}

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

function splitString(all){
    var list = all.split(", ");
    return list;
}

function splitString1(all){
    var list = all.split("; ");
    return list;
}

function initMap(lt1,lg1,name1,size,secretMessages1) {
    var map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
        center: {lat:59.987049, lng: 30.312465}
    });

    var lt = splitString(lt1);
    var lg = splitString(lg1);
    var name = splitString(name1);
    var secretMessages = splitString1(secretMessages1);


    for(var i=0; i<size; i++) {
        var myLatLng = {lat: parseFloat(lt[i]), lng: parseFloat(lg[i])};
        var marker = new google.maps.Marker({
            position: myLatLng,
            map:map,
            title: name[i]
        });
        attachSecretMessage(marker, secretMessages[i]);
    }
    return map;
}

function attachSecretMessage(marker, secretMessage) {
    var infowindow = new google.maps.InfoWindow({
        content: secretMessage
    });

    marker.addListener('click', function() {
        infowindow.open(marker.get('map'), marker);
    });
}

function changeDelivery(x,y){
    document.getElementById(x).style.borderColor='#7b0000';
    document.getElementById(x+1).style.display = 'block';
    document.getElementById(y).style.borderColor='#ffe6a9';
    document.getElementById(y+1).style.display = 'none';
}

function changeShop() {
    document.getElementById("usePickUp").innerText = document.getElementById("selector").value;
}

function changeAdress(){
    document.getElementById("useCourier").innerText = document.getElementById("ololo").value;
}


