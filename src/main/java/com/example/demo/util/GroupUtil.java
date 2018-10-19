package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.UserInfo;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Multimaps;
/**
 * 
 * @author YCKJ1060
 *
 * @param <K> 分组字段的数据类型
 * @param <T>   list
 */
public class GroupUtil<K,T> {
	 /**
     * 
     * desc:
     * @param list  要分组的list
     * @param orderByField 根据这个字段分组
     * @return
     */
    public  ImmutableListMultimap<K, T> group(List<T> list,String orderByField) {
       return Multimaps.index(list, new Function<T,K>() {

            @Override
            public  K apply(T input) {
                return (K) RefentUtil.getValue(input, orderByField);
            }
        });
    }
    
    public static void main(String[] args) {
        List<UserInfo> list = new ArrayList<>();
        UserInfo info = new UserInfo();
        info.setId("1");
        info.setName("name1");
        
        UserInfo info2 = new UserInfo();
        info2.setId("1");
        info2.setName("name11111");
        
        UserInfo info3 = new UserInfo();
        info3.setId("3");
        info3.setName("name3");
        
        UserInfo info4 = new UserInfo();
        info4.setId("3");
        info4.setName("name333");
        
        list.add(info);
        list.add(info2);
        list.add(info3);
        list.add(info4);
        
        
        ImmutableListMultimap<String, UserInfo> map =  new GroupUtil<String,UserInfo>().group(list, "id");
    }
}
