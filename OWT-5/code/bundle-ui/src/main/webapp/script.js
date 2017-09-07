var SERVICE_URL = '/cxf/api/echo/';


function sendMessage() {
    var message = $('#message-input').val();
    if ($.trim(message).length == 0) {
        return;
    }
    addUserMessageToLog(message);
    callService(message);
}

function addUserMessageToLog(message) {
    addMessageToLog(message, 'message-log-item-user', 'User')
    $('#message-input').val('');
    scrollToMessagesBottom();
}

function addEchoMessageToLog(message) {
    addMessageToLog(message, 'message-log-item-echo', 'Echo')
    scrollToMessagesBottom();
}

function addMessageToLog(message, messageCssClass, messageSender) {
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


    messageLogItemRow2.text(message);
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

function callService(message) {
    var data = new Object();
    data.message = message;
    $.ajax({
        url: SERVICE_URL,
        method: 'POST',
        data: JSON.stringify(data),
        contentType: 'application/json; charset=utf-8'
    }).done(function (response) {
        addEchoMessageToLog(response.message);
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