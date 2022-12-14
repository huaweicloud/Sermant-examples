/*
 * Copyright (C) 2021-2021 Huawei Technologies Co., Ltd. All rights reserved.
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

package com.huawei.dubbotest.controller;

import com.huawei.dubbotest.domain.Test;
import com.huawei.dubbotest.service.ATest;

import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

@RestController
public class DubboController {
    @Resource(name = "aTest")
    private ATest aTest;

    @GetMapping("/empty")
    public String empty(Long id, String name, @RequestHeader Map<String, String> headers) {
        RpcContext.getContext().setAttachments(headers);
        if (id == null) {
            id = 0L;
        }
        if (name == null) {
            name = "";
        }
        Map<String, String> resultMap = new TreeMap<String, String>();
        resultMap.put("_dubbo.version", "2.7.5");
        try {
            resultMap.putAll(aTest.testEmpty(id, name));
        } catch (Exception e) {
            resultMap.put("error", e.getMessage());
        }
        return resultMap.toString();
    }

    @GetMapping("/object")
    public String object(Test test, @RequestHeader Map<String, String> headers) {
        RpcContext.getContext().setAttachments(headers);
        Map<String, String> resultMap = new TreeMap<String, String>();
        resultMap.put("_dubbo.version", "2.7.5");
        try {
            resultMap.putAll(aTest.testObject(test));
        } catch (Exception e) {
            resultMap.put("error", e.getMessage());
        }
        return resultMap.toString();
    }

    @GetMapping("/enabled")
    public String enabled(Test test, @RequestHeader Map<String, String> headers) {
        RpcContext.getContext().setAttachments(headers);
        Map<String, String> resultMap = new TreeMap<String, String>();
        resultMap.put("_dubbo.version", "2.7.5");
        try {
            resultMap.putAll(aTest.testEnabled(test));
        } catch (Exception e) {
            resultMap.put("error", e.getMessage());
        }
        return resultMap.toString();
    }

    @GetMapping("/array")
    public String array(String name, @RequestHeader Map<String, String> headers) {
        RpcContext.getContext().setAttachments(headers);
        String[] arr = null;
        if (name != null) {
            arr = name.split(",");
        }
        Map<String, String> resultMap = new TreeMap<String, String>();
        resultMap.put("_dubbo.version", "2.7.5");
        try {
            resultMap.putAll(aTest.testArray(arr));
        } catch (Exception e) {
            resultMap.put("error", e.getMessage());
        }
        return resultMap.toString();
    }

    @GetMapping("/list")
    public String list(String name, @RequestHeader Map<String, String> headers) {
        RpcContext.getContext().setAttachments(headers);
        List<String> list = null;
        if (name != null) {
            list = Arrays.asList(name.split(","));
        }
        Map<String, String> resultMap = new TreeMap<String, String>();
        resultMap.put("_dubbo.version", "2.7.5");
        try {
            resultMap.putAll(aTest.testList(list));
        } catch (Exception e) {
            resultMap.put("error", e.getMessage());
        }
        return resultMap.toString();
    }

    @GetMapping("/map")
    public String map(@RequestParam Map<String, String> param, @RequestHeader Map<String, String> headers) {
        RpcContext.getContext().setAttachments(headers);
        System.out.println("param:" + param);
        Map<String, String> resultMap = new TreeMap<String, String>();
        resultMap.put("_dubbo.version", "2.7.5");
        try {
            resultMap.putAll(aTest.testMap(param));
        } catch (Exception e) {
            resultMap.put("error", e.getMessage());
        }
        return resultMap.toString();
    }
}
