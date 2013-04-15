package websockets;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.glassfish.grizzly.websockets.WebSocketEngine;

/**
 *
 * @author skuarch
 */
public class servletWebSocket extends HttpServlet {

    private SocketServer socketServer = new SocketServer();

    //==========================================================================
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet");
        WebSocketEngine.getEngine().register(socketServer);
    }

    //==========================================================================
    @Override
    public void init() throws ServletException {
        System.out.println("servlet");
        WebSocketEngine.getEngine().register(socketServer);
    }
    
}
