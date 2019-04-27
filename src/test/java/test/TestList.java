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
 * @create 2019/4/26 18:52
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-redis.xml")
public class TestList {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void setValue(){
        //右压栈  后进去的排在后面
        redisTemplate.boundListOps("rightList").rightPush("1");
        redisTemplate.boundListOps("rightList").rightPush("2");
        redisTemplate.boundListOps("rightList").rightPush("3");
        //左压栈
        redisTemplate.boundListOps("leftList").leftPush("a");
        redisTemplate.boundListOps("leftList").leftPush("b");
        redisTemplate.boundListOps("leftList").leftPush("c");

    }
    @Test
    public void getValue(){
        //range(0,20);  遍历list下表0 到 20的元素  没有提供查询所有的方法
        List rightList = redisTemplate.boundListOps("rightList").range(0,20);
        System.out.println("rightList = " + rightList);
        List left = redisTemplate.boundListOps("leftList").range(0,20);
        System.out.println("left = " + left);
    }
    //删除 remove i 个数   value要删除的value
    @Test
    public  void delList(){
        redisTemplate.boundListOps("rightList").remove(3,"3");
    }
    //删除所有
    @Test
    public  void delAllList(){
        redisTemplate.delete("rightList");
    }


}
