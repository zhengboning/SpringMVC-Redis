package com.test.test;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Transaction;







public class Test {

	public static void main(String[] args) {
//		Jedis js = new Jedis("127.0.0.1", 6379);
		
//		js.set("key001", "redis001");
//		String val = js.get("key001");
//		System.out.println(val);
//		js.del("key001");
		
/**************************����Redis����������**************************/
		
		/**
		 * list
		 */
//		js.rpush("list1", "aaaaaaaaaaaaaaaaaaaaaa");
//		js.rpush("list1", "bbbbbbbbbbbbbbbbbbbbbb");
//		js.rpush("list1", "ccccccccccccccccccccc");
//		js.rpush("list1", "dddddddddddddd");
//		List<String> vals = js.lrange("list1", 0, -1);
//		for (int i = 0; i < vals.size(); i++) {
//			System.out.println(vals.get(i));
//		}

		
		/**
		 * set ����Ψһ
		 */
//		js.sadd("s1", "˳��3");
//		js.sadd("s1", "a");
//		js.sadd("s1", "b");
//		js.sadd("s1", "1");
//		js.sadd("s1", "����");
//		js.sadd("s1", "2");
//		js.sadd("s1", "so waht��");
//		js.sadd("s1", "%^");
//		js.sadd("s1", "˳��1");
//		js.sadd("s1", "������");
//		js.sadd("s1", "˳��2");
//		Set<String> s = js.smembers("s1");
//		for (String string : s) {
//			System.out.println(s);
//		}
//		js.srem("s1", "����");
		
		
		/**
		 * zset(sorted set ���򼯺�) 
		 * ��2�б�������:ziplist,skiplist,��zset�����ݽ϶�ʱ,���ᱻ�ع�Ϊskiplist
		 */	
//		js.zadd("zs", 92, "����1");
//		js.zadd("zs", 93, "����7");
//		js.zadd("zs", 94, "����5");
//		js.zadd("zs", 87, "����9");
//		js.zadd("zs", 66, "����");
//		js.zadd("zs", 19, "����0");
//		Set<String> sets = js.zrange("zs", 0, -1);
//		for (String string : sets) {
//			System.out.println(sets);
//		}
		
		
		/**
		 * Hash
		 */
//		Map m = new HashMap();
//		m.put("1", "t");
//		m.put("2", "ttt");
//		m.put("username", "����");
//		m.put("password", "123456");
//		m.put("age", "79");
//		m.put("sex", "man");
//		js.hmset("m", m);	
//		List<String> v = js.hmget("m", new String[]{"username","age"});
//		List<String> v1 = js.hmget("m", "sex");
//		System.out.println(v);
//		System.out.println(v1);
//		js.hdel("m", "username");//ɾ��map�е�ĳһ�����ļ�ֵ��
		
		/**
		 * �������
		 */
//		js.flushAll();
		
		/**
		 * ��������
		 */
//		js.disconnect();
		
		
/**************************�������**************************/
		
		/**
		 * ����ʽ(Transactions)
		 * ����ҪĿ���Ǳ��ϣ�һ��client����������е��������������ִ�У����м䲻���������client�����
		 * 
		 * ���ǵ���jedis.watch(��)���������key��������ú�keyֵ�����仯�������������ִ��ʧ�ܡ�
		 * ���⣬������ĳ������ʧ�ܣ�������ع�������������һ����Ҫע�⡣
		 * ���У����ǿ���ʹ��discard()������ȡ������
		 */
//		Jedis js1 = new Jedis("127.0.0.1", 6379);
//		long s = System.currentTimeMillis();
//		Transaction tx = js1.multi();
//		for (int i = 0; i < 99999; i++) {
//			tx.set("keyttt"+i, "valttt"+i);
//		}
//		List<Object> res= tx.exec();
//		long e = System.currentTimeMillis();
//		System.out.println((e-s)/1000.0+"��");
		//System.out.println(res);
//		js1.disconnect();
		

/**************************�ܵ�**************************/
		/**
		 * �ܵ�(Pipelining)
		 * ��ʱ��������Ҫ�����첽��ʽ��һ�η��Ͷ��ָ���ͬ���ȴ��䷵�ؽ����
		 * ��������ȡ�÷ǳ��õ�ִ��Ч�ʡ�����ǹܵ�
		 */
//		Jedis js2 = new Jedis("127.0.0.1", 6379);
//		long s = System.currentTimeMillis();
//		Pipeline pe = js2.pipelined();
//		for (int i = 0; i < 9999; i++) {
//			pe.set("keya"+i, "valuea"+i);
//		}
//		List<Object> l = pe.syncAndReturnAll();
//		long e = System.currentTimeMillis();
//		System.out.println((e-s)/1000.0+"��");
//		js2.disconnect();
		
		
/**************************�ܵ��е�������**************************/		
		/**
		 * �ܵ��е�������
		 * ���÷��Ͽ����ܵ��а���������
		 */
		
//		Jedis js3 = new Jedis("127.0.0.1", 6379);
//		long s = System.currentTimeMillis();
//		Pipeline pe = js3.pipelined();
//		pe.multi();
//		for (int i = 0; i < 9999; i++) {
//			pe.set("keybb"+i, "valuebb"+i);
//		}
//		pe.exec();
//		List<Object> l = pe.syncAndReturnAll();
//		long e = System.currentTimeMillis();
//		System.out.println((e-s)/1000.0+"��");
//		js3.disconnect();		
		
		
/**************************�ֲ�ʽֱ��ͬ������**************************/			
		/**
		 * �ֲ�ʽֱ��ͬ������
		 * �̲߳���ȫ�ģ����������̳߳���ʹ��ֱ��
		 */
//	    List<JedisShardInfo> shards = Arrays.asList(
//	    		new JedisShardInfo("localhost",6379),
//	    		new JedisShardInfo("localhost",6380));
//	    ShardedJedis sharding = new ShardedJedis(shards);
//	    long start = System.currentTimeMillis();
//	    for (int i = 0; i < 100000; i++) {
//	        String result = sharding.set("sn" + i, "n" + i);
//	    }
//	    long end = System.currentTimeMillis();
//	    System.out.println("Simple@Sharing SET: " + ((end - start)/1000.0) + " seconds");
//	    sharding.disconnect();		
		
/**************************�ֲ�ʽֱ��ͬ������**************************/			
		/**
		 * �ֲ�ʽֱ���첽����
		 * �̲߳���ȫ�ģ����������̳߳���ʹ��ֱ��
		 */		
//		 List<JedisShardInfo> shards = Arrays.asList(
//		            new JedisShardInfo("localhost",6379),
//		            new JedisShardInfo("localhost",6380));
//		    ShardedJedis sharding = new ShardedJedis(shards);
//		    ShardedJedisPipeline pipeline = sharding.pipelined();
//		    long start = System.currentTimeMillis();
//		    for (int i = 0; i < 100000; i++) {
//		        pipeline.set("sp" + i, "p" + i);
//		    }
//		    List<Object> results = pipeline.syncAndReturnAll();
//		    long end = System.currentTimeMillis();
//		    System.out.println("Pipelined@Sharing SET: " + ((end - start)/1000.0) + " seconds");
//		    sharding.disconnect();		
		

		    
/**************************�ֲ�ʽ���ӳ�ͬ������**************************/		
			/**
			 * ͬ����ʽ
			 */
//		    List<JedisShardInfo> shards = Arrays.asList(
//		            new JedisShardInfo("localhost",6379),
//		            new JedisShardInfo("localhost",6380));
//
//		    ShardedJedisPool pool = new ShardedJedisPool(new JedisPoolConfig(), shards);
//
//		    ShardedJedis one = pool.getResource();
//
//		    long start = System.currentTimeMillis();
//		    for (int i = 0; i < 100000; i++) {
//		        String result = one.set("spn" + i, "n" + i);
//		    }
//		    long end = System.currentTimeMillis();
//		    pool.returnResource(one);
//		    System.out.println("Simple@Pool SET: " + ((end - start)/1000.0) + " seconds");
//
//		    pool.destroy();		
//		
		
/**************************�ֲ�ʽ���ӳ��첽����**************************/		
		/**
		 * �첽��ʽ
		 */		
//		 List<JedisShardInfo> shards = Arrays.asList(
//		            new JedisShardInfo("localhost",6379),
//		            new JedisShardInfo("localhost",6380));
//
//	    ShardedJedisPool pool = new ShardedJedisPool(new JedisPoolConfig(), shards);
//
//	    ShardedJedis one = pool.getResource();
//
//	    ShardedJedisPipeline pipeline = one.pipelined();
//
//	    long start = System.currentTimeMillis();
//	    for (int i = 0; i < 100000; i++) {
//	        pipeline.set("sppn" + i, "n" + i);
//	    }
//	    List<Object> results = pipeline.syncAndReturnAll();
//	    long end = System.currentTimeMillis();
//	    pool.returnResource(one);
//	    System.out.println("Pipelined@Pool SET: " + ((end - start)/1000.0) + " seconds");
//	    pool.destroy();
		

/**************************��Ҫע��ĵط�**************************/	
		/**
		 * ����͹ܵ������첽ģʽ��
		 * 	������͹ܵ��в���ͬ����ѯ���!,�м�!!!
		 * ���������������ã����ǲ�����ģ�
		 */
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		Transaction tx = jedis.multi();
		 for (int i = 0; i < 100000; i++) {
		     tx.set("t" + i, "t" + i);
		 }
		 System.out.println(tx.get("t1000").get());  //������
		 List<Object> resTX = tx.exec();

		 Pipeline pipeline = jedis.pipelined();
		 long start = System.currentTimeMillis();
		 for (int i = 0; i < 100000; i++) {
		     pipeline.set("p" + i, "p" + i);
		 }
		 System.out.println(pipeline.get("p1000").get()); //������
		 List<Object> resPE = pipeline.syncAndReturnAll();
	
		 
/**************************�ܽ�**************************/	
		 
		 /**
		  * 1.����͹ܵ������첽�ģ����˸о����ڹܵ����ٽ���������ã�û�б�Ҫ������ֱ�ӽ�������ģʽ��
		  * 
		  * 2.�ֲ�ʽ�У����ӳص����ܱ�ֱ���������Ժ�
		  * 
		  * 3.�ֲ�ʽ�����в�֧������
		  * 	��Ϊ�������ڷ�������ʵ�֣����ڷֲ�ʽ�У�ÿ���εĵ��ö��󶼿��ܷ��ʲ�ͬ�Ļ��������ԣ�û����������
		  */
		 
		 
/**************************ʹ��Junit���Դ���**************************/		
/*		 
		 @FixMethodOrder(MethodSorters.NAME_ASCENDING)
		 public class TestJedis {

		     private static Jedis jedis;
		     private static ShardedJedis sharding;
		     private static ShardedJedisPool pool;

		     @BeforeClass
		     public static void setUpBeforeClass() throws Exception {
		         List<JedisShardInfo> shards = Arrays.asList(
		                 new JedisShardInfo("localhost",6379),
		                 new JedisShardInfo("localhost",6379)); //ʹ����ͬ��ip:port,��������


		         jedis = new Jedis("localhost"); 
		         sharding = new ShardedJedis(shards);

		         pool = new ShardedJedisPool(new JedisPoolConfig(), shards);
		     }

		     @AfterClass
		     public static void tearDownAfterClass() throws Exception {
		         jedis.disconnect();
		         sharding.disconnect();
		         pool.destroy();
		     }

		     @Test
		     public void test1Normal() {
		         long start = System.currentTimeMillis();
		         for (int i = 0; i < 100000; i++) {
		             String result = jedis.set("n" + i, "n" + i);
		         }
		         long end = System.currentTimeMillis();
		         System.out.println("Simple SET: " + ((end - start)/1000.0) + " seconds");
		     }

		     @Test
		     public void test2Trans() {
		         long start = System.currentTimeMillis();
		         Transaction tx = jedis.multi();
		         for (int i = 0; i < 100000; i++) {
		             tx.set("t" + i, "t" + i);
		         }
		         //System.out.println(tx.get("t1000").get());

		         List<Object> results = tx.exec();
		         long end = System.currentTimeMillis();
		         System.out.println("Transaction SET: " + ((end - start)/1000.0) + " seconds");
		     }

		     @Test
		     public void test3Pipelined() {
		         Pipeline pipeline = jedis.pipelined();
		         long start = System.currentTimeMillis();
		         for (int i = 0; i < 100000; i++) {
		             pipeline.set("p" + i, "p" + i);
		         }
		         //System.out.println(pipeline.get("p1000").get());
		         List<Object> results = pipeline.syncAndReturnAll();
		         long end = System.currentTimeMillis();
		         System.out.println("Pipelined SET: " + ((end - start)/1000.0) + " seconds");
		     }

		     @Test
		     public void test4combPipelineTrans() {
		         long start = System.currentTimeMillis();
		         Pipeline pipeline = jedis.pipelined();
		         pipeline.multi();
		         for (int i = 0; i < 100000; i++) {
		             pipeline.set("" + i, "" + i);
		         }
		         pipeline.exec();
		         List<Object> results = pipeline.syncAndReturnAll();
		         long end = System.currentTimeMillis();
		         System.out.println("Pipelined transaction: " + ((end - start)/1000.0) + " seconds");
		     }

		     @Test
		     public void test5shardNormal() {
		         long start = System.currentTimeMillis();
		         for (int i = 0; i < 100000; i++) {
		             String result = sharding.set("sn" + i, "n" + i);
		         }
		         long end = System.currentTimeMillis();
		         System.out.println("Simple@Sharing SET: " + ((end - start)/1000.0) + " seconds");
		     }

		     @Test
		     public void test6shardpipelined() {
		         ShardedJedisPipeline pipeline = sharding.pipelined();
		         long start = System.currentTimeMillis();
		         for (int i = 0; i < 100000; i++) {
		             pipeline.set("sp" + i, "p" + i);
		         }
		         List<Object> results = pipeline.syncAndReturnAll();
		         long end = System.currentTimeMillis();
		         System.out.println("Pipelined@Sharing SET: " + ((end - start)/1000.0) + " seconds");
		     }

		     @Test
		     public void test7shardSimplePool() {
		         ShardedJedis one = pool.getResource();

		         long start = System.currentTimeMillis();
		         for (int i = 0; i < 100000; i++) {
		             String result = one.set("spn" + i, "n" + i);
		         }
		         long end = System.currentTimeMillis();
		         pool.returnResource(one);
		         System.out.println("Simple@Pool SET: " + ((end - start)/1000.0) + " seconds");
		     }

		     @Test
		     public void test8shardPipelinedPool() {
		         ShardedJedis one = pool.getResource();

		         ShardedJedisPipeline pipeline = one.pipelined();

		         long start = System.currentTimeMillis();
		         for (int i = 0; i < 100000; i++) {
		             pipeline.set("sppn" + i, "n" + i);
		         }
		         List<Object> results = pipeline.syncAndReturnAll();
		         long end = System.currentTimeMillis();
		         pool.returnResource(one);
		         System.out.println("Pipelined@Pool SET: " + ((end - start)/1000.0) + " seconds");
		     }
		 }		 
*/		 
		 
	}

}
