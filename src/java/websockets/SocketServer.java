package websockets;

import java.util.ArrayList;
import java.util.List;
import org.glassfish.grizzly.http.HttpRequestPacket;
import org.glassfish.grizzly.websockets.DataFrame;
import org.glassfish.grizzly.websockets.WebSocket;
import org.glassfish.grizzly.websockets.WebSocketApplication;

public class SocketServer extends WebSocketApplication {

    private final List<WebSocket> sockets = new ArrayList<WebSocket>();

    //==========================================================================
    public SocketServer() {
        System.out.println("construct socketServer");
    }

    //==========================================================================
    @Override
    public boolean isApplicationRequest(HttpRequestPacket hrp) {
        return true;
    }

    //==========================================================================
    @Override
    public void onConnect(WebSocket socket) {
        System.out.println("onConnect " + socket.toString());
        sockets.add(socket);
    }

    //==========================================================================
    @Override
    public void onClose(WebSocket socket, DataFrame frame) {
        System.out.println("onClose " + socket.toString());
        sockets.remove(socket);
    }

    //==========================================================================
    @Override
    public void onMessage(WebSocket socket, String text) {
        System.out.println("onMessage " + text);
        for (WebSocket s : sockets) {
            s.send(text);
        }
    }

    //==========================================================================
    public List<WebSocket> getSockets() {
        return sockets;
    }
} // end class