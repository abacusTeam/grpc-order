import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import server.OrderServiceImpl;

import java.io.IOException;
import java.util.Objects;

/**
 * @author ubektas
 */

public class ApplicationServer {
    private Server server;
    private int port = 8087;

    private void start() throws Exception {
        server = NettyServerBuilder.forPort(port).addService(new OrderServiceImpl()).build();
        server.start();
        server.awaitTermination();
    }

    private void stop() {
        if (!Objects.isNull(server)) {
            server.shutdown();
        }
    }


    public static void main(String[] args) throws Exception {
        final ApplicationServer applicationServer = new ApplicationServer();
        applicationServer.start();
    }
}
