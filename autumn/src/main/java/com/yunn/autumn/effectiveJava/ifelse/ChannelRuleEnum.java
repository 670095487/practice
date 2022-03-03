package com.yunn.autumn.effectiveJava.ifelse;

public enum ChannelRuleEnum {

    // private String name;
    // public GeneralChannelRule generalChannelRule;
    // /**
    //  * 头条
    //  */
    //  TOUTIAO("TOUTIAO",new TouTiaoChannelRule()),
    //
    // /**
    //  * 阿里
    //  */
    //  ALI("ALI",new AliChannelRule());
    //
    // ChannelRuleEnum(String name, GeneralChannelRule generalChannelRule) {
    //     this.name = name;
    //
    // }

    TOUTIAO("TOUTIAO", new TouTiaoChannel()),
    ALI("ALI", new AliChannelRule()),
    ;

    ChannelRuleEnum(String s, GeneralChannelRule rule) {
        this.name = s;
        this.generalChannelRule = rule;
    }

    public String name;
    public GeneralChannelRule generalChannelRule;


    public static GeneralChannelRule match(String name) {
        if ("ALI".equals(name)) {
            return ALI.generalChannelRule;
        } else if ("TOUTIAO".equals(name)) {
            return TOUTIAO.generalChannelRule;
        } else return null;
    }
}
