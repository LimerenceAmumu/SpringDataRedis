package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 李贺鹏
 * @create 2019/4/26 18:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestValue {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void  setValue(){
        redisTemplate.boundValueOps("name").set("amumu");
    }
    @Test
    public void  getValue(){
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println("name = " + name);
    }
    @Test
    public void  delValue(){
        redisTemplate.delete("name");
    }


}
