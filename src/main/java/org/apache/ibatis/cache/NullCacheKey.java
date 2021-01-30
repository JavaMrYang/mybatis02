package org.apache.ibatis.cache;

/**
 * @author :LiuYang
 * @desc
 * Null值缓存key
 * @date :2021/1/30/030 13:25
 **/
public class NullCacheKey extends CacheKey{

    public NullCacheKey() {
        //只有hash值和校验码为key?
        super();
    }

    @Override
    public void update(Object object) {
        throw new CacheException("Not allowed to update a NullCacheKey instance.");
    }

    @Override
    public void updateAll(Object[] objects) {
        throw new CacheException("Not allowed to update a NullCacheKey instance.");
    }
}
