/*
 * Automatically generated by jrpcgen 1.0.7 on 12/19/23, 5:46 PM
 * jrpcgen is part of the "Remote Tea" ONC/RPC package for Java
 * See http://remotetea.sourceforge.net for details
 */
import org.acplt.oncrpc.*;
import java.io.IOException;

import java.net.InetAddress;

/**
 * The class <code>acsClient</code> implements the client stub proxy
 * for the FTP remote program. It provides method stubs
 * which, when called, in turn call the appropriate remote method (procedure).
 */
public class acsClient extends OncRpcClientStub {

    /**
     * Constructs a <code>acsClient</code> client stub proxy object
     * from which the FTP remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public acsClient(InetAddress host, int protocol)
           throws OncRpcException, IOException {
        super(host, acs.FTP, 1, 0, protocol);
    }

    /**
     * Constructs a <code>acsClient</code> client stub proxy object
     * from which the FTP remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param port Port number at host where the remote program can be reached.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public acsClient(InetAddress host, int port, int protocol)
           throws OncRpcException, IOException {
        super(host, acs.FTP, 1, port, protocol);
    }

    /**
     * Constructs a <code>acsClient</code> client stub proxy object
     * from which the FTP remote program can be accessed.
     * @param client ONC/RPC client connection object implementing a particular
     *   protocol.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public acsClient(OncRpcClient client)
           throws OncRpcException, IOException {
        super(client);
    }

    /**
     * Constructs a <code>acsClient</code> client stub proxy object
     * from which the FTP remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param program Remote program number.
     * @param version Remote program version number.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public acsClient(InetAddress host, int program, int version, int protocol)
           throws OncRpcException, IOException {
        super(host, program, version, 0, protocol);
    }

    /**
     * Constructs a <code>acsClient</code> client stub proxy object
     * from which the FTP remote program can be accessed.
     * @param host Internet address of host where to contact the remote program.
     * @param program Remote program number.
     * @param version Remote program version number.
     * @param port Port number at host where the remote program can be reached.
     * @param protocol {@link org.acplt.oncrpc.OncRpcProtocols Protocol} to be
     *   used for ONC/RPC calls.
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public acsClient(InetAddress host, int program, int version, int port, int protocol)
           throws OncRpcException, IOException {
        super(host, program, version, port, protocol);
    }

    /**
     * Call remote procedure read_file_1.
     * @param file_name parameter (of type String) to the remote procedure call.
     * @return Result from remote procedure call (of type response).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public response read_file_1(String file_name)
           throws OncRpcException, IOException {
        XdrString args$ = new XdrString(file_name);
        response result$ = new response();
        client.call(acs.read_file_1, acs.V1, args$, result$);
        return result$;
    }

    /**
     * Call remote procedure write_1.
     * @param file_name parameter (of type String) to the remote procedure call.
     * @param content_file parameter (of type String) to the remote procedure call.
     * @return Result from remote procedure call (of type response).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public response write_1(String file_name, String content_file)
           throws OncRpcException, IOException {
        class XdrAble$ implements XdrAble {
            public String file_name;
            public String content_file;
            public void xdrEncode(XdrEncodingStream xdr)
                throws OncRpcException, IOException {
                xdr.xdrEncodeString(file_name);
                xdr.xdrEncodeString(content_file);
            }
            public void xdrDecode(XdrDecodingStream xdr)
                throws OncRpcException, IOException {
            }
        };
        XdrAble$ args$ = new XdrAble$();
        args$.file_name = file_name;
        args$.content_file = content_file;
        response result$ = new response();
        client.call(acs.write_1, acs.V1, args$, result$);
        return result$;
    }

    /**
     * Call remote procedure delete_1.
     * @param file_name parameter (of type String) to the remote procedure call.
     * @return Result from remote procedure call (of type response).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public response delete_1(String file_name)
           throws OncRpcException, IOException {
        XdrString args$ = new XdrString(file_name);
        response result$ = new response();
        client.call(acs.delete_1, acs.V1, args$, result$);
        return result$;
    }

    /**
     * Call remote procedure list_1.
     * @param dire_name parameter (of type String) to the remote procedure call.
     * @return Result from remote procedure call (of type response).
     * @throws OncRpcException if an ONC/RPC error occurs.
     * @throws IOException if an I/O error occurs.
     */
    public response list_1(String dire_name)
           throws OncRpcException, IOException {
        XdrString args$ = new XdrString(dire_name);
        response result$ = new response();
        client.call(acs.list_1, acs.V1, args$, result$);
        return result$;
    }

}
// End of acsClient.java
