package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

/**
 * @author 李贺鹏
 * @create 2019/4/27 8:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestHash {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void setValue(){
        redisTemplate.boundHashOps("hashMap").put("num1","a");
        redisTemplate.boundHashOps("hashMap").put("num2","b");
        redisTemplate.boundHashOps("hashMap").put("num3","c");
        redisTemplate.boundHashOps("hashMap").put("num4","d");
    }
    @Test
    public void getKeys(){
        Set hashMap = redisTemplate.boundHashOps("hashMap").keys();
        System.out.println("hashMap = " + hashMap);
    }
    @Test
    public void getValues(){
        List hashMap = redisTemplate.boundHashOps("hashMap").values();
        System.out.println("hashMap = " + hashMap);
    }
    @Test
    public void getkeyV(){
        String str = (String) redisTemplate.boundHashOps("hashMap").get("num1");
        System.out.println("str = " + str);
    }
    @Test
    public void removeOne(){
         redisTemplate.boundHashOps("hashMap").delete("num1");
        List hashMap = redisTemplate.boundHashOps("hashMap").values();
        System.out.println("hashMap = " + hashMap);

    }
    @Test
    public void removeAll(){
        redisTemplate.delete("hashMap");
        List hashMap = redisTemplate.boundHashOps("hashMap").values();
        System.out.println("hashMap = " + hashMap);

    }
}
