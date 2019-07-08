package nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/1/21
 * \* Time: 11:00
 * \* Description:
 * \
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

    private ByteBuf buf;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {

    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        ByteBuf in = (ByteBuf) msg;
//        try {
//            while (in.isReadable()) { // (1)
//                System.out.print((char) in.readByte());
//                System.out.flush();
//            }
//        } finally {
////            ReferenceCountUtil.release(msg); // (2)
//        }
        in.retain();
        System.out.print(in.toString(CharsetUtil.UTF_8));
        ctx.write(in);
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}