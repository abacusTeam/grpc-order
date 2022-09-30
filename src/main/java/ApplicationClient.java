import com.grpc.deneme.OrderRequest;
import com.grpc.deneme.OrderResponse;
import com.grpc.deneme.OrderServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author ubektas
 */
public class ApplicationClient {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8087)
                .usePlaintext().build();
        OrderServiceGrpc.OrderServiceBlockingStub  orderServiceBlockingStub = OrderServiceGrpc.newBlockingStub(managedChannel);


        OrderRequest  orderRequest = OrderRequest.newBuilder().setEmail("ubektas@x.com").setProduct("denemeProduct").setAmount(100).build();

        OrderResponse orderResponse = orderServiceBlockingStub.executeOrder(orderRequest);

        System.out.println("Received Response:"+ orderResponse.getInfo());

        managedChannel.shutdown();



    }
}
