/*
 * Copyright (C) 2021-2021 Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.huaweicloud.sermant.examples.demo.declarer;

import com.huaweicloud.sermant.examples.demo.interceptor.DemoTraceConsumerInterceptor;
import com.huaweicloud.sermant.examples.demo.interceptor.DemoTraceNormalInterceptor;
import com.huaweicloud.sermant.examples.demo.interceptor.DemoTraceProviderInterceptor;

import com.huaweicloud.sermant.core.plugin.agent.declarer.AbstractPluginDeclarer;
import com.huaweicloud.sermant.core.plugin.agent.declarer.InterceptDeclarer;
import com.huaweicloud.sermant.core.plugin.agent.matcher.ClassMatcher;
import com.huaweicloud.sermant.core.plugin.agent.matcher.MethodMatcher;

/**
 * 用于测试链路功能的增强定义
 *
 * @author HapThorin
 * @version 1.0.0
 * @since 2021-10-25
 */
public class DemoTraceDeclarer extends AbstractPluginDeclarer {
    @Override
    public ClassMatcher getClassMatcher() {
        return ClassMatcher.nameEquals("com.huawei.example.demo.service.DemoTraceService");
    }

    @Override
    public InterceptDeclarer[] getInterceptDeclarers(ClassLoader classLoader) {
        return new InterceptDeclarer[] {
            InterceptDeclarer.build(MethodMatcher.nameEquals("provider"), new DemoTraceProviderInterceptor()),
            InterceptDeclarer.build(MethodMatcher.nameEquals("normal"), new DemoTraceNormalInterceptor()),
            InterceptDeclarer.build(MethodMatcher.nameEquals("consumer"), new DemoTraceConsumerInterceptor())};
    }
}
