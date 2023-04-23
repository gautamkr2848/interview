package com.interview.systemDesign;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LoadBalancer {

        public static List<String> servers = new ArrayList<>();

        static {
            servers.add("192.168.1.1");
            servers.add("192.168.1.2");
            servers.add("192.168.1.3");
            servers.add("192.168.1.4");
            servers.add("192.168.1.5");
            servers.add("192.168.1.6");
            servers.add("192.168.1.7");
            servers.add("192.168.1.8");
            servers.add("192.168.1.9");
            servers.add("192.168.1.10");
        }

}

interface LoadBalance {
    String getServer(String clientIp);
}

class RoundRobin implements LoadBalance {
    private static Integer position = 0;

    @Override
    public String getServer(String clientIp) {
        String target = null;

        synchronized (position) {
            if (position > LoadBalancer.servers.size() - 1) {
                position = 0;
            }
            target = LoadBalancer.servers.get(position);
            position++;
        }
        return target;
    }
}

class RandomLoadBalance implements LoadBalance {

    @Override
    public String getServer(String clientIp) {
        int randomIndex = new Random().nextInt(LoadBalancer.servers.size());
        String target = LoadBalancer.servers.get(randomIndex);

        return target;
    }
}

class IpHash implements LoadBalance {

    @Override
    public String getServer(String clientIp) {
        if (clientIp == null) {
            clientIp = "127.0.0.1";
        }

        Integer index = clientIp.hashCode() % LoadBalancer.servers.size();
        String target = LoadBalancer.servers.get(index);
        return target;
    }
}
