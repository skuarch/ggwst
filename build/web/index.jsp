 
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript">

        ws = new WebSocket("ws://192.168.208.9:8080/ggwst/servletWebSocket");
        ws.onopen = function(e) {
            var resultAreaObj = document.getElementById('result');
            resultAreaObj.innerHTML += '<span class="log">socket open</span>' + '<br>'
        };
        ws.onclose = function(e) {
            var resultAreaObj = document.getElementById('result');
            resultAreaObj.innerHTML += '<span class="log">socket close</span>' + '<br>'
        };
        ws.onmessage = function(e) {
            var resultAreaObj = document.getElementById('result');
            resultAreaObj.innerHTML += e.data + '<br>'
        };
        ws.onerror = function(e1) {
            var resultAreaObj = document.getElementById('result');
            resultAreaObj.innerHTML += '<span class="log">error</span>' + '<br>'
        };
        send = function() {
            var textFieldObj = document.getElementById('textField');
            var data = textFieldObj.value;
            if (data) {
                ws.send(data);
                textFieldObj.value = '';
            }
        };

    </script>

    <body>

        <input type="text" name="textField" id="textField" size="50"/>
        <input type="button" id="send" value="send" onclick="send();"/>

        <hr/>

        <div id="result">
        </div>

    <body>
</html>