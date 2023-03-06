package com.yunn.workquestion;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yunN
 * @date 2022/03/24
 */
public class StreamMapApiUse {

    List<DemoUseObj> filterAndSorted(List<DemoUseObj> demoUseObjs) {
        Map<String, DemoUseObj> collect = demoUseObjs.stream()
                .collect(Collectors.toMap(demoUseObj -> (demoUseObj.getLcn() + demoUseObj.getAdd()), demoUseObj -> demoUseObj, (a, b) -> {
                    if (a.getAuthDate().isBefore(b.getAuthDate()) || a.getAuthDate().equals(b.getAuthDate())) {
                        return a;
                    } else {
                        return b;
                    }
                }));

        return new ArrayList<>(collect.values());
    }
}
