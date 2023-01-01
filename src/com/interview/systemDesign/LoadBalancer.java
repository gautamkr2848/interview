package com.interview.systemDesign;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LoadBalancer {

        public static Map<String, Integer> ipMap = new ConcurrentHashMap<>();

        static {
            ipMap.put("192.168.1.1", 10);
            ipMap.put("192.168.1.2", 10);
            ipMap.put("192.168.1.3", 10);
            ipMap.put("192.168.1.4", 10);
            ipMap.put("192.168.1.5", 10);
            ipMap.put("192.168.1.6", 10);
            ipMap.put("192.168.1.7", 10);
            ipMap.put("192.168.1.8", 10);
            ipMap.put("192.168.1.9", 10);
            ipMap.put("192.168.1.10", 10);
        }

}

interface LoadBalance {
    String getServer(String clientIp);
}

class RoundRobin implements LoadBalance {
    private static Integer position = 0;

    @Override
    public String getServer(String clientIp) {
        Set<String> servers = LoadBalancer.ipMap.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        String target = null;

        synchronized (position) {
            if (position > serverList.size() - 1) {
                position = 0;
            }
            target = serverList.get(position);
            position++;
        }
        return target;
    }
}

class RandomLoadBalance implements LoadBalance {

    @Override
    public String getServer(String clientIp) {
        Set<String> servers = LoadBalancer.ipMap.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        int randomIndex = new Random().nextInt(serverList.size());
        String target = serverList.get(randomIndex);

        return target;
    }
}

class IpHash implements LoadBalance {

    @Override
    public String getServer(String clientIp) {
        if (clientIp == null) {
            clientIp = "127.0.0.1";
        }
        Set<String> servers = LoadBalancer.ipMap.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        String remoteId = clientIp;
        Integer index = remoteId.hashCode() % serverList.size();
        String target = serverList.get(index);
        return target;
    }
}
