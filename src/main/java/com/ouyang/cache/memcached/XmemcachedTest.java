package com.ouyang.cache.memcached;

import org.junit.Test;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class XmemcachedTest {

	public MemcachedClient getMemcachedClient(String url) throws Exception {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
	               AddrUtil.getAddresses(url));
		MemcachedClient memcachedClient = builder.build();
		return memcachedClient;
	}
	
	@Test
	public void testLocalConnection() throws Exception {
		MemcachedClient client = getMemcachedClient("localhost:11211");
		client.set("test", 0, "test string");
		System.out.println(client.get("test"));
		System.out.println(client.getConnectTimeout());
	}
}
