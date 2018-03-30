package com.taiji.eap.common.websocket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * @author 潘宏智
 * @date
 */
public class WebsocketEndPoint extends TextWebSocketHandler{

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");
        session.sendMessage(returnMessage);
    }
}
