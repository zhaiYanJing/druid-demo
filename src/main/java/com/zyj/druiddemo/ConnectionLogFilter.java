package com.zyj.druiddemo;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {

    public void connection_connectionBefore(FilterChain filterChain, Properties info) {
        log.info("BEFORE CONNECTION!");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connectionProxy) {
        log.info("AFTER CONNECTION!");
    }

    public static void main(String[] args) {

        try {
            String password="FVthfJCngGwsdLqZCJbKrFb78pAHMLj1CnFy8uUorAetstxU13FBs+F+blL/FzuEt3suBARjNkwh7hbS5MXcdA==";
            String key = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKY/XPixARnH6vCu6aoEYpDv/0B3HfIqQETkIUHOgwhiEjqSBJlyzfRNU/eH6oCEXqaRg3hQy6M0cv1w6vQFbOMCAwEAAQ==";

            System.out.println(ConfigTools.decrypt(key,password));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
