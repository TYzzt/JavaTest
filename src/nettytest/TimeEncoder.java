package nettytest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/1/21
 * \* Time: 16:30
 * \* Description:
 * \
 */
public class TimeEncoder extends ChannelOutboundHandlerAdapter {
    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) {
        UnixTime m = (UnixTime) msg;
        ByteBuf encoded = ctx.alloc().buffer(4);
        encoded.writeInt((int) m.value());
        ctx.write(encoded, promise); // (1)
    }


//    public class TimeEncoder extends MessageToByteEncoder<UnixTime> {
//        @Override
//        protected void encode(ChannelHandlerContext ctx, UnixTime msg, ByteBuf out) {
//            out.writeInt((int)msg.value());
//        }
//    }
}