package cn.enjoy.spring.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class JamesImportSelect implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"cn.enjoy.spring.bean.Cat","cn.enjoy.spring.bean.Pig"};
    }
}
