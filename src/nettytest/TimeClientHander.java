package nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/1/21
 * \* Time: 15:49
 * \* Description:
 * \
 */
public class TimeClientHander extends ChannelInboundHandlerAdapter {
    private ByteBuf buf;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        buf = ctx.alloc().buffer(4);
    }

    public void handlerRemoved(ChannelHandlerContext ctx) {
        buf.release();
        buf = null;
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)

        UnixTime m = (UnixTime) msg;
        System.out.println(m);
        ctx.close();

//        ByteBuf m = (ByteBuf) msg;
//        buf.writeBytes(m);
//        if (buf.readableBytes() >= 4) {
//            long currenttime = (buf.readUnsignedInt() ) * 1000L;
//            System.out.println(new Date(currenttime));
//            ctx.close();
//        }else {
//            System.out.println("continue:"+m.toString());
//        }
//        m.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}