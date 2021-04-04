package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.util.internal.StringUtil;

import java.util.Enumeration;

public class ipAddressBacklistHttpRequestFilter implements HttpRequestFilter {

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {

        String ip = getIpAddressFromHttpHeader(fullRequest.headers());
        boolean isMatch = false;
        for(int i=0; i<backlistIpAddress.length ; i++){
            if(backlistIpAddress[i].equals(ip)){
                isMatch = true;
                break;
            }
        }
        if(isMatch){
            fullRequest.headers().set("inBackListIP", "true");
        }
    }

    private String getIpAddressFromHttpHeader(HttpHeaders httpHeaders){
        String ip = httpHeaders.get("x-forwarded-for");

        if(StringUtil.isNullOrEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = httpHeaders.get("Proxy-Client-IP");

        }

        if(StringUtil.isNullOrEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = httpHeaders.get("WL-Proxy-Client-IP");

        }

        if(StringUtil.isNullOrEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = httpHeaders.get("X-Real-IP");

        }
        return ip;
    }

    private static String[] backlistIpAddress = new String[]{
            "10.38.38.438",
            "10.250.250.250",
            "169.169.168.1.1"
    };
}
