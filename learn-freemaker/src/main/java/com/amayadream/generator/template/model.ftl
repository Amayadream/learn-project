package ${classpath}<#if prefixModel??&&prefixModel!="">.${prefixModel}</#if>;

public class ${beanName?capitalize}{

<#if columnList?exists>
<#list columnList as item>
    private ${item.type} ${item.name};
</#list>

<#list columnList as item>
    public ${item.type} get${item.name?capitalize}(){
        return ${item.name};
    }

    public void set${item.name?capitalize}(${item.type} ${item.name}){
        this.${item.name} = ${item.name};
    }

</#list>
</#if>
}