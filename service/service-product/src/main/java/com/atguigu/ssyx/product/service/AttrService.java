package com.atguigu.ssyx.product.service;

import com.atguigu.ssyx.model.product.Attr;

import java.util.List;

public interface AttrService {
    List<Attr> findByAttrGroupId(Long attrGroupId);

    Attr getById(Long id);

    void save(Attr attr);

    void updateById(Attr attr);

    void removeByIds(List<Long> idList);

    void removeById(Long id);
}
