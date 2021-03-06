package org.apache.ibatis.cache;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author :LiuYang
 * @desc
 * 缓存key
 * 一般缓存框架的数据结构基本上都是 Key-Value 方式存储，
 * MyBatis 对于其 Key 的生成采取规则为：[mappedStementId + offset + limit + SQL + queryParams + environment]生成一个哈希码
 * @date :2021/1/30/030 13:24
 **/
public class CacheKey {

    public static final CacheKey NULL_CACHE_KEY = new NullCacheKey();

    private static final int DEFAULT_MULTIPLYER = 37;
    private static final int DEFAULT_HASHCODE = 17;

    private int multiplier;
    private int hashcode;
    private long checksum;
    private int count;
    private List<Object> updateList;

    public CacheKey() {
        this.hashcode = DEFAULT_HASHCODE;
        this.multiplier = DEFAULT_MULTIPLYER;
        this.count = 0;
        this.updateList = new ArrayList<Object>();
    }

    //传入一个Object数组，更新hashcode和效验码
    public CacheKey(Object[] objects) {
        this();
        updateAll(objects);
    }

    public void update(Object o) {
        if(o!=null&&o.getClass().isArray()){
            //如果是数组，则循环调用doUpdate
            int length= Array.getLength(o);
            for(int i=0;i<length;i++){
                Object element=Array.get(o,i);
                doUpdate(element);
            }
        }else{
            doUpdate(o);
        }
    }

    private void doUpdate(Object object) {
        //计算hash值，校验码
        int baseHashCode = object == null ? 1 : object.hashCode();

        count++;
        checksum += baseHashCode;
        baseHashCode *= count;

        hashcode = multiplier * hashcode + baseHashCode;

        //同时将对象加入列表，这样万一两个CacheKey的hash码碰巧一样，再根据对象严格equals来区分
        updateList.add(object);
    }


    public void updateAll(Object[] objects) {
        for (Object o : objects) {
            update(o);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if(!(object instanceof CacheKey)){
            return false;
        }
        final CacheKey cacheKey = (CacheKey) object;

        //先比hashcode，checksum，count，理论上可以快速比出来
        if (hashcode != cacheKey.hashcode) {
            return false;
        }
        if (checksum != cacheKey.checksum) {
            return false;
        }
        if (count != cacheKey.count) {
            return false;
        }
        //万一两个CacheKey的hash码碰巧一样，再根据对象严格equals来区分
        //这里两个list的size没比是否相等，其实前面count相等就已经保证了
        for (int i = 0; i < updateList.size(); i++) {
            Object thisObject = updateList.get(i);
            Object thatObject = cacheKey.updateList.get(i);
            if (thisObject == null) {
                if (thatObject != null) {
                    return false;
                }
            } else {
                if (!thisObject.equals(thatObject)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(multiplier, hashcode, checksum, count, updateList);
    }
}
