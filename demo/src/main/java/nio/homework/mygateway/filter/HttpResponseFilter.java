package nio.homework.mygateway.filter;
import io.netty.channel.ChannelHandlerContext;

import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResponseFilter {
    void filter(FullHttpResponse fullHttpResponse);
}
