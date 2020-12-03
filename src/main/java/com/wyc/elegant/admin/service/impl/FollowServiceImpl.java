package com.wyc.elegant.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyc.elegant.admin.mapper.FollowMapper;
import com.wyc.elegant.admin.model.entity.TbFollow;
import com.wyc.elegant.admin.service.FollowService;
import org.springframework.stereotype.Service;

/**
 * 关注实现类
 *
 * @author Knox 2020/11/20
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, TbFollow> implements FollowService {
}