package com.test.test;

import java.util.Arrays;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisInitBean {
	
	private List Host;
//	private int RedisPort;
//	private static int MaxActive;
	private long maxWaitMillis;
	private int MaxIdle;
	private Boolean testOnBorrow;
	private static List<JedisShardInfo> shards ;
	private static ShardedJedisPool pool;
	private static ShardedJedis jedis;
	
	public RedisInitBean(List host, long maxWaitMillis, int maxIdle,
			Boolean testOnBorrow) {
		super();
		Host = host;
		this.maxWaitMillis = maxWaitMillis;
		MaxIdle = maxIdle;
		this.testOnBorrow = testOnBorrow;
		if(host.size()!=0){
			for (int i = 0; i < host.size(); i++) {		
			    String h[] = ((String) host.get(i)).split(":");     
			    shards = Arrays.asList(new JedisShardInfo(h[0].trim(),Integer.parseInt(h[1].trim())));
			    System.out.println(shards);
			}
		}else{
			System.out.println("请检查Redis配置文件，host项为必填项！格式[IP:PORT]");
		}

		pool = new ShardedJedisPool(new JedisPoolConfig(), shards);
		jedis = pool.getResource();	
	}
	
	/**
	 * 分布式连接池 异步调用！
	 *  
	 */
	public synchronized ShardedJedis getSingletonInstance(){
		return jedis;
	}
	
	public synchronized static void returnResource(){
		pool.returnResource(jedis);
	}
	
	public synchronized static void destroy(){
		pool.destroy();
	}
	
}
