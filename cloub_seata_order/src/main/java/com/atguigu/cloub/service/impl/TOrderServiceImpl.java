
package com.atguigu.cloub.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.cloub.entity.TAccount;
import com.atguigu.cloub.entity.TOrder;
import com.atguigu.cloub.entity.TStorage;
import com.atguigu.cloub.mapper.TOrderMapper;
import com.atguigu.cloub.openFeign.AccountFeignApi;
import com.atguigu.cloub.openFeign.StroageFeignApi;
import com.atguigu.cloub.service.TOrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
public class TOrderServiceImpl implements TOrderService {

    @Autowired
    private TOrderMapper tOrderMapper;
    // 订单微服务调用 账户微服务
    @Autowired
    private AccountFeignApi accountFeignApi;

    // 订单微服务调用 库存微服务
    @Autowired
    private StroageFeignApi stroageFeignApi;

    /**
     * 查询表t_order所有信息
     */
    @Override
    public List<TOrder> findAllTOrder() {
        return tOrderMapper.findAllTOrder();
    }

    /**
     * 根据主键id查询表t_order信息
     *
     * @param id
     */
    @Override
    public TOrder findTOrderByid(@Param("id") String id) {
        return tOrderMapper.findTOrderByid(id);
    }

    /**
     * 根据条件查询表t_order信息
     *
     * @param tOrder
     */
    @Override
    public List<TOrder> findTOrderByCondition(TOrder tOrder) {
        return tOrderMapper.findTOrderByCondition(tOrder);
    }

    /**
     * 根据主键id查询表t_order信息
     *
     * @param id
     */
    @Override
    public Integer deleteTOrderByid(@Param("id") String id) {
        return tOrderMapper.deleteTOrderByid(id);
    }

    /**
     * 根据主键id更新表t_order信息
     *
     * @param tOrder
     */
    @Override
    public Integer updateTOrderByid(TOrder tOrder) {
        return tOrderMapper.updateTOrderByid(tOrder);
    }

    /**
     * 新增表t_order信息
     *
     * @param tOrder
     */
    @Override
    @GlobalTransactional
    public Integer addTOrder(TOrder tOrder) {
        String xid = RootContext.getXID();
        log.info(" 开始  xid:=================" + xid);
        if (StringUtils.isEmpty(tOrder.getId())) {
            tOrder.setId(IdUtil.simpleUUID());
        }
        // 订单状态
        tOrder.setStatus(0);
        tOrder.setProductId("1");
        tOrder.setUserId("1");
        tOrder.setCount(Integer.valueOf("3"));
        tOrder.setMoney(BigDecimal.valueOf(100));
        // 插入订单 数据
        int result = tOrderMapper.addTOrder(tOrder);
        TOrder tOrder1 = null;

        if (result > 0) {
            tOrder1 = tOrderMapper.findTOrderByid(tOrder.getId());
            log.info(" 插入订单:=================成功");
            BigDecimal counts = BigDecimal.valueOf(tOrder1.getCount());
            // 修改 库存
            TStorage tStorage = new TStorage();
            tStorage.setProductId(tOrder1.getProductId());
            //使用库存
            tStorage.setUsed(BigDecimal.valueOf(tOrder1.getCount()));
            //剩余库存
            tStorage.setResidue(BigDecimal.valueOf(1000 - tOrder1.getCount()));
            tStorage.setId("1");
            stroageFeignApi.updateTStorageByid(tStorage);
            log.info(" 修改 库存 成功  xid:=================" + xid);

            // 修改账户
            TAccount tAccount = new TAccount();
            tAccount.setUserId(tOrder1.getUserId());
            double ues = counts.intValue() * tOrder1.getMoney().intValue();
            // 已使用金额
            tAccount.setUsed(BigDecimal.valueOf(ues));
            double res = 1000 - ues;
            // 剩余金额
            tAccount.setResidue(BigDecimal.valueOf(res));
            tAccount.setId("1");
            accountFeignApi.updateTAccountByid(tAccount);
            log.info(" 修改 账户 成功  xid:=================" + xid);

            tOrder1.setStatus(1);
            tOrderMapper.updateTOrderByid(tOrder1);
            log.info(" 修改 订单 状态 已完结   xid:=================" + xid);

        }
        log.info(" 结束 xid:=================" + xid);
        return result;
    }
}