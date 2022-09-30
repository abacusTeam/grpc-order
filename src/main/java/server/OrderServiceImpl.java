package server;

import com.grpc.deneme.Order;
import com.grpc.deneme.OrderRequest;
import com.grpc.deneme.OrderResponse;

/**
 * @author ubektas
 */
public class OrderServiceImpl extends com.grpc.deneme.OrderServiceGrpc.OrderServiceImplBase {

    @Override
    public void executeOrder(com.grpc.deneme.OrderRequest request,
                             io.grpc.stub.StreamObserver<com.grpc.deneme.OrderResponse> responseObserver) {

        OrderResponse response = OrderResponse.newBuilder()
                .setInfo("Hi " + request.getEmail() + ", you order has been executed")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
