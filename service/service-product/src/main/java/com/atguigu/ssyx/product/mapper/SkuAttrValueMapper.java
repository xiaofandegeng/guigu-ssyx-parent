package com.atguigu.ssyx.product.mapper;

import com.atguigu.ssyx.model.product.SkuAttrValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuAttrValueMapper extends BaseMapper<SkuAttrValue> {
    @Select("<script>"
            + "SELECT id AS id, sku_id AS skuId, attr_id AS attrId, attr_name AS attrName, attr_value AS attrValue, sort, create_time as createTime, update_time as updateTime "
            + "FROM sku_attr_value "
            + "<where>"
            + "sku_id = #{skuId}"
            + "</where>"
            + "order by updateTime DESC"
            + "</script>")
    List<SkuAttrValue> findBySkuId(@Param("skuId") Long skuId);
}
