package ${classPath}<#if packageModel??&&packageModel!="">.${packageModel}</#if>;

public class ${beanName?capitalize}{

<#if columnList?exists>
<#list columnList as item>
    /** ${item.columnComments} */
    private ${item.columnType} ${item.columnName?lower_case};
</#list>

    /**
    * getter&setter
    */
<#list columnList as item>
    public ${item.columnType} get${item.columnName?capitalize}(){
        return ${item.columnName?lower_case};
    }

    public void set${item.columnName?capitalize}(${item.columnType} ${item.columnName?lower_case}){
        this.${item.columnName?lower_case} = ${item.columnName?lower_case};
    }

</#list>
</#if>
}