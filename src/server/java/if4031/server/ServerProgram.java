package if4031.server;

import if4031.common.IRCServiceGrpc;
import if4031.server.config.ServerConfiguration;
import if4031.server.rpc.IRCServiceGrpcImpl;
import io.grpc.ServerImpl;
import io.grpc.netty.NettyServerBuilder;

import java.io.IOException;

/**
 * Created by nim_13512065 on 9/27/15.
 */
public class ServerProgram {
    private static final String PROPERTY_FILE = "/server.properties";

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerImpl server;
//        ServerConfiguration configuration = new ServerConfiguration(PROPERTY_FILE);
//        String serverAddress = configuration.getString("serverAddress");
//        int port = configuration.getInt("serverPort");
        String serverAddress = "localhost";
        int port = 9090;
        server = NettyServerBuilder.forPort(port)
                .addService(IRCServiceGrpc.bindService(new IRCServiceGrpcImpl()))
                        .build().start();
        System.out.println("running");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may has been reset by its JVM shutdown hook.
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                System.err.println("*** server shut down");
            }
        });
    }

}
