/*
 * Copyright (C) 2022-2022 Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.huaweicloud.sermant.examples.demo.interceptor;

import com.huaweicloud.sermant.examples.demo.common.DemoLogger;

import com.huaweicloud.sermant.core.plugin.agent.entity.ExecuteContext;
import com.huaweicloud.sermant.core.plugin.agent.interceptor.AbstractInterceptor;

import java.util.Locale;

/**
 * 用于测试插件内部增强开关是否生效
 *
 * @author lilai
 * @version 1.0.0
 * @since 2022-08-13
 */
public class DemoCheckEnableInterceptor extends AbstractInterceptor {
    @Override
    public ExecuteContext before(ExecuteContext context) throws Exception {
        DemoLogger.println(String.format(Locale.ROOT, "[DemoCheckEnableInterceptor]before, class: %s, method: %s.",
                context.getRawCls().getName(), context.getMethod().getName()));
        return context;
    }

    @Override
    public ExecuteContext after(ExecuteContext context) throws Exception {
        DemoLogger.println(String.format(Locale.ROOT, "[DemoCheckEnableInterceptor]after, class: %s, method: %s.",
                context.getRawCls().getName(), context.getMethod().getName()));
        return context;
    }
}
