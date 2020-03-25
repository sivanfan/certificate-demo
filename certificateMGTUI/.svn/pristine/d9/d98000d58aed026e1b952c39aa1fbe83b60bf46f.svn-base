package com.ule.cermanager.sitemesh;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;


public class Meshsite3Filter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/decorator/default")//拦截规则，/decorator/default 会被转发
                .addExcludedPath("/static/**") //白名单
                .addExcludedPath("/auth/*")
                //.addTagRuleBundle(new MyTagRuleBundle())//自定义标签
                ;
    }
}
