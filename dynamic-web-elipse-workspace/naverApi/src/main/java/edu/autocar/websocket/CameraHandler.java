package edu.autocar.websocket;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

public class CameraHandler extends BinaryWebSocketHandler {
	Map<Integer, List<WebSocketSession>> cameramap = Collections.synchronizedMap(new HashMap<>());

	@Override
	protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
		System.out.println("수신된 메세지" + message);
		ByteBuffer rcvMsg = message.getPayload(); 
	}
}
