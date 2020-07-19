package com.myselfRule;


import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;


public class RandomRule_ZH extends AbstractLoadBalancerRule {


    //total=0，当total=5以后，指针才往下走
    //index=0，当前服务器提供的服务器地址
    //total需要重置为零。如果total已经达到一个5次，index要+1
    private int total = 0; //总共调用的次数，要求每台服务器调用5次
    private int currentIndex = 0; //当前服务器提供的机器号

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }

        Server server = null;
        int count = 0;
        while (server == null && count++ < 10) {
            List<Server> reachableServers = lb.getReachableServers();
            List<Server> allServers = lb.getAllServers();
            int upCount = reachableServers.size();
            int serverCount = allServers.size();

            if ((upCount == 0) || (serverCount == 0)) {
                return null;
            }

            //total=0，当total=5以后，指针才往下走
            //index=0，当前服务器提供的服务器地址
            //total需要重置为零。如果total已经达到一个5次，index要+1
            //private int total = 0; 总共调用的次数，要求每台服务器调用5次
            //private int currentIndex = 0; 当前服务器提供的机器号
            if(total < 5){
                server = reachableServers.get(currentIndex);
                total++;
            }else {
                total = 0;
                currentIndex++;
                if(currentIndex > reachableServers.size()){
                    currentIndex = 0;
                }
            }

            if (server == null) {
                /* Transient. */
                Thread.yield();
                continue;
            }

            if (server.isAlive() && (server.isReadyToServe())) {
                return (server);
            }

            // Next.
            server = null;
        }

        if (count >= 10) {

        }
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
