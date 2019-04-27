package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * @author 李贺鹏
 * @create 2019/4/26 18:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestSet {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void setValue(){
        redisTemplate.boundSetOps("setName").add("zed");
        redisTemplate.boundSetOps("setName").add("anney");
        redisTemplate.boundSetOps("setName").add("aixi");
    }
    @Test
    public void getValue(){
        Set setName = redisTemplate.boundSetOps("setName").members();
        System.out.println("setName = " + setName);
    }
    @Test
    public void removeOne(){
        redisTemplate.boundSetOps("setName").remove("zed");
        Set setName = redisTemplate.boundSetOps("setName").members();
        System.out.println("setName = " + setName);
    }
    @Test
    public void delAll(){
        redisTemplate.delete("setName");
        Set setName = redisTemplate.boundSetOps("setName").members();
        System.out.println("setName = " + setName);
    }
}
