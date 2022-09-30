import io.grpc.Server;
import io.grpc.ServerBuilder;
import server.OrderServiceImpl;

import java.io.IOException;

/**
 * @author ubektas
 */
public class ApplicationServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8087).addService(new OrderServiceImpl()).build();
        server.start();
        server.awaitTermination();
    }
}
