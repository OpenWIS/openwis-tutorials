//var SERVICE_URL = 'https://jsonplaceholder.typicode.com/posts/';
var SERVICE_URL = 'http://localhost:8181/cxf/api/echo/';


function sendMessage() {
    var messageText = $('#message-input').val();
    if ($.trim(messageText).length == 0) {
        return;
    }
    addUserMessageToLog(messageText);
    callService();
}

function addUserMessageToLog(messageText) {
    addMessageToLog(messageText, 'message-log-item-user', 'User')
    $('#message-input').val('');
    scrollToMessagesBottom();
}

function addEchoMessageToLog(messageText) {
    addMessageToLog(messageText, 'message-log-item-echo', 'Echo')
    scrollToMessagesBottom();
}

function addMessageToLog(messageText, messageCssClass, messageSender) {
    var messageLogItem = $('<div></div>');
    var messageLogItemRow1 = $('<div></div>');
    var messageLogItemRow2 = $('<div></div>');

    var messageLogItemWho = $('<span></span>').addClass('message-log-who');
    messageLogItemWho.text(messageSender);

    var messageLogItemWhen = $('<span></span>');
    messageLogItemWhen.text(getWhen());

    messageLogItemRow1.append(messageLogItemWho);
    messageLogItemRow1.append(messageLogItemWhen);
    messageLogItem.append(messageLogItemRow1);


    messageLogItemRow2.text(messageText);
    messageLogItem.append(messageLogItemRow2);

    messageLogItem.addClass(messageCssClass);
    $('#message-log').append(messageLogItem);
}

function getWhen() {
    return new Date().toLocaleTimeString();
}

function scrollToMessagesBottom() {
    $('#message-log').animate({ scrollTop: $('#message-log').prop('scrollHeight') }, 10);
}

function callService() {
    $.ajax({
        url: SERVICE_URL,
        method: 'POST'        
    }).done(function (data) {
        addEchoMessageToLog(JSON.stringify(data));
    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ", " + jqxhr.responseText;
        alert("Request Failed: " + err);
    });
}

$(document).ready(function () {
    $('#send').click(function () {
        sendMessage();
    });

    $('#message-input').keyup(function (e) {
        if (e.keyCode == 13) {
            sendMessage();
        }
    });
});