package com.yunn.workquestion;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author yunN
 * @date 2022/04/06
 */
public class EasyExcelUtil {

    @Test
    public void test() {
        File file = new File("D:\\Dev\\IdeaProject");
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(file + "\\test.xlsx").build();
            WriteSheet n1 = EasyExcel.writerSheet(0, "n1").head(EasyExcelUtilUseObj.class).build();
            WriteSheet n2 = EasyExcel.writerSheet(1, "n2").head(EasyExcelUtilUseObj.class).build();
            List<EasyExcelUtilUseObj> testData = getTestData();
            excelWriter.write(testData, n1);
            excelWriter.write(testData, n2);
        } catch (Exception e) {
            //
        } finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    private List<EasyExcelUtilUseObj> getTestData() {
        EasyExcelUtilUseObj obj1 = EasyExcelUtilUseObj.builder()
                .name("zzc")
                .name2("zsh")
                .build();
        EasyExcelUtilUseObj obj2 = EasyExcelUtilUseObj.builder()
                .name("zzc")
                .name2("zsh")
                .build();
        return Arrays.asList(obj1, obj2);
    }
}

@Data
@Builder
class EasyExcelUtilUseObj {
    @ExcelProperty("name")
    private String name;
    @ExcelProperty("name2")
    private String name2;
}
